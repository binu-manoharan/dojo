package cg.element;

/**
 * Item that needs to be collected for quests
 */
public class Item {
    int playerId;
    int x, y;
    String name;

    public Item(int playerId, int x, int y, String name) {
        this.playerId = playerId;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "playerId=" + playerId +
                ", x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
