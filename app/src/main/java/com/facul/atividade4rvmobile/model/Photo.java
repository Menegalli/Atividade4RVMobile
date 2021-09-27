package com.facul.atividade4rvmobile.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Photo implements Parcelable {
    private int id;
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(int id, int albumId, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Photo(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.albumId = json.getInt("albumId");
            this.url = json.getString("url");
            this.title = json.getString("title");
            this.thumbnailUrl = json.getString("thumbnailUrl");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Photo(Parcel in) {
        id = in.readInt();
        albumId = in.readInt();
        title = in.readString();
        url = in.readString();
        thumbnailUrl = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @Override
    public String toString() {
        return "Id: "+id+"\n"+
                "Id Album: "+albumId+"\n"+
                "Título: " +title+"\n------------\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.albumId);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.thumbnailUrl);
    }
}
