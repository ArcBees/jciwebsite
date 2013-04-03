package com.jci.client.application.contact;

import com.gwtplatform.mvp.client.UiHandlers;
import com.jci.shared.domain.ContactMessage;

public interface ContactPageUiHandlers extends UiHandlers {
    void contact(ContactMessage contactMessage);
}
