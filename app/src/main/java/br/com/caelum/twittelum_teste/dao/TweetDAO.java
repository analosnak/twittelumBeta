package br.com.caelum.twittelum_teste.dao;

import android.content.ContentValues;
import android.content.Context;

import br.com.caelum.twittelum_teste.modelo.Tweet;

import static br.com.caelum.twittelum_teste.dao.TwittelumContract.Tweet.COLUMN_NAME_CONTENT;
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
}
