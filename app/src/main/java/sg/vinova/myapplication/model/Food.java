package sg.vinova.myapplication.model;
/* *
 *  Created by JAY on 20/06/2018
 */

import java.io.Serializable;

public class Food implements Serializable{
    private String name;
    private int rating;
    private String cover;
    private String avatar;
    private int likeNumber;
    private int buyNumber;

    public Food(String name, int rating, String cover, String avatar, int likeNumber, int buyNumber) {
        this.name = name;
        this.rating = rating;
        this.cover = cover;
        this.avatar = avatar;
        this.likeNumber = likeNumber;
        this.buyNumber = buyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }
}
