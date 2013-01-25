package com.jci.client.resource.header;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface HeaderResource extends ClientBundle {
    public interface Style extends CssResource {
        String bottomBorder();

        String left();

        String rightColumn();

        String right();

        String rootWrapper();

        String headLangue();

        String title();

        String subtitle();

        String blackbar();

        String navbar();

        String logoMargin();
    }

    ImageResource headLogoJCI_EN();

    ImageResource headLangue_EN();

    ImageResource headMouseOver();

    Style style();
}
