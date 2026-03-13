package com.example;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.example.model.UportalMenu;
import com.example.model.VUportalMenu;
import com.example.model.dao.UportalMenuDAO;

@ManagedBean(name = "adminMenuService")
@ApplicationScoped
public class AdminMenuService implements Serializable {

    @ManagedProperty(value = "#{uportalMenuDAO}")
    private UportalMenuDAO uportalMenuDAO;

    public List<UportalMenu> getAllMenus() {
        return uportalMenuDAO.findAll();
    }

    public void deleteMenu(Long entityId) {
        uportalMenuDAO.delete(entityId);
    }

    public TreeNode<UportalMenu> buildMenuTree() {
        TreeNode<UportalMenu> root = new DefaultTreeNode<>(null, null);
        Map<String, TreeNode<UportalMenu>> nodesByHierarchy = new HashMap<>();

        List<UportalMenu> items = getAllMenus();
        items.sort(Comparator.comparing(item -> {
            VUportalMenu vmenu = item.getVmenu();
            return vmenu != null && vmenu.getStrJerarquia() != null ? vmenu.getStrJerarquia() : "";
        }));

        for (UportalMenu item : items) {
            String hierarchy = item.getVmenu() != null ? item.getVmenu().getStrJerarquia() : null;
            TreeNode<UportalMenu> parentNode = root;

            if (hierarchy != null && hierarchy.contains(".")) {
                String parentHierarchy = hierarchy.substring(0, hierarchy.lastIndexOf('.'));
                parentNode = nodesByHierarchy.getOrDefault(parentHierarchy, root);
            }

            TreeNode<UportalMenu> currentNode = new DefaultTreeNode<>(item, parentNode);
            nodesByHierarchy.put(hierarchy, currentNode);
        }

        return root;
    }

    public void setUportalMenuDAO(UportalMenuDAO uportalMenuDAO) {
        this.uportalMenuDAO = uportalMenuDAO;
    }
}