package com.lentimosystems.licio.futaa2.models;


import com.google.gson.annotations.SerializedName;

public class StandingLeagueTable {

    @SerializedName("name")

    private String name;

    @SerializedName("strBadge")
    String strBadge;

    @SerializedName("teamid")

    private String teamid;
    @SerializedName("played")

    private int played;
    @SerializedName("goalsfor")

    private int goalsfor;
    @SerializedName("goalsagainst")

    private int goalsagainst;
    @SerializedName("goalsdifference")

    private int goalsdifference;
    @SerializedName("win")
    private int win;

    @SerializedName("draw")

    private int draw;
    @SerializedName("loss")

    private int loss;
    @SerializedName("total")
    private int total;



    public StandingLeagueTable(String name, String strBadge, String teamid, int played, int goalsfor, int goalsagainst, int goalsdifference, int win, int draw, int loss, int total) {
        this.name = name;
        this.strBadge = strBadge;
        this.teamid = teamid;
        this.played = played;
        this.goalsfor = goalsfor;
        this.goalsagainst = goalsagainst;
        this.goalsdifference = goalsdifference;
        this.win = win;
        this.draw = draw;
        this.loss = loss;
        this.total = total;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }


    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
