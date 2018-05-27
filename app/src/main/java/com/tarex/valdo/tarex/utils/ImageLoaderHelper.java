package com.tarex.valdo.tarex.utils;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tarex.valdo.tarex.R;

public class ImageLoaderHelper {

    private ImageLoaderHelper() {
    }

    public static void loadPicture(@NonNull ImageView imageView, @NonNull String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .noFade()
                .into(imageView);
    }


}
