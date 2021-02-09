package com.example.coderspot;
import com.google.gson.annotations.SerializedName;
public class SONGS {
    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String imageUrl;

    public SONGS(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
