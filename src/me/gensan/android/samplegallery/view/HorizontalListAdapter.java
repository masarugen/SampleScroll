package me.gensan.android.samplegallery.view;

import java.util.List;

import me.gensan.android.samplegallery.R;
import me.gensan.android.samplegallery.urlimageview.UrlImageView;
import me.gensan.android.samplegallery.vo.GalleryVo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class HorizontalListAdapter extends BaseAdapter {
	
	private List<GalleryVo> mList;
	private LayoutInflater mInflater;
	private OnItemClickListener mListener;
	
	public HorizontalListAdapter(Context context, List<GalleryVo> list) {
		mList = list;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, final ViewGroup parent) {

		GalleryVo vo = (GalleryVo) getItem(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.gallery_item, parent, false);
		}
		((UrlImageView) convertView.findViewById(R.id.photo)).setImageUrl(vo.thumb);
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mListener != null) {
					mListener.onItemClick(position);
				}
			}
		});

		return convertView;
	}
	
	public void setOnItemClickListener(OnItemClickListener listener) {
		mListener = listener;
	}

	public interface OnItemClickListener {
		public void onItemClick(int position);
	}
}
