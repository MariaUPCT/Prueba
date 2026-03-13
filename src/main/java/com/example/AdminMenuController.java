package com.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.TreeNode;

@ManagedBean(name = "adminMenuController")
@RequestScoped
public class AdminMenuController implements Serializable {

    private AdminMenuTableModel tablaMenu;
    private TreeNode<MenuItem> treeInfoMenus;
    private TreeNode<MenuItem> treeInfoMenusSelected;

    @ManagedProperty(value = "#{adminMenuService}")
    private AdminMenuService adminMenuService;

    @PostConstruct
    public void init() {
        this.tablaMenu = new AdminMenuTableModel(adminMenuService);
        initTreeMenus();
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

    public void setAdminMenuService(AdminMenuService adminMenuService) {
        this.adminMenuService = adminMenuService;
    }
    
    /**************************************************
	 * Gestión de MENÚS (TREE)
	 **************************************************/
     public void initTreeMenus() {
        this.treeInfoMenus = adminMenuService.buildMenuTree();
    }
}
