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

package com.jci.client.application.program;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.jci.client.resource.CommonResource;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class ProgramPageView extends ViewImpl implements ProgramPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, ProgramPageView> {
    }

    @UiField
    DivElement divButtons;

    private final String activeStyleName;

    @Inject
    public ProgramPageView(Binder uiBinder,
                           CommonResource commonResource) {
        initWidget(uiBinder.createAndBindUi(this));

        activeStyleName = commonResource.style().active();

        $("a", divButtons).click(new Function() {
            @Override
            public void f(Element e) {
                $("." + activeStyleName).removeClass(activeStyleName);

                $(e).addClass(activeStyleName);
                pauseCarousel();
            }
        });
    }


    @Override
    public void pauseCarousel() {
        pauseCarouselNative();
    }

    public static native void pauseCarouselNative() /*-{
        $wnd.$('#myCarouselProgram').bind('slid', function() {
            $wnd.$('#myCarouselProgram').carousel('pause');
        });​
    }-*/;
}
