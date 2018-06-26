package br.com.caelum.twittelum_teste.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.modelo.Tweet;

public class TweetListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        ListView tweetList = findViewById(R.id.tweet_list);
        List<String> tweetsText = Arrays.asList("Tweet legal", "Bom dia!", "Twwet do Neymar");
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tweetsText);
        tweetList.setAdapter(adapter);
    }
}
