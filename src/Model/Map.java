package Model;

public class Map {

    private Cell[][] cells = new Cell[Utils.mapSize][Utils.mapSize];
    private static Map map = new Map();
    private Map() {
        for (int i = 0; i < Utils.mapSize ; i++) {
            for (int j = 0; j < Utils.mapSize ; j++) {
                cells[i][j] = new Cell();
            }
        }
        well = Well.getWell();
    }

    public static Map getMap() {
        return map;
    }

    public Cell[][] getCells() {
        return cells;
    }
   private Well well = Well.getWell();

    public Well getWell() {
        return well;
    }
}
