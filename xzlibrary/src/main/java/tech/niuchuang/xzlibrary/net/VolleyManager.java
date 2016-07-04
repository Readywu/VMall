package tech.niuchuang.xzlibrary.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import tech.niuchuang.xzlibrary.net.okhttp.OkHttp3Stack;
import tech.niuchuang.xzlibrary.net.request.ByteRequest;
import tech.niuchuang.xzlibrary.net.request.GsonRequest;
import tech.niuchuang.xzlibrary.net.request.JsonArrayRequest;
import tech.niuchuang.xzlibrary.net.request.JsonObjectRequest;

/**
 * Created by Allen Lin on 2016/02/18.
 */
public class VolleyManager implements IHttpClient {
    //INSTANCE;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static VolleyManager INSTANCE;
    private final Context mContext;
    private static final int[] sLock = new int[0];

    private VolleyManager(Context context) {
        mContext = context;
        mRequestQueue = Volley.newRequestQueue(context,
                new OkHttp3Stack(new OkHttpClient()));
    }

    /**
     * 这里使用Application的Context
     *
     * @param context
     * @return
     */
    public static VolleyManager getInstance(Context context) {
        if (null == INSTANCE) {
            synchronized (sLock) {
                if (null == INSTANCE) {
                    INSTANCE = new VolleyManager(context);
                }
            }
        }
        return INSTANCE;
    }


    /**
     * 添加请求
     *
     * @param request
     */
    public void addRequest(Request request, Object tag) {
        if (tag != null) {
            request.setTag(tag);
        }
        mRequestQueue.add(request);
    }


    /**
     * ImageRequest
     *
     * @param tag
     * @param url
     * @param listener
     * @param maxWidth
     * @param maxHeight
     * @param scaleType
     * @param decodeConfig
     * @param errorListener
     * @return
     */
    public ImageRequest ImageRequest(Object tag, String url, Response.Listener<Bitmap> listener,
                                     int maxWidth, int maxHeight, ImageView.ScaleType scaleType,
                                     Bitmap.Config decodeConfig, Response.ErrorListener errorListener) {
        ImageRequest request = new ImageRequest(url, listener, maxWidth, maxHeight, scaleType,
                decodeConfig, errorListener);
        request.setTag(tag);
        addRequest(request, tag);
        return request;
    }


    @Override
    public Request request(HttpRequest httpRequest, IHttpListener<String> listener, Object tag) {
        return null;
    }

    @Override
    public Request byteRequest(HttpRequest httpRequest, IHttpListener<byte[]> listener, Object tag) {
        ByteRequest request = new ByteRequest(httpRequest, listener);
        addRequest(request, tag);
        return request;
    }

    @Override
    public Request jsonObjectRequest(HttpRequest httpRequest, IHttpListener<JSONObject> listener, Object tag) {
        JsonObjectRequest request = new JsonObjectRequest(httpRequest, listener);
        addRequest(request, tag);
        return request;
    }

    @Override
    public Request jsonArrayRequest(HttpRequest httpRequest, IHttpListener<JSONArray> listener, Object tag) {
        JsonArrayRequest request = new JsonArrayRequest(httpRequest, listener);
        addRequest(request, tag);
        return request;
    }

    @Override
    public <T> Request gsonRequest(Class<T> tClass, HttpRequest httpRequest, IHttpListener<T> listener, Object tag) {
        GsonRequest<T> request = new GsonRequest<T>(tClass, httpRequest, listener);
        addRequest(request, tag);
        return request;
    }

    @Override
    public <T> Request gsonRequest(TypeToken<T> typeToken, HttpRequest httpRequest, IHttpListener<T> listener, Object tag) {
        GsonRequest<T> request = new GsonRequest<T>(typeToken, httpRequest, listener);
        addRequest(request, tag);
        return request;
    }

    /**
     * 取消请求
     *
     * @param tag
     */
    @Override
    public void cancelRequest(Object tag) {
        mRequestQueue.cancelAll(tag);
    }
}