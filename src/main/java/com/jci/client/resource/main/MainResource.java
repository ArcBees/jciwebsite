package com.jci.client.resource.main;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface MainResource extends ClientBundle {
    public interface Style extends CssResource {
        String dragUp();

        String sliderWrapper();

        String sponsorWrapper();

        String sliderPhoto();

        String sliderButtons();

        String aWonderfulCity();
    }

    Style style();

    ImageResource homeImage001();

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Horizontal)
    ImageResource degrade_bt();

}
