package com.jci.client.rest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

import javax.inject.Singleton;

public class RestModule extends AbstractGinModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    ContactService getContactService() {
        ContactService contactService = GWT.create(ContactService.class);
        Resource resource = new Resource("rest/contact/");
        ((RestServiceProxy) contactService).setResource(resource);

        return contactService;
    }
}
