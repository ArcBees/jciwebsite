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

import javax.inject.Inject;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.plugins.effects.PropertiesAnimation.Easing.SWING;

public class RegisterPageView extends ViewImpl implements RegisterPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, RegisterPageView> {
    }

    @Inject
    public RegisterPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void scrollTo(String id) {
        if (id != "") {
            int offsetTop = $("#" + id).offset().top;
            $("html, body").animate("scrollTop:'" + offsetTop + "'", 800, SWING);
        }
    }
}
