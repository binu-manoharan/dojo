package cg.binu.input;

/**
 * Class representing a player
 */
public class Hero {
    private final int health;
    private final int mana;

    public Hero(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }
}
