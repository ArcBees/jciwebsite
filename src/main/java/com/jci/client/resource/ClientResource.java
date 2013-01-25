package com.jci.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface ClientResource extends ClientBundle {
    public interface Style extends CssResource {
        String test();
    }

    Style style();
}
