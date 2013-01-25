package com.jci.client.resource.header;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface HeaderResource extends ClientBundle {
    public interface Style extends CssResource {
        String bottomBorder();
    }

    ImageResource headLogoJCI_EN();

    Style style();
}
