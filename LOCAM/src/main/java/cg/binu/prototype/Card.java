package cg.binu.prototype;

/**
 *
 */
public class Card {
    private final int cardNumber;
    private final int instanceId;
    private final int location;
    private final int cardType;
    private final int cost;
    private final int attack;
    private final int defense;
    private final String abilities;
    private final int myHealthChange;
    private final int opponentHealthChange;
    private final int cardDraw;

    public Card(int cardNumber, int instanceId, int location, int cardType, int cost, int attack, int defense, String abilities, int myHealthChange, int opponentHealthChange, int cardDraw) {
        this.cardNumber = cardNumber;
        this.instanceId = instanceId;
        this.location = location;
        this.cardType = cardType;
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

        if (cardNumber != card.cardNumber) return false;
        return instanceId == card.instanceId;

    }

    @Override
    public int hashCode() {
        int result = cardNumber;
        result = 31 * result + instanceId;
        return result;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public int getLocation() {
        return location;
    }

    public int getCardType() {
        return cardType;
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

    public String getAbilities() {
        return abilities;
    }

    public int getMyHealthChange() {
        return myHealthChange;
    }

    public int getOpponentHealthChange() {
        return opponentHealthChange;
    }

    public int getCardDraw() {
        return cardDraw;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", instanceId=" + instanceId +
                ", location=" + location +
                ", cardType=" + cardType +
                ", cost=" + cost +
                ", attack=" + attack +
                ", defense=" + defense +
                ", abilities='" + abilities + '\'' +
                ", myHealthChange=" + myHealthChange +
                ", opponentHealthChange=" + opponentHealthChange +
                ", cardDraw=" + cardDraw +
                '}';
    }
}
