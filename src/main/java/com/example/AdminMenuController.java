package com.example;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "adminMenuController")
@RequestScoped
public class AdminMenuController implements Serializable {

    private AdminMenuTableModel tablaMenu;
    private TreeNode<MenuItem> treeInfoMenus;
    private TreeNode<MenuItem> treeInfoMenusSelected;

    @ManagedProperty(value = "#{menuDAO}")
    private MenuDAO menuDAO;

    @PostConstruct
    public void init() {
        this.tablaMenu = new AdminMenuTableModel(menuDAO);
        initTreeMenus();
    }

    public void initTreeMenus() {
        TreeNode<MenuItem> root = new DefaultTreeNode<>(null, null);
        Map<String, TreeNode<MenuItem>> nodesByHierarchy = new HashMap<>();

        List<MenuItem> items = menuDAO.findAll();
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

        this.treeInfoMenus = root;
    }

    public AdminMenuTableModel getTablaMenu() {
        return tablaMenu;
    }

    public void setTablaMenu(AdminMenuTableModel tablaMenu) {
        this.tablaMenu = tablaMenu;
    }

    public TreeNode<MenuItem> getTreeInfoMenus() {
        return treeInfoMenus;
    }

    public void setTreeInfoMenus(TreeNode<MenuItem> treeInfoMenus) {
        this.treeInfoMenus = treeInfoMenus;
    }

    public TreeNode<MenuItem> getTreeInfoMenusSelected() {
        return treeInfoMenusSelected;
    }

    public void setTreeInfoMenusSelected(TreeNode<MenuItem> treeInfoMenusSelected) {
        this.treeInfoMenusSelected = treeInfoMenusSelected;
    }

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}
