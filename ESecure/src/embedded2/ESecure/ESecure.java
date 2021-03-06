package embedded2.ESecure;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class ESecure extends Activity {
	KeyPad k;
//	SensorManager sm;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//changed this text
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_keypad);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
//		sm.registerListener(this, SensorManager.SENSOR_ORIENTATION | SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_NORMAL);
		k = new KeyPad(this, v);
		setContentView(k);
		k.requestFocus();
		// Vibrate for 500 milliseconds
		v.vibrate(500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_keypad, menu);
		return true;
	}

//	@SuppressWarnings("deprecation")
//	public void onSensorChanged(int sensor, float[] values) {
//		synchronized (this) {
//
////			if (sensor == SensorManager.SENSOR_ORIENTATION) {
////				Log.v("Orientation X: ", "" + values[0]);
////				Log.v("Orientation Y: ", "" + values[1]);
////				Log.v("Orientation Z: ", "" + values[2]);
////			}
////			if (sensor == SensorManager.SENSOR_ACCELEROMETER) {
////				Log.v("Accel X: ", "" + values[0]);
////				Log.v("Accel Y: ", "" + values[1]);
////				Log.v("Accel Z: ", "" + values[2]);
////			}
//		}
//	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onResume() {
		super.onResume();
		//sm.registerListener(this, SensorManager.SENSOR_ORIENTATION | SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onStop() {
		super.onStop();
		k.save();
		
	}
	
	protected void onPause() {
		super.onPause();
		k.save();
	}

//	@Override
//	public void onAccuracyChanged(int arg0, int arg1) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_settings:
			return true;
		case R.id.color_settings:
			return true;
		case R.id.exit:
			k.save();
			System.exit(0);
		case R.id.new_pass:
			k.newPassword();
			return true;
		case R.id.red:
			k.setColor(1);
			break;
		case R.id.orange:
			k.setColor(2);
			break;
		case R.id.yellow:
			k.setColor(3);
			break;
		case R.id.green:
			k.setColor(4);
			break;
		case R.id.blue:
			k.setColor(5);
			break;
		case R.id.violet:
			k.setColor(6);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

}
