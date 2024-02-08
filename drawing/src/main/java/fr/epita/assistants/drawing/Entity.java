package fr.epita.assistants.drawing;

public abstract class Entity implements IDrawable {
    private long id;
    private long SEQUENCE = 0;

    public Entity(){
            SEQUENCE++;
            id = SEQUENCE;
    }

    public long getId() {
        return this.id;
    }

    public void draw(){}
}
