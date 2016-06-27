package cn.a17xiezuo.xzlibrary.net.request;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;


import org.json.JSONException;
import org.json.JSONObject;

import cn.a17xiezuo.xzlibrary.net.HttpRequest;
import cn.a17xiezuo.xzlibrary.net.IHttpListener;


public class JsonObjectRequest extends RequestWrapper<JSONObject> {

    public JsonObjectRequest(HttpRequest httpRequest, IHttpListener<JSONObject> listener) {
        super(httpRequest, listener);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        String result = getResponseString(response);
        if (result.equals(PARSEERROR)) {
            return Response.error(new ParseError());
        }
        try {
            return Response.success(new JSONObject(result), HttpHeaderParser.parseCacheHeaders(response));
        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        }
    }
}
