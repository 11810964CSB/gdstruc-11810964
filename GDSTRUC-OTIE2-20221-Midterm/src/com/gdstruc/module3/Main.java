package com.gdstruc.module3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CardStack playerDeck = new CardStack();
        CardStack playerHand = new CardStack();
        CardStack discardedCards = new CardStack();
        //System.out.println("stacks successfully made!");
        int totalTurns = 0;



        // 11810964: manually pushing a crapton of cards onto player deck for i am a hack

        Card goku = new Card("Goku");
        Card vegeta = new Card("Vegeta");
        Card broly = new Card("Broly");
        Card krillin = new Card("Krillin");
        Card jeffrey = new Card("Test Jeffrey I");
        Card gohan = new Card("Gohan");
        Card piccolo = new Card("Piccolo");
        Card tien = new Card("Tien");
        Card roshi = new Card("Master Roshi");
        Card frieza = new Card("Frieza");
        Card jeffreyii = new Card("Test Jeffrey II");
        Card jeffreyiii = new Card("Test Jeffrey III");


        playerDeck.push(goku);
        playerDeck.push(vegeta);
        playerDeck.push(broly);
        playerDeck.push(krillin);
        playerDeck.push(jeffrey);
        playerDeck.push(gohan);
        playerDeck.push(piccolo);
        playerDeck.push(tien);
        playerDeck.push(roshi);
        playerDeck.push(frieza);
        // and we repeat 2 times for 30 cards
        playerDeck.push(goku);
        playerDeck.push(vegeta);
        playerDeck.push(broly);
        playerDeck.push(krillin);
        playerDeck.push(jeffreyii);
        playerDeck.push(gohan);
        playerDeck.push(piccolo);
        playerDeck.push(tien);
        playerDeck.push(roshi);
        playerDeck.push(frieza);
        // take it back now ya'll
        playerDeck.push(goku);
        playerDeck.push(vegeta);
        playerDeck.push(broly);
        playerDeck.push(krillin);
        playerDeck.push(jeffreyiii);
        playerDeck.push(gohan);
        playerDeck.push(piccolo);
        playerDeck.push(tien);
        playerDeck.push(roshi);
        playerDeck.push(frieza);
        // cha cha real smooth

        // 11810964 GAME STARTS HERE

        while (playerDeck.isEmpty()==false)
        {
            // 11810964: randbetween does not exist in java?!
            Random random = new Random();
            int randLimitChoice = 3;
            int randLimitNumber = 5;
            int roundChoice = random.nextInt(randLimitChoice);
            int randValue = (random.nextInt(randLimitNumber) + 1);

            ++totalTurns;
            System.out.println("ROUND "+totalTurns+" START...");

            if(roundChoice == 0) // WORKING: From deck to hand.
            {
                System.out.println("BAZINGA! DRAWING "  + randValue + " CARDS FROM DECK");
                for (int i = 0; i < randValue; i++)
                {
                    if (playerDeck.isEmpty())
                    {
                        System.out.println("OH! THE DECK IS EMPTY. WE'RE DONE HERE.");
                        break;
                    }
                    else
                    {
                        System.out.println("DREW A CARD FROM DECK!");
                        playerHand.push(playerDeck.peek());
                        playerDeck.pop();
                    }
                }
            }
            else if(roundChoice == 1) // WORKING: From hand to discard.
            {
                System.out.println("ZOOP ZOW! DISCARDING " + randValue + " CARDS FROM HAND");
                for (int i = 0; i < randValue; i++)
                {
                    if (playerHand.isEmpty())
                    {
                        System.out.println("OOPS! YOU CANNOT DISCARD FROM AN EMPTY HAND.");
                        ++totalTurns;
                        break;
                    }
                    else
                    {
                        System.out.println("DISCARDED A CARD FROM HAND!");
                        discardedCards.push(playerHand.peek());
                        playerHand.pop();
                    }
                }

            }
            else if(roundChoice == 2) // WORKING: From discard to Hand.
            {
                System.out.println("YEEPOW! GETTING " + randValue+ " CARDS FROM DISCARDED DECK");
                for (int i = 0; i < randValue; i++)
                {
                    if (discardedCards.isEmpty())
                    {
                        System.out.println("CANNOT GET CARDS FROM AN EMPTY DISCARD PILE!");
                        ++totalTurns;
                        break;
                    }
                    else
                    {
                        System.out.println("DREW A CARD FROM DISCARDS!");
                        playerHand.push(discardedCards.peek());
                        discardedCards.pop();
                    }
                }

            }

            // ROUND END NOTES
            System.out.println();
            System.out.println("Round " + totalTurns + " results...");
            System.out.println("Current Cards in hand: ");
            playerHand.printStack();
            System.out.println("Remaining cards in player deck: "+playerDeck.size());
            System.out.println("Cards discarded: "+discardedCards.size());
            System.out.println();
        }
        System.out.println();
        System.out.println("No more cards in the deck! It took "+ totalTurns +" rounds to complete.");
        System.out.println("Final amount of cards in hand: " + playerHand.size());
        System.out.println("Final amount of cards discarded: "+discardedCards.size());
    }
}