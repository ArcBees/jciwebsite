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

package com.jci.client.gin;

import com.jci.client.resource.CommonResource;
import com.jci.client.resource.about.AboutResource;
import com.jci.client.resource.contact.ContactResource;
import com.jci.client.resource.footer.FooterResource;
import com.jci.client.resource.header.HeaderResource;
import com.jci.client.resource.main.MainResource;
import com.jci.client.resource.program.ProgramResource;
import com.jci.client.resource.sponsors.SponsorsResource;

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    public ResourceLoader(CommonResource commonResource,
                          HeaderResource headerResource,
                          FooterResource footerResource,
                          SponsorsResource sponsorsResource,
                          MainResource mainResource,
                          ProgramResource programResource,
                          AboutResource aboutResource,
                          ContactResource contactResource) {
        commonResource.style().ensureInjected();
        headerResource.style().ensureInjected();
        footerResource.style().ensureInjected();
        sponsorsResource.style().ensureInjected();
        mainResource.style().ensureInjected();
        programResource.style().ensureInjected();
        aboutResource.style().ensureInjected();
        contactResource.style().ensureInjected();
    }
}
