package thomasWilliams.ShuffleFour;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {
	private ArrayList<String> lstText;
	private ArrayList<Integer> lstImage;
	private Activity activity;
	private int intGridSize;

	public GridviewAdapter(Activity activity, int intGridSize) {
		super();
		this.activity = activity;
		this.intGridSize = intGridSize;
		prepareList();
	}

	public void prepareList() {

		lstImage = new ArrayList<Integer>();
		lstText = new ArrayList<String>();
		for (int i = 0; i < AppConfig.intLevelsPerPage; i++) {
			lstImage.add(AppConfig.aryImgColors[intGridSize - 1]);
			lstText.add(Integer.toString(i + 1));
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lstText.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return lstText.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {
		public ImageView imgGridview;
		public TextView txtGridview;
		public TextView txtMoves;
		public TextView txtMovesLabel;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();

		if (convertView == null) {
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.gridview_row, null);

			view.txtGridview = (TextView) convertView.findViewById(R.id.txtGridview);
			view.txtMoves = (TextView) convertView.findViewById(R.id.txtMoves);
			view.txtMovesLabel = (TextView) convertView.findViewById(R.id.txtMovesLabel);
			view.imgGridview = (ImageView) convertView.findViewById(R.id.imgGridview);

			convertView.setTag(view);
		} else {
			view = (ViewHolder) convertView.getTag();
		}

		StoreDataInSQLite DataStore = new StoreDataInSQLite(activity);
		DataStore.open();
		Cursor curMoves = DataStore.fetchRow(StoreDataInSQLite.KEY_GRIDSIZE + " = " + intGridSize + " and " + StoreDataInSQLite.KEY_LEVEL + " = " + (position + 1));
		DataStore.close();

		if (curMoves.getCount() > 0) {
			int intBestMoves = curMoves.getInt(curMoves.getColumnIndex(StoreDataInSQLite.KEY_MOVES));
			view.txtMoves.setTextSize(TypedValue.COMPLEX_UNIT_DIP, AppConfig.fltMenuTextSize);
			view.txtMoves.setText(String.valueOf(intBestMoves));
			view.txtMoves.setTextColor(AppConfig.aryMenuColors[1]);
			view.txtMoves.setVisibility(View.VISIBLE);
			view.txtMovesLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, AppConfig.fltMenuTextSize / 2);
			view.txtMovesLabel.setVisibility(View.VISIBLE);
			
			// Set other Objects to INVISIBLE
			view.txtGridview.setVisibility(View.INVISIBLE);
			// view.imgGridview.setBackgroundColor(AppConfig.aryMenuColors[intGridSize - 1]);
		} else {
			view.txtGridview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, AppConfig.fltMenuTextSize);
			view.txtGridview.setText(lstText.get(position));
			view.txtGridview.setTextColor(AppConfig.aryMenuColors[intGridSize - 1]);
			view.txtGridview.setVisibility(View.VISIBLE);
			
			// Set other Objects to INVISIBLE
			view.txtMovesLabel.setVisibility(View.INVISIBLE);
			view.txtMoves.setVisibility(View.INVISIBLE);
		}
		view.imgGridview.setImageResource(lstImage.get(position));
		view.imgGridview.setVisibility(View.VISIBLE);

		return convertView;
	}
}