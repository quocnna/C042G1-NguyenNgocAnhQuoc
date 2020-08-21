package _03_Arrays_Methods.Practices;

public class MineSweeper {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."},
                {".", ".", "*", ".", "."},
                {".", "*", ".", ".", "."}
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;
        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];
        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < map[0].length; xOrdinate++) {
                String curentCell = map[yOrdinate][xOrdinate];
                if (curentCell.equals("*")) {
                    mapReport[yOrdinate][xOrdinate] = "*";
                } else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {yOrdinate - 1, xOrdinate - 1}, {yOrdinate - 1, xOrdinate}, {yOrdinate - 1, xOrdinate + 1},
                            {yOrdinate, xOrdinate - 1}, {yOrdinate, xOrdinate + 1},
                            {yOrdinate + 1, xOrdinate - 1}, {yOrdinate + 1, xOrdinate}, {yOrdinate + 1, xOrdinate + 1},
                    };

                    int minesAround = 0;
                    for (int i = 0; i < NEIGHBOURS_ORDINATE.length; i++) {
                        int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[i];
                        int xOrdinateOfNeighbour = neighbourOrdinate[1];
                        int yOrdinateOfNeighbour = neighbourOrdinate[0];

                        boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0
                                || xOrdinateOfNeighbour == MAP_WIDTH
                                || yOrdinateOfNeighbour < 0
                                || yOrdinateOfNeighbour == MAP_HEIGHT;
                        if (isOutOfMapNeighbour) continue;

                        boolean isMineOwnerNeighbour = map[yOrdinateOfNeighbour][xOrdinateOfNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }
                    mapReport[yOrdinate][xOrdinate] = String.valueOf(minesAround);
                }
            }
        }
        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                String currentCellReport = mapReport[yOrdinate][xOrdinate];
                System.out.print(currentCellReport);
            }
            System.out.println();
        }
    }
}
