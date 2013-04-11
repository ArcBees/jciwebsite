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

package com.jci.client.application.program;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.jci.client.application.ApplicationPresenter;
import com.jci.client.place.NameTokens;

import javax.inject.Inject;

public class ProgramPagePresenter extends Presenter<ProgramPagePresenter.MyView, ProgramPagePresenter.MyProxy> {
    private HandlerRegistration handlerRegistration;

    public interface MyView extends View {
        void pauseCarousel();

        void untoggleTooltipClick(Element e);

        void untoggleTooltip();
    }

    @ProxyStandard
    @NameToken(NameTokens.program)
    public interface MyProxy extends ProxyPlace<ProgramPagePresenter> {
    }

    @Inject
    public ProgramPagePresenter(EventBus eventBus,
                                MyView view,
                                MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        handlerRegistration = RootPanel.get().addDomHandler(new KeyDownHandler() {
             @Override
             public void onKeyDown(KeyDownEvent keyDownEvent) {
                 if (keyDownEvent.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
                     getView().untoggleTooltip();
                 }
             }
         }, KeyDownEvent.getType());
    }

    @Override
    protected void onHide() {
        super.onHide();

        handlerRegistration.removeHandler();
    }
}
