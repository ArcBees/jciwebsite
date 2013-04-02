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

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.jci.client.resource.CommonResource;
import com.jci.client.resource.contact.ContactResource;
import com.jci.client.utils.Regexes;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class ContactPageView extends ViewImpl implements ContactPagePresenter.MyView, AttachEvent.Handler {
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

    private final String activeStyleName;
    private final String errorInput;

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
        validateAllE($("input[id='name']", form));
        validateAllE($("input[id='email']", form));
        validateAllE($("input[id='subject']", form));
        validateAllE($("textarea[id='message']", form));
        validateEmailE($("input[id='email']", form));
    }

    private void validateAllE(GQuery e) {
        if ($(e).val().equals("")) {
            $(e).next("p").text("This field must be filled.");
            $(e).addClass(errorInput);
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
            } else {
                $(e).next("p").text("");
                $(e).removeClass(errorInput);
            }
        }
    }
}
