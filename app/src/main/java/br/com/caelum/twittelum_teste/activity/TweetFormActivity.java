package br.com.caelum.twittelum_teste.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.caelum.twittelum_teste.R;
import br.com.caelum.twittelum_teste.dao.TweetDAO;
import br.com.caelum.twittelum_teste.dto.FormHelper;

public class TweetFormActivity extends AppCompatActivity {

    private FormHelper formHelper;
    private TweetDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        formHelper = new FormHelper(this);
        dao = new TweetDAO(TweetFormActivity.this);

        Button botao = formHelper.getButton();
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (formHelper.isEmptyContent()) {
                    formHelper.showError();
                } else {
                    Toast.makeText(TweetFormActivity.this, "salvando..",Toast.LENGTH_SHORT).show();
                    dao.save(formHelper.getTweet());
                    finish();
                }
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
        dao.close();
        super.onDestroy();
    }
}
