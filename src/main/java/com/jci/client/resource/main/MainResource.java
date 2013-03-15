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
