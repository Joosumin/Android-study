package net.skhu.minwooks_exam2;

import android.graphics.Bitmap;

public class kakao {
    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    private Bitmap image;

    public void setName(String name) { this.name = name; }

    String name;

    public kakao(Bitmap image, String name){
        this.image = image;
        this.name = name;
    }
}
