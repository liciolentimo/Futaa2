package com.lentimosystems.licio.futaa2.models;

import com.google.gson.annotations.SerializedName;

public class League {


    @SerializedName("idLeague")
    String idleague;

    @SerializedName("strBadge")
    String strBadge;

    @SerializedName("strLeague")
    String strLeague;

    @SerializedName("strCountry")
    String strCountry;

    public League(String idleague, String strBadge, String strLeague, String strCountry) {
        this.idleague = idleague;
        this.strBadge = strBadge;
        this.strLeague = strLeague;
        this.strCountry = strCountry;
    }

    public String getIdleague() {
        return idleague;
    }

    public void setIdleague(String idleague) {
        this.idleague = idleague;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }
}
