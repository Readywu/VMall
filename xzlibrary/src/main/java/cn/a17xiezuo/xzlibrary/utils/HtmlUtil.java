package cn.a17xiezuo.xzlibrary.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhan on 2015/11/11.
 */
public class HtmlUtil {

    private final static String regxpForHtml = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签

    public static String filterHtml(String str) {
        Pattern pattern = Pattern.compile(regxpForHtml);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString().replaceAll("&nbsp;", " ").replaceAll("<br>", "\n");
    }

    // 过滤<a></a>标签
    private static String regxpForATag = "<\\s*a\\s.*?href\\s*=\\s*[^>]*\\s*>\\s*(.*?)\\s*<\\s*/\\s*a\\s*>";
    private static Pattern patternHref = Pattern.compile(regxpForATag,
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    private static Matcher matcherHref = null;

    // 过滤Img标签
    private static String regxpForImgTag = "<\\s*img\\s*([^>]*)\\s*/?\\s*>";
    private static Pattern patternImg = Pattern.compile(regxpForImgTag,
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    // 过滤Img标签下的src
    private static final Pattern patternImgStr = Pattern.compile(
            "<\\s*img\\s*(?:[^>]*)src\\s*=\\s*([^>]+)",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    // 过滤Javascript标签
    // "<\\s*script\\s*.*[^>]*\\s*>\\s*(.*?)\\s*<\\s*/\\s*script\\s*>"
    // "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"
    private static String regxpForJsTag = "<\\s*script\\s*[^>]*?\\s*>\\s*[\\s\\S]*?\\s*<\\s*/\\s*script\\s*?>";
    private static Pattern patternJs = Pattern.compile(regxpForJsTag,
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    // 过滤标签标签下的class
    private static final Pattern patternStyleClass = Pattern.compile(
            "<\\s*.*(class\\s*=\\s*[^>]+)?\\s*>", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE);

    // 过滤link标签
    private static final Pattern patternLink = Pattern.compile(
            "<\\s*link\\s.*?href\\s*=\\s*[^>]*\\s*/?\\s*>",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    // 过滤style标签
    private static final Pattern patternStyle = Pattern.compile(
            "<\\s*style\\s*[^>]*?\\s*>\\s*[\\s\\S]*?\\s*<\\s*/\\s*style\\s*?>",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    /**
     * 1、<a><img /></a>
     *
     * @param xmlString
     * @return
     */
    public static String filterdAdvertising(String xmlString) {
        // matcher = pattern
        // .matcher("<img src='' >dsgsdgfsd<a href = ' ' ><imG src='sdfsdf'/>< /
        // A >sdfgsdhf < A hrEf = \" dsd\" > sdgsdfgsdg</a>1212121 < img src = '
        // ' / >< a href ='href'><img href='hhhhhh' />sdfsfd dfdf</a>1sdfsdf1");

        List<String> advertisingList = null;
        String returnString = xmlString;
        if (xmlString != null && !"".equals(returnString)) {
            matcherHref = patternHref.matcher(xmlString);
            advertisingList = new ArrayList<String>();

            while (matcherHref.find()) {
                String hrefString = matcherHref.group();
                Matcher matcherImg = patternImg.matcher(hrefString);
                while (matcherImg.find()) {
                    advertisingList.add(matcherHref.group());
                }
            }
        }
        // System.out.println(returnString);
        if (advertisingList != null && advertisingList.size() > 0) {
            for (String string : advertisingList) {
                // System.out.println(string);
                returnString = returnString.replace(string, "$$");
                // System.out.println(returnString);
                // System.out.println("############################");
            }
        }
        return returnString;
    }

    /**
     * 2、过滤图片
     *
     * @param xmlString
     *
     * @return
     */
    // private static String filterImgs(String xmlString, String savepath)
    // throws Exception {
    // String returnString = xmlString;
    //
    // List<UploadBean> resultList = new ArrayList<UploadBean>();
    // Map<String, String> map = new HashMap<String, String>();
    // // System.out.println(tempString);
    // Matcher matcherImg = patternImg.matcher(returnString);
    // int count = 10;
    // while (matcherImg.find()) {
    // String imgString = matcherImg.group();
    // UploadBean uploadbean = new UploadBean();
    // String src = filterImgSrc(imgString);
    // System.out.println(src);
    // String[] test = src.split("/");
    // String imagename = test[test.length - 1];
    // uploadbean.setSavepath(savepath + "/" + imagename);
    // uploadbean.setUploadsrc(src);
    // resultList.add(uploadbean);
    //
    // }
    // map = FileDownLoad.batchDownLoad(resultList);
    // Iterator<String> iterator = map.keySet().iterator();
    // while (iterator.hasNext()) {
    // String srcString = iterator.next();
    // String localString = map.get(srcString);
    // // System.out.println(srcString);
    // // System.out.println(localString);
    // returnString = returnString.replace(srcString, localString);
    // }
    //
    // return returnString;
    // }

    /**
     * 过滤Img下的src
     *
     * @param imgString
     * @return
     */
    public static List<String> getImgSrc(String imgString) {
        Matcher matcher = patternImgStr.matcher(imgString);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                continue;
            }
            // 这里可能还需要更复杂的判断,用以处理src="...."内的一些转义符
            if (group.startsWith("'")) {
                list.add(group.substring(1, group.indexOf("'", 1)));
            } else if (group.startsWith("\"")) {
                list.add(group.substring(1, group.indexOf("\"", 1)));
            } else {
                list.add(group.split("\\s")[0]);
            }
        }
        // for (String string : list) {
        // System.out.println(string);
        // }
        return list;
    }

    /**
     * 过滤Img下的src
     *
     * @param imgString
     * @return
     */
    public static String filterImgSrc(String imgString) {
        Matcher matcher = patternImgStr.matcher(imgString);
        String returnString = null;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                continue;
            }
            // 这里可能还需要更复杂的判断,用以处理src="...."内的一些转义符
            if (group.startsWith("'")) {
                returnString = group.substring(1, group.indexOf("'", 1));
            } else if (group.startsWith("\"")) {
                returnString = group.substring(1, group.indexOf("\"", 1));
            } else {
                returnString = group.split("\\s")[0];
            }
        }
        return returnString;
    }

    /**
     * 过滤掉Javascript
     *
     * @param contentString
     * @return
     */
    public static String filterScript(String contentString) {
        String returnString = contentString;
        Matcher matcher = patternJs.matcher(returnString);
        while (matcher.find()) {
            String group = matcher.group();
            if (group == null) {
                continue;
            }
            returnString = returnString.replace(group, "$$");
        }
        // System.out.println(returnString);
        return returnString;
    }

    /**
     * 过滤掉样式class=""
     *
     * @param contentString
     * @return
     */
    public static String filterStyleClass(String contentString) {
        String returnString = contentString;

        Pattern patternStyleClass = Pattern.compile(
                "(\\s*class\\s*=\\s*[\"|\'](.*?)[\"|\']\\s*?)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = patternStyleClass.matcher(returnString);
        while (matcher.find()) {
            String group = matcher.group();
            if (group == null) {
                continue;
            }
            // System.out.println(group);
            returnString = returnString.replace(group, "$$");
        }
        // System.out.println(returnString);
        return returnString;
    }

    /**
     * 过滤link标签
     *
     * @param contentString
     * @return
     */
    public static String filterLink(String contentString) {
        String returnString = contentString;
        Matcher matcher = patternLink.matcher(returnString);
        while (matcher.find()) {
            String group = matcher.group();
            if (group == null) {
                continue;
            }
            // System.out.println(group);
            returnString = returnString.replace(group, "$$");
        }
        // System.out.println(returnString);
        return returnString;
    }

    /**
     * 过滤style标签
     *
     * @param contentString
     * @return
     */
    public static String filterStyle(String contentString) {
        String returnString = contentString;
        Matcher matcher = patternStyle.matcher(returnString);
        while (matcher.find()) {
            String group = matcher.group();
            if (group == null) {
                continue;
            }
            // System.out.println(group);
            returnString = returnString.replace(group, "$$");
        }
        // System.out.println(returnString);
        return returnString;
    }

    public static void main(String[] args) {
        String contentString = "ddddd<style class=\"testsdfsdfsfdsgdsghdfs\" sdf sdf  sdf ></style><div style='display:none'>sdf</div><link class='1234' href='东四饭店sgs对公' > <style href=''>ddd</style><link href='javascript:function (){}' ></div>的闪光灯<tr class=\"hidsdy\"></tr> <style href=''>ddd</style>";
        System.out.println(filterStyle(contentString));
    }

    /**
     * 过滤全部
     *
     * @param contentString
     * @param savepath
     * @return
     */
    public static String filterContent(String contentString, String savepath)
            throws Exception {
        String returnString = contentString;
        // System.out.println(returnString);
        // 1、过滤广告
        returnString = filterdAdvertising(returnString);
        // 2、过滤图片
        // returnString = filterImgs(returnString, savepath);
        // 3、过滤script
        returnString = filterScript(returnString);
        // 4、过滤link
        returnString = filterLink(returnString);
        // 5、过滤Style
        returnString = filterStyle(returnString);
        // 6、过滤class
        returnString = filterStyleClass(returnString);
        // System.out.println("############################");
        // System.out.println(returnString);
        return returnString;
    }

    /**
     * 转换获取html src img
     *
     * @param imgString
     * @return
     */
    public static String filterImgSrcContent(String imgString) {
        String patternStr = "<\\s*img\\s*(?:[^>]*)src\\s*=\\s*([^>]+)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(imgString);
        String returnString = null;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                continue;
            }
            // 这里可能还需要更复杂的判断,用以处理src="...."内的一些转义符
            if (group.startsWith("'")) {
                returnString = group.substring(1, group.indexOf("'", 1));
            } else if (group.startsWith("\"")) {
                returnString = group.substring(1, group.indexOf("\"", 1));
            } else {
                returnString = group.split("\\s")[0];
            }
        }
        return returnString;
    }
}
