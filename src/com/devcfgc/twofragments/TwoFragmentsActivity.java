package com.devcfgc.twofragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class TwoFragmentsActivity extends FragmentActivity implements
		OneFragment.OneFragmentListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two_fragments);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.two_fragments, menu);
		return true;
	}

	@Override
	public void onButtonClick(String text) {
		TwoFragment textFragment = (TwoFragment) getSupportFragmentManager()
				.findFragmentById(R.id.two_fragment);
		textFragment.changeTextProperties(text);
	}
}
