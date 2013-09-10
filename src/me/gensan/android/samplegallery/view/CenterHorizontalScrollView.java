package me.gensan.android.samplegallery.view;

import me.gensan.android.samplegallery.view.HorizontalListAdapter.OnItemClickListener;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class CenterHorizontalScrollView extends HorizontalScrollView implements OnItemClickListener {

	private Context mContext;
	private int mSize;
	private int mScreenWidth;
	private int mLeftMergin;
	private int mRightMergin;

	public CenterHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		mScreenWidth = display.getWidth();
	}

	public void setAdapter(Context context, HorizontalListAdapter adapter) {
		adapter.setOnItemClickListener(this);
		mSize = adapter.getCount();
		ViewGroup parent = (ViewGroup) getChildAt(0);
		parent.removeAllViews();
		for (int i = 0; i < adapter.getCount(); i++) {
			parent.addView(adapter.getView(i, null, parent));
		}
	}

	public void setCurrentCenter() {
		
	}

	public void setCenter(int index) {
		ViewGroup parent = (ViewGroup) getChildAt(0);
		View view = parent.getChildAt(index);
		int scrollX = (view.getLeft() - (mScreenWidth / 2)) + (view.getWidth() / 2) - mLeftMergin;
		smoothScrollTo(scrollX, 0);
	}

	@Override
	public void onItemClick(int position) {
		setCenter(position);
	}

}
