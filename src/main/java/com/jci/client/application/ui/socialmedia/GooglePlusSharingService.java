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

import com.jci.client.resource.MyConstants;

import javax.inject.Inject;

public class GooglePlusSharingService implements SharingService {
    private final MyConstants myConstants;
    private final ShareWindow shareWindow;

    @Inject
    public GooglePlusSharingService(ShareWindow shareWindow,
                                    MyConstants myConstants) {
        this.shareWindow = shareWindow;
        this.myConstants = myConstants;
    }

    @Override
    public void share() {
        shareWindow.open(myConstants.googleUrl());
    }
}
