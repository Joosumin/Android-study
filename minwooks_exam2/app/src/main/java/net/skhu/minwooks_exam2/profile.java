package net.skhu.minwooks_exam2;

import android.graphics.Bitmap;

public class profile {
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

    String name;

    public profile(Bitmap image, String name){
        this.image = image;
        this.name = name;
    }
}
