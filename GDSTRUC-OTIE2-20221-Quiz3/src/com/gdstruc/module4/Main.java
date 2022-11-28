package com.gdstruc.module4;

import java.util.Random;
import java.util.Scanner; // 11810964: what??? o_o

public class Main {

    public static void pressE() { // 11810964: scanners? huh
        // also for some reason it needs a double enter to continue, might just be a problem on my end
        Scanner scn= new Scanner(System.in);
        System.out.println("ENTER TO CONTINUE.");
        scn.nextLine();
    }

    public static void main(String[] args) {
        ArrayQueue playerQueue = new ArrayQueue(14); // where players wait for game
        ArrayQueue waitingPlayer = new ArrayQueue(14); // this is where players wait before ^ or when they are in match

        // 11810964: enqueue 14 playas
        waitingPlayer.enqueue(new Player(1, "Goku", 9001));
        waitingPlayer.enqueue(new Player(2, "Vegeta", 8000));
        waitingPlayer.enqueue(new Player(3, "Broly", 15000));
        waitingPlayer.enqueue(new Player(4, "Krillin", 800));
        waitingPlayer.enqueue(new Player(5, "Gohan", 8999));
        waitingPlayer.enqueue(new Player(6, "Test Jeffrey I", 1));
        waitingPlayer.enqueue(new Player(7, "Test Jeffrey II", 2));
        waitingPlayer.enqueue(new Player(8, "Piccolo", 8550));
        waitingPlayer.enqueue(new Player(9, "Zamasu", 0));
        waitingPlayer.enqueue(new Player(10, "Beerus", 0));
        waitingPlayer.enqueue(new Player(11, "Mr Popo", 15001));
        waitingPlayer.enqueue(new Player(12, "Arale", 15001));
        waitingPlayer.enqueue(new Player(13, "Some dude", 1));
        waitingPlayer.enqueue(new Player(14, "Test Jeffrey III", 3));

        // 11810964: GAME STARTS HERE

        int gameCount = 0;
        int turnCount = 1;

        while (gameCount < 10)
        {
            Random random = new Random();
            int randPlayers = 7;
            int randPlayersEnqueued = (random.nextInt(randPlayers)+1);

            System.out.println("TURN "+turnCount+" HAS STARTED ! ! !");

            if (playerQueue.size() >= 5)
            {
                System.out.println();
                System.out.println("FIVE PLAYERS HAVE BEEN REACHED ! ! ! SENDING THEM INTO HFIL ! ! !");
                for (int i = 0; i < 5; i++){
                    Player temp = playerQueue.peek();
                    playerQueue.dequeue(); //dequeue that five times
                    waitingPlayer.enqueue(temp);
                }
                gameCount++;
                System.out.println("RADICAL. WE NOW HAVE A TOTAL OF "+gameCount+" GAMES GOING ON.");
                System.out.println();
            }
            else
            {
                System.out.println("GETTING "+randPlayersEnqueued+" PLAYERS INTO THE QUEUE...");
            for (int i = 0; i < randPlayersEnqueued; i++){
                    Player temp = waitingPlayer.peek();
                    waitingPlayer.dequeue();
                    playerQueue.enqueue(temp);
            }
            }
            System.out.println("CURRENT PLAYERS IN QUEUE: ");
            playerQueue.printQueue();
            System.out.println("WE CURRENTLY HAVE "+playerQueue.size()+" PLAYERS IN THE QUEUE.");
            System.out.println("WE CURRENTLY HAVE "+gameCount+" GAMES GOING ON.");
            System.out.println();
            ++turnCount;
            pressE();
            System.out.println();
            System.out.println("ENTER BUTTON SUCCESSFULLY INPUTTED! NEXT TURN.");
            System.out.println();
        }
        System.out.println();
        System.out.println("PROGRAM ENDS HERE, 10 GAMES HAVE BEEN MADE.");
        System.out.println("IT TOOK "+turnCount+" TURNS TO FINISH ! ! !");
        System.out.println();
        //System.out.println(randPlayersEnqueued);
        }
    }
