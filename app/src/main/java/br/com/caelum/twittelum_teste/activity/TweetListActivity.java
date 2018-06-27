package br.com.caelum.twittelum_teste.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.dao.TweetDAO;
import br.com.caelum.twittelum_teste.modelo.Tweet;

public class TweetListActivity extends AppCompatActivity {


    private TweetDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        dao = new TweetDAO(this);
        List<Tweet> tweets = dao.findAll();

        ListAdapter adapter = new ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets);
        ListView tweetList = findViewById(R.id.list_tweets);
        tweetList.setAdapter(adapter);

        FloatingActionButton button = findViewById(R.id.list_tweet_button);
//        Log.i("FUNDO_COR",Float.toString(Color.valueOf(button.getRippleColor()).blue()));
//        Log.i("FUNDO_TINTURA",button.getBackgroundTintList().toString());
//        Log.i("FUNDO_MODO_TINTURA",button.getBackgroundTintMode().toString());
//        Log.i("FUNDO_COR",Integer.toString(button.getSolidColor()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dao.close();
    }
}
