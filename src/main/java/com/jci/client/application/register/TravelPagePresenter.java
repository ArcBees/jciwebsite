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

package com.jci.client.application.register;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.jci.client.application.ApplicationPresenter;
import com.jci.client.place.NameTokens;

import javax.inject.Inject;

public class TravelPagePresenter extends Presenter<TravelPagePresenter.MyView, TravelPagePresenter.MyProxy> {
    public interface MyView extends View {
        void showSection(String id);

        void showHotel();

        void showTravel();
    }

    @ProxyStandard
    @NameToken(NameTokens.travel)
    public interface MyProxy extends ProxyPlace<TravelPagePresenter> {
    }

    private String id;

    @Inject
    public TravelPagePresenter(EventBus eventBus,
                               MyView view,
                               MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        id = request.getParameter("id", "");
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        getView().showSection(id);
    }
}
