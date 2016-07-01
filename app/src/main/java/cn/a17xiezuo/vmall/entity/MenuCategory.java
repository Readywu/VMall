package cn.a17xiezuo.vmall.entity;

import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.application.VMallApplication;

public enum MenuCategory {


    HOME(VMallApplication.getInstance().getString(R.string.nav_button_home), "建设宝"),
    PERSON("我", "我"),
    SERVICE("客服", "客服服务"),
    CATEGORY("分类", "分类"),
    ORDER("采购单", "采购单");

    private String displayName;
    private String customTitle;

    MenuCategory(String displayName, String title) {
        this.displayName = displayName;
        this.customTitle = title;
    }

    public String getCustomTitle() {
        return customTitle;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return this.name();
    }
}
