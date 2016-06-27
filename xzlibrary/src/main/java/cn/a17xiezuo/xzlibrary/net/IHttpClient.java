package cn.a17xiezuo.xzlibrary.net;

import com.android.volley.Request;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 */
public interface IHttpClient {

    /**
     * String请求
     *
     * @param httpRequest
     * @param listener
     * @param tag
     * @return
     */
    Request request(HttpRequest httpRequest, final IHttpListener<String> listener, Object tag);

    /**
     * byte请求
     *
     * @param httpRequest
     * @param listener
     * @param tag
     * @return
     */
    Request byteRequest(HttpRequest httpRequest, IHttpListener<byte[]> listener, Object tag);

    /**
     * JsonObject请求
     *
     * @param httpRequest
     * @param listener
     * @param tag
     * @return
     */
    Request jsonObjectRequest(HttpRequest httpRequest, IHttpListener<JSONObject> listener, Object tag);

    /**
     * JsonArray请求
     *
     * @param httpRequest
     * @param listener
     * @param tag
     * @return
     */
    Request jsonArrayRequest(HttpRequest httpRequest, IHttpListener<JSONArray> listener, Object tag);

    /**
     * Gson请求，可以映射Model
     *
     * @param tClass      映射的Model
     * @param httpRequest
     * @param listener
     * @param tag
     * @param <T>
     * @return
     */
    <T> Request gsonRequest(Class<T> tClass, HttpRequest httpRequest, IHttpListener<T> listener, Object tag);

    /**
     * Gson请求，可以映射Model
     *
     * @param typeToken   例如List<Model>
     * @param httpRequest
     * @param listener
     * @param tag
     * @param <T>
     * @return
     */
    <T> Request gsonRequest(TypeToken<T> typeToken, HttpRequest httpRequest, IHttpListener<T> listener, Object tag);

    /**
     * 取消请求
     *
     * @param tag
     */
    void cancelRequest(Object tag);
}
