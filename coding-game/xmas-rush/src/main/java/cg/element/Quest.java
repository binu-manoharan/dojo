package cg.element;

/**
 * Quest for a player to collect item
 */
public class Quest {
    String itemName;
    int playerId;

    public Quest(String itemName, int playerId) {
        this.itemName = itemName;
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "itemName='" + itemName + '\'' +
                ", playerId=" + playerId +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public int getPlayerId() {
        return playerId;
    }
}
