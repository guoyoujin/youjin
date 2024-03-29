package com.tongxinapplication;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.tongxin.volley.util.LruBitmapCache;

import android.app.Application;
import android.text.TextUtils;

public class MyTongXinApplication extends Application{
	public static final String TAG = MyTongXinApplication.class
	        .getSimpleName();

	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	private static MyTongXinApplication mInstance;

	@Override
	public void onCreate() {
	    super.onCreate();
	    mInstance = this;
	}

	public static synchronized MyTongXinApplication getInstance() {
	    return mInstance;
	}

	public RequestQueue getRequestQueue() {
	    if (mRequestQueue == null) {
	        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
	    }

	    return mRequestQueue;
	}

	public ImageLoader getImageLoader() {
	    getRequestQueue();
	    if (mImageLoader == null) {
	        mImageLoader = new ImageLoader(this.mRequestQueue,
	                new LruBitmapCache());
	    }
	    return this.mImageLoader;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
	    // set the default tag if tag is empty
	    req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
	    getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
	    req.setTag(TAG);
	    getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
	    if (mRequestQueue != null) {
	        mRequestQueue.cancelAll(tag);
	    }
	}
	}