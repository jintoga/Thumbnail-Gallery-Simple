package com.example.dat.gallerytest;

import android.graphics.Bitmap;

/**
 * Created by DAT on 5/13/2015.
 */
public class ImageItem {
    private int imageID;
    private String title;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageItem(int imageID, String title) {

        this.imageID = imageID;
        this.title = title;
    }
}
