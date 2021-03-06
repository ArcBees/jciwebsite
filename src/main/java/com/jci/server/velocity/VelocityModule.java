/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.jci.server.velocity;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import org.apache.velocity.app.VelocityEngine;

import javax.inject.Singleton;

public class VelocityModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().build(VelocityWrapperFactory.class));
    }

    @Provides
    @Singleton
    VelocityEngine buildVelocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();

        velocityEngine.setProperty("resource.loader", "class");
        velocityEngine.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        velocityEngine.init();

        return velocityEngine;
    }
}
