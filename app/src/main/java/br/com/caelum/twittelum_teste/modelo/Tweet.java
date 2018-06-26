package br.com.caelum.twittelum_teste.modelo;

/**
 * Created by analosnak on 17/06/2018.
 */

public class Tweet {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
