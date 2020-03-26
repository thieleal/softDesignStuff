/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Modified by Team Card Game Team
 * Alex Thiele
 * Andre Arseneau
 * Xudong Su
 * Nguyen Quoc Thong
 * Feb 6 2020
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @modified Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    //private int size;//the size of the grouping

    public GroupOfCards() {
        this.cards = new ArrayList<Card>();
        //this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public void createCard(){
        //create a cards and store it into card
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Value value : Card.Value.values()){
                this.cards.add(new Card(suit, value));
            }
        }
    }
    
    
    //public ArrayList<Card> getCards() {
    //    return cards;
    //}

    public void shuffle() {
        ArrayList<Card> template = new ArrayList<Card>();
        Random random = new Random();
        int index = 0;
        int initalSize = this.cards.size();
        for(int i = 0; i < initalSize; i++){
            index = random.nextInt((this.cards.size()-1-0)+1)+0;
            template.add(this.cards.get(index));
            //Remove the original deck
            this.cards.remove(index); 
        }
         this.cards = template;
    }
    
    public void removeCard(int i){
        this.cards.remove(i);
    }
    
    public Card getCard(int i){
       return this.cards.get(i);
    }
    
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    
    public void draw(GroupOfCards deckCard){
        this.cards.add(deckCard.getCard(0));
        deckCard.removeCard(0);
    }
    
    //count total value of cards in deck
    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;
        
        for(Card aCard : this .cards){
         switch(aCard.getValue()){
             case TWO:  totalValue +=2;break;
             case THREE:  totalValue +=3;break;
             case FOUR:  totalValue +=4;break;
             case FIVE:  totalValue +=5;break;
             case SIX:  totalValue +=6;break;
             case SEVEN:  totalValue +=7;break;
             case EIGHT:  totalValue +=8;break;
             case NINE:  totalValue +=9;break;
             case TEN:  totalValue +=10;break;
             case JACK:  totalValue +=10;break;
             case QUEEN:  totalValue +=10;break;
             case KING:  totalValue +=10;break;
             case ACE:  aces +=1;break;         
         }   
        }
        for(int i=0; i< aces; i++){
        
            if(totalValue > 10){
                totalValue +=1;
            }
            else{
                totalValue +=11;
            }   
        
        }
        return totalValue;
    }
    
    public int deckSize(){
        return this.cards.size();
    }
    
    public void moveAllCards(GroupOfCards moveCards){
        int cardSize = this.cards.size();
        
        for(int i = 0; i < cardSize; i++){
            moveCards.addCard(this.getCard(i));
        }
        
        for(int i = 0; i < cardSize; i++){
            this.removeCard(0);
        }
        
        
    }
            
    public String toString(){
        String cardListOutput = "";
        for(Card aCard : this.cards){
            cardListOutput += aCard +"\n";
                 //   + "-" + aCard.toString();
          
    }
      return cardListOutput;  
    }
}//end class
