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

package com.jci.client.resource.main;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface MainResource extends ClientBundle {
    public interface Style extends CssResource {
        String sliderWrapper();

        String sponsorWrapper();

        String sliderPhoto();

        String sliderButtons();

        String aWonderfulCity();

        String button_visio();

        String buttons_visio_off();

        String buttons_visio_on();
    }

    Style style();

    ImageResource homeImage001();

    ImageResource button_visio_off();

    ImageResource button_visio_on();

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Horizontal)
    ImageResource degrade_bt();

    ImageResource partners();

    ImageResource arcbees();

    ImageResource qvc();
}
