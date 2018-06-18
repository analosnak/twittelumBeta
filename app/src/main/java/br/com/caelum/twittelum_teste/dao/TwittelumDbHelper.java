package br.com.caelum.twittelum_teste.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by analosnak on 15/06/2018.
 */

public class TwittelumDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TwittelumSQLite";
    public static final int DATABASE_VERSION = 1;

    public TwittelumDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TwittelumContract.Tweet.SQL_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {
        sqLiteDatabase.execSQL(TwittelumContract.Tweet.SQL_DELETE_QUERY);
    }
}
