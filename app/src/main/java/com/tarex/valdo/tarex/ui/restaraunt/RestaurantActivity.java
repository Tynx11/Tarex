package com.tarex.valdo.tarex.ui.restaraunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.ui.base.BaseActivity;
import com.tarex.valdo.tarex.utils.ImageLoaderHelper;

import static com.tarex.valdo.tarex.utils.Constants.ID_KEY;
import static com.tarex.valdo.tarex.utils.Constants.NAME_KEY;

public class RestaurantActivity extends BaseActivity implements RestaurantView {

    private TextView tvName;
    private TextView tvPlace;
    private TextView tvDescription;
    private TextView tvMonday;
    private TextView tvTuesday;
    private TextView tvWednesday;
    private TextView tvThursday;
    private TextView tvFriday;
    private TextView tvSunday;
    private TextView tvSaturday;

    private ImageView iv_Photo;

    @InjectPresenter
    RestaurantPresenter presenter;


    private Long id;

    public static void start(@NonNull Activity activity, @NonNull Restaurant restaurant) {
        Intent intent = new Intent(activity, RestaurantActivity.class);
        intent.putExtra(NAME_KEY, restaurant.getName());
        intent.putExtra(ID_KEY, restaurant.getId());
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaraunt);
        initViews();
        id = getIntent().getLongExtra(ID_KEY, 0);
    }

    private void initViews() {
       tvName = findViewById(R.id.tv_name_restaraunt);
       tvPlace = findViewById(R.id.tv_address);
       tvDescription = findViewById(R.id.tv_description_details_restaraunt);
       tvMonday = findViewById(R.id.tv_monday);
       tvTuesday = findViewById(R.id.tv_tuesday);
       tvWednesday = findViewById(R.id.tv_wedensday);
       tvThursday = findViewById(R.id.tv_thursday);
       tvFriday = findViewById(R.id.tv_friday);
       tvSunday = findViewById(R.id.tv_sunday);
       tvSaturday = findViewById(R.id.tv_saturday);
       iv_Photo = findViewById(R.id.iv_restaraunt);

    }

    @Override
    public void getRestaurantId() {
        presenter.init(id);
    }

    @Override
    public void setName(Restaurant restaurant) {
        tvName.setText(String.valueOf(restaurant.getName()));
    }

    @Override
    public void setDescription(Restaurant restaurant) {
        tvDescription.setText(String.valueOf(restaurant.getDescription()));

    }

    @Override
    public void setImage(Restaurant restaurant) {
        ImageLoaderHelper.loadPicture(iv_Photo,restaurant.getUrlPhoto());

    }

    @Override
    public void setPlace(Restaurant restaurant) {
        tvPlace.setText(restaurant.getAddress().getCity() + " " + restaurant.getAddress().getStreet() + " " + restaurant.getAddress().getHouse());
    }
}
