package net.games.snack.model;

public class Cell {
    private final int x;
    private final int y;
    private final CellType type;
    private final Integer id;

    public Cell(int x, int y, CellType type, Integer id) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellType getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }
}
