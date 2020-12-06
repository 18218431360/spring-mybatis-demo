package com.lks.bean;

public class Menu {
    private Integer menuId;

    private String menuName;

    private String menuFunction;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuFunction() {
        return menuFunction;
    }

    public void setMenuFunction(String menuFunction) {
        this.menuFunction = menuFunction == null ? null : menuFunction.trim();
    }
}