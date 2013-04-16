package com.jci.client.application.ui.socialmedia;

import com.google.gwt.http.client.URL;
import com.jci.client.resource.MyConstants;

import javax.inject.Inject;

public class TwitterSharingService implements SharingService {
    private final ShareWindow shareWindow;
    private final MyConstants myConstants;

    @Inject
    public TwitterSharingService(ShareWindow shareWindow,
                                 MyConstants myConstants) {
        this.shareWindow = shareWindow;
        this.myConstants = myConstants;
    }

    @Override
    public void share() {
        shareWindow.open("http://twitter.com/home?status=" + URL.encodePathSegment(myConstants.twitterSummary()));
    }
}
