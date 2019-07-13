package com.example.userandadmin;

public class Model {

    private String title;
    private String description;
    private int like;
    private int dislike;
    private int type;
    private int thumbnail;

    public Model(String title, String description, int like, int dislike, int type, int thumbnail) {
        this.title = title;
        this.description = description;
        this.like = like;
        this.dislike = dislike;
        this.type = type;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
