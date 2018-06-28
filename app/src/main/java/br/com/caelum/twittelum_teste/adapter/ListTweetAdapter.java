package br.com.caelum.twittelum_teste.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.modelo.Tweet;

/**
 * Created by analosnak on 28/06/2018.
 */

public class ListTweetAdapter extends BaseAdapter {
    private final Activity activity;
    private final List<Tweet> tweets;

    public ListTweetAdapter(Activity activity, List<Tweet> tweets) {
        this.activity = activity;
        this.tweets = tweets;
    }

    @Override
    public int getCount() {
        return tweets.size();
    }

    @Override
    public Object getItem(int position) {
        return tweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tweets.get(position).getPublishingDate().compareTo(LocalDateTime.MIN);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = activity.getLayoutInflater().inflate(R.layout.image_two_texts_list_item,parent,false);
        Tweet tweet = tweets.get(position);

        ImageView photo = layout.findViewById(R.id.image_item);
        photo.setImageResource(R.drawable.baseline_account_box_24);

        TextView contentView = layout.findViewById(R.id.text1_item);
        contentView.setText(tweet.getContent());

        TextView dateView = layout.findViewById(R.id.text2_item);
        dateView.setText(tweet.getPublishingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy\nHH:mm")));

        return layout;
    }
}
