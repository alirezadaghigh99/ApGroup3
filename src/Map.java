public class Map {

    private Cell[][] cells = new Cell[Utils.mapSize][Utils.mapSize];

    public Map() {
        for (int i = 0; i < Utils.mapSize ; i++) {
            for (int j = 0; j < Utils.mapSize ; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
}
