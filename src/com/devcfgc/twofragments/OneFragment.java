package com.devcfgc.twofragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class OneFragment extends Fragment {

	private static EditText mEditText;

	OneFragmentListener activityCallback;

	//Listener for onButtonClick UI
	public interface OneFragmentListener {
		public void onButtonClick(String text);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			activityCallback = (OneFragmentListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OneFragmentListener");
		}
	}

	//We get the reference to the editText and the button setUp the OnClickListener
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.one_fragment, container, false);

		mEditText = (EditText) view.findViewById(R.id.textOneFragment);

		final Button button = (Button) view.findViewById(R.id.buttonChange);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				buttonClicked(v);
			}
		});

		return view;
	}

	//Set the activityCallback to onButtonClick passing the text in the mEditText
	public void buttonClicked(View view) {
		activityCallback.onButtonClick(mEditText.getText().toString());
	}
}
