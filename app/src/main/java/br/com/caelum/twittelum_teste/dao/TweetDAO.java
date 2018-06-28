package br.com.caelum.twittelum_teste.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.twittelum_teste.activity.TweetListActivity;
import br.com.caelum.twittelum_teste.modelo.Tweet;

import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.COLUMN_NAME_CONTENT;
import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.COLUMN_NAME_PUBL_DATE;
import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.COLUMN_NAME_USER_PHOTO;
import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.SQL_SELECT_ALL_QUERY;
import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.TABLE_NAME;

/**
 * Created by analosnak on 17/06/2018.
 */

public class TweetDAO {

    private TwittelumDbHelper dbHelper;

    public TweetDAO(Context context) {
        this.dbHelper = new TwittelumDbHelper(context);
    }

    public void save(Tweet tweet) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_USER_PHOTO, tweet.getUserPhotoPath());
        values.put(COLUMN_NAME_CONTENT, tweet.getContent());
        values.put(COLUMN_NAME_PUBL_DATE, tweet.getPublishingDate().toString());
        dbHelper.getWritableDatabase().insert(TABLE_NAME, null,values);
    }

    public List<Tweet> findAll() {
        List<Tweet> tweets = new ArrayList<>();

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(SQL_SELECT_ALL_QUERY + TABLE_NAME, null);
        while(cursor.moveToNext()) {
            Tweet tweet = new Tweet();
            tweet.setUserPhotoPath(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_USER_PHOTO)));
            tweet.setContent(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_CONTENT)));
            tweet.setPublishingDate(LocalDateTime.parse(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_PUBL_DATE))));
            tweets.add(tweet);
        }
        return tweets;
    }

    public void close() {
        dbHelper.close();
    }
}
