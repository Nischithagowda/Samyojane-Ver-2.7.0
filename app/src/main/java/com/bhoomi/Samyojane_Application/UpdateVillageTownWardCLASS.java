package com.bhoomi.Samyojane_Application;

import java.math.BigInteger;

/**
 * Created by Nischitha on 08,November,2021
 **/
public class UpdateVillageTownWardCLASS {
    private String LoginID, RuralOrUrban;
    private BigInteger GscNo;
    private int DesignationCode, NewTownVillageCode, NewWardNo;

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String loginID) {
        LoginID = loginID;
    }

    public String getRuralOrUrban() {
        return RuralOrUrban;
    }

    public void setRuralOrUrban(String ruralOrUrban) {
        RuralOrUrban = ruralOrUrban;
    }

    public BigInteger getGscNo() {
        return GscNo;
    }

    public void setGscNo(BigInteger gscNo) {
        GscNo = gscNo;
    }

    public int getDesignationCode() {
        return DesignationCode;
    }

    public void setDesignationCode(int designationCode) {
        DesignationCode = designationCode;
    }

    public int getNewTownVillageCode() {
        return NewTownVillageCode;
    }

    public void setNewTownVillageCode(int newTownVillageCode) {
        NewTownVillageCode = newTownVillageCode;
    }

    public int getNewWardNo() {
        return NewWardNo;
    }

    public void setNewWardNo(int newWardNo) {
        NewWardNo = newWardNo;
    }
}
