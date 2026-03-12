package com.example;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "uportalGroups")
@ApplicationScoped
public class UportalGroups {

    public String getX_CV_ADMINS_UPORTAL() {
        return "ROLE_ADMIN";
    }
}
