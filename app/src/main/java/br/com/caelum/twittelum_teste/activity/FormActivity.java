package br.com.caelum.twittelum_teste.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.dao.TweetDAO;
import br.com.caelum.twittelum_teste.dao.TwittelumDbHelper;
import br.com.caelum.twittelum_teste.modelo.Tweet;

public class FormActivity extends AppCompatActivity {

    private TwittelumDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.dbHelper = new TwittelumDbHelper(this);

        Button botao = findViewById(R.id.form_botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormActivity.this, "salvando..",Toast.LENGTH_SHORT).show();
                Log.i("DB", "salvando...");
                EditText campoTexto = findViewById(R.id.form_tweet);
                String tweetMessage = campoTexto.getText().toString();
                Tweet tweet = new Tweet();
                tweet.setContent(tweetMessage);
                TweetDAO dao = new TweetDAO(dbHelper);
                dao.save(tweet);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}
