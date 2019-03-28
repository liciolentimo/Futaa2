package com.lentimosystems.licio.futaa2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("idEvent")
    @Expose
    private String idEvent;
    @SerializedName("idSoccerXML")
    @Expose
    private String idSoccerXML;
    @SerializedName("strEvent")
    @Expose
    private String strEvent;
    @SerializedName("strFilename")
    @Expose
    private String strFilename;
    @SerializedName("strSport")
    @Expose
    private String strSport;
    @SerializedName("idLeague")
    @Expose
    private String idLeague;
    @SerializedName("strLeague")
    @Expose
    private String strLeague;
    @SerializedName("strSeason")
    @Expose
    private String strSeason;
    @SerializedName("strDescriptionEN")
    @Expose
    private Object strDescriptionEN;
    @SerializedName("strHomeTeam")
    @Expose
    private String strHomeTeam;
    @SerializedName("strAwayTeam")
    @Expose
    private String strAwayTeam;
    @SerializedName("intHomeScore")
    @Expose
    private String intHomeScore;
    @SerializedName("intRound")
    @Expose
    private String intRound;
    @SerializedName("intAwayScore")
    @Expose
    private String intAwayScore;
    @SerializedName("intSpectators")
    @Expose
    private String intSpectators;
    @SerializedName("strHomeGoalDetails")
    @Expose
    private String strHomeGoalDetails;
    @SerializedName("strHomeRedCards")
    @Expose
    private String strHomeRedCards;
    @SerializedName("strHomeYellowCards")
    @Expose
    private String strHomeYellowCards;
    @SerializedName("strHomeLineupGoalkeeper")
    @Expose
    private String strHomeLineupGoalkeeper;
    @SerializedName("strHomeLineupDefense")
    @Expose
    private String strHomeLineupDefense;
    @SerializedName("strHomeLineupMidfield")
    @Expose
    private String strHomeLineupMidfield;
    @SerializedName("strHomeLineupForward")
    @Expose
    private String strHomeLineupForward;
    @SerializedName("strHomeLineupSubstitutes")
    @Expose
    private String strHomeLineupSubstitutes;
    @SerializedName("strHomeFormation")
    @Expose
    private String strHomeFormation;
    @SerializedName("strAwayRedCards")
    @Expose
    private String strAwayRedCards;
    @SerializedName("strAwayYellowCards")
    @Expose
    private String strAwayYellowCards;
    @SerializedName("strAwayGoalDetails")
    @Expose
    private String strAwayGoalDetails;
    @SerializedName("strAwayLineupGoalkeeper")
    @Expose
    private String strAwayLineupGoalkeeper;
    @SerializedName("strAwayLineupDefense")
    @Expose
    private String strAwayLineupDefense;
    @SerializedName("strAwayLineupMidfield")
    @Expose
    private String strAwayLineupMidfield;
    @SerializedName("strAwayLineupForward")
    @Expose
    private String strAwayLineupForward;
    @SerializedName("strAwayLineupSubstitutes")
    @Expose
    private String strAwayLineupSubstitutes;
    @SerializedName("strAwayFormation")
    @Expose
    private String strAwayFormation;
    @SerializedName("intHomeShots")
    @Expose
    private String intHomeShots;
    @SerializedName("intAwayShots")
    @Expose
    private String intAwayShots;
    @SerializedName("dateEvent")
    @Expose
    private String dateEvent;
    @SerializedName("strDate")
    @Expose
    private String strDate;
    @SerializedName("strTime")
    @Expose
    private String strTime;
    @SerializedName("strTVStation")
    @Expose
    private Object strTVStation;
    @SerializedName("idHomeTeam")
    @Expose
    private String idHomeTeam;
    @SerializedName("idAwayTeam")
    @Expose
    private String idAwayTeam;
    @SerializedName("strResult")
    @Expose
    private Object strResult;
    @SerializedName("strCircuit")
    @Expose
    private Object strCircuit;
    @SerializedName("strCountry")
    @Expose
    private Object strCountry;
    @SerializedName("strCity")
    @Expose
    private Object strCity;
    @SerializedName("strPoster")
    @Expose
    private Object strPoster;
    @SerializedName("strFanart")
    @Expose
    private Object strFanart;
    @SerializedName("strThumb")
    @Expose
    private Object strThumb;
    @SerializedName("strBanner")
    @Expose
    private Object strBanner;
    @SerializedName("strMap")
    @Expose
    private Object strMap;
    @SerializedName("strLocked")
    @Expose
    private String strLocked;

    public Result(String idEvent, String idSoccerXML, String strEvent, String strFilename, String strSport, String idLeague, String strLeague, String strSeason, Object strDescriptionEN, String strHomeTeam, String strAwayTeam, String intHomeScore, String intRound, String intAwayScore, String intSpectators, String strHomeGoalDetails, String strHomeRedCards, String strHomeYellowCards, String strHomeLineupGoalkeeper, String strHomeLineupDefense, String strHomeLineupMidfield, String strHomeLineupForward, String strHomeLineupSubstitutes, String strHomeFormation, String strAwayRedCards, String strAwayYellowCards, String strAwayGoalDetails, String strAwayLineupGoalkeeper, String strAwayLineupDefense, String strAwayLineupMidfield, String strAwayLineupForward, String strAwayLineupSubstitutes, String strAwayFormation, String intHomeShots, String intAwayShots, String dateEvent, String strDate, String strTime, Object strTVStation, String idHomeTeam, String idAwayTeam, Object strResult, Object strCircuit, Object strCountry, Object strCity, Object strPoster, Object strFanart, Object strThumb, Object strBanner, Object strMap, String strLocked) {
        this.idEvent = idEvent;
        this.idSoccerXML = idSoccerXML;
        this.strEvent = strEvent;
        this.strFilename = strFilename;
        this.strSport = strSport;
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSeason = strSeason;
        this.strDescriptionEN = strDescriptionEN;
        this.strHomeTeam = strHomeTeam;
        this.strAwayTeam = strAwayTeam;
        this.intHomeScore = intHomeScore;
        this.intRound = intRound;
        this.intAwayScore = intAwayScore;
        this.intSpectators = intSpectators;
        this.strHomeGoalDetails = strHomeGoalDetails;
        this.strHomeRedCards = strHomeRedCards;
        this.strHomeYellowCards = strHomeYellowCards;
        this.strHomeLineupGoalkeeper = strHomeLineupGoalkeeper;
        this.strHomeLineupDefense = strHomeLineupDefense;
        this.strHomeLineupMidfield = strHomeLineupMidfield;
        this.strHomeLineupForward = strHomeLineupForward;
        this.strHomeLineupSubstitutes = strHomeLineupSubstitutes;
        this.strHomeFormation = strHomeFormation;
        this.strAwayRedCards = strAwayRedCards;
        this.strAwayYellowCards = strAwayYellowCards;
        this.strAwayGoalDetails = strAwayGoalDetails;
        this.strAwayLineupGoalkeeper = strAwayLineupGoalkeeper;
        this.strAwayLineupDefense = strAwayLineupDefense;
        this.strAwayLineupMidfield = strAwayLineupMidfield;
        this.strAwayLineupForward = strAwayLineupForward;
        this.strAwayLineupSubstitutes = strAwayLineupSubstitutes;
        this.strAwayFormation = strAwayFormation;
        this.intHomeShots = intHomeShots;
        this.intAwayShots = intAwayShots;
        this.dateEvent = dateEvent;
        this.strDate = strDate;
        this.strTime = strTime;
        this.strTVStation = strTVStation;
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
        this.strResult = strResult;
        this.strCircuit = strCircuit;
        this.strCountry = strCountry;
        this.strCity = strCity;
        this.strPoster = strPoster;
        this.strFanart = strFanart;
        this.strThumb = strThumb;
        this.strBanner = strBanner;
        this.strMap = strMap;
        this.strLocked = strLocked;
    }


    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

      public String getIntHomeScore() {
        return intHomeScore;
    }

    public void setIntHomeScore(String intHomeScore) {
        this.intHomeScore = intHomeScore;
    }


    public String getIntAwayScore() {
        return intAwayScore;
    }


    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrTime() {
        return strTime;
    }

   }
