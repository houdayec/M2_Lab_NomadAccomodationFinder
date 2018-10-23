package com.universita.corsica.nomadaccomodationfinder.model;

import java.util.Date;

public class Comment {

    /**
     * INTERN STATE
     */
    public String id;
    public int note;
    public String content;
    public Date publishedDate;
    public User writer;

    /**
     * GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    /**
     * CONSTRUCTORS
     */
    public Comment(){

    }

    public Comment(String id, int note, String content) {
        this.id = id;
        this.note = note;
        this.content = content;
    }

    /**
     * OVERRIDED METHODS
     */
    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", note=" + note +
                ", content='" + content + '\'' +
                ", publishedDate=" + publishedDate +
                ", writer=" + writer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (note != comment.note) return false;
        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (publishedDate != null ? !publishedDate.equals(comment.publishedDate) : comment.publishedDate != null)
            return false;
        return writer != null ? writer.equals(comment.writer) : comment.writer == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + note;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (writer != null ? writer.hashCode() : 0);
        return result;
    }
}
