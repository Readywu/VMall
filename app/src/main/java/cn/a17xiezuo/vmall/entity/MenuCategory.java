package cn.a17xiezuo.vmall.entity;

public enum MenuCategory {
    RECORD("日报"),

    TANK("任务"),

    DOCUMENT("文档"),

    CUSTOMER("客户"),

    WORKFLOW("审批"),

    ATTENDANCE("考勤"),

    SETTING("设置"),

    HOMEPAGE("主页"),

    WECHAT("微信"),

    WORKTARGET("工作目标"),

    SPEAKER("语音"),

    SCHEDULE("日程"),

    REPORT("报告"),

    REPORTFORM("报表"), PERSON("我"), CONTACT("通讯"), APP("应用"), NEW("新建"), NONE(
            "无");
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
