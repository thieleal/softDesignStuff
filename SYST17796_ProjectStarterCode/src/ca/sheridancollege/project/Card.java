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

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes
    public enum Suit{
        ClUB, DIAMOND, SPADE, HEART
    }
    
    public enum Value{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, KING, QUEEN, ACE
    } 
    
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.value = value;
        this.suit =suit;
    }
    
    public Value getValue(){
        return this.value;
    }
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    public String toString(){
        return this.suit.toString()+"-"+this.value.toString();
                
    }
}