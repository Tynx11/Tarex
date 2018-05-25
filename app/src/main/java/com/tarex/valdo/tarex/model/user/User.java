package com.tarex.valdo.tarex.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User {
    @PrimaryKey
    @SerializedName("id")
    private long id;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastname;

    @SerializedName("login")
    private String login;

    @SerializedName("password")
    private String password;

    @SerializedName("tokens")
    List<UserTokens> userTokens;

    public User() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserTokens> getUserTokens() {
        return userTokens;
    }

    public void setUserTokens(List<UserTokens> userTokens) {
        this.userTokens = userTokens;
    }
}
