/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author apple
 */
public class BlackJackGame {
    
    public static void main(String[] args) {
                
        System.out.println("Welcome to BlackJacK!");
        
        //Creating a game
        GroupOfCards cardsInDeck =  new GroupOfCards();
        cardsInDeck.createCard();
        cardsInDeck.shuffle();
        
        //Create a deck for player
         GroupOfCards playerDeck = new GroupOfCards();
         
         GroupOfCards dealerDeck = new GroupOfCards();

         double playerMoney = 100.00;
         
         Scanner userInput = new Scanner(System.in);
         
    //Loop
    while(playerMoney > 0){
        System.out.println("You still have $" + playerMoney + " How much money would you want to bet?");
         double playerBet = userInput.nextDouble();
         if(playerBet > playerMoney){
             System.out.println("This is a invalid amount!");
             break;
         }
         
         boolean endRound =false;
         
         playerDeck.draw(cardsInDeck);
         playerDeck.draw(cardsInDeck);
         
         dealerDeck.draw(cardsInDeck);
         dealerDeck.draw(cardsInDeck);
         
         while(true){ 
             System.out.println("\nYour hand:");
             System.out.println(playerDeck.toString());
             System.out.println("Your hand is valued at:" + playerDeck.cardsValue());
             
             //Display Dealer Hand
             System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]" );
             
             //Next step for player
             System.out.println("Would you like to (1)Hit or (2)Stand?");
             int response = userInput.nextInt();
             
             //if they choose the hit.
             if (response == 1 ){
                 playerDeck.draw(cardsInDeck);
                 System.out.println("You draw a:" + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                 //over 21
                 if(playerDeck.cardsValue() > 21){
                     System.out.println("Brust! Currently valued at:" + playerDeck.cardsValue());
                     playerMoney -= playerBet;
                     endRound = true;
                     break;
                }
            }
             //choose hold
             if (response == 2){
               break;  
             }    
        }
         
         // show dealer Cards
         System.out.println("Dealer Cards: " + "\n"+ dealerDeck.toString());
         if ((dealerDeck.cardsValue() > playerDeck.cardsValue())&& endRound == false){
             System.out.println("Dealer wins!");
             playerMoney -= playerBet;
             endRound = true;
         }
         
         while((dealerDeck.cardsValue() < 17)&& endRound == false){
             dealerDeck.draw(cardsInDeck);
             System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
         }
         System.out.println("Dealer's Hand is valued at:" + dealerDeck.cardsValue());
         
         if((dealerDeck.cardsValue() > 21)&& endRound == false){
             System.out.println("You win.");
             playerMoney += playerBet;
             endRound = true;
         }
         
         if((dealerDeck.cardsValue() == playerDeck.cardsValue())&& endRound == false){
             System.out.println("Push");
             endRound = true;
         }
         
         if((playerDeck.cardsValue() > dealerDeck.cardsValue())&& endRound == false){
             System.out.println("You win!");
             playerMoney += playerBet;
             endRound = true;
         }
         else if(endRound == false){
             System.out.println("You lose!");
             playerMoney -= playerBet;
             endRound = true;
         }
         playerDeck.moveAllCards(cardsInDeck);
         dealerDeck.moveAllCards(cardsInDeck);
         System.out.println("End of game");
    }
        System.out.println("Sorry ! You are out of money.");
    }
}
