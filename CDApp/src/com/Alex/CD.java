package com.Alex;

public class CD {
    private String title;
    private Artist artist;

    public CD(String title, String artistName) {
        this.title = title;
        this.artist = new Artist(artistName);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist(){
        return this.artist.getName();
    }

    @Override
    public String toString() {
        return getTitle() + " by " + getArtist();
    }

    public static CD createCD(String title, String artistName){
        return new CD(title, artistName);
    }
}
