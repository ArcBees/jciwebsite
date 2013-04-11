/*
 Copyright 2013 ArcBees Inc.

 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy of
 the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 License for the specific language governing permissions and limitations under
 the License.
 */

package com.jci.client.application.register;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.jci.client.resource.CommonResource;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class TravelPageView extends ViewImpl implements TravelPagePresenter.MyView, AttachEvent.Handler {
    interface Binder extends UiBinder<Widget, TravelPageView> {
    }


    @UiField
    DivElement hotel;
    @UiField
    DivElement travel;
    @UiField
    AnchorElement buttonHotel;
    @UiField
    AnchorElement buttonTravel;

    private final String activeStyleName;

    @Inject
    public TravelPageView(Binder uiBinder,
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

    @Override
    public void showSection(String id) {
        if (id.equals("travel")) {
            showTravel();
        } else {
            showHotel();
        }
    }

    @Override
    public void showHotel() {
        $(buttonTravel).removeClass(activeStyleName);
        $(buttonHotel).addClass(activeStyleName);
        $(hotel).show();
        $(travel).hide();
    }

    @Override
    public void showTravel() {
        $(buttonHotel).removeClass(activeStyleName);
        $(buttonTravel).addClass(activeStyleName);
        $(travel).show();
        $(hotel).hide();
    }

    private void bindGwtQuery() {
        $(buttonHotel).click(new Function() {
            @Override
            public void f() {
                showHotel();
            }
        });

        $(buttonTravel).click(new Function() {
            @Override
            public void f() {
                showTravel();
            }
        });
    }
}
