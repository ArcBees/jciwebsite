package com.jci.client.resource.footer;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface FooterResource extends ClientBundle {
    public interface Style extends CssResource {
        String copy();

        String city();
    }

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Both)
    ImageResource copy();

    ImageResource city();

    Style style();
}
