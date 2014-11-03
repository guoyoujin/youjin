package com.tongxinloading;

import java.util.ArrayList;
import java.util.List;

import com.tongxindoxtor.R;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class LoadingFristActivity extends Activity {
	ViewPager viewPager;
	ImageView[] image_view;
	@SuppressWarnings("deprecation")
	LocalActivityManager manager = null;
	ArrayList<Fragment> fragment_list = new ArrayList<Fragment>();
	List<View> listViews;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading_frist);
		viewPager = (ViewPager) findViewById(R.id.viewPager_doctor_login);
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		listViews = new ArrayList<View>();
		Intent i1 = new Intent(LoadingFristActivity.this,
				LoadGuideOneActivity.class);
		i1.putExtra("activity", 1);
		listViews.add(getView("LoginGuideOneActivity", i1));
		Intent i2 = new Intent(LoadingFristActivity.this,
				LoadGuideOneActivity.class);
		i2.putExtra("activity", 2);
		listViews.add(getView("LoadGuideTwoActivity", i2));
		Intent i3 = new Intent(LoadingFristActivity.this,
				LoadGuideOneActivity.class);
		i3.putExtra("activity", 3);
		listViews.add(getView("LoadGuideThereActivity", i3));

		viewPager.setAdapter(new MyPageAdapter(listViews));
	}

	private View getView(String id, Intent intent) {
		Log.i("TAG", "getView() called! id = " + id);
		return manager.startActivity(id, intent).getDecorView();
	}

	private class MyPageAdapter extends PagerAdapter {

		private List<View> list;

		private MyPageAdapter(List<View> list) {
			this.list = list;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object arg2) {
			ViewPager pViewPager = ((ViewPager) view);
			pViewPager.removeView(list.get(position));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			ViewPager pViewPager = ((ViewPager) view);
			pViewPager.addView(list.get(position));
			return list.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

	}

}
