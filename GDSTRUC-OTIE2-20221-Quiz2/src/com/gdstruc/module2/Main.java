package com.gdstruc.module2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // add players
        Player goku = new Player(1, "Goku", 9001);
        Player vegeta = new Player(2, "Vegeta", 9000);
        Player broly = new Player(3, "Broly", 20000);
        Player krillin = new Player(4, "Krillin", 1000);

        // add the players to a linked list
        PlayerLinkedList linkedList = new PlayerLinkedList();
        linkedList.addToFront(goku);
        linkedList.addToFront(vegeta);
        linkedList.addToFront(broly);

        // add one more player
        linkedList.addToFront(new Player(10, "Yamcha", 500));

        // print the elements of the starting from the head
        linkedList.printList();

        // 11810964: we send yamcha to HFIL via removing the first element
        linkedList.removeFirst();

        // 11810964: we check if yamcha has died and yes he has :D
        linkedList.printList();

        // 11810964: we check the element size of linked list, should be 3
        linkedList.getSize();

        // 11810964: revive yamcha using dragon balls
        linkedList.addToFront(new Player(10, "Yamcha", 500));
        System.out.println("Put Yamcha back in the list!");

        // 11810964: we check the element size of linked list, should be 4
        linkedList.getSize();

        // 11810964: now we look for goku, if all goes well we get a true
        linkedList.contains(goku);

        // 11810964: now we look for krillin who IS NOT on the linked list, if all goes well we get a false
        linkedList.contains(krillin);

        // 11810964: print the list one last time and now we get broly's index which is 1, and krillin who has no index
        linkedList.printList();
        linkedList.indexOf(broly);
        linkedList.indexOf(krillin);
    }
}