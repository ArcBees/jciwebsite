package com.jci.client.application.ui.socialmedia;

import com.jci.client.resource.CommonResource;
import com.jci.client.resource.MyConstants;

import javax.inject.Inject;

public class FacebookSharingService implements SharingService {
    private final ShareWindow shareWindow;
    private final String imageUri;
    private final MyConstants myConstants;

    @Inject
    public FacebookSharingService(ShareWindow shareWindow,
                                  CommonResource commonResource,
                                  MyConstants myConstants) {
        this.shareWindow = shareWindow;
        this.imageUri = commonResource.headLogoJCIBig().getSafeUri().asString();
        this.myConstants = myConstants;
    }

    @Override
    public void share() {
        String url = "https://www.facebook.com/sharer/sharer.php?s=+100" +
                "&p[title]=" + myConstants.facebookTitle() + "" +
                "&p[url]=" + myConstants.facebookUrl() + "" +
                "&p[images][0]=" + imageUri +
                "&p[summary]=" + myConstants.facebookSummary();

        shareWindow.open(url);
    }
}
