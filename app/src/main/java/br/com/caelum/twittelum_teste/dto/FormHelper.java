package br.com.caelum.twittelum_teste.dto;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDateTime;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.activity.TweetFormActivity;
import br.com.caelum.twittelum_teste.modelo.Tweet;

/**
 * Created by analosnak on 18/06/2018.
 */

public class FormHelper {

    private final ImageView photo;
    private final FloatingActionButton imageButton;
    private final EditText contentInput;
    private final TextView counter;
    private final Button button;
    private final int maxChars;

    public FormHelper(TweetFormActivity activity) {
        photo = activity.findViewById(R.id.form_image);
        imageButton = activity.findViewById(R.id.form_image_button);
        contentInput = activity.findViewById(R.id.form_tweet);
        counter = activity.findViewById(R.id.form_counter);
        button = activity.findViewById(R.id.form_button);
        maxChars = activity.getResources().getInteger(R.integer.tweet_max_size);
        this.addCounterListener();
    }

    public FloatingActionButton getImageButton() {
        return imageButton;
    }

    public Button getButton() {
        return button;
    }

    public void addCounterListener() {
        contentInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int wordBeginningPosition, int before, int numWordChars) {
                int numWrittenChars = wordBeginningPosition + numWordChars;
                counter.setText((maxChars - numWrittenChars) + "/" + maxChars);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    public Tweet getTweet() {
        Tweet tweet = new Tweet();
        tweet.setUserPhotoPath(photo.getTag().toString());
        tweet.setContent(contentInput.getText().toString());
        tweet.setPublishingDate(LocalDateTime.now());

        return tweet;
    }

    public boolean isEmptyContent() {
        return contentInput.getText().toString().isEmpty();
    }

    public void showError() {
        contentInput.setError("O conteúdo do tweet não pode ser vazio");
    }

    public void cleanInputs() {
        contentInput.setText("");
    }

    public void setUserPhoto(String photoPathName) {
        Bitmap imageBitmap = BitmapFactory.decodeFile(photoPathName);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(imageBitmap, 200, 200, true);
        this.photo.setImageBitmap(scaledBitmap);
        this.photo.setTag(photoPathName);
    }
}
