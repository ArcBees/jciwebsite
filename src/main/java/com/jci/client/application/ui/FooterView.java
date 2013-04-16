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

package com.jci.client.application.ui;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.jci.client.application.ui.socialmedia.Facebook;
import com.jci.client.application.ui.socialmedia.GooglePlus;
import com.jci.client.application.ui.socialmedia.SharingService;
import com.jci.client.application.ui.socialmedia.Twitter;
import com.jci.client.resource.footer.FooterResource;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class FooterView extends Composite implements AttachEvent.Handler {
    public interface Binder extends UiBinder<HTMLPanel, FooterView> {
    }

    private final SharingService twitterSharingService;
    private final SharingService facebookSharingService;
    private final SharingService googlePlusSharingService;
    private final String shareStyleName;
    private final String spanHiddenStyleName;
    private final String spanVisibleStyleName;
    private final String shareFacebookStyleName;
    private final String shareTwitterStyleName;
    private final String shareGoogleStyleName;

    @Inject
    public FooterView(Binder binder,
                      @Twitter SharingService twitterSharingService,
                      @Facebook SharingService facebookSharingService,
                      @GooglePlus SharingService googlePlusSharingService,
                      FooterResource footerResource) {
        this.twitterSharingService = twitterSharingService;
        this.facebookSharingService = facebookSharingService;
        this.googlePlusSharingService = googlePlusSharingService;
        initWidget(binder.createAndBindUi(this));

        shareStyleName = footerResource.style().share();
        spanHiddenStyleName = footerResource.style().spanHidden();
        spanVisibleStyleName = footerResource.style().spanVisible();
        shareFacebookStyleName = footerResource.style().facebook();
        shareTwitterStyleName = footerResource.style().twitter();
        shareGoogleStyleName = footerResource.style().google();

        asWidget().addAttachHandler(this);
    }

    @Override
    public void onAttachOrDetach(AttachEvent attachEvent) {
        if (attachEvent.isAttached()) {
            bindGwtQuery();
        }
    }

    private void bindGwtQuery() {
        $("." + shareStyleName).click(new Function() {
            @Override
            public void f(Element e) {
                toggleShare();
            }
        });

        $("." + shareFacebookStyleName).click(new Function() {
            @Override
            public void f(Element e) {
                facebookSharingService.share();
            }
        });

        $("." + shareTwitterStyleName).click(new Function() {
            @Override
            public void f(Element e) {
                twitterSharingService.share();
            }
        });

        $("." + shareGoogleStyleName).click(new Function() {
            @Override
            public void f(Element e) {
                googlePlusSharingService.share();
            }
        });
    }

    private void toggleShare() {
        if (!$("." + spanHiddenStyleName).hasClass(spanVisibleStyleName)) {
            $("." + shareStyleName + " span").text(":");
            $("." + spanHiddenStyleName).addClass(spanVisibleStyleName);
        } else {
            $("." + shareStyleName + " span").text("");
            $("." + spanHiddenStyleName).removeClass(spanVisibleStyleName);
        }
    }
}
