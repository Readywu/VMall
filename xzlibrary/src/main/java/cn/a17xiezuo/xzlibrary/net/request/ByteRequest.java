package cn.a17xiezuo.xzlibrary.net.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import cn.a17xiezuo.xzlibrary.net.HttpRequest;
import cn.a17xiezuo.xzlibrary.net.IHttpListener;


public class ByteRequest extends RequestWrapper<byte[]> {

    public ByteRequest(HttpRequest httpRequest, IHttpListener<byte[]> listener) {
        super(httpRequest, listener);
    }

    @Override
    protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {
        return Response.success(response.data, HttpHeaderParser.parseCacheHeaders(response));
    }
}
