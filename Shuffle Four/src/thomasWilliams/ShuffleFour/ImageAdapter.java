package thomasWilliams.ShuffleFour;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			// imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
		// imageView.setBackgroundColor(0xFF66FF66);
		return imageView;
	}

	/*
	 * public View getView(int position, View convertView, ViewGroup parent) { TextView tv; if (convertView == null) { tv = new TextView(context); tv.setLayoutParams(new GridView.LayoutParams(85, 85)); } else { tv = (TextView) convertView; }
	 * 
	 * tv.setText(texts[position]); return tv; }
	 */

	// references to our images
	// private Integer[] mThumbIds = { R.drawable.ic_launcher, R.drawable.icon_72x72, R.drawable.refresh_screen_01, R.drawable.refresh_screen_02, R.drawable.refresh_screen_03, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.white_bg, R.drawable.white_bg, R.drawable.white_bg, R.drawable.white_bg, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02, R.drawable.refresh_screen_02 };
	// private Integer[] mThumbIds = { R.drawable.gridview_001, R.drawable.gridview_002, R.drawable.gridview_003, R.drawable.gridview_004, R.drawable.gridview_005, R.drawable.gridview_006, R.drawable.gridview_007, R.drawable.gridview_008, R.drawable.gridview_009, R.drawable.gridview_010, R.drawable.gridview_011, R.drawable.gridview_012, R.drawable.gridview_013, R.drawable.gridview_014, R.drawable.gridview_015, R.drawable.gridview_016, R.drawable.gridview_017, R.drawable.gridview_018, R.drawable.gridview_019, R.drawable.gridview_020, R.drawable.gridview_021, R.drawable.gridview_022, R.drawable.gridview_023, R.drawable.gridview_024, R.drawable.gridview_025 };
	private Integer[] mThumbIds;
}