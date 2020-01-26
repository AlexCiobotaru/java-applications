package com.Alex;
import java.util.ArrayList;

public class CDCatalog {

    private String title;
    private ArrayList<CD> cdList;

    public CDCatalog(String title) {
        this.title = title;
        this.cdList = new ArrayList<>();
    }

    private int findCD(CD cd){
        return cdList.indexOf(cd);
    }

    private int findCD(String cdTitle){
        for(int i = 0; i < cdList.size(); i++){
            CD currentCD = this.cdList.get(i);

            if(currentCD.getTitle().equals(cdTitle))
                return i;

            if(currentCD.getTitle() == null){
                System.out.println("CD not found!");
            }

        }
        return -1;
    }

    public CD findByTitle(String cdTitle){
        for (int i = 0; i < cdList.size(); i++){
            CD cd = this.cdList.get(i);
                if (cd.getTitle() == null) {
                    System.out.println("CD not found!");
                    return null;
                }
                if (cd.getTitle().equals(cdTitle))
                    return cd;
        }
        return null;
    }

    public CD findByArtist(String artist){
        for (int i = 0; i < cdList.size(); i++){
            CD cd = this.cdList.get(i);
            if(cd.getArtist() == null){
                System.out.println("CD by " + cd.getArtist() + " not found!");
                return null;
            }
            if(cd.getArtist().equals(artist))
                return cd;
        }
        return null;
    }

    public void addCD(CD cd){

            if(findCD(cd.getTitle()) >= 0) {
                System.out.println("CD already exists in the catalog!");
                return;
            }else if(cd.getTitle().isBlank()){
                System.out.println("Title field is blank!");

            }else if(cd.getArtist().isBlank()){
            System.out.println("Artist field is blank!");
            return;
            }

            cdList.add(cd);
            System.out.println(cd.getTitle() + " by " + cd.getArtist() + " successfully added");

    }

    public void removeCD(String name){

        for(int i = 0; i < cdList.size();i++){
            CD currentCD = this.cdList.get(i);
            int foundPosition = findCD(currentCD.getTitle());
            if(foundPosition < 0){
                System.out.println(currentCD.getTitle() + " was not found");
            }

            if(currentCD.getTitle().equals(name)) {
                this.cdList.remove(currentCD);
                System.out.println(currentCD.getTitle() + " was successfully deleted!");
            }
        }

    }

    public void removeAllCD(){
        if(cdList.isEmpty())
            System.out.println("The CD Catalog is empty. Can't remove from an empty catalog.");
        if(cdList.removeAll(cdList)){
            System.out.println("All CDs have been deleted. The CD Catalog is now empty!");
        }
    }

    public CD getByIndex(int index){
        for (int i = 0; i < cdList.size(); i++){
            CD cd = this.cdList.get(i);
            if(cdList.indexOf(cd) == index)
                return cd;
        }
        return null;
    }

    public int getSize(){
        return cdList.size();
    }

    public void printCatalog(){
        if(cdList.isEmpty()){
            System.out.println("Empty Catalog!");
        }

        for (int i = 0; i < cdList.size(); i++)
            System.out.println((i+1) + "." + this.cdList.get(i).toString());
    }

}
