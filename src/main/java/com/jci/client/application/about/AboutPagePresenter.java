package com.jci.client.application.about;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.jci.client.application.ApplicationPresenter;
import com.jci.client.place.NameTokens;

public class AboutPagePresenter  extends Presenter<AboutPagePresenter.MyView, AboutPagePresenter.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.about)
    public interface MyProxy extends ProxyPlace<AboutPagePresenter> {
    }

    @Inject
    public AboutPagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);
    }
}
