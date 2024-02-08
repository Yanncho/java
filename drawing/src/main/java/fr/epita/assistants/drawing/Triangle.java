package fr.epita.assistants.drawing;

public class Triangle extends Sharp{
    public Triangle(int length){
        super(length);
    }

    public void draw() {
        for (int x = 0; x < super.length; x++){
            for (int y = 0; y < super.length; y++){
                if (x == y || y == 0 || x == super.length-1)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
