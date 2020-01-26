package com.Alex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Program that implements a playlist for songs. Songs from different albums can be added
 * to the playlist and will appear in the list in the order
 * they are added. It provides a menu to skip forward to the next song,
 * skip backwards to a previous song. Replay the current song,
 * list the songs in the playlist.
 * The application uses the notion of linked list to perform the operations mentioned above.
 */

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24

        play(playList);
    }

    public static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> listIterator = playList.listIterator();
        boolean quit = false;
        boolean forward = true;

        if(playList.size() == 0){
            System.out.println("No song in the playlist!");
        }else System.out.println("Now playing " + listIterator.next().toString());
        printMenu();
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("PlayList Complete!");
                    quit = true;
                case 1:
                    if(!forward){
                        if (listIterator.hasNext())
                            listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("Now playing " + listIterator.next().toString());
                    else {System.out.println("We reached the end of the playlist"); forward = false;}
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    else {
                        System.out.println("We reached the start of the playlist!");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious())
                            System.out.println("Replaying " + listIterator.previous().toString());
                        else {
                            System.out.println("We are at the start of the list!");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Replaying " + listIterator.next().toString());
                        }else
                            System.out.println("We are at the end of the playlist!");
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.isEmpty())
                        System.out.println("Empty playlist");
                    if (playList.size() > 0)
                        listIterator.remove();
                    if(listIterator.hasNext())
                        System.out.println("Now playing: " + listIterator.next().toString());
                    else if(listIterator.hasPrevious())
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \n");
        System.out.println("0 - To quit");
        System.out.println("1 - To play the next song");
        System.out.println("2 - To play the previous song");
        System.out.println("3 - To replay the current song");
        System.out.println("4 - To list all the songs");
        System.out.println("5 - To show the menu");
        System.out.println("6 - To remove a song");
    }

    private static void printList(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.isEmpty())
            System.out.println("Empty playlist!");
        System.out.println("\nPress:");

        while (listIterator.hasNext()){
            System.out.println(listIterator.next() + "\n");
        }
    }

}

