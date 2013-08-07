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

package com.jci.client.application.home;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.jci.client.application.home.video.VideoWidget;

import static com.google.gwt.query.client.GQuery.$;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView, AttachEvent.Handler {
    public interface Binder extends UiBinder<Widget, HomePageView> {
    }

    @UiField
    DivElement videoTrigger;
    @UiField
    VideoWidget videoWidget;

    @Inject
    HomePageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        asWidget().addAttachHandler(this);
    }

    @Override
    public void startCarousel() {
        startCarouselNative();
    }

    @Override
    public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
            $(videoTrigger).click(new Function() {
                @Override
                public void f() {
                    hideVideoTrigger();
                }
            });
        }
    }

    @Override
    public void showVideoTrigger() {
        $(videoWidget).hide();
        $(videoTrigger).show();
    }

    private void hideVideoTrigger() {
        $(videoWidget).show();
        $(videoTrigger).hide();
    }

    private native void startCarouselNative() /*-{
        $wnd.$('#myCarouselHome').carousel();
    }-*/;
}
