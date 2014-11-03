package com.tongxinapplication;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public class StrErrListener implements ErrorListener{
	private Context mContext;
	public void onErrorResponse(VolleyError arg0) {  
//        Toast.makeText(mContext,  
//                VolleyError.getMessage(arg0, mContext),  
//                Toast.LENGTH_LONG).show();  
    }  

}
