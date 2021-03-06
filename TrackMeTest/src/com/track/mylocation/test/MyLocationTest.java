package com.track.mylocation.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.track.mylocation.MyLocation;

public class MyLocationTest extends ActivityInstrumentationTestCase2<MyLocation>{
	public MyLocationTest(String name) {
		super("com.track.mylocation.MyLocation",MyLocation.class);
		setName(name);
	}
	MyLocation mActivity;

	@Override
	public void setUp() throws Exception{
		super.setUp();
	}
	
	public void testActivityShowsUpTheButton(){
		mActivity = this.getActivity();
		Button button = (Button)mActivity.findViewById(com.track.mylocation.R.id.retrieve_location_button);
		assertNotNull(button);
		assertEquals("Retrieve Location",button.getText());		
	}

}
