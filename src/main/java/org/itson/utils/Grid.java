
package org.itson.utils;

/**
 *
 * @author icedo
 */
public class Grid {
    private int wide;
    private int high;
    private Tile tiles[][];

    public Grid(int wide, int high, Tile[][] tiles) {
        this.wide = wide;
        this.high = high;
        this.tiles = tiles;

       
        for (int i = 0; i < wide; i++) {
            for (int j = 0; j < high; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }
}
    

