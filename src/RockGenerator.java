import java.util.Random;
public class RockGenerator {



    public RockGenerator(){}

    /**
     * generates randomized rock within the range 10-30 that is spread out throughout the tiles
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     *
     */
    public void GenRock(Tile[][] lot) {
        Random rock = new Random();

        int rockCount = rock.nextInt(20) + 10;
        int temp;

        while (rockCount > 0) {
            for (int row = 0; row < 5; row++) {
                for (int column = 0; column < 10; column++) {
                    temp = rock.nextInt(4);

                    if (temp == 1 && lot[row][column].isDoesTileHaveRocks()== false && rockCount>0) {
                        lot[row][column].setTileStatus(TileStatus.HasRock);
                        rockCount = rockCount - 1;
                    }
                    else if(lot[row][column].getTileStatus() == null)
                        lot[row][column].setTileStatus(TileStatus.Unplowed);
                }

            }

        }
    }
}
