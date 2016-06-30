package cn.a17xiezuo.vmall.entity;

import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.application.VMallApplication;

public enum MenuCategory {


    HOMEPAGE(VMallApplication.getInstance().getString(R.string.nav_button_home), "建设宝"),
    PERSON("我", "我"),
    CONTACT("通讯", "通讯录"),
    APP("应用", "应用"),
    NEW("采购单", "采购单");

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
