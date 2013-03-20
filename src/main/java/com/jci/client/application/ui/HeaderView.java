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

package com.jci.client.application.ui;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.jci.client.resource.header.HeaderResource;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;



public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {
    public interface Binder extends UiBinder<Widget, HeaderView> {
    }

    @UiField
    DivElement menu;

    private final String activeStyleName;



    @Inject
    public HeaderView(final Binder binder, HeaderResource headerResource) {
        initWidget(binder.createAndBindUi(this));

        activeStyleName = headerResource.style().active();
    }

    @Override
    protected void onAttach() {
//        $("a", menu).click(new Function() {
//            @Override
//            public void f(Element e) {
//                $("." + activeStyleName).removeClass(activeStyleName);
//                $(e).addClass(activeStyleName);
//            }
//        });
    }

    @Override
    public void activateCurrentLink(String nameTokens) {
        activateCurrentLinkNative(nameTokens);
    }

    public static native void activateCurrentLinkNative(String nameTokens) /*-{
            $wnd.alert(nameTokens);
    }-*/;

}
