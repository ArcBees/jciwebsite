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

package com.jci.client.application.contact;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.jci.client.application.ApplicationPresenter;
import com.jci.client.place.NameTokens;
import com.jci.client.rest.ContactService;
import com.jci.shared.domain.ContactMessage;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import javax.inject.Inject;

public class ContactPagePresenter extends Presenter<ContactPagePresenter.MyView,
        ContactPagePresenter.MyProxy> implements ContactPageUiHandlers {
    public interface MyView extends View, HasUiHandlers<ContactPageUiHandlers> {
        void errorSending();

        void successSending();
    }

    @ProxyStandard
    @NameToken(NameTokens.contact)
    public interface MyProxy extends ProxyPlace<ContactPagePresenter> {
    }

    private final ContactService contactService;

    @Inject
    public ContactPagePresenter(EventBus eventBus,
                                MyView view,
                                MyProxy proxy,
                                ContactService contactService) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);

        this.contactService = contactService;

        getView().setUiHandlers(this);
    }

    @Override
    public void contact(ContactMessage contactMessage) {
        contactService.contact(contactMessage, new MethodCallback<Void>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                getView().errorSending();
            }

            @Override
            public void onSuccess(Method method, Void response) {
                getView().successSending();
            }
        });
    }
}
