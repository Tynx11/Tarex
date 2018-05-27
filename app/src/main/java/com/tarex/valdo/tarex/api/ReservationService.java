package com.tarex.valdo.tarex.api;

import com.tarex.valdo.tarex.forms.ReservationForm;
import com.tarex.valdo.tarex.model.reservation.ReservationResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReservationService {

    @POST("reservation")
    Single<ReservationResponse> reservation (@Body ReservationForm reservationForm);

}
