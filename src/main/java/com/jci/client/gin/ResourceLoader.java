package com.jci.client.gin;

import com.jci.client.resource.main.MainResource;
import com.jci.client.resource.CommonResource;
import com.jci.client.resource.footer.FooterResource;
import com.jci.client.resource.header.HeaderResource;

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    public ResourceLoader(CommonResource commonResource,
                          HeaderResource headerResource,
                          FooterResource footerResource,
                          MainResource mainResource){
        commonResource.style().ensureInjected();
        headerResource.style().ensureInjected();
        footerResource.style().ensureInjected();
        mainResource.style().ensureInjected();
    }
}