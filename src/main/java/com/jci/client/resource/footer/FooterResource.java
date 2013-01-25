package com.jci.client.resource.footer;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface FooterResource extends ClientBundle {
    public interface Style extends CssResource {
        String copy();
    }

    Style style();
}
