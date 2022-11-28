package com.gdstruc.module5;

public class Main {
    public static void main(String[] args) {
        Player pikachu = new Player(25, "Pikachu", 1);
        Player celebi = new Player(251, "Celebi", 2);
        Player hitmonchan = new Player(107, "Hitmonchan", 3);
        Player mankey = new Player(56, "Mankey", 4);
        Player starmie = new Player(175, "Starmie", 4);

        SimpleHashtable hashtable = new SimpleHashtable();

        // add initial players
        hashtable.put(celebi.getUserName(), celebi);
        hashtable.put(mankey.getUserName(), mankey);
        hashtable.put(pikachu.getUserName(), pikachu);
        hashtable.put(hitmonchan.getUserName(), hitmonchan);
        hashtable.put(starmie.getUserName(), starmie);

        // print the contents of the hashtable
        //hashtable.printHashtable();

        // get a value based on a given key
        //System.out.println(hashtable.get("Mankey"));

        // 11810964: remove functions below

        hashtable.remove(mankey.getUserName(), mankey);
        hashtable.printHashtable();
        System.out.println("Mankey should be removed from above");

        // 11810964: mankey removed first, then celebi
        hashtable.remove(celebi.getUserName(), celebi);
        hashtable.printHashtable();
        System.out.println("Celebi should be removed from above");
    }
}