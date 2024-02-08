package fr.epita.assistants.drawing;

public class Rectangle extends Sharp{
    private int width;
    public Rectangle(int width, int length){
        super(length);
        this.width = width;
    }

    public void draw() {
        for (int x = 0; x < super.length; x++){
            for (int y = 0; y < this.width; y++){
                if (x == 0 || x == super.length - 1 || y == 0 || y == width - 1)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
