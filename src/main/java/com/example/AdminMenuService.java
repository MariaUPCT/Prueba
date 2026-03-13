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

@ManagedBean(name = "adminMenuService")
@ApplicationScoped
public class AdminMenuService implements Serializable {

    @ManagedProperty(value = "#{menuDAO}")
    private MenuDAO menuDAO;

    public List<MenuItem> getAllMenus() {
        return menuDAO.findAll();
    }

    public void deleteMenu(Long entityId) {
        menuDAO.delete(entityId);
    }

    public TreeNode<MenuItem> buildMenuTree() {
        TreeNode<MenuItem> root = new DefaultTreeNode<>(null, null);
        Map<String, TreeNode<MenuItem>> nodesByHierarchy = new HashMap<>();

        List<MenuItem> items = getAllMenus();
        items.sort(Comparator.comparing(item -> {
            VMenu vmenu = item.getVmenu();
            return vmenu != null && vmenu.getStrJerarquia() != null ? vmenu.getStrJerarquia() : "";
        }));

        for (MenuItem item : items) {
            String hierarchy = item.getVmenu() != null ? item.getVmenu().getStrJerarquia() : null;
            TreeNode<MenuItem> parentNode = root;

            if (hierarchy != null && hierarchy.contains(".")) {
                String parentHierarchy = hierarchy.substring(0, hierarchy.lastIndexOf('.'));
                parentNode = nodesByHierarchy.getOrDefault(parentHierarchy, root);
            }

            TreeNode<MenuItem> currentNode = new DefaultTreeNode<>(item, parentNode);
            nodesByHierarchy.put(hierarchy, currentNode);
        }

        return root;
    }

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}