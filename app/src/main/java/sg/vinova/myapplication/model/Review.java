package sg.vinova.myapplication.model;
/* *
 *  Created by JAY on 21/06/2018
 */

public class Review {
    private String userName;
    private String avatar;
    private String comment;
    private String date;
    private int rating;

    public Review(String userName, String avatar, String comment, String date, int rating) {
        this.userName = userName;
        this.avatar = avatar;
        this.comment = comment;
        this.date = date;
        this.rating = rating;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
