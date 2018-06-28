package br.com.caelum.twittelum_teste.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.adapter.ListTweetAdapter;
import br.com.caelum.twittelum_teste.dao.TweetDAO;
import br.com.caelum.twittelum_teste.modelo.Tweet;

public class TweetListActivity extends AppCompatActivity {


    private TweetDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);
        dao = new TweetDAO(this);

        FloatingActionButton button = findViewById(R.id.list_tweet_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TweetListActivity.this, TweetFormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        createList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dao.close();
    }

    private void createList() {
        List<Tweet> tweets = dao.findAll();
        ListAdapter adapter = new ListTweetAdapter(this, tweets);
        ListView tweetList = findViewById(R.id.list_tweets);
        tweetList.setAdapter(adapter);
    }
}
