package com.jci.server.email;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class EmailModule extends AbstractModule {
    @Override
    protected void configure() {
        requestStaticInjection(SendEmailTask.class);
        install(new FactoryModuleBuilder().build(SendMailFactory.class));
    }
}
