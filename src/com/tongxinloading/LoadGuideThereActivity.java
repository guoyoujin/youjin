package com.tongxinloading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.tongxindoxtor.R;

public class LoadGuideThereActivity extends Activity implements OnClickListener{
	Context mContext=null;
	RelativeLayout layout_background_image=null;
	Button btn_intent_login=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_guide_activity);
		
		mContext=LoadGuideThereActivity.this;
		layout_background_image=(RelativeLayout)findViewById(R.id.layout_background_image);
		btn_intent_login=(Button) findViewById(R.id.btn_intent_login);
		btn_intent_login.setOnClickListener(this);
		layout_background_image.setBackgroundResource(R.drawable.doctorguide3);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btn_intent_login:
			Intent intent=new Intent(mContext,DoctorLogin.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
