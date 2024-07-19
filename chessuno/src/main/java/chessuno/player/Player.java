package chessuno.player;

import chessuno.Color;

public class Player {

    private String name;

    private Color color;

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

}
