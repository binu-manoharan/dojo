package cg.binu.input;

public class Card {
    private final int number;
    private final String name;
    private final CardType type;
    private final int cost;
    private final int attack;
    private final int defense;
    private final String abilities;
    private final int myHealthChange;
    private final int opponentHealthChange;
    private final int cardDraw;

    public Card(
            int number,
            String name,
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
        this.name = name;
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

        return number == card.number;

    }

    @Override
    public int hashCode() {
        return number;
    }

    public String getName() {
        return name;
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
}
