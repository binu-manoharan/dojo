package cg.tree;

import cg.board.Board;
import cg.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to find if there is a path connected
 */
public class PathHelper {
    public static boolean isConnected(Board board, int x, int y, int x1, int y1) {
        final ArrayList<Tile> connectedTiles = new ArrayList<>();
        addAllConnectedTiles(board, connectedTiles, x, y);
        return connectedTiles.contains(board.getTiles()[x1][y1]);
    }

    private static void addAllConnectedTiles(Board board, List<Tile> connectedTiles, int x, int y) {
        final Tile currentTile = board.getTiles()[x][y];
        if (!connectedTiles.contains(currentTile)) {
            connectedTiles.add(currentTile);
        }

        final List<Tile> connectedAdjacentTiles = board.getConnectedAdjacentTiles(x, y);
        for (Tile connectedAdjacentTile : connectedAdjacentTiles) {
            if (connectedTiles.contains(connectedAdjacentTile)) {
                return;
            }
            addAllConnectedTiles(board, connectedTiles, connectedAdjacentTile.getX(), connectedAdjacentTile.getY());
        }
    }
}
