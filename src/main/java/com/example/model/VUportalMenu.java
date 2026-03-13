package com.example.model;

import java.io.Serializable;

public class VUportalMenu implements Serializable {

    private String strJerarquia;

    public VUportalMenu() {
    }

    public VUportalMenu(String strJerarquia) {
        this.strJerarquia = strJerarquia;
    }

    public String getStrJerarquia() {
        return strJerarquia;
    }

    public void setStrJerarquia(String strJerarquia) {
        this.strJerarquia = strJerarquia;
    }
}
