package com.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.TreeNode;

import com.example.model.UportalMenu;

@ManagedBean(name = "adminMenuController")
@RequestScoped
public class AdminMenuController implements Serializable {

    private AdminMenuTableModel tablaMenu;
    private TreeNode<UportalMenu> treeInfoMenus;
    private TreeNode<UportalMenu> treeInfoMenusSelected;

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

    public TreeNode<UportalMenu> getTreeInfoMenus() {
        return treeInfoMenus;
    }

    public void setTreeInfoMenus(TreeNode<UportalMenu> treeInfoMenus) {
        this.treeInfoMenus = treeInfoMenus;
    }

    public TreeNode<UportalMenu> getTreeInfoMenusSelected() {
        return treeInfoMenusSelected;
    }

    public void setTreeInfoMenusSelected(TreeNode<UportalMenu> treeInfoMenusSelected) {
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
