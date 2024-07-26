package chessuno.player;

import java.util.ArrayList;

import chessuno.Color;
import chessuno.cards.Card;
import chessuno.chessPieces.ChessPiece;

public class Player {

    private String name;

    private Color color;

    private ArrayList<ChessPiece> chessPieces;

    private ArrayList<Card> cards;

    public Player(String name, Color color) {
        setName(name);
        setColor(color);
    }
    


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Color return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }


    /**
     * @return ArrayList<ChessPiece> return the chessPieces
     */
    public ArrayList<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    /**
     * @param chessPieces the chessPieces to set
     */
    public void setChessPieces(ArrayList<ChessPiece> chessPieces) {
        this.chessPieces = chessPieces;
    }

    /**
     * @return ArrayList<Card> return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @param cards the cards to set
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

}
