package cn.a17xiezuo.xzlibrary.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;

import cn.a17xiezuo.xzlibrary.common.Constants;
import cn.a17xiezuo.xzlibrary.ui.view.MyURLSpan;

public class Utility {

    /**
     * change other activity
     *
     * @param context this context
     * @param cls     intent activity
     */
    public static void onStartActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static String TwoLengthNum(int num) {
        DecimalFormat df = new DecimalFormat("00");
        String str = df.format(num);
        return str;
    }

    public static boolean isArrayDifferent(ArrayList<String> la,
                                           ArrayList<String> lb) {
        boolean diff = false;

        if (la == null)
            la = new ArrayList<String>();

        if (lb == null) {
            lb = new ArrayList<String>();
        }

        int aSize = la.size();
        int bSize = lb.size();
        lb.retainAll(la);
        if (lb.size() != aSize || lb.size() != bSize) {
            diff = true;
        }
        return diff;
    }

    /**
     * 不推荐使用该方法，请使用ListViewForScrollView或继承实现，使用了后果自负 囧 ylb
     *
     * @param listView
     */
    @Deprecated
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        int dividerHeight = listView.getDividerHeight();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        // listAdapter.getCount()返回数据项的数目
        int count = listAdapter.getCount();
        for (int i = 0, len = count; i < len; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
            totalHeight += dividerHeight;
        }
        // totalHeight += 10;
        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (count - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    @SuppressLint("DefaultLocale")
    public static String getDateTimeDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%d-%s-%s %s:%s:%s",
                time.get(Calendar.YEAR), pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)),
                pad(time.get(Calendar.HOUR_OF_DAY)),
                pad(time.get(Calendar.MINUTE)), pad(time.get(Calendar.SECOND)));
        return strTime;
    }

    public static String getDateTimeYYYYMMDDHHMMDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%d-%s-%s %s:%s",
                time.get(Calendar.YEAR), pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)),
                pad(time.get(Calendar.HOUR_OF_DAY)),
                pad(time.get(Calendar.MINUTE)));
        return strTime;
    }

    /**
     * 时刻显示(当天的显示'今天')
     *
     * @param timeInMillis
     * @return
     */
    public static String getTimeSpecialDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        if (isToday(timeInMillis)) {
            return String.format("今天 %s:%s",
                    pad(time.get(Calendar.HOUR_OF_DAY)),
                    pad(time.get(Calendar.MINUTE)));
        } else {
            return String.format("%d-%s-%s %s:%s", time.get(Calendar.YEAR),
                    pad(time.get(Calendar.MONTH) + 1),
                    pad(time.get(Calendar.DAY_OF_MONTH)),
                    pad(time.get(Calendar.HOUR_OF_DAY)),
                    pad(time.get(Calendar.MINUTE)));
        }
    }

    @SuppressLint("DefaultLocale")
    public static String getTimeDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s:%s",
                pad(time.get(Calendar.HOUR_OF_DAY)),
                pad(time.get(Calendar.MINUTE)));
        return strTime;
    }

    public static String getHMSTimeDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s:%s:%s",
                pad(time.get(Calendar.HOUR_OF_DAY)),
                pad(time.get(Calendar.MINUTE)), pad(time.get(Calendar.SECOND)));
        return strTime;
    }

    @SuppressLint("DefaultLocale")
    public static String getDateDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%d-%s-%s", time.get(Calendar.YEAR),
                pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)));
        return strTime;
    }

    public static String getDateDisplayAndWeek(long timeInMillis, int week) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String weekString = "";
        switch (week) {
            case 1:
                weekString = "周日  ";
                break;
            case 2:
                weekString = "周一  ";
                break;
            case 3:
                weekString = "周二  ";
                break;
            case 4:
                weekString = "周三  ";
                break;
            case 5:
                weekString = "周四  ";
                break;
            case 6:
                weekString = "周五  ";
                break;
            case 7:
                weekString = "周六  ";
                break;
            default:
                break;
        }
        String strTime = String.format("%d-%s-%s", time.get(Calendar.YEAR),
                pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)));
        return weekString + strTime;
    }

    /**
     * 12月03日 星期三 00:01:02
     *
     * @param timeInMillis
     * @return
     */
    public static String getDateMonthDayTimeDisplayAndWeek(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);
        String weekString = "";
        int week = time.get(Calendar.DAY_OF_WEEK);
        switch (week) {
            case 1:
                weekString = "星期日";
                break;
            case 2:
                weekString = "星期一";
                break;
            case 3:
                weekString = "星期二";
                break;
            case 4:
                weekString = "星期三";
                break;
            case 5:
                weekString = "星期四";
                break;
            case 6:
                weekString = "星期五";
                break;
            case 7:
                weekString = "星期六";
                break;
            default:
                break;
        }
        String strDate = String.format("%s月%s日",
                pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)));
        String strTime = String.format("%s:%s:%s",
                pad(time.get(Calendar.HOUR_OF_DAY)),
                pad(time.get(Calendar.MINUTE)), pad(time.get(Calendar.SECOND)));
        StringBuffer sb = new StringBuffer("");
        sb.append(strDate);
        sb.append(" ");
        sb.append(weekString);
        sb.append(" ");
        sb.append(strTime);
        return sb.toString();
    }

    public static String getMonthDayDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s-%s",
                pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)));
        return strTime;
    }

    public static String getMonthDayDisplay(long timeInMillis, String format) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s" + format + "%s",
                pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)));
        return strTime;
    }

    /**
     * 格式2014/9
     *
     * @param timeInMillis
     * @return
     */
    public static String getYearMonthDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s-%s", pad(time.get(Calendar.YEAR)),
                pad(time.get(Calendar.MONTH) + 1));
        return strTime;
    }

    /**
     * 格式*年*月
     *
     * @param timeInMillis
     * @return
     */
    public static String getYearMonthDaispaly(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s年%s月", pad(time.get(Calendar.YEAR)),
                pad(time.get(Calendar.MONTH) + 1));
        return strTime;
    }

    /**
     * 格式*年*月
     *
     * @param timeInMillis
     * @return
     */
    public static String getYearMonthDayDaispaly(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s年%s月%s日",
                pad(time.get(Calendar.YEAR)),
                pad(time.get(Calendar.MONTH) + 1),
                pad(time.get(Calendar.DAY_OF_MONTH)));
        return strTime;
    }

    /**
     * 获取年
     *
     * @param timeInMillis
     * @return
     */
    public static String getYearDaispaly(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s", pad(time.get(Calendar.YEAR)));
        return strTime;
    }

    /**
     * 获取年
     *
     * @param timeInMillis
     * @return
     */
    public static String getMonthDaispaly(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);

        String strTime = String.format("%s", pad(time.get(Calendar.MONTH) + 1));
        return strTime;
    }

    public static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    /**
     * 把格式是2012-12-02的日期串转为时间戳类型
     *
     * @param strDate
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long strToDate(String strDate, String dataformatter) {
        try {
            if (TextUtils.isEmpty(strDate)) {
                return 0;
            }
            SimpleDateFormat formatter = new SimpleDateFormat(dataformatter);
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(strDate, pos);
            return strtodate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setAlphaForView(View v, float alpha) {
        AlphaAnimation animation = new AlphaAnimation(alpha, alpha);
        animation.setDuration(0);
        animation.setFillAfter(true);
        v.startAnimation(animation);
    }

    public static void setEditTextSection(EditText editText, int lentgh) {
        if (null == editText) {
            return;
        }
        editText.setSelection(lentgh);
    }

    /**
     * Whether can connect the network.
     *
     * @return
     */
    public static boolean isConnnection(Context context) {
        boolean isConnect = false;
        ConnectivityManager cManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cManager.getActiveNetworkInfo();
        if (null != networkInfo && networkInfo.isAvailable()) {
            isConnect = true;
        } else {
            isConnect = false;
        }

        return isConnect;
    }

    /**
     * 匹配格式： 11位手机号码 3-4位区号，7-8位直播号码，1－4位分机号 如：12345678901、1234-12345678-1234
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        // String regex = "^13/d{9}||15[8,9]/d{8}$";
        String regex = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|"
                + "(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|"
                + "(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber.trim());

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * 匹配格式： 3-4位区号，7-8位直播号码，1－4位分机号 如：12345678901、1234-12345678-1234
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isTelphoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        // String regex = "^13/d{9}||15[8,9]/d{8}$";
        String regex = "(^((\\d{7,8})|\\(?(\\d{4}|\\d{3})\\)?-?(\\d{7,8})|"
                + "\\(?(\\d{4}|\\d{3})\\)?-?(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|"
                + "(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber.trim());

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static String delHTMLTag(String htmlStr) {
        // 定义script的正则表达式
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        // 定义style的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        // 定义HTML标签的正则表达式
        String regEx_html = "<[^>]+>";

        Pattern p_script = Pattern.compile(regEx_script,
                Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern
                .compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        return htmlStr.trim(); // 返回文本字符串
    }

    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (null != v && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 获得时间显示 其中，今天只显示时刻，昨天显示昨天+时刻，其他显示年月+时刻
     *
     * @param timeInMillis
     * @return
     */
    public static String getDateTimeLongDisplay(long timeInMillis) {
        if (isToday(timeInMillis)) {
            return getTimeDisplay(timeInMillis);
        } else if (isYestoday(timeInMillis)) {
            return "昨天" + getTimeDisplay(timeInMillis);
        } else {
            return getDateDisplay(timeInMillis);
        }
    }

    public static String getDateLongDisplay(long timeInMillis) {
        if (isToday(timeInMillis)) {
            return "今天";
        } else if (isYestoday(timeInMillis)) {
            return "昨天";
        } else {
            return getDateDisplay(timeInMillis);
        }
    }

    public static String getMessageTimeLongDisplay(long timeInMillis) {
        if (isToday(timeInMillis)) {
            return getTimeDisplay(timeInMillis);
        } else if (isYestoday(timeInMillis)) {
            return "昨天" + getTimeDisplay(timeInMillis);
        } else {
            return getDateTimeYYYYMMDDHHMMDisplay(timeInMillis);
        }
    }


    /**
     * 今天显示时刻，昨天显示昨天+时刻，其余显示日期+时刻
     *
     * @param timeInMillis
     * @return
     */
    public static String getCustomSmartDateTimeDisplay(long timeInMillis) {
        if (timeInMillis <= 0) {
            return "";
        }
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeInMillis);
        if (isToday(timeInMillis)) {
            String strTime = String.format("%s:%s",
                    time.get(Calendar.HOUR_OF_DAY),
                    pad(time.get(Calendar.MINUTE)));
            return String.format("%tR", timeInMillis);
        } else if (isYestoday(timeInMillis)) {
            String strTime = String.format("%s:%s",
                    time.get(Calendar.HOUR_OF_DAY),
                    pad(time.get(Calendar.MINUTE)));
            return String.format("昨天 %tR", timeInMillis);
        } else if (isNowYear(timeInMillis)) {
            return String.format("%s-%s %s:%s",
                    pad(time.get(Calendar.MONTH) + 1),
                    pad(time.get(Calendar.DAY_OF_MONTH)),
                    pad(time.get(Calendar.HOUR_OF_DAY)),
                    pad(time.get(Calendar.MINUTE)));
        } else {
            return getDateTimeDisplay(timeInMillis);
        }
    }


    public static String getApplicationPackage(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            String versionName = packageInfo.versionName;
            int versionCode = packageInfo.versionCode;
            String packageNames = packageInfo.packageName;
            return packageNames;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 通过浏览器下载
     *
     * @param context
     * @param url
     */
    public static void downloadByBrowser(Context context, String url) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(url));
        intent.setAction(Intent.ACTION_VIEW);
        context.startActivity(intent);
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断某个时间是否是今天
     *
     * @param timeInMillis
     * @return
     */
    public static boolean isToday(long timeInMillis) {
        boolean result = false;
        Calendar calToday = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        if (calToday.get(Calendar.YEAR) == cal.get(Calendar.YEAR)
                && calToday.get(Calendar.MONTH) == cal.get(Calendar.MONTH)
                && calToday.get(Calendar.DAY_OF_MONTH) == cal
                .get(Calendar.DAY_OF_MONTH)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 判断某个时间是否是昨天
     *
     * @param timeInMillis
     * @return
     */
    public static boolean isYestoday(long timeInMillis) {
        boolean result = false;
        Calendar calYesroday = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        int year = calYesroday.get(Calendar.YEAR);
        int month = calYesroday.get(Calendar.MONTH);
        int day = calYesroday.get(Calendar.DAY_OF_MONTH);
        calYesroday.set(year, month, day - 1, 0, 0, 0);

        cal.setTimeInMillis(timeInMillis);
        if (calYesroday.get(Calendar.YEAR) == cal.get(Calendar.YEAR)
                && calYesroday.get(Calendar.MONTH) == cal.get(Calendar.MONTH)
                && calYesroday.get(Calendar.DAY_OF_MONTH) == cal
                .get(Calendar.DAY_OF_MONTH)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * @param timeInMillis
     * @return
     */
    public static boolean isNowYear(long timeInMillis) {
        boolean result = false;
        if (timeInMillis <= 0) {
            return result;
        }
        Calendar calToday = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        if (calToday.get(Calendar.YEAR) == cal.get(Calendar.YEAR)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 删除时分秒
     *
     * @param timeInMillis
     * @return
     */
    public static long onlyGetYearMonthDay(long timeInMillis) {
        long result = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        result = cal.getTimeInMillis();
        return result;
    }

    public static long getTimeFromString(String str_Date) {
        long result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(str_Date);
            result = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取设备号
     *
     * @return
     */
    public static String getImei(Context context) {
        return ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 判断当前应用程序处于前台还是后台
     *
     * @param context
     * @return
     */
    public static boolean isBackground(Context context) {
        if (context == null)
            return true;
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> appProcessInfos = activityManager
                .getRunningAppProcesses();
        if (appProcessInfos != null && appProcessInfos.size() > 0) {
            for (RunningAppProcessInfo appProcessInfo : appProcessInfos) {
                if (appProcessInfo.processName.equals(context.getPackageName())) {
                    if (appProcessInfo.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                        LogUtil.i("Background", String.format(
                                "Background App:", appProcessInfo.processName));
                        return true;
                    } else {
                        LogUtil.i("Background", String.format(
                                "Foreground App:", appProcessInfo.processName));
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param mContext
     * @param textView
     * @param value
     */
    public static void setTextUrlReadable(Context mContext, TextView textView,
                                          String value) {
        textView.setAutoLinkMask(Linkify.WEB_URLS);
        textView.setText(value);

        CharSequence content = textView.getText();

        SpannableStringBuilder builder = SpannableStringBuilder
                .valueOf(content);

        URLSpan[] spans = builder.getSpans(0, content.length(), URLSpan.class);

        if (spans != null && spans.length > 0) {

            int start = 0;

            int end = 0;

            for (URLSpan span : spans) {

                start = builder.getSpanStart(span);

                end = builder.getSpanEnd(span);

                // to replace each link span with customized ClickableSpan

                builder.removeSpan(span);

                builder.setSpan(new MyURLSpan(mContext, span.getURL()
                                .toString()), start, end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
            textView.setAutoLinkMask(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(builder);
        }

    }

    public static void setTextUrlReadable(Context mContext, TextView textView,
                                          String value, ArrayList<Map<String, Object>> userList) {
        setTextUrlReadable(mContext, textView, value, userList, "7888a9");
    }

    public static void setTextUrlReadable(Context mContext, TextView textView,
                                          String value, ArrayList<Map<String, Object>> userList, String color) {

        textView.setAutoLinkMask(Linkify.WEB_URLS);
        textView.setText(value);

        CharSequence content = textView.getText();

        SpannableStringBuilder builder = SpannableStringBuilder
                .valueOf(content);

        URLSpan[] spans = builder.getSpans(0, content.length(), URLSpan.class);

        if (spans != null && spans.length > 0) {

            int start = 0;

            int end = 0;

            for (URLSpan span : spans) {

                start = builder.getSpanStart(span);

                end = builder.getSpanEnd(span);

                // to replace each link span with customized ClickableSpan

                builder.removeSpan(span);

                builder.setSpan(new MyURLSpan(mContext, span.getURL()
                                .toString()), start, end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
        }


        textView.setAutoLinkMask(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(builder);
    }

    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public static boolean isMobilePhone86(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            return false;
        }
        String patternStr = "^((\\+)?86)?1(3|4|5|7|8)\\d{9}$";
        Pattern pattern = Pattern.compile(patternStr);
        try {
            phoneNum = phoneNum.replace(" ", "");
            phoneNum = phoneNum.replace("-", "").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    public static boolean isAllNum(String num) {
        String str = "^[0-9]*$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(num);
        return m.matches();
    }



    public static String getStackTraceString(
            StackTraceElement[] stackTraceElements) {
        if (stackTraceElements == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement element : stackTraceElements)
            stringBuilder.append(element.toString()).append("\n");
        return stringBuilder.toString();
    }


    /**
     * 加密
     *
     * @param content
     */
    public static String EncodeRSAStatic(String content) {
        try {
            PublicKey publicKey = RSATools
                    .loadPublicKey(Constants.DEFAULT_PUBLIC_KEY);// getPublicKey(RSA_MODULUS,
            // RSA_PUBLIC_EXPONENT);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            // 加密
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] dataEncode = cipher.doFinal(content.getBytes());
            byte[] tmp = Base64.encode(dataEncode, Base64.DEFAULT);
            String result = new String(tmp);
            return result;
        } catch (Exception ike) {
            ike.printStackTrace();
        }
        return "";
    }

    /**
     * 解密
     *
     * @param content
     */
    public static String DncodeRSAStatic(String content) {
        try {
            PrivateKey privateKey = RSATools
                    .loadPrivateKey(Constants.DEFAULT_PRIVATE_KEY);// getPrivateKey(RSA_MODULUS,
            // RSA_PRIVATE_EXPONENT);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] baseResult = Base64.decode(content, Base64.DEFAULT);
            byte[] dataDecode = cipher.doFinal(baseResult);

            String originalContent = new String(dataDecode);
            return originalContent;
        } catch (Exception ike) {
            ike.printStackTrace();
        }
        return "";
    }




    /**
     * 时间格式化
     *
     * @param times
     * @return
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("SimpleDateFormat")
    public static String formatTime(int times) {
        int theHour = times / 3600;
        int theMinute = (times % 3600) / 60;
        int theSecond = (times % 3600) % 60;
        Time time = new Time(theHour, theMinute, theSecond);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        return (df.format(time));
    }



    /**
     * sqlite的特殊字符转义及通配符
     *
     * @param keyWord
     * @return
     */
    public static String sqliteEscape(String keyWord) {
        keyWord = keyWord.replace("/", "//");
        keyWord = keyWord.replace("'", "''");
        keyWord = keyWord.replace("[", "/[");
        keyWord = keyWord.replace("]", "/]");
        keyWord = keyWord.replace("%", "/%");
        keyWord = keyWord.replace("&", "/&");
        keyWord = keyWord.replace("_", "/_");
        keyWord = keyWord.replace("(", "/(");
        keyWord = keyWord.replace(")", "/)");
        return keyWord;
    }



    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public static final boolean isGpsOPen(final Context context) {
        LocationManager locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        // boolean network =
        // locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps) {
            return true;
        }
        return false;
    }

    /**
     * 消息提示进入动画
     *
     * @return
     */
    public static TranslateAnimation inMessageAnimation() {
        TranslateAnimation mShowAction = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);
        return mShowAction;

    }

    /**
     * 消息提示消失动画
     *
     * @return
     */
    public static TranslateAnimation outMessageAnimation() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;

    }

    /**
     * 判断是否开启
     *
     * @param mContext
     * @param className
     * @return
     */
    public static boolean isWorked(Context mContext, String className) {
        ActivityManager myManager = (ActivityManager) mContext
                .getApplicationContext().getSystemService(
                        Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningService = (ArrayList<ActivityManager.RunningServiceInfo>) myManager
                .getRunningServices(30);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().toString()
                    .equals(className)) {
                return true;
            }
        }
        return false;
    }




    public static long getTimeFromTimeString(String user_time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date d;
        try {
            if (user_time.contains(" ")) {
                d = format.parse(user_time);
            } else {
                d = format2.parse(user_time);
            }
            return d.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean isCorrectOfTime(long startTime, String timeString) {
        long timeOfToday = System.currentTimeMillis();
        long timeOfStart = startTime;
        String stringtime = timeString;
        if (!TextUtils.isEmpty(stringtime) && !stringtime.equals("不提醒")) {
            try {
                long diff = 0;
                if (stringtime.contains("小时")) {
                    diff = Long.parseLong(stringtime.split("小时")[0]) * 60 * 60 * 1000;
                }
                if (stringtime.contains("天")) {
                    diff = Long.parseLong(stringtime.split("天")[0]) * 24 * 60
                            * 60 * 1000;
                }
                if (stringtime.contains("分钟")) {
                    diff = Long.parseLong(stringtime.split("分钟")[0]) * 60 * 1000;
                }

                if (timeOfStart - diff < timeOfToday) {

                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;

    }

}
