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

package com.jci.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.jci.client.application.about.AboutModule;
import com.jci.client.application.contact.ContactModule;
import com.jci.client.application.home.HomeModule;
import com.jci.client.application.program.ProgramModule;
import com.jci.client.application.register.TravelModule;
import com.jci.client.application.ui.HeaderModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new TravelModule());
        install(new ProgramModule());
        install(new AboutModule());
        install(new ContactModule());
        install(new HeaderModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
