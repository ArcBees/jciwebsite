package com.jci.client.gin;

import com.jci.client.resource.ClientResource;

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    public ResourceLoader(ClientResource clientResource){
        clientResource.style().ensureInjected();
    }
}