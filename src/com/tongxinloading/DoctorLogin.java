package com.tongxinloading;

import java.util.HashMap;

import org.apache.http.protocol.ResponseDate;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.tongxin.url.DoctorUtilUrl;
import com.tongxindoxtor.R;

public class DoctorLogin extends Activity implements OnClickListener {
	Context mContext;
	TextView textView_action_title_bar_left = null;
	EditText doctorLoginNameEditText;
	EditText doctorLoginPasswordEditText;
	TextView doctorLoginForgetPasswordTextView;
	Button doctorLoginLoginButton;
	Button doctorLoginRegestButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		mContext = DoctorLogin.this;
		View activity_view = View.inflate(mContext,
				R.layout.doctor_login_activity, null);
		setContentView(activity_view);
		init_httpget();
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_action_bar);
		textView_action_title_bar_left_onclick();
		init_httpget();
		initView();

	}
	
	
	public void initView(){
		doctorLoginNameEditText=(EditText) findViewById(R.id.doctorLoginNameEditText);
		doctorLoginPasswordEditText=(EditText) findViewById(R.id.doctorLoginPasswordEditText);
		doctorLoginRegestButton=(Button) findViewById(R.id.doctorLoginRegestButton);
		doctorLoginLoginButton=(Button) findViewById(R.id.doctorLoginLoginButton);
		doctorLoginLoginButton.setOnClickListener(this);
		doctorLoginRegestButton.setOnClickListener(this);
		doctorLoginForgetPasswordTextView=(TextView) findViewById(R.id.doctorLoginForgetPasswordTextView);
	}

	public void textView_action_title_bar_left_onclick() {
		textView_action_title_bar_left = (TextView) findViewById(R.id.textView_action_title_bar_left);
		textView_action_title_bar_left
				.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {					
						finish();
				}
		});
	}

	public void onClick(View view) {	
		switch (view.getId()) {
		case R.id.doctorLoginLoginButton:					
			init_httpget();
			break;
		case R.id.doctorLoginRegestButton:		
			
			break;
		default:
			break;
		}
	}
	public void init_httpget(){
		Log.i("TAG", DoctorUtilUrl.BASE_URL+DoctorUtilUrl.DOCTOR_LOGIN);
		HashMap<String, String> params = new HashMap<String, String>();
		
		params.put("username","gyj");
		params.put("password","123456");
		
		JsonObjectRequest request=new JsonObjectRequest(Method.GET, DoctorUtilUrl.BASE_URL,new JSONObject(params), new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(DoctorLogin.this, arg0.toString(), Toast.LENGTH_SHORT).show();
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Log.i("TAG", DoctorUtilUrl.BASE_URL+DoctorUtilUrl.DOCTOR_LOGIN);
		StringRequest reStringRequest=new StringRequest(Method.GET, DoctorUtilUrl.BASE_URL, new Response.Listener<String>() {

			@Override
			public void onResponse(String arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(DoctorLogin.this, arg0.toString(), Toast.LENGTH_SHORT).show();
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

}
