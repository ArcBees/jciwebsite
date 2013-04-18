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

package com.jci.server.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import com.jci.shared.domain.RegistrationUrl;
import org.junit.Test;
import org.xml.sax.SAXException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationUrlExtractorTest {
    @Test
    public void extract() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        RegistrationUrlExtractor registrationUrlExtractor = new RegistrationUrlExtractor();
        RegistrationUrl registrationUrl = registrationUrlExtractor.extract();

        assertTrue(registrationUrl.getEn().startsWith("/logiciel/gestion_securite/telechargement/?id="));
        assertTrue(registrationUrl.getFr().startsWith("/logiciel/gestion_securite/telechargement/?id="));
        assertFalse(registrationUrl.getEn().equals(registrationUrl.getFr()));
    }
}
