package fr.epita.assistants.war;

public class Soldier extends Combatant {
    protected int health_points;
    protected int damage_points;
    protected String scream;

    public void kill() {
        health_points = 0;
    }

    public Soldier() {
        this.health_points = 15;
        this.damage_points = 3;
        this.scream = "No pity for losers!";
    }
    void printState() {
        System.out.println("I have " + this.health_points + " health points.");
    }
    @Override
    void attack(Soldier s) {
        s.health_points -= this.damage_points;
    }

    @Override
    void attack(Vehicle v) {
        System.out.println("I can't fight this.");
    }

    @Override
    void scream() {
        System.out.println(this.scream);
    }
}
