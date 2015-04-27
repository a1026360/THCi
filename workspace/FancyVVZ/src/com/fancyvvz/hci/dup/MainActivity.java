package com.fancyvvz.hci.dup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	private ViewFlipper viewFlipper;

	@Override
	/**
	 * Set contend and init viewFlipper
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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

	@Override
	/**
	 * Useless until implemented. JR
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	/**
	 * Useless until implemented. JR
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
