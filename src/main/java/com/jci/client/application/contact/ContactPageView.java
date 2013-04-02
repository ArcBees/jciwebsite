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
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.jci.client.resource.CommonResource;
import com.jci.client.resource.program.ProgramResource;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class ContactPageView extends ViewImpl implements ContactPagePresenter.MyView, AttachEvent.Handler{
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

    @Inject
    public ContactPageView(Binder uiBinder,
                           CommonResource commonResource) {
        initWidget(uiBinder.createAndBindUi(this));
        
        activeStyleName = commonResource.style().active();

        asWidget().addAttachHandler(this);
    }

    @Override
    public void onAttachOrDetach(AttachEvent attachEvent) {
        if (attachEvent.isAttached()) {
            bindGwtQuery();
        }
    }

    private void bindGwtQuery() {
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
        });    }
}
