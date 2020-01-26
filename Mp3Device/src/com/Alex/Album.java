package com.Alex;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    private Song findSong(String songTitle){
        for (Song i : songs){
            if(i.getTitle().equals(songTitle))
                return i;
        }
        return null;
    }

    public boolean addSong(String songTitle, double duration){
        Song newSong = findSong(songTitle);
        if(newSong == null){
            this.songs.add(new Song(songTitle,duration));
            return true;
        }else System.out.println(newSong.getTitle() + " already exists!");
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playList){
        Song song = findSong(songTitle);
        if(song != null){
            playList.add(song);
            return true;
        }else { System.out.println("Song " + songTitle + " is already on file!");
                return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }


}
