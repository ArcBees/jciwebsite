/*
 Copyright 2013 ArcBees Inc.

 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy of
 the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 License for the specific language governing permissions and limitations under
 the License.
 */

package com.jci.server.guice;

import com.arcbees.appengine.mail.MailModule;
import com.google.inject.AbstractModule;
import com.jci.server.rest.RestModule;
import com.jci.server.velocity.VelocityModule;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new RestModule());
        install(new VelocityModule());
        install(new MailModule());
    }
}
