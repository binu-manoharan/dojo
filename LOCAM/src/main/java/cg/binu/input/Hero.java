package cg.binu.input;

/**
 * Class representing a player
 */
class Hero {
    private final int health;
    private final int mana;

    Hero(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    int getHealth() {
        return health;
    }

    int getMana() {
        return mana;
    }
}
