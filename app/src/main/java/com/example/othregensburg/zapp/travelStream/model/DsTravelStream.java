package com.example.othregensburg.zapp.travelStream.model;

public class DsTravelStream {

    private String title;
    private String subtitle;
    private int resId;

    public DsTravelStream(String title, String subtitle, int resId) {
        this.title = title;
        this.subtitle = subtitle;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
