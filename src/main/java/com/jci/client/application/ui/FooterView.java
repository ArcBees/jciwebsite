package com.jci.client.application.ui;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import javax.inject.Inject;

public class FooterView extends Composite {
    public interface Binder extends UiBinder<HTMLPanel, FooterView> {
    }

    @Inject
    public FooterView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
