package com.jci.client.application.about;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class AboutPageView extends ViewImpl implements AboutPagePresenter.MyView {
    @UiField
    DivElement quebec;
    @UiField
    DivElement canada;
    @UiField
    AnchorElement buttonCanada;
    @UiField
    AnchorElement buttonQuebec;

    public interface Binder extends UiBinder<Widget, AboutPageView> {
    }

    @Inject
    public AboutPageView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        $(buttonCanada).click(new Function() {
            @Override
            public boolean f(Event e) {
                $(canada).show();
                $(quebec).hide();

                return false;
            }
        });

        $(buttonQuebec).click(new Function() {
            @Override
            public boolean f(Event e) {
                $(quebec).show();
                $(canada).hide();

                return false;
            }
        });
    }
}
