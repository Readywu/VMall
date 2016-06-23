package cn.a17xiezuo.xzlibrary.common;


import cn.a17xiezuo.xzlibrary.R;

public class Constants {

    /**
     * 科大迅飞语音APPID
     */
    public static final String appid = "5212f55e";

    /**
     * 名片扫描appKey
     */
    // public static final String CAMCARDAPPKEY = "PS4ggX4A4EHE8d7014LFVUQ2";
    public static final String CAMCARDAPPKEY = "fanwei_PS4ggX4A4EHE8d7014LFVUQ2";
    public static final String CAMCARD_SITE_USER = "fanwei";
    public static final String CAMCARD_SITE_PSD = "NLYKT5M8MWFPTGD8";

    public static final String MAINACITIVYT = "MainActivity";

    public static final String DIRECTORY_ROOT = "eteams";
    public static final String DIRECTORY_VOICE = "voice";
    public static final String DIRECTORY_IMAGES = "images";
    public static final String DIRECTORY_IMAGES_USER = "images_temp";
    public static final String DIRECTORY_IMAGES_PERSONNAL_NAME = "images_us";
    public static final String DIRECTORY_IMAGES_WECHAT_GROUP = "images_w_g";
    public static final String DIRECTORY_DOCUMENT = "document";
    public static final String DIRECTORY_HTML = "html";
    public static final String DIRECTORY_DOWNLOAD = "download";

    public static final int HIDE_ATTENTION_CHILDS_MENU = 0x0000;
    public static final int ATTENTION_FIRSTGROUP_EXPAND = 0x0001;
    public static final int ATTENTION_SECONDGROUP_EXPAND = 0x0002;
    public static final int ATTENTION_FIRSTGROUP_COLLAPSE = 0x0003;
    public static final int ATTENTION_SECONDGROUP_COLLAPSE = 0x0004;

    public static final int CALLBACKDEFAULTID = -1;

    // 权限控制中，错误代码返回
    /**
     * 没有读取权限
     */
    public static final int PERMISSION_UNREAD = 900;
    /**
     * 没有更新权限
     */
    public static final int PERMISSION_UNUPDATE = 901;
    /**
     * 没有删除权限
     */
    public static final int PERMISSION_UNDELETE = 902;
    /**
     * 缺少参数
     */
    public static final int PERMISSION_FEW_PARAMETER = 101;
    /**
     * 你访问的数据服务器不存在
     */
    public static final int PERMISSION_NODATA = 102;
    /**
     * 成功
     */
    public static final int PERMISSSION_SUCCESS = 0;
    /**
     * 失败
     */
    public static final int PERMISSION_FAILED = 100;

    /**
     * Session失效
     */
    public static final int PERMISSION_SESSION_OVERDUE = -1;

    // EXTRA
    public static final String EXTRA_CUSTOMERDETAILINFO_NEW = "EXTRA_CUSTOMERDETAILINFO_NEW";
    public static final String EXTRA_CREATEWORKFLOW_NEW = "EXTRA_CREATEWORKFLOW_NEW";
    public static final String EXTRA_MAINLINEDETAIL_NEW = "EXTRA_MAINLINEDETAIL_NEW";
    public static final String EXTRA_SCHEDULE_NEW = "EXTRA_SCHEDULE_NEW";
    public static final String EXTRA_DOCUMENT_NEW = "EXTRA_DOCUMENT_NEW";
    public static final String EXTRA_WORKFLOW_NEW = "EXTRA_WORKFLOW_NEW";
    public static final String EXTRA_RELEVANCE_NEW = "EXTRA_RELEVANCE_NEW";
    public static final String EXTRA_MODULE_FRAGMENT = "EXTRA_MODULE_FRAGMENT";
    public static final String EXTRA_SELECTED_IDS = "SELECTED_IDS";
    public static final String EXTRA_TAG_NAMES = "TAG_NAMES";
    public static final String EXTRA_TAG_IDS = "TAG_IDS";
    public static final String EXTRA_TAG_TYPE = "TAG_TYPE";
    public static final String EXTRA_TAG_TYPE_ALL = "TAG_TYPE_ALL";
    public static final String EXTRA_USER_IDS = "USER_IDS";
    public static final String EXTRA_USER_IDS_HIDDEN = "USER_IDS_HIDDEN";
    public static final String EXTRA_USER_IDS_RELATED = "USER_IDS_RELATED";
    public static final String EXTRA_FRAGMENT_NAME = "EXTRA_FRAGMENT_NAME";
    public static final String EXTRA_BLOG_UNREAD = "EXTRA_BLOG_UNREAD";

    @Deprecated
    public static final String EXTRA_MAINLINE_IDS = EXTRA_SELECTED_IDS;
    public static final String EXTRA_MAINLINE_ID = "EXTRA_MAINLINE_ID";
    public static final String EXTRA_USER_WITH_GROUP = "USER_WITH_GROUP";
    public static final String EXTRA_SINGLE_CHOICE = "SINGLE_CHOICE";
    public static final String EXTRA_SELECT_DATE = "SELECT_DATE";
    public static final String EXTRA_SELECT_DOCUMENTTYPE = "SELECT_TYPE";
    public static final String EXTRA_DATE = "DATE";
    public static final String EXTRA_TITLE = "TITLE";
    public static final String EXTRA_TITLE_DRAWABLE = "EXTRA_TITLE_DRAWABLE";
    public static final String EXTRA_NEEDSHARE = "EXTRA_NEEDSHARE";
    public static final String EXTRA_SHAREIMGURL = "EXTRA_SHAREIMGURL";
    public static final String EXTRA_HASSESSIONID = "EXTRA_HASSESSIONID";
    public static final String EXTRA_BOLG_FILTER = "EXTRA_BOLG_FILTER";
    public static final String EXTRA_HINT = "HINT";
    public static final String EXTRA_STRING_MAX_LENGTH = "STRING_MAX_LENGTH";
    public static final String EXTRA_NOTE_INPUT = "EXTRA_NOTE_INPUT";
    public static final String EXTRA_INPUT_TYPE = "INPUT_TYPE";
    public static final String EXTRA_USER_WITH_WATCH = "EXTRA_USER_WITH_WATCH";
    public static final String EXTRA_SELECT_USER_LIST = "EXTRA_SELECT_USER_LIST";
    public static final String EXTRA_SELECTUSERS_FOR_INIT_FLAG = "EXTRA_SELECTUSERS_FOR_INIT_FLAG";
    public static final String EXTRA_MAINLINE_LOGO_PATH = "EXTRA_MAINLINE_LOGO_PATH";
    public static final String EXTRA_CHOSE_CUSTOMER = "EXTRA_CHOSE_CUSTOMER";
    public static final String EXTRA_CHOSE_TARGET = "EXTRA_CHOSE_TARGET";
    public static final String EXTRA_MAINLINE_LOGO_FILE = "EXTRA_MAINLINE_LOGO_FILE";
    public static final String EXTRA_TASK_ID = "TASK_ID";
    public static final String EXTRA_NEW_MODE = "NEW_MODE";
    public static final String EXTRA_TASK_TITLE = "TASK_TITLE";
    public static final String EXTRA_TASK_TEXT = "TASK_TEXT";
    public static final String EXTRA_TASK_TYPE = "TASK_TYPE";
    public static final String EXTRA_TASK_CANEDIT = "TASK_CANEDIT";

    public static final String EXTRA_IS_TO_EDIT_TYPE = "EXTRA_IS_TO_EDIT_TYPE";

    public static final String TANK_EXPAND_TYPE = "TANK_EXPAND_TYPE";
    public static final String EXTRA_TASK_BELONGTO = "EXTRA_TASK_BELONGTO";
    public static final String EXTRA_TASK_MANAGEID = "EXTRA_TASK_MANAGEID";

    public static final String EXTRA_CHAT_USER_ID = "CHAT_USER_ID";
    public static final String EXTRA_CHAT_TITLE = "CHAT_TITLE";
    public static final String EXTRA_CHAT_MESSAGE = "CHAT_MESSAGE";
    public static final String EXTRA_CHAT_MESSAGE_MODULE = "CHAT_MESSAGE_MODULE";
    public static final String EXTRA_CHAT_MESSAGE_LINK = "CHAT_MESSAGE_LINK";
    public static final String EXTRA_CHAT_FORWARD_MESSAGE_ID = "CHAT_FORWARD_MESSAGE_ID";
    public static final String EXTRA_RECEIVE_MESSAGE = "RECEIVE_MESSAGE";
    public static final String EXTRA_RECEIVE_MESSAGE_COUNT = "RECEIVE_MESSAGE_COUNT";
    public static final String EXTRA_EVENT_TYPE = "EVENT_TYPE";
    public static final String EXTRA_IS_CHANNEL = "IS_CHANNEL";
    public static final String EXTRA_UNREADNUM = "EXTRA_UNREADNUM";
    public static final String EXTRA_LASTTIME = "EXTRA_LASTTIME";

    public static final String EXTRA_FILE_PATH = "FILE_PATH";
    public static final String EXTRA_FILE_IS_LOCAL = "FILE_IS_LOCAL";
    public static final String EXTRA_FILE_TYPE = "FILE_TYPE";
    public static final String EXTRA_FILE_INFO = "FILE_INFO";
    public static final String EXTRA_FILE_LIST = "FILE_LIST";

    public static final String EXTRA_NEED_ATTACHMENT = "NEED_ATTACHMENT";
    public static final String EXTRA_NEED_MEIDAFILE = "NEED_MEIDAFILE";

    public static final String EXTRA_WORKFLOW_ID = "WORKFLOW_ID";
    public static final String EXTRA_PID_ID = "PID_ID";
    public static final String EXTRA_FORM_ID = "FORM_ID";
    public static final String EXTRA_ROW_ID = "ROW_ID";

    public static final String EXTRA_RELEVANCE_OBJECTS = "EXTRA_RELEVANCE_OBJECTS";

    public static final String EXTRA_SUBFORM_LISTDATA = "SUBFORM_LISTDATA";
    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_COMMENT_TIME_TYPE = "COMMENT_TIME_TYPE";

    public static final String EXTRA_UNREADITEM_FLG = "UNREADITEM";
    public static final String EXTRA_UNREADFEEDBACK_FLG = "UNREADITEMFEEDBACK";
    public static final String EXTRA_NEWCOMPELET_FLG = "NEWCOMPELET";
    public static final String EXTRA_ATMEITEM = "EXTRA_ATMEITEM";
    public static final String EXTRA_UNCOMPELET_FLG = "UNCOMPELET";
    public static final String EXTRA_FOLLOWITEM_FLG = "FOLLOWITEM";
    public static final String EXTRA_NEWCOMMENT_FLG = "NEWCOMMENTITEM";
    public static final String EXTRA_UNCOMPELETINTENT_FLG = "UNCOMPELET";
    public static final String EXTRA_FOLLOWINTENT_FLG = "FOLLOWITEM";
    public static final String EXTRA_SUBORDINATE = "SUBORDINATE";
    public static final String EXTRA_FOLLOW = "FOLLOW";
    public static final String EXTRA_BEFOLLOWED = "BEFOLLOWED";
    public static final String EXTRA_FLG = "FLG";
    public static final String EXTRA_BLOG_USERID = "EXTRA_BLOG_USERID";
    public static final String EXTRA_BLOG_ID = "EXTRA_BLOG_USERID";
    public static final String EXTRA_FLG_SHOWLOCATION = "SHOWLOCATION";
    public static final String EXTRA_FLG_SETTING = "SETTING";
    public static final String EXTRA_ISATTENDANCE = "ISATTENDANCE";
    public static final String EXTRA_FLAG_ATTACHMENT = "ATTACHMENTID";
    public static final String EXTRA_FLAG_USERID = "USERID";
    public static final String EXTRA_FLAG_USER_SUB_TITLE = "EXTRA_FLAG_USER_SUB_TITLE";
    public static final String EXTRA_FLAG_USER_FOLLWED_TITLE = "EXTRA_FLAG_USER_FOLLWED_TITLE";
    public static final String EXTRA_FLAG_USER_FANS_TITLE = "EXTRA_FLAG_USER_FANS_TITLE";

    public static final String EXTRA_FLAG_FILEID = "FILEID";
    public static final String EXTRA_FLAG_FILENAME = "FILENAME";
    public static final String EXTRA_FLAG_LOADID = "LOADID";
    public static final String EXTRA_ISCARDINFO = "CARDINFO";

    public static final String EXTRA_SELECTED_NAMES = "SELECTED_NAMES";

    public static final String EXTRA_FLAG_GONHOME = "GONHOME";

    public static final String EXTRA_FLAG_LATITUDE = "LATITUDE";
    public static final String EXTRA_FLAG_LONGITUDE = "LONGITUDE";
    public static final String EXTRA_FLAG_LOCATION = "LOCATION";
    public static final String EXTRA_FLAG_DATE = "YEAR";

    public static final String EXTAR_ATTENDANCE_NOTICETIME = "ATTENDANCE_NOTICETIME";
    public static final String EXTRA_LOGOUT_FINISH = "EXTRA_LOGOUT_FINISH";
    public static final String EXTRA_ISUPLOADDOCUMENT = "ISUPLOADDOCUMENT";
    public static final String EXTRA_ATTACHMENTSTRING = "ATTACHMENT";
    public static final String EXTRA_TARGETID = "TARGETID";
    public static final String EXTRA_MODULE = "MODULE";
    public static final String EXTRA_APPLICATION_WATCH = "FOLLOW";
    public static final String EXTRA_APPLICATION_RECEIVE = "RECEIVE";
    public static final String EXTRA_APPLICATION_JOINSHARE = "JIONSHARE";
    public static final String EXTRA_APPLICATION_JOINAPPLY = "JOINAPPLY";
    public static final String EXTRA_LOCATION_TIME = "EXTRA_LOCATION_TIME";
    public static final String EXTRA_FLAG_ISREAD = "EXTRA_FLAG_ISREAD";
    public static final String EXTRA_FLAG_RELOADPOSITION = "RELOADPOSITION";
    public static final String EXTRA_CLASS_NAME = "EXTRA_CLASS_NAME";
    public static final String EXTRA_IAMGE_URIS = "EXTRA_IAMGE_URIS";
    public static final String EXTRA_REGISTER_TENANTKEY = "EXTRA_REGISTER_TENANTKEY";
    public static final String EXTRA_REGISTER_TENANTNAME = "EXTRA_REGISTER_TENANTNAME";
    public static final String EXTRA_REGISTER = "EXTRA_REGISTER";
    public static final String EXTRA_REGISTER_EMAIL = "EXTRA_REGISTER_EMAIL";
    public static final String EXTRA_REGISTER_PASSCODE = "EXTRA_REGISTER_PASSCODE";
    public static final String EXTRA_REGISTER_LOGIN = "EXTRA_REGISTER_LOGIN";
    public static final String EXTRA_REGISTER_ACCOUNT = "EXTRA_REGISTER_ACCOUNT";
    public static final String EXTRA_UPDATE_NOTICE = "EXTRA_UPDATE_NOTICE";
    public static final String EXTRA_ATTACHMENT_IDS = "EXTRA_ATTACHMENT_IDS";
    public static final String EXTRA_ATTACHMENT_NAMES = "EXTRA_ATTACHMENT_NAMES";
    public static final String EXTRA_ATTACHMENT_INDEX = "EXTRA_ATTACHMENT_INDEX";
    public static final String EXTRA_ATTACHEMNTS = "EXTRA_ATTACHEMNTS";
    public static final String EXTRA_REMAINDFLAG_REMAIND = "REMAIND";
    public static final String EXTRA_REMAINDFLAG_NEWUSER = "NEWUSER";
    public static final String EXTRA_NEW_MESSAGE = "NEW_MESSAGE";
    public static final String EXTRA_SELECTED_PATH = "EXTRA_SELECTED_PATH";
    public static final String EXTRA_SHOWTEXT = "EXTRA_SHOWTEXT";
    public static final String EXTRA_SELECTIME = "EXTRA_SELECTIME";
    public static final String EXTRA_REGIST = "EXTRA_REGIST";
    public static final String EXTRA_START_FLG = "EXTRA_START_FLG";
    public static final String EXTRA_CUSTOMER_TITLE = "EXTRA_CUSTOMER_TITLE";
    public static final String EXTRA_CUSTOMER_ID = "EXTRA_CUSTOMER_ID";
    public static final String EXTRA_CUSTOMER_OPERATOR = "EXTRA_CUSTOMER_OPERATOR";
    public static final String EXTRA_LEFT_MEMBER_NUMBER = "EXTRA_LEFT_MEMBER_NUMBER";
    public static final String EXTRA_ATTACHMENT_VIEW_LIST = "EXTRA_ATTACHMENT_VIEW_LIST";
    public static final String EXTRA_SELECT_SUBEMPLOYEE = "EXTRA_SELECT_SUBEMPLOYEE";
    public static final String EXTRA_DEPARTMENT_ID = "EXTRA_DEPARTMENT_ID";
    public static final String EXTRA_DEPARTMENT_UPDATE_OPERATOR = "EXTRA_DEPARTMENT_UPDATE_OPERATOR";
    public static final String EXTRA_PARENTFOLDER = "EXTRA_PARENTFOLDER";
    public static final String EXTRA_FOLDER = "EXTRA_FOLDER";
    public static final String EXTRA_FOLDER_IDS = "FOLDER_IDS";
    public static final String EXTRA_OBJECT = "OBJECT";
    public static final String EXTRA_SUBITEM = "EXTRA_SUBITEM";
    public static final String EXTRA_CARTINFO_SUB_FOLLOW = "EXTRA_CARTINFO_SUB_FOLLOW";// 个人卡片跳转到的下属、我关注的、关注我的标记
    public static final String EXTRA_CANEDIT = "CANEDIT";

    public static final String BROADCASTNAME_UPLOAD = "com.weaver.teams.attachmentbroadcast";
    // public static final String BROADCASTNAME_BOOT =
    // "com.weaver.teams.bootbroadcast";
    public static final String BROADCASTUPDATEDOUCMENT = "com.weaver.teams.updatedocument";
    public static final String BROADCASTUPDATEBLOG = "com.weaver.teams.updateblog";
    public static final String BROADCASTUPDATEBLOG_CACHE = "com.weaver.teams.updateblog.cache";
    public static final String BROADCASTUPDATETARGETLIST = "com.weaver.teams.updatetargetlist";
    public static final String BROADCASTUPDATETARGETITEMS = "com.weaver.teams.updatetargetitems";
    public static final String BROADCASTDELETETARGET = "com.weaver.teams.deletetarget";
    public static final String BROADCASTDELETEWORKFLOW = "com.weaver.teams.deletetworkflow";
    public static final String ACTION_SUB_TASK_UPDATE = "com.weaver.teams.action.SUB_TASK_UPDATE";
    public static final String ACTION_SUB_TASK_DETAIL_NUMBER = "com.weaver.teams.action.SUB_TASK_DETAIL_NUMBER";
    public static final String BROADCASTMOVEFOLDER = "com.weaver.teams.movefolder";
    public static final String ACTION_SUB_TASK_REMOVE_PARENT = "com.weaver.teams.remove.task.parent";
    public static final String ACTION_TARGET_CREATE_ITEM = "com.weaver.teams.target.create.items";
    public static final String ACTION_WECHATMESSAGE = "com.weaver.teams.wechat";
    public static final String ACTION_CUSTOMER_UPDATE = "com.weaver.teams.action.CUSTOMER_UPDATE";

    public static final String ACTION_HOME_REFRESH = "com.weaver.teams.action.HOME_REFRESH";

    public static final String EXTRA_BLOG_ID_TODAY = "EXTRA_BLOG_ID_TODAY";

    public static final String REQUEST_ANIMATOR = "REQUEST_ANIMATOR";

    public static final String EXTRA_AGENDA_CREATE_STARTDATE = "EXTRA_AGENDA_CREATE_STARTDATE";
    public static final String EXTRA_AGENDA_CREATE_ENDDATE = "EXTRA_AGENDA_CREATE_ENDDATE";
    public static final String EXTRA_AGENDA_CREATE_ISALLDAY = "EXTRA_AGENDA_CREATE_ISALLDAY";
    public static final String EXTRA_FEEDBACK_ATUSERID = "EXTRA_FEEDBACK_ATUSERID";
    public static final String EXTRA_FEEDBACK_ATUSERIDINDEX = "EXTRA_FEEDBACK_ATUSERIDINDEX";
    public static final String EXTRA_TMSNOTICE_DELETE = "EXTRA_TMSNOTICE_DELETE";
    public static final String EXTRA_TOTALTARGETCOUNT = "EXTRA_TOTALTARGETCOUNT";
    public static final String EXTRA_TOTALTARGETLIST = "EXTRA_TOTALTARGETLIST";

    public static final String EXTRA_CONTACTREMINDNUM = "EXTRA_CONTACTREMINDNUM";
    // 动画
    public static final long DURATION_MILLIS = 500;
    public static final long DELAY_MILLIS = 0;
    // 10 分钟
    public static final int REFRESH_TIME = 1000 * 60 * 10;
    // 60 秒
    public static final int GET_NEWS_COUNT_REFRESH_TIME = 1000 * 60;

    // 30秒
    public static final int TIMEOUT = 1000 * 30;

    public static final int LENGTH_2000 = 2000;
    public static final int LENGTH_1000 = 1000;
    public static final int MAX_LENGTH_DEFAULT = 100;
    public static final int LENGTH_LIMITLESS = 1000000000;
    public static final int LENGTH_20 = 20;

    public static final String DEFAULT_TARGET_ICON_URL = "/static/img/icon/goal/1.png";

    public static final int MSG_LOGIN_TO_RE_CHECK = 1;
    public static final String PREF_CURRENT_CHATTING = "PREF_CURRENT_CHATTING";
    ;
    public static final String KEY_COUNT_NEWITEM = "KEY_COUNT_NEWITEM";
    public static final String KEY_COUNT_NEWCOMMENT = "KEY_COUNT_NEWCOMMENT";
    public static final String KEY_COUNT_UNFINISH = "KEY_COUNT_UNFINISH";
    public static final String KEY_COUNT_WATCHED = "KEY_COUNT_WATCHED";
    public static final String KEY_COUNT_NEWFINISH = "KEY_COUNT_NEWFINISH";
    public static final String KEY_COUNT_REMAIND = "KEY_COUNT_REMAIND";
    public static final String KEY_COUNT_FOLLOWCOUNT = "KEY_COUNT_FOLLOWCOUNT";
    public static final String KEY_COUNT_APPLYCOUNT = "KEY_COUNT_APPLYCOUNT";
    public static final String KEY_COUNT_UNREADBOLG = "KEY_COUNT_UNREADBOLG";
    public static final String KEY_COUNT_SHAREJOINCOUNT = "KEY_COUNT_SHAREJOINCOUNT";
    public static final String KEY_COUNT_NEW_USER = "KEY_COUNT_NEW_USER";
    public static final String ACTION_GET_COUNT = "com.weaver.teams.GET_NEWS_COUNT";
    public static final String ACTION_GET_MEMBERS_COUNT = "com.weaver.teams.GET_MEMBERS_COUNT";
    public static final String ACTION_MODULE_LIST = "com.module.list";
    public static final String ACTION_UPDATE_BLOGDETAIL_UI = "com.weaver.teams.upateblog";
    public static final String ACTION_LOGOUT_FINISH = "com.weaver.logout";
    public static final String ACTION_TODAYTASK = "com.weaver.teams.OEOPNTODAYTASK";
    public static final String ACTION_REFRESH_CUSTOMER_CONTACTLIST = "com.weaver.teams.ACTION_REFRESH_CUSTOMER_CONTACTLIST";
    public static final String ACTION_REFRESH_CUSTOMER_CONTACTREMINDERLIST = "com.weaver.teams.ACTION_REFRESH_CUSTOMER_CONTACTREMINDERLIST";
    public static final String EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID";
    public static final String ACTION_COMMENT_ADD_BY_MODULE = "com.weaver.teams.ACTION.COMMENT.ADD.BY.MODULE";
    public static final String EXTRA_COMMENT_OBJECT = "EXTRA_COMMENT_OBJECT";
    public static final String EXTRA_STREAM_OBJECT = "EXTRA_STREAM_OBJECT";
    public static final String EXTRA_SAVE_OK = "SAVE_OK";
    public static final int WORKFLOW_LOCAL_DATA_TYPE_TODO = 0;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_TODO_UNREAD = 1;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_TODO_NEWCOMMENT = 2;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_TODO_READ = 3;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_DONE = 4;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_DONE_NEWCOMMENT = 5;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_DONE_READ = 6;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_CREATED = 7;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_NO_LOCAL_DATA = 8;
    public static final int WORKFLOW_LOCAL_DATA_TYPE_FINISHED = 9;
    public static final long DELAY_VIEW_CLICK = 500;
    /**
     * device_id错误
     */
    public static final int ERROR_DEVICEID = 100;
    /**
     * app_id错误
     */
    public static final int ERROR_APPID = 101;
    /**
     * app_key错误
     */
    public static final int ERROR_APPKEY = 102;

    // 名片识别ERROR
    /**
     * 使用时间超出限制
     */
    public static final int ERROR_TIME_EXCEEDED = 103;
    /**
     * 设备数量超出限制
     */
    public static final int ERROR_DEVICE_EXCEEDED = 104;
    /**
     * 识别张数超出限制
     */
    public static final int ERROR_CARD_EXCEEDED = 105;
    /**
     * ERROR_SUBAPPKEY
     */
    public static final int ERROR_SUBAPPKEY = 106;
    /**
     * 正常识别
     */
    public static final int OK = 200;
    /**
     * 用户取消
     */
    public static final int CANCELED = 300;
    /**
     * 识别失败
     */
    public static final int REGNIZE_FAILED = 301;
    /**
     * CamCard版本过低
     */
    public static final int VERSION_UNMATCH = 501;
    /**
     * 网络错误
     */
    public static final int NETWORK_INVALID = 511;
    /**
     * 签名验证错误
     */
    public static final int SIGNATURE_INVALID = 516;
    /**
     * 无法获取验证信息
     */
    public static final int AUTHINFO_INVALID = 616;
    /**
     * 图像尺寸过大或过小
     */
    public static final int ERROR_WRONG_IMAGE_SIZE = -1;
    /**
     * 图像格式错误
     */
    public static final int ERROR_WRONT_IMAGE_FORMAT = -2;
    /**
     * 账户授权错误
     */
    public static final int ERROR_ACCOUNT_UNAUTHORIZED = -3;
    /**
     * 设备授权错误
     */
    public static final int ERROR_DEVICES_UNAUTHORIZED = -4;
    /**
     * 签名错误
     */
    public static final int ERROR_SIGNATURE_INVALID = -5;
    /**
     * 时间错误
     */
    public static final int ERROR_TIME_INCORRECT = -6;
    public static final String ACTION_CHANGETEAM = "com.weaver.teams.teamslist.changed"; // 切换团队
    public static final String ACTION_CHANGETEAM_RELOGIN = "com.weaver.teams.teamslist.changed.relogin"; // 后台失效切换团队
    public static final String ACTION_AGREEJOINTEAM = "com.weaver.teams.teamslist.refresh"; // 团队
    public static final String EXTRA_CHAT_CHANNEL_ID = "CHAT_CHANNEL_ID";
    public static final String EXTRA_HANDLEIDS = "HANDLEIDS";
    public static final String APP_WEIXIN_ID = "wx8682c8baeeb641fc";
    public static final String DB_SECRET_KEY = "secret_key_eteams";
    // 应用的APP_KEY
    public static final String APP_WEIBO_KEY = "3769688680";
    // 应用的回调页
    public static final String REDIRECT_URL = "http://www.sina.com";
    // 应用申请的高级权限
    public static final String SCOPE = "email,direct_messages_read,direct_messages_write,"
            + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
            + "follow_app_official_microblog," + "invitation_write";
    public static final String APP_QQ_ID = "101070623";
    public static final String SYSTEM_SERVICE_CHAT_ID = "10000";
    public static final String DEFAULT_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChzngWjzqI000a/PKYQsay2UvH"
            + "\r"
            + "K23OuAdMrq8Cl9l34Ao7fqMUQRypIsL4udgdYgQBDn4Q66XRqY47/+hwdiQRDg7T"
            + "\r"
            + "dJT5l7G2zdA8D8Cwv/wnvjvFfuSBl8kVYnz6hAbCWf/YpuPLOlUUEKPrZaQoF3Nd"
            + "\r" + "rS3P87FbRpCEcJ/bLwIDAQAB" + "\r";
    public static final String DEFAULT_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKHOeBaPOojTTRr8"
            + "\r"
            + "8phCxrLZS8crbc64B0yurwKX2XfgCjt+oxRBHKkiwvi52B1iBAEOfhDrpdGpjjv/"
            + "\r"
            + "6HB2JBEODtN0lPmXsbbN0DwPwLC//Ce+O8V+5IGXyRVifPqEBsJZ/9im48s6VRQQ"
            + "\r"
            + "o+tlpCgXc12tLc/zsVtGkIRwn9svAgMBAAECgYBXZ7sDJLfP9aSvMXiyu0+uiScg"
            + "\r"
            + "HduhUVPQHoS3d+Onl8SvQsdBR7L9wqNjzLBrnuje0T9UUJcwXNFSo/ih14+/Mr/5"
            + "\r"
            + "Fl634EX+f5mzA7YO4Vt+GdMl/rL+8TtCfP/+z/jzwwvJSKD8DsfaH5mFnjp6VD6p"
            + "\r"
            + "ZrpUsgvsrG27iioFAQJBANKJZp9sdVUwen/Y3izPushb5oG1dTCdb1o7i7uIpmvF"
            + "\r"
            + "qJvrImsXDb/X8+3/oo0NnqA1nnzz+GJ2xIdAjQHqsO8CQQDEvzuV4uvnsivDLt6F"
            + "\r"
            + "Fise/XgkD0KRShxn6XaPUbp5h883q4nYZbgV7pO1c+YZIh/mKT3a4olO5kgvRx2g"
            + "\r"
            + "6PnBAkAIOvraDKFhnS2MxeuZkN1aa81NEMzuA5mQy3cg86yd1fJLdhu4WARflY+h"
            + "\r"
            + "pDa0kO28kZwKgncZUk9IgkuA4a3dAkBPDoCE49/jBAbtsQGc/KFrHHKQGsmm097C"
            + "\r"
            + "Kl+Hi1Ggz9+GARmsqILl3S3hNab55mpm8591Op3t5D6RMMRJChSBAkEAh3SOL07t"
            + "\r"
            + "UU320Yn1XQO0rC7bUx3x2DD1s3V7IYCcbEJL367PHE/baZkjB4z2xww5iWT+xgJp"
            + "\r" + "kZZHrXqgs2kwIA==" + "\r";
    public static final String ACTION_MSG_CHANNEL_CHANGED = "com.weaver.teams.msg.channel.changed"; // 群组改变
    public static final String ACTION_MSG_CHANNEL_CHANGED_OPERATOR = "ACTION_MSG_CHANNEL_CHANGED_OPERATOR";// 群组改变操作形式
    public static final String ACTION_NEWSOCKETMESSAGE = "com.weaver.teams.newsocketmessage";// 接收到了新的socket消息
    public static final String ACTION_NEWPLACARDSOCKETMESSAGE = "com.weaver.teams.newplacardsocketmessage";// 接收到了新的公告socket消息
    public static final String SOCKETMESSAGE = "socketmessage";// 消息内容
    public static final String SOCKETMESSAGEBUNDLE = "socketmessagebundle";
    public static final String ACTION_SOCKET_HOMEPAGE_ENTITY = "com.weaver.teams.action.homepage.entity";// 首页socket广播
    public static final String HOMEPAGE_ENTITY_OBJECT = "HOMEPAGE_ENTITY_OBJECT";
    public static final String ACTION_HOMEPAGE_ENTITY_DECREASE = "com.weaver.teams.action.homepage.entity.decrease"; // 二级项减少广播
    public static final String HOMEPAGE_ENTITY_TYPE = "HOMEPAGE_ENTITY_TYPE"; // 二级项减少的消息类型
    public static final String HOMEPAGE_ENTITY_DECREASE_TYPE = "HOMEPAGE_ENTITY_DECREASE_TYPE"; // 二级项减少的消息类型
    public static final String HOMEPAGE_ENTITY_DECREASE_NUMBER = "HOMEPAGE_ENTITY_DECREASE_NUMBER"; // 二级项减少的消息相应类型的个数
    public static final String ACTION_TODAYTASK_SOCKET_MESSAGE = "com.weaver.teams.action.todaytask.socket.message"; // 今天的任务socket广播
    public static final String ACTION_TODAYAGENDA_SOCKET_MESSAGE = "com.weaver.teams.action.todayagenda.socket.message"; // 今天的日程socket广播
    public static final String ACTION_TODOWORKFLOW_SOCKET_MESSAGE = "com.weaver.teams.action.todoworkflow.socket.message"; // 待办流程socket广播
    public static final String ACTION_BLOG_SOCKET_MESSAGE = "com.weaver.teams.action.blog.socket.message"; // 日报相关socket广播
    public static final String COMMON_MESSAGETYPE_STR = "COMMON_MESSAGETYPE_STR";// 消息类型
    public static final String COMMON_MESSAGE_COMMAND_STR = "COMMON_MESSAGE_COMMAND_STR"; // 消息类型command
    public static final String ACTION_BLOGDATEPAGE_DETAIL = "com.weaver.teams.action.blog.date.page.detail";
    public static final String ACTION_SOCKETSTATUS = "ACTION_SOCKETSTATUS";//
    public static final String SOCKETSTATUS = "SOCKETSTATUS";//
    public static final String ACTION_SOCKETTRAFFICSTATS = "ACTION_SOCKETTRAFFICSTATS";//
    public static final String SOCKETTTRAFFICSTATS = "SOCKETTTRAFFICSTATS";//
    public static final String ACTION_WIDGETNUM = "ACTION_WIDGETNUM";// 小组件
    public static final String WIDGETNUM_OBJECT = "WIDGETNUM_OBJECT";// 小组件
    public static final String mNewBuilt = "BUILT_POPWINDOW";// 由popwindow新建进入
    public static final String ACTION_CREATE_SCHEDULE_LOCAL_ONLY_CREATOR = "com.weaver.teams.ACTION_CREATE_SCHEDULE_LOCAL_ONLY_CREATOR"; // 日程创建时候只有登录人是创建人的时候的广播
    public static final String DETAIL_INPUT_NOTE = "DETAIL_INPUT_NOTE";// 由详情页面的备注进入
    public static final String EXTRA_SUB_TASK = "EXTRA_SUB_TASK";// 子任务
    public static final String ACTION_USERINFO_UPDATE = "ACTION_USERINFO_UPDATE";// 个人信息更新
    public static final String ISCREATE = "ISCREATE";// 是否创建
    // 下属事项
    public static final String SUB_DOMAIN_SP = "subDomain";
    public static final String SUB_KEY_TASK = "task";
    public static final String SUB_KEY_DOC = "document";
    public static final String SUB_KEY_CUSTOMER = "customer";
    public static final String SUB_KEY_WORKFLOW = "workflow";
    public static final String SUB_KEY_MAINLINE = "mainline";
    public static final String WECHAT_GROUP_MEMBERS = "WECHAT_GROUP_MEMBERS";//
    public static final String WECHAT_GROUP_MEMBERS_AFETR_ADDED = "WECHAT_GROUP_MEMBERS_AFETR_ADDED";//
    public static final String WECHAT_GROUP_NAME = "WECHAT_GROUP_NAME";//
    public static final String EXTRA_DOCUMEN_SUMMARY = "EXTRA_DOCUMEN_SUMMARY";// 文档摘要
    public static final String EXTRA_DOCUMEN_PERMISSION = "EXTRA_DOCUMEN_PERMISSION";// 文档权限
    public static final String EXTRA_DOCUMEN_ID = "EXTRA_DOCUMEN_ID";// 文档id
    public static final String EXTRA_DOCUMEN_TYPE = "EXTRA_DOCUMEN_TYPE";// 文档类型
    // 比如txt,excel等等
    public static final String EXTRA_TENANT_ID = "EXTRA_TENANT_ID";
    public static final String EXTRA_CONTACT_CUSTOMER = "EXTRA_CONTACT_CUSTOMER";// 客户联系人的客户
    public static final String EXTRA_PLACARD_ID = "EXTRA_PLACARD_ID";// 公告id

    // public static int colorRes[] = {
    //
    // android.R.color.holo_blue_bright,
    //
    // android.R.color.holo_green_light,
    //
    // android.R.color.holo_orange_light,
    //
    // android.R.color.holo_red_light };
    public static int colorRes[] = {R.color.refresh_color_one,
            R.color.refresh_color_two, R.color.refresh_color_three,
            R.color.refresh_color_four};

    public static enum TankExpandType {
        ALL, TODAY, TOMORROW, FUTURE, REMEMBER, OVERTIME
    }


    public static class Extra {
        public static final String IMAGES = "com.nostra13.example.universalimageloader.IMAGES";
        public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
    }

    public static boolean isRefreshDocumentContent = false;// 是否刷新文档内容

    public static boolean isReUpLoadFile = false;
    public static String attachment_id;

    public static String mTempPath = "";
}
