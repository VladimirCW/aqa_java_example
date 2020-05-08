package main.java.objects.inheritance;

public class Horse extends Animal implements IAttackable{
    public Horse(String name) {
        super(name);
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}
