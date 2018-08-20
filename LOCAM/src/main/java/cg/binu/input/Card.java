package cg.binu.input;

public class Card {
    private final int number;
    private int instanceId;
    private final int location;
    private final CardType type;
    private final int cost;
    private final int attack;
    private final int defense;
    private final String abilities;
    private final int myHealthChange;
    private final int opponentHealthChange;
    private final int cardDraw;
    private int health;
    private int damage;

    public Card(
            int number,
            int instanceId,
            int location,
            CardType type,
            int cost,
            int attack,
            int defense,
            String abilities,
            int myHealthChange,
            int opponentHealthChange,
            int cardDraw
    ) {
        this.number = number;
        this.instanceId = instanceId;
        this.location = location;
        this.type = type;
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
        this.abilities = abilities;
        this.myHealthChange = myHealthChange;
        this.opponentHealthChange = opponentHealthChange;
        this.cardDraw = cardDraw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (number != card.number) return false;
        if (instanceId != card.instanceId) return false;
        return location == card.location;

    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + instanceId;
        result = 31 * result + location;
        return result;
    }

    public int getCost() {
        return cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public int getLocation() {
        return location;
    }

    public String getAbilities() {
        return abilities;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
