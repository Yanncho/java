package fr.epita.assistants.staticpen;

public class Pen {
    public enum Color {
        RED,
        BLUE
    }

    public static int nbPen = 0;
    public static int nbRedPen = 0;
    public static int nbBluePen = 0;

    public Color color;

    public Pen(final Color color) {
        nbPen++;
        this.color = color;
        if (color == Color.RED)
            nbRedPen++;
        if (color == Color.BLUE)
            nbBluePen++;
    }

    public static int getRedPenCounter() {
        return nbRedPen;
    }

    public static int getPenCounter() {
        return nbPen;
    }

    public static int getBluePenCounter() {
        return nbBluePen;
    }

    public void changeColor(final Color color) {
        if (color == Color.RED && this.color == Color.BLUE) {
            nbRedPen++;
            nbBluePen--;
        }
        else if (color == Color.BLUE && this.color == Color.RED) {
            nbRedPen--;
            nbBluePen++;
        }
        this.color = color;
    }

    public static void resetCounts() {
        nbBluePen = 0;
        nbPen = 0;
        nbRedPen = 0;
    }

    public void print() {
        System.out.println("I'm a " + this.color + " pen.");
    }
}
