package br.com.caelum.twittelum_teste.dao;

import android.provider.BaseColumns;

/**
 * Created by analosnak on 17/06/2018.
 */

public class TwittelumContract {
    private TwittelumContract () {}

    public static class Tweet implements BaseColumns {
        public static final String TABLE_NAME = "Tweet";
        public static final String COLUMN_NAME_CONTENT = "Content";

        public static final String SQL_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "(" + Tweet._ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_CONTENT + " TEXT)";
        public static final String SQL_DELETE_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;
    }
}
