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

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jci.shared.domain.RegistrationUrl;

public class RegistrationUrlExtractor {
    private final String pageUrl = "http://www.jccq.qc" +
            ".ca/Categorie-dactivites/Congres-National-et-AGA-JCI-Canada/Convention" +
            "-Nationale-JCI-Canada-2013-2013-JCI-Canada-National-Convention.aspx";

    public RegistrationUrl extract() {
        String html = getHtmlPage();

        Pattern htmltag = Pattern.compile("<a\\b[^>]*href=\"[^>]*>(click here|cliquez ici)</a>");
        Pattern link = Pattern.compile("href=\"(.*?)\"");
        Matcher matcher = htmltag.matcher(html);

        String fr = "";
        String en = "";

        while (matcher.find()) {
            String group = matcher.group();
            Matcher linkMatcher = link.matcher(group);
            if (group.contains("cliquez ici")) {
                fr = getLink(linkMatcher);
            } else {
                en = getLink(linkMatcher);
            }
        }

        RegistrationUrl registrationUrl = new RegistrationUrl();
        registrationUrl.setEn(en);
        registrationUrl.setFr(fr);

        return registrationUrl;
    }

    private String getLink(Matcher matcher) {
        String url = "";
        while (matcher.find()) {
            String dirty = matcher.group();
            url = dirty.replaceFirst("href=\"", "").replaceAll("\"(.*?)", "");
        }
        return url;
    }

    private String getHtmlPage() {
        URL url;
        InputStream is = null;
        DataInputStream dis;
        String line;

        String text = "";

        try {
            url = new URL(pageUrl);
            is = url.openStream();
            dis = new DataInputStream(new BufferedInputStream(is));

            while ((line = dis.readLine()) != null) {
                text += line;
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
            }
        }

        return text;
    }
}
