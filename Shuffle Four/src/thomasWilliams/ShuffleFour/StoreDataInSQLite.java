package thomasWilliams.ShuffleFour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StoreDataInSQLite {

	public static final String KEY_GRIDSIZE = "strGridSize";
	public static final String KEY_LEVEL = "strLevel";
	public static final String KEY_MOVES = "strMoves";
	public static final String KEY_DATE = "strDate";
	public static final String KEY_ROWID = "_id";

	private static final String TAG = "HistoryTable";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static final String DATABASE_NAME = "history_database";
	private static final String DATABASE_TABLE = "history";
	private static final int DATABASE_VERSION = 3;

	/**
	 * Database creation sql statement
	 */
	private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE + " (" + KEY_ROWID + " integer primary key autoincrement, " + KEY_DATE + " text not null, " + KEY_GRIDSIZE + " text not null, " + KEY_LEVEL + " text not null, " + KEY_MOVES + " text not null);";

	private final Context mCtx;

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.i(TAG, "Creating DataBase: " + DATABASE_CREATE);
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}

	/**
	 * Constructor - takes the context to allow the database to be opened/created
	 * 
	 * @param ctx
	 *            the Context within which to work
	 */
	public StoreDataInSQLite(Context ctx) {
		this.mCtx = ctx;
	}

	public StoreDataInSQLite open() throws SQLException {
		Log.i(TAG, "OPening DataBase Connection....");
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	public long createRow(String strGridSize, String strLevel, String strMoves, String strDate) {
		Log.i(TAG, "Inserting record...");
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_GRIDSIZE, strGridSize);
		initialValues.put(KEY_LEVEL, strLevel);
		initialValues.put(KEY_MOVES, strMoves);
		initialValues.put(KEY_DATE, strDate);

		return mDb.insert(DATABASE_TABLE, null, initialValues);
	}

	public boolean deleteRow(long rowId) {

		return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	public boolean ClearAll() {

		return mDb.delete(DATABASE_TABLE, null, null) > 0;
	}

	public Cursor fetchAllData() {

		return mDb.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_GRIDSIZE, KEY_LEVEL, KEY_MOVES, KEY_DATE }, null, null, null, null, null);
	}

	public Cursor fetchData(long empId) throws SQLException {

		Cursor mCursor =

		mDb.query(true, DATABASE_TABLE, new String[] { KEY_ROWID, KEY_GRIDSIZE, KEY_LEVEL, KEY_MOVES, KEY_DATE }, KEY_ROWID + "=" + empId, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	public Cursor fetchRow(String strWhereClause) throws SQLException {
		String strQuery = "select * from " + DATABASE_TABLE + " where " + strWhereClause;
		Cursor mCursor = mDb.rawQuery(strQuery, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

//	public String fetchID(int intGridSize, int intLevel) throws SQLException {
//		String strQuery = "select * from " + DATABASE_TABLE + " where " + KEY_GRIDSIZE + " = " + intGridSize + " and " + KEY_LEVEL + " = " + intLevel;
//		Cursor mCursor = mDb.rawQuery(strQuery, null);
//		if (mCursor.getCount() > 0) {
//			mCursor.moveToFirst();
//			return mCursor.getString(mCursor.getColumnIndex(KEY_ROWID));
//		}
//		return null;
//	}

	public long TotalCount() {
		Cursor dataCount = mDb.rawQuery("SELECT  * FROM " + DATABASE_TABLE, null);
		return dataCount.getCount();
	}

	public boolean updateHistory(int empId, String strGridSize, String strLevel, String strMoves, String strDate) {
		ContentValues args = new ContentValues();
		args.put(KEY_GRIDSIZE, strGridSize);
		args.put(KEY_LEVEL, strLevel);
		args.put(KEY_MOVES, strMoves);
		args.put(KEY_DATE, strDate);

		return mDb.update(DATABASE_TABLE, args, KEY_ROWID + "=" + empId, null) > 0;
	}
}