package br.com.caelum.twittelum_teste.dto;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.activity.FormActivity;
import br.com.caelum.twittelum_teste.modelo.Tweet;

/**
 * Created by analosnak on 18/06/2018.
 */

public class FormHelper {

    private final EditText contentInput;
    private final TextView counter;
    private final Button button;
    private final int maxChars;

    public FormHelper(FormActivity activity) {
        contentInput = activity.findViewById(R.id.form_tweet);
        counter = activity.findViewById(R.id.form_counter);
        button = activity.findViewById(R.id.form_button);
        maxChars = activity.getResources().getInteger(R.integer.tweet_max_size);
        this.addCounterListener();
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
        tweet.setContent(contentInput.getText().toString());

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
}
