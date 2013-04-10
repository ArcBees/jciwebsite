package com.jci.client.application.ui;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

import javax.inject.Inject;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView> implements HeaderUiHandlers {
    public interface MyView extends View, HasUiHandlers<HeaderUiHandlers> {
        void activateCurrentLink(String nameToken);
    }

    private final PlaceManager placeManager;

    @Inject
    public HeaderPresenter(EventBus eventBus,
                           MyView view,
                           PlaceManager placeManager) {
        super(eventBus, view);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        activateCurrentLinks();
    }

    @Override
    protected void onReset() {
        super.onReset();

        activateCurrentLinks();
    }

    private void activateCurrentLinks() {
        PlaceRequest placeRequest = placeManager.getCurrentPlaceRequest();
        String nameToken = placeRequest.getNameToken();

        getView().activateCurrentLink(nameToken);
    }

    @Override
    public void switchLocale() {
        LocaleInfo currentLocale = LocaleInfo.getCurrentLocale();

        String newLocale;

        if (currentLocale.getLocaleName().equals("fr")) {
            newLocale = "en";
        } else {
            newLocale = "fr";
        }

        Window.Location.assign(Window.Location.createUrlBuilder()
                .setParameter(LocaleInfo.getLocaleQueryParam(), newLocale)
                .buildString());
    }
}
