package com.lentimosystems.licio.futaa2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveScore {
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("League")
    @Expose
    private String league;
    @SerializedName("Round")
    @Expose
    private String round;
    @SerializedName("HomeTeam")
    @Expose
    private String homeTeam;
    @SerializedName("HomeTeam_Id")
    @Expose
    private String homeTeamId;
    @SerializedName("AwayTeam")
    @Expose
    private String awayTeam;
    @SerializedName("AwayTeam_Id")
    @Expose
    private String awayTeamId;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("HomeGoals")
    @Expose
    private String homeGoals;
    @SerializedName("AwayGoals")
    @Expose
    private String awayGoals;
    @SerializedName("Location")
    @Expose
    private String location;

    public LiveScore(String date, String league, String round, String homeTeam, String homeTeamId, String awayTeam, String awayTeamId, String time, String homeGoals, String awayGoals, String location) {
        this.date = date;
        this.league = league;
        this.round = round;
        this.homeTeam = homeTeam;
        this.homeTeamId = homeTeamId;
        this.awayTeam = awayTeam;
        this.awayTeamId = awayTeamId;
        this.time = time;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
