package com.example;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class MenuItem implements Serializable {

    private Long entityId;
    private Integer codMenu;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String accion;
    private String accionTipo;
    private Integer orden;
    private boolean booleanActivo;
    private VMenu vmenu;

    public MenuItem() {
        this.vmenu = new VMenu();
    }

    public MenuItem(Long entityId, Integer codMenu, String titulo, String descripcion, String imagen, String accion,
            String accionTipo, Integer orden, boolean booleanActivo, String strJerarquia) {
        this.entityId = entityId;
        this.codMenu = codMenu;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.accion = accion;
        this.accionTipo = accionTipo;
        this.orden = orden;
        this.booleanActivo = booleanActivo;
        this.vmenu = new VMenu(strJerarquia);
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Integer getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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

    public boolean isBooleanActivo() {
        return booleanActivo;
    }

    public void setBooleanActivo(boolean booleanActivo) {
        this.booleanActivo = booleanActivo;
    }

    public VMenu getVmenu() {
        return vmenu;
    }

    public void setVmenu(VMenu vmenu) {
        this.vmenu = vmenu;
    }

    public String getADVSEARCH_strJerarquia() {
        return vmenu != null ? vmenu.getStrJerarquia() : null;
    }

    public String getCONTAINS_titulo() {
        return titulo;
    }

    public String getCONTAINS_descripcion() {
        return descripcion;
    }

    public String getCONTAINS_accion() {
        return accion;
    }

    public String getActivo() {
        return booleanActivo ? "S" : "N";
    }

    public List<String> getUportalMenuGrupos() {
        return Collections.emptyList();
    }

    public String getUportalMenuGruposStr() {
        return "";
    }
}
