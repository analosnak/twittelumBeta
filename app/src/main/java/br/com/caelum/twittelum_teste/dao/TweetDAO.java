package br.com.caelum.twittelum_teste.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.caelum.twittelum_teste.modelo.Tweet;

import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.COLUMN_NAME_CONTENT;
import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.SQL_SELECT_ALL_QUERY;
import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.TABLE_NAME;

/**
 * Created by analosnak on 17/06/2018.
 */

public class TweetDAO {

    private TwittelumDbHelper dbHelper;

    public TweetDAO(TwittelumDbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void save(Tweet tweet) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_CONTENT, tweet.getContent());
        dbHelper.getWritableDatabase().insert(TABLE_NAME, null,values);
    }

    public List<Tweet> findAll() {
        List<Tweet> tweets = new ArrayList<>();

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(SQL_SELECT_ALL_QUERY + TABLE_NAME, null);
        while(cursor.moveToNext()) {
            Tweet tweet = new Tweet();
            tweet.setContent(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_CONTENT)));
            tweets.add(tweet);
        }
        return tweets;
    }
}
