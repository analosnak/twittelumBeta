package br.com.caelum.twittelum_teste.modelo;

import java.time.LocalDateTime;

/**
 * Created by analosnak on 17/06/2018.
 */

public class Tweet {
    private String userPhotoPath;
    private String content;
    private LocalDateTime publishingDate;

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDateTime publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
