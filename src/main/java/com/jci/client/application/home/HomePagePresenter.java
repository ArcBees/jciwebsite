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

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.jci.client.application.ApplicationPresenter;
import com.jci.client.place.NameTokens;
import com.jci.client.rest.RegistrationService;
import com.jci.shared.domain.RegistrationUrl;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
    public interface MyView extends View {
        void startCarousel();

        void showVideoTrigger();

        void setRegistrationUrl(String registrationUrl);
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    private final RegistrationService registrationService;

    @Inject
    public HomePagePresenter(EventBus eventBus,
                             MyView view,
                             MyProxy proxy,
                             RegistrationService registrationService) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);

        this.registrationService = registrationService;
    }

    @Override
    protected void onBind() {
        super.onBind();

        getSubscriptionUrl();
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        getView().startCarousel();
        getView().showVideoTrigger();
    }

    private void getSubscriptionUrl() {
        registrationService.getRegistrationUrl(new MethodCallback<RegistrationUrl>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                Window.alert("Failure");
            }

            @Override
            public void onSuccess(Method method, RegistrationUrl registrationUrl) {
                getView().setRegistrationUrl(registrationUrl.getFr());
            }
        });
    }
}
