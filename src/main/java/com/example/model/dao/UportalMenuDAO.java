package com.example.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.example.model.UportalMenu;

@ManagedBean(name = "uportalMenuDAO")
@ApplicationScoped
public class UportalMenuDAO implements Serializable {

    private final List<UportalMenu> items = new ArrayList<>(Arrays.asList(
            new UportalMenu(1L, 100, "Inicio", "Pantalla principal", "fal fa-home", "/index.xhtml", "F", 1, true,
                    "1"),
            new UportalMenu(2L, 110, "Usuarios", "Administracion de usuarios", "fal fa-users",
                    "/users/list.xhtml", "F", 2, true, "1.1"),
            new UportalMenu(3L, 120, "Informes", "Informes del sistema", "fal fa-chart-bar",
                    "/reports/main.xhtml", "I", 3, true, "1.2"),
            new UportalMenu(4L, 130, "Ayuda", "Enlace externo de ayuda", "fal fa-circle-question",
                    "https://www.upct.es", "E", 4, true, "2"),
            new UportalMenu(5L, 140, "Archivado", "Opcion desactivada", "fal fa-box-archive", "/archive.xhtml",
                    "F", 5, false, "3")));

    public List<UportalMenu> findAll() {
        return new ArrayList<>(items);
    }

    public void delete(Long entityId) {
        if (entityId == null) {
            return;
        }
        Iterator<UportalMenu> it = items.iterator();
        while (it.hasNext()) {
            if (entityId.equals(it.next().getEntityId())) {
                it.remove();
                return;
            }
        }
    }
}
