package com.example.model;

import java.io.Serializable;

public class VMenu implements Serializable {

    private String strJerarquia;

    public VMenu() {
    }

    public VMenu(String strJerarquia) {
        this.strJerarquia = strJerarquia;
    }

    public String getStrJerarquia() {
        return strJerarquia;
    }

    public void setStrJerarquia(String strJerarquia) {
        this.strJerarquia = strJerarquia;
    }
}
