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

package com.jci.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface CommonResource extends ClientBundle {
    public interface Style extends CssResource {
        String dragUp();

        String width();

        String white();

        String round();

        String tuile();

        String button_gray();

        String active();

        String content();

        String actions();

        String shadow();
    }

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Both)
    ImageResource tuile();

    Style style();
}
