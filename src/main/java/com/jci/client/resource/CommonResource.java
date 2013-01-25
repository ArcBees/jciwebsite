package com.jci.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface CommonResource extends ClientBundle {
    public interface Style extends CssResource {
        String width();
    }

    Style style();
}
