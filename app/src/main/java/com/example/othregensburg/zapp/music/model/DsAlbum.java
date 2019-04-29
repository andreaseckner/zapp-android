package com.example.othregensburg.zapp.music.model;

public class DsAlbum {

    private String title;
    private String performer;
    private int resIdImage;
    private int backgroundColor;

    public DsAlbum(String title, String performer, int resIdImage) {
        this.title = title;
        this.performer = performer;
        this.resIdImage = resIdImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getResIdImage() {
        return resIdImage;
    }

    public void setResIdImage(int resIdImage) {
        this.resIdImage = resIdImage;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
