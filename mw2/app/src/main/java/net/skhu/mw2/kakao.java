package net.skhu.mw2;

import android.graphics.Bitmap;

public class kakao {
    private Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String name;
    private String title;
    private String message;

    public kakao(Bitmap image, String title, String name, String message ){
        this.image = image;
        this.message = message;
        this.name = name;
        this.title = title;
    }
}