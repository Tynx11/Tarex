package com.tarex.valdo.tarex.ui.reservation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ReservationView extends MvpView {
    @StateStrategyType(OneExecutionStateStrategy.class)
    void handleError(Throwable error);

    void setToken (String token);
}
