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

    }

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Both)
    ImageResource tuile();

    Style style();
}
