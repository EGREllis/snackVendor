package net.games.snack.model;

public enum CellType {
    EMPTY,
    ROAD,
    HOUSE,
    RED,
    YELLOW,
    GREEN,
    BRIDGE;

    public CellType parseType(String text) {
        CellType result = null;
        switch (text.toUpperCase()) {
            case "EMPTY":
                result = EMPTY;
                break;
            case "ROAD":
                result = ROAD;
                break;
            case "HOUSE":
                result = HOUSE;
                break;
            case "RED":
                result = RED;
                break;
            case "YELLOW":
                result = YELLOW;
                break;
            case "GREEN":
                result = GREEN;
                break;
            case "BRIDGE":
                result = BRIDGE;
                break;
        }
        return result;
    }
}
