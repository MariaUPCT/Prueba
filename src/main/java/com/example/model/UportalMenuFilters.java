package com.example.model;

import java.io.Serializable;

public class UportalMenuFilters implements Serializable {

    private String ADVSEARCH_strJerarquia;
    private Integer codMenu;
    private String CONTAINS_titulo;
    private String CONTAINS_descripcion;
    private String CONTAINS_accion;
    private String accionTipo;
    private Integer orden;

    public String getADVSEARCH_strJerarquia() {
        return ADVSEARCH_strJerarquia;
    }

    public void setADVSEARCH_strJerarquia(String aDVSEARCH_strJerarquia) {
        ADVSEARCH_strJerarquia = aDVSEARCH_strJerarquia;
    }

    public Integer getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public String getCONTAINS_titulo() {
        return CONTAINS_titulo;
    }

    public void setCONTAINS_titulo(String cONTAINS_titulo) {
        CONTAINS_titulo = cONTAINS_titulo;
    }

    public String getCONTAINS_descripcion() {
        return CONTAINS_descripcion;
    }

    public void setCONTAINS_descripcion(String cONTAINS_descripcion) {
        CONTAINS_descripcion = cONTAINS_descripcion;
    }

    public String getCONTAINS_accion() {
        return CONTAINS_accion;
    }

    public void setCONTAINS_accion(String cONTAINS_accion) {
        CONTAINS_accion = cONTAINS_accion;
    }

    public String getAccionTipo() {
        return accionTipo;
    }

    public void setAccionTipo(String accionTipo) {
        this.accionTipo = accionTipo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
