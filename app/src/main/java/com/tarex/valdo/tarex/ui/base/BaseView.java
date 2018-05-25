package com.tarex.valdo.tarex.ui.base;

public interface BaseView<T> {

    void setPresenter(T presenter);

    void handleError(Throwable error);
}
