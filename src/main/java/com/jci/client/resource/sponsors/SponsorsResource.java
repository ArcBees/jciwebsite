package com.jci.client.resource.sponsors;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandre Breton
 * Date: 13-03-19
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public interface SponsorsResource extends ClientBundle{
    public interface Style extends CssResource {

        String sponsorWrapper();
    }


    ImageResource lavery_en();

    ImageResource lavery_fr();

    ImageResource arcbees();

    ImageResource qvc();

    Style style();
}