package fr.talabard.instalike.business;

import android.graphics.Bitmap;

/**
 * Created by jerem on 01/04/2017.
 */

public class PictureToshow {

    private Bitmap image;
    private Long id;
    private String title;
    private String description;

    public PictureToshow(Bitmap image, String title, String description,Long id) {
        this.image = image;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
