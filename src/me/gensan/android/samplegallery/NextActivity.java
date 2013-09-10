package me.gensan.android.samplegallery;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class NextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		findViewById(R.id.browser).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("http://www.yahoo.co.jp");
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
			}
		});
		findViewById(R.id.dialog).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(NextActivity.this);
				builder.setMessage("test");
				builder.create().show();
			}
		});
	}

	@Override
	protected void onPause() {
		android.util.Log.d("hashizume", "onPause:" + isFinishing());
		super.onPause();
		if (!isFinishing()) {
			finish();
		}
	}

	@Override
	protected void onStop() {
		android.util.Log.d("hashizume", "onStop:" + isFinishing());
		super.onStop();
	}

}
