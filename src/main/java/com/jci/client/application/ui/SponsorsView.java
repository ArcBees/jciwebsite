package com.jci.client.application.ui;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import javax.inject.Inject;

public class SponsorsView extends Composite {
    public interface Binder extends UiBinder<HTMLPanel, SponsorsView> {
    }

    @Inject
    public SponsorsView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
