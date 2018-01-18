package allebdi.tourguide;

import java.io.Serializable;

/**
 * Created by fahd on picture1/14/18.
 */

public class Place implements Serializable {

    String name;
    String description;
    int picturePath;
    float rating;

    public Place() {
    }

    public Place(String name, String description, float rating, int imgPath) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.picturePath = imgPath;
    }

    public int getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(int picturePath) {
        this.picturePath = picturePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Place{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picturePath=" + picturePath +
                ", rating=" + rating +
                '}';
    }
}
