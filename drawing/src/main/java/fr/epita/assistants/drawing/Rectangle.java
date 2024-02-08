package fr.epita.assistants.drawing;

public class Rectangle extends Sharp {
    private int width;

    public Rectangle(int width, int length){
        super(length);
        this.width = width;
    }

    public void draw() {
        for (int w = 0; w < this.width; w++) {
            for (int h = 0; h < length; h++) {
                if (h == 0 || h == length - 1 || w == 0 || w == width - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
