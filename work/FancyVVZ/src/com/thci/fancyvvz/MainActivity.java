package com.thci.fancyvvz;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private ViewFlipper viewFlipper;

	@Override
	/**
	 * Set contend and init viewFlipper. JR
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);
		viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
	}
	
	/**
	 * Switch between views. Ever return false for no reason. JR
	 */
	public boolean onTouchEvent(MotionEvent motionEvent) {
		
		switch(motionEvent.getAction()) {
		case MotionEvent.ACTION_UP:
			viewFlipper.setInAnimation(getApplicationContext(), R.anim.slide_in_from_bot);
			viewFlipper.setOutAnimation(getApplicationContext(), R.anim.slide_out_to_top);
			// viewFlippers childs are numbered from 0 to 1 (two views total). JR
			if (viewFlipper.getDisplayedChild() == 0) {
				viewFlipper.showNext();
			} else {
				viewFlipper.showPrevious();
			}
		}
		return false;
	}
}