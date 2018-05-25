package com.tarex.valdo.tarex.model.user;

import com.google.gson.annotations.SerializedName;

class UserTokens {
    @SerializedName("id")
    Long id;

    @SerializedName("value")
    String value;

    @SerializedName("user")
    String userId;
}
