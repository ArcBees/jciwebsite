/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.jci.client.application.contact;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.jci.client.resource.CommonResource;
import com.jci.client.resource.contact.ContactResource;
import com.jci.client.utils.Regexes;
import com.jci.shared.domain.ContactMessage;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class ContactPageView extends ViewWithUiHandlers<ContactPageUiHandlers> implements ContactPagePresenter
        .MyView, AttachEvent.Handler {
    interface Binder extends UiBinder<Widget, ContactPageView> {
    }

    @UiField
    AnchorElement buttonForm;
    @UiField
    AnchorElement buttonComitee;
    @UiField
    DivElement form;
    @UiField
    DivElement comitee;
    @UiField
    ImageElement loader;

    private final String activeStyleName;
    private final String errorInput;
    private boolean valid;

    @Inject
    public ContactPageView(Binder uiBinder,
                           CommonResource commonResource,
                           ContactResource contactResource) {
        initWidget(uiBinder.createAndBindUi(this));

        activeStyleName = commonResource.style().active();
        errorInput = contactResource.style().errorInput();

        asWidget().addAttachHandler(this);
    }

    @Override
    public void onAttachOrDetach(AttachEvent attachEvent) {
        if (attachEvent.isAttached()) {
            bindGwtQuery();
        }
    }

    @Override
    public void errorSending() {
        $(loader).hide();

        showMessage("Your message was not sent. We'll investigate this as soon as possible.", "#D15B2D");
    }

    @Override
    public void successSending() {
        $(loader).hide();

        showMessage("Thank you! Your message was sent to JCI organisers.", "#59780e");
    }

    private void bindGwtQuery() {
        $("input[type='submit']", form).click(new Function() {
            @Override
            public boolean f(Event e) {
                e.preventDefault();
                validateAll();
                return false;
            }
        });

        $("input[type='text'], textarea", form).blur(new Function() {
            @Override
            public void f(Element e) {
                validate(e);
            }
        });

        $("input[id='email']", form).blur(new Function() {
            @Override
            public void f(Element e) {
                validateEmail(e);
            }
        });

        $(buttonForm).click(new Function() {
            @Override
            public void f() {
                $(buttonComitee).removeClass(activeStyleName);
                $(buttonForm).addClass(activeStyleName);
                $(form).show();
                $(comitee).hide();
            }
        });

        $(buttonComitee).click(new Function() {
            @Override
            public void f() {
                $(buttonForm).removeClass(activeStyleName);
                $(buttonComitee).addClass(activeStyleName);
                $(comitee).show();
                $(form).hide();
            }
        });
    }

    private void validateAll() {
        valid = true;

        GQuery name = $("input[id='name']", form);
        validateAllE(name);
        GQuery email = $("input[id='email']", form);
        validateAllE(email);
        GQuery subject = $("input[id='subject']", form);
        validateAllE(subject);
        GQuery message = $("textarea[id='message']", form);
        validateAllE(message);
        validateEmailE(email);

        if (valid) {
            ContactMessage contactMessage = new ContactMessage();

            contactMessage.setEmail(email.val());
            contactMessage.setMessage(message.val());
            contactMessage.setSubject(subject.val());
            contactMessage.setName(name.val());

            $(loader).show();
            getUiHandlers().contact(contactMessage);
        }

        valid = false;
    }

    private void validateAllE(GQuery e) {
        if ($(e).val().equals("")) {
            $(e).next("p").text("This field must be filled.");
            $(e).addClass(errorInput);
            valid = false;
        } else {
            $(e).next("p").text("");
            $(e).removeClass(errorInput);
        }
    }

    private void validateEmailE(GQuery e) {
        if ($(e).next("p").text().equals("")) {
            if (!$(e).val().matches(Regexes.emailRegex)) {
                $(e).next("p").text("This email is not valid.");
                $(e).addClass(errorInput);
                valid = false;
            } else {
                $(e).next("p").text("");
                $(e).removeClass(errorInput);
            }
        }
    }

    private void validate(Element e) {
        if ($(e).val().equals("")) {
            $(e).next("p").text("This field must be filled.");
            $(e).addClass(errorInput);
            valid = false;
        } else {
            $(e).next("p").text("");
            $(e).removeClass(errorInput);
        }
    }

    private void validateEmail(Element e) {
        if ($(e).next("p").text().equals("")) {
            if (!$(e).val().matches(Regexes.emailRegex)) {
                $(e).next("p").text("This email is not valid.");
                $(e).addClass(errorInput);
                valid = false;
            } else {
                $(e).next("p").text("");
                $(e).removeClass(errorInput);
            }
        }
    }

    private void showMessage(String text, String color) {
        GQuery message = $("textarea[id='message']", form);
        $(message).next("p").css("color", color);
        $(message).next("p").text(text);
    }
}
