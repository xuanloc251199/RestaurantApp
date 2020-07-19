package com.example.restaurant_food_app.home.model;

public class Comment {
    int avtComment;
    String showNameCmt, contentCmt, timeCmt, likeCmt, replyCmt;

    public Comment(int avtComment, String showNameCmt, String contentCmt, String timeCmt, String likeCmt, String replyCmt) {
        this.avtComment = avtComment;
        this.showNameCmt = showNameCmt;
        this.contentCmt = contentCmt;
        this.timeCmt = timeCmt;
        this.likeCmt = likeCmt;
        this.replyCmt = replyCmt;
    }

    public int getAvtComment() {
        return avtComment;
    }

    public void setAvtComment(int avtComment) {
        this.avtComment = avtComment;
    }

    public String getShowNameCmt() {
        return showNameCmt;
    }

    public void setShowNameCmt(String showNameCmt) {
        this.showNameCmt = showNameCmt;
    }

    public String getContentCmt() {
        return contentCmt;
    }

    public void setContentCmt(String contentCmt) {
        this.contentCmt = contentCmt;
    }

    public String getTimeCmt() {
        return timeCmt;
    }

    public void setTimeCmt(String timeCmt) {
        this.timeCmt = timeCmt;
    }

    public String getLikeCmt() {
        return likeCmt;
    }

    public void setLikeCmt(String likeCmt) {
        this.likeCmt = likeCmt;
    }

    public String getReplyCmt() {
        return replyCmt;
    }

    public void setReplyCmt(String replyCmt) {
        this.replyCmt = replyCmt;
    }
}
