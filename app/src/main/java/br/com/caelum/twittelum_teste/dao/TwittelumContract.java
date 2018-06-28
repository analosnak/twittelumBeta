package br.com.caelum.twittelum_teste.dao;

import android.provider.BaseColumns;

/**
 * Created by analosnak on 17/06/2018.
 */

public class TwittelumContract {
    private TwittelumContract () {}

    public static class Tweet implements BaseColumns {
        public static final String TABLE_NAME = "Tweet";
        public static final String COLUMN_NAME_USER_PHOTO = "UserPhotoPath";
        public static final String COLUMN_NAME_CONTENT = "Content";
        public static final String COLUMN_NAME_PUBL_DATE = "PublishingDate";

        public static final String SQL_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "(" + Tweet._ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_USER_PHOTO + " TEXT ," +
                COLUMN_NAME_CONTENT + " TEXT NOT NULL ," +
                COLUMN_NAME_PUBL_DATE +" TEXT NOT NULL)";
        public static final String SQL_UPDATE_1_2_QUERY1 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN  " + COLUMN_NAME_USER_PHOTO + " TEXT ;";
        public static final String SQL_UPDATE_1_2_QUERY2 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN  " + COLUMN_NAME_PUBL_DATE + " TEXT NOT NULL DEFAULT '2018-06-27T00:00:00';";
        public static final String SQL_DELETE_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;
        public static final String SQL_SELECT_ALL_QUERY = "SELECT * FROM ";

    }
}
