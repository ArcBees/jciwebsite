package com.jci.server.rest;

import com.google.inject.AbstractModule;

public class RestModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(ContactResource.class);
    }
}
