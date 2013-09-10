package me.gensan.android.samplegallery;

import java.lang.reflect.Type;
import java.util.List;

import me.gensan.android.samplegallery.view.CenterHorizontalScrollView;
import me.gensan.android.samplegallery.view.HorizontalListAdapter;
import me.gensan.android.samplegallery.vo.GalleryVo;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class ScrollViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrollview);
		
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://bjin.me/api/?type=rand&count=100&format=json", new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				Gson gson = new Gson();
				Type type = new TypeToken<List<GalleryVo>>() {}.getType();
				List<GalleryVo> list = gson.fromJson(response, type);
				for (GalleryVo vo : list) {
					Log.d("hashizume", "thumb:" + vo.thumb);
				}
				((CenterHorizontalScrollView) findViewById(R.id.scrollView))
					.setAdapter(getApplicationContext(),
							new HorizontalListAdapter(getApplicationContext(), list));
			}
		});
	}

}
