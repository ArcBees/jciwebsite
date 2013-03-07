package com.jci.client.resource.register;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface RegisterResource extends ClientBundle {
    public interface Style extends CssResource {
        String content();

        String actions();

        String register();

        String getThere();
    }

    Style style();
}