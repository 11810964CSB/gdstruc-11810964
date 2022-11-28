package com.gdstruc.module3;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

// wrapper class to limit the LinkedList class into Stack operations
public class CardStack {
    private LinkedList<Card> playerDeck;

    public CardStack() {
        playerDeck = new LinkedList<>();
    }

    public void push(Card card) {
        playerDeck.push(card);
    }

    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return playerDeck.pop();
    }

    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return playerDeck.peek();
    }

    public boolean isEmpty() {
        return playerDeck.isEmpty();
    }

    public int size(){
        return playerDeck.size();
    }
    public void printStack() {
        //System.out.println("Printing Stack: ");

        ListIterator<Card> iterator = playerDeck.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}