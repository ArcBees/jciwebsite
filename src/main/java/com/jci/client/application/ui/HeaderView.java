package com.jci.client.application.ui;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import javax.inject.Inject;

public class HeaderView extends Composite {
    public interface Binder extends UiBinder<HTMLPanel, HeaderView> {
    }

    @Inject
    public HeaderView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
