package com.example.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class UportalMenu implements Serializable {

    private Long entityId;
    private Integer codMenu;
    private String titulo;
    private String descripcion;
    private String tituloIngles;
    private String descripcionIngles;
    private String imagen;
    private String imagenExterna;
    private String accion;
    private String accionTipo;
    private String renderSemilla;
    private String openInNewTab;
    private String codPermiso;
    private String sendLangParameter;
    private Integer codModulo;
    private Integer codPadre;
    private Integer orden;
    private boolean booleanActivo;
    private VUportalMenu vmenu;

    public UportalMenu() {
        this.renderSemilla = "S";
        this.openInNewTab = "N";
        this.sendLangParameter = "N";
        this.vmenu = new VUportalMenu();
    }

    public UportalMenu(Long entityId, Integer codMenu, String titulo, String descripcion, String imagen, String accion,
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
        this.vmenu = new VUportalMenu(strJerarquia);
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

    public String getTituloIngles() {
        return tituloIngles;
    }

    public void setTituloIngles(String tituloIngles) {
        this.tituloIngles = tituloIngles;
    }

    public String getDescripcionIngles() {
        return descripcionIngles;
    }

    public void setDescripcionIngles(String descripcionIngles) {
        this.descripcionIngles = descripcionIngles;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenExterna() {
        return imagenExterna;
    }

    public void setImagenExterna(String imagenExterna) {
        this.imagenExterna = imagenExterna;
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

    public String getRenderSemilla() {
        return renderSemilla;
    }

    public void setRenderSemilla(String renderSemilla) {
        this.renderSemilla = renderSemilla;
    }

    public String getOpenInNewTab() {
        return openInNewTab;
    }

    public void setOpenInNewTab(String openInNewTab) {
        this.openInNewTab = openInNewTab;
    }

    public String getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(String codPermiso) {
        this.codPermiso = codPermiso;
    }

    public String getSendLangParameter() {
        return sendLangParameter;
    }

    public void setSendLangParameter(String sendLangParameter) {
        this.sendLangParameter = sendLangParameter;
    }

    public Integer getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(Integer codModulo) {
        this.codModulo = codModulo;
    }

    public Integer getCodPadre() {
        return codPadre;
    }

    public void setCodPadre(Integer codPadre) {
        this.codPadre = codPadre;
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

    public VUportalMenu getVmenu() {
        return vmenu;
    }

    public void setVmenu(VUportalMenu vmenu) {
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

    public void setActivo(String activo) {
        this.booleanActivo = "S".equalsIgnoreCase(activo);
    }

    public List<String> getUportalMenuGrupos() {
        return Collections.emptyList();
    }

    public String getUportalMenuGruposStr() {
        return "";
    }
}
