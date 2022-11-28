package com.gdstruc.module2;

import java.util.LinkedList;
public class PlayerLinkedList {

    private PlayerNode head;

    // function to add a new player to the front of the linked list
    public void addToFront(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
    }

    // function to print the elements of the linked list
    public void printList() {
        System.out.print("HEAD -> ");
        PlayerNode current = head;

        while (current != null) {
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayer();
        }

        System.out.print(" NULL\n");
    }
    // 11810964: function to remove the first element via replacing it with the next player
    public void removeFirst() {
        PlayerNode current = head;
        System.out.println(current.getPlayer() + " has been removed!");
        head = head.getNextPlayer(); //omg what this works? maybe setNextPlayer is better but heck, it works
    }
    // 11810964: function to get the element size of the list via a modified printList() function
    public void getSize(){
        PlayerNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNextPlayer();
        }
        System.out.println("Size of Linked List: " + size);
    }

    public boolean contains(Player player){
        PlayerNode current = head;
        while (current != null) {
            if(player == current.getPlayer())
            {
                System.out.println("True");
                return true;
            }
            else
            {
                current = current.getNextPlayer();
            }
        }
        System.out.println("False");
        return false; // 11810964 : i get the feeling this isn't the proper way to do it
    }

    public boolean indexOf(Player player){
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if(player == current.getPlayer())
            {
                System.out.println(player.getName()+"'s "+ "Index: " +index);
                return true;
            }
            else
            {
                index++;
                current = current.getNextPlayer();
            }
        }
        System.out.println("no such player in index");
        return false; // 11810964 : i get the feeling this isn't the proper way to do it
    }

}
