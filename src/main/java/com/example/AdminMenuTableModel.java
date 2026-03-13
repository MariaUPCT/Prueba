package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class AdminMenuTableModel extends LazyDataModel<MenuItem> implements Serializable {

    private final AdminMenuService adminMenuService;
    private MenuFilters filters = new MenuFilters();
    private MenuItem selection;
    private boolean newItem;

    public AdminMenuTableModel(AdminMenuService adminMenuService) {
        this.adminMenuService = adminMenuService;
    }

    @Override
    public List<MenuItem> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        List<MenuItem> filtered = getFilteredItems();

        setRowCount(filtered.size());

        if (filtered.isEmpty() || first >= filtered.size()) {
            return new ArrayList<>();
        }

        int toIndex = Math.min(first + pageSize, filtered.size());
        return filtered.subList(first, toIndex);
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return getFilteredItems().size();
    }

    @Override
    public String getRowKey(MenuItem item) {
        return item != null && item.getEntityId() != null ? String.valueOf(item.getEntityId()) : null;
    }

    @Override
    public MenuItem getRowData(String rowKey) {
        if (rowKey == null || rowKey.trim().isEmpty()) {
            return null;
        }

        return adminMenuService.getAllMenus().stream()
                .filter(item -> item.getEntityId() != null)
                .filter(item -> rowKey.equals(String.valueOf(item.getEntityId())))
                .findFirst()
                .orElse(null);
    }

    private List<MenuItem> getFilteredItems() {
        List<MenuItem> allItems = adminMenuService.getAllMenus();

        return allItems.stream()
                .filter(this::matchFilters)
                .sorted(Comparator.comparing(i -> safe(i.getVmenu() != null ? i.getVmenu().getStrJerarquia() : "")))
                .collect(Collectors.toList());
    }

    private boolean matchFilters(MenuItem item) {
        if (!contains(item.getADVSEARCH_strJerarquia(), filters.getADVSEARCH_strJerarquia())) {
            return false;
        }
        if (filters.getCodMenu() != null && !filters.getCodMenu().equals(item.getCodMenu())) {
            return false;
        }
        if (!contains(item.getTitulo(), filters.getCONTAINS_titulo())) {
            return false;
        }
        if (!contains(item.getDescripcion(), filters.getCONTAINS_descripcion())) {
            return false;
        }
        if (!contains(item.getAccion(), filters.getCONTAINS_accion())) {
            return false;
        }
        if (!equalsIgnoreCase(item.getAccionTipo(), filters.getAccionTipo())) {
            return false;
        }
        if (filters.getOrden() != null && !filters.getOrden().equals(item.getOrden())) {
            return false;
        }
        return true;
    }

    private boolean contains(String source, String value) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        return safe(source).toLowerCase(Locale.ROOT).contains(value.trim().toLowerCase(Locale.ROOT));
    }

    private boolean equalsIgnoreCase(String source, String value) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        return safe(source).equalsIgnoreCase(value.trim());
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }

    public void initSave() {
        this.selection = new MenuItem();
        this.newItem = true;
    }

    public String initSaveAndGoForm() {
        initSave();
        return "menu_form.xhtml?faces-redirect=true";
    }
    
    public String remove() {
        if (selection != null && !isNew()) {
            adminMenuService.deleteMenu(selection.getEntityId());
            selection = null;
        }
        return null;
    }

    public boolean isNew() {
        return newItem;
    }

    public void clear() {
        this.filters = new MenuFilters();
    }

    public MenuFilters getFilters() {
        return filters;
    }

    public void setFilters(MenuFilters filters) {
        this.filters = filters;
    }

    public MenuItem getSelection() {
        return selection;
    }

    public void setSelection(MenuItem selection) {
        this.selection = selection;
        this.newItem = false;
    }
}
