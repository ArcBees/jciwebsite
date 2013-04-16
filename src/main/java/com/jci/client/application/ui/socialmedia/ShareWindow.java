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

package com.jci.client.application.ui.socialmedia;

import com.google.gwt.user.client.Window;

import javax.inject.Inject;

class ShareWindow {
    private static final String NAME = "_blank";
    private final String features;

    @Inject
    public ShareWindow(WindowMetrics windowMetrics) {
        this.features = buildFeatures(windowMetrics);
    }

    void open(String url) {
        Window.open(url, NAME, features);
    }

    private static String buildFeatures(WindowMetrics windowMetrics) {
        String width = "width=" + windowMetrics.width;
        String height = "height=" + windowMetrics.height;
        String left = "left=" + windowMetrics.left;
        String top = "top=" + windowMetrics.top;

        return width + "," + height + "," + left + "," + top;
    }
}
