package cn.a17xiezuo.vmall.entity;

public enum MenuCategory {


    HOMEPAGE("主页"),
    PERSON("我"),
    CONTACT("通讯"),
    APP("应用"),
    NEW("新建");

    private String displayName;

    MenuCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return this.name();
    }
}
