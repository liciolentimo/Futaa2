package com.lentimosystems.licio.futaa2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("idPlayer")
    @Expose
    private String idPlayer;
    @SerializedName("idTeam")
    @Expose
    private String idTeam;
    @SerializedName("idSoccerXML")
    @Expose
    private String idSoccerXML;
    @SerializedName("idPlayerManager")
    @Expose
    private String idPlayerManager;
    @SerializedName("strNationality")
    @Expose
    private String strNationality;
    @SerializedName("strPlayer")
    @Expose
    private String strPlayer;
    @SerializedName("strTeam")
    @Expose
    private String strTeam;
    @SerializedName("strSport")
    @Expose
    private String strSport;
    @SerializedName("intSoccerXMLTeamID")
    @Expose
    private String intSoccerXMLTeamID;
    @SerializedName("dateBorn")
    @Expose
    private String dateBorn;
    @SerializedName("dateSigned")
    @Expose
    private String dateSigned;
    @SerializedName("strSigning")
    @Expose
    private String strSigning;
    @SerializedName("strWage")
    @Expose
    private String strWage;
    @SerializedName("strBirthLocation")
    @Expose
    private String strBirthLocation;
    @SerializedName("strDescriptionEN")
    @Expose
    private String strDescriptionEN;
    @SerializedName("strDescriptionDE")
    @Expose
    private Object strDescriptionDE;
    @SerializedName("strDescriptionFR")
    @Expose
    private Object strDescriptionFR;
    @SerializedName("strDescriptionCN")
    @Expose
    private Object strDescriptionCN;
    @SerializedName("strDescriptionIT")
    @Expose
    private Object strDescriptionIT;
    @SerializedName("strDescriptionJP")
    @Expose
    private Object strDescriptionJP;
    @SerializedName("strDescriptionRU")
    @Expose
    private Object strDescriptionRU;
    @SerializedName("strDescriptionES")
    @Expose
    private String strDescriptionES;
    @SerializedName("strDescriptionPT")
    @Expose
    private Object strDescriptionPT;
    @SerializedName("strDescriptionSE")
    @Expose
    private Object strDescriptionSE;
    @SerializedName("strDescriptionNL")
    @Expose
    private Object strDescriptionNL;
    @SerializedName("strDescriptionHU")
    @Expose
    private Object strDescriptionHU;
    @SerializedName("strDescriptionNO")
    @Expose
    private Object strDescriptionNO;
    @SerializedName("strDescriptionIL")
    @Expose
    private Object strDescriptionIL;
    @SerializedName("strDescriptionPL")
    @Expose
    private Object strDescriptionPL;
    @SerializedName("strGender")
    @Expose
    private String strGender;
    @SerializedName("strPosition")
    @Expose
    private String strPosition;
    @SerializedName("strCollege")
    @Expose
    private Object strCollege;
    @SerializedName("strFacebook")
    @Expose
    private String strFacebook;
    @SerializedName("strWebsite")
    @Expose
    private String strWebsite;
    @SerializedName("strTwitter")
    @Expose
    private String strTwitter;
    @SerializedName("strInstagram")
    @Expose
    private String strInstagram;
    @SerializedName("strYoutube")
    @Expose
    private String strYoutube;
    @SerializedName("strHeight")
    @Expose
    private String strHeight;
    @SerializedName("strWeight")
    @Expose
    private String strWeight;
    @SerializedName("intLoved")
    @Expose
    private String intLoved;
    @SerializedName("strThumb")
    @Expose
    private String strThumb;
    @SerializedName("strCutout")
    @Expose
    private String strCutout;
    @SerializedName("strFanart1")
    @Expose
    private String strFanart1;
    @SerializedName("strFanart2")
    @Expose
    private String strFanart2;
    @SerializedName("strFanart3")
    @Expose
    private String strFanart3;
    @SerializedName("strFanart4")
    @Expose
    private String strFanart4;
    @SerializedName("strLocked")
    @Expose
    private String strLocked;

    public Player(String idPlayer, String idTeam, String idSoccerXML, String idPlayerManager, String strNationality, String strPlayer, String strTeam, String strSport, String intSoccerXMLTeamID, String dateBorn, String dateSigned, String strSigning, String strWage, String strBirthLocation, String strDescriptionEN, Object strDescriptionDE, Object strDescriptionFR, Object strDescriptionCN, Object strDescriptionIT, Object strDescriptionJP, Object strDescriptionRU, String strDescriptionES, Object strDescriptionPT, Object strDescriptionSE, Object strDescriptionNL, Object strDescriptionHU, Object strDescriptionNO, Object strDescriptionIL, Object strDescriptionPL, String strGender, String strPosition, Object strCollege, String strFacebook, String strWebsite, String strTwitter, String strInstagram, String strYoutube, String strHeight, String strWeight, String intLoved, String strThumb, String strCutout, String strFanart1, String strFanart2, String strFanart3, String strFanart4, String strLocked) {
        this.idPlayer = idPlayer;
        this.idTeam = idTeam;
        this.idSoccerXML = idSoccerXML;
        this.idPlayerManager = idPlayerManager;
        this.strNationality = strNationality;
        this.strPlayer = strPlayer;
        this.strTeam = strTeam;
        this.strSport = strSport;
        this.intSoccerXMLTeamID = intSoccerXMLTeamID;
        this.dateBorn = dateBorn;
        this.dateSigned = dateSigned;
        this.strSigning = strSigning;
        this.strWage = strWage;
        this.strBirthLocation = strBirthLocation;
        this.strDescriptionEN = strDescriptionEN;
        this.strDescriptionDE = strDescriptionDE;
        this.strDescriptionFR = strDescriptionFR;
        this.strDescriptionCN = strDescriptionCN;
        this.strDescriptionIT = strDescriptionIT;
        this.strDescriptionJP = strDescriptionJP;
        this.strDescriptionRU = strDescriptionRU;
        this.strDescriptionES = strDescriptionES;
        this.strDescriptionPT = strDescriptionPT;
        this.strDescriptionSE = strDescriptionSE;
        this.strDescriptionNL = strDescriptionNL;
        this.strDescriptionHU = strDescriptionHU;
        this.strDescriptionNO = strDescriptionNO;
        this.strDescriptionIL = strDescriptionIL;
        this.strDescriptionPL = strDescriptionPL;
        this.strGender = strGender;
        this.strPosition = strPosition;
        this.strCollege = strCollege;
        this.strFacebook = strFacebook;
        this.strWebsite = strWebsite;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;
        this.strYoutube = strYoutube;
        this.strHeight = strHeight;
        this.strWeight = strWeight;
        this.intLoved = intLoved;
        this.strThumb = strThumb;
        this.strCutout = strCutout;
        this.strFanart1 = strFanart1;
        this.strFanart2 = strFanart2;
        this.strFanart3 = strFanart3;
        this.strFanart4 = strFanart4;
        this.strLocked = strLocked;
    }



    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }



    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }



    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }


    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    public String getStrWeight() {
        return strWeight;
    }


    public String getStrCutout() {
        return strCutout;
    }


}
