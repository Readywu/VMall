package tech.niuchuang.xzlibrary.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

public class VMallImageCache implements ImageLoader.ImageCache {

    private LruCache<String, Bitmap> mCache;

    public VMallImageCache() {
        int maxSize = 8 * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                //getRowBytes()返回图片每行的字节数，乘以高度得到图片的size
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}