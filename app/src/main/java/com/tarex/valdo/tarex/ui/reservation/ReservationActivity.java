package com.tarex.valdo.tarex.ui.reservation;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.ui.base.BaseActivity;
import com.tarex.valdo.tarex.ui.restaraunt.RestaurantView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.tarex.valdo.tarex.utils.Constants.ID_KEY;
import static com.tarex.valdo.tarex.utils.Constants.NAME_KEY;

public class ReservationActivity extends BaseActivity implements ReservationView {

    Button btnPickDate;
    Button btnPickTime;
    Button btnLetsReserv;
    TextView choosenTime;

    Calendar dateAndTime;

    private String restaurantName;
    private Long id;
    private String reservTime;
    private String reservDate;
    private String token;

    @InjectPresenter
    ReservationPresenter presenter;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        init();
        id = getIntent().getLongExtra(ID_KEY,0);
        restaurantName = getIntent().getStringExtra(NAME_KEY);
        dateAndTime=Calendar.getInstance();

        btnLetsReserv.setOnClickListener(view -> {
            presenter.reservation(presenter.getAccesToken(this,"shPref"),id,reservTime,reservDate);

        });

        btnPickTime.setOnClickListener(view -> {

            setTime(view);
        });

        btnPickDate.setOnClickListener(view ->  {

            setDate(view);
        });

    }

    // отображаем диалоговое окно для выбора даты
    public void setDate(View v) {
        new DatePickerDialog(ReservationActivity.this, AlertDialog.THEME_HOLO_LIGHT, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(ReservationActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }


    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);

        }
    };

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm");
            reservDate = df.format(dateAndTime.getTime());
            reservTime = timeFormat.format(dateAndTime.getTime());
            choosenTime.setText(reservDate);

        }
    };

    private void init () {
        btnPickDate = findViewById(R.id.btn_pick_date);
        btnPickTime = findViewById(R.id.btn_pick_time);
        choosenTime = findViewById(R.id.tv_choosen_time);
        btnLetsReserv = findViewById(R.id.btn_lets_reserv);
    }

    @Override
    public void handleError(Throwable error) {

    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}