import java.util.Random;

public class ListOfPlant {


    private Plants listOfPlant[];

    /**
     * contains the requirements of crops and default amount of crop types
     * based on its needs (water, fertilizer, etc.)
     */
    public ListOfPlant(){
        listOfPlant = new Plants[9];
        Random rnd = new Random();

        for(int i = 0; i < 8; i++)
            listOfPlant[i] = new Plants();

        listOfPlant[0].setSeedName("Turnip");
        listOfPlant[0].setCropType("Root Crop");
        listOfPlant[0].setHarvestTime(2);
        listOfPlant[0].setProductsProduce(1+rnd.nextInt(1));
        listOfPlant[0].setExpYield(5.0);


        listOfPlant[1].setSeedName("Carrot");
        listOfPlant[1].setCropType("Root Crop");
        listOfPlant[1].setHarvestTime(3);
        listOfPlant[1].setProductsProduce(1+rnd.nextInt(1));
        listOfPlant[1].setExpYield(7.5);

        listOfPlant[2].setSeedName("Potato");
        listOfPlant[2].setCropType("Root Crop");
        listOfPlant[2].setHarvestTime(5);
        listOfPlant[2].setProductsProduce(1+rnd.nextInt(9));
        listOfPlant[2].setExpYield(12.5);

        listOfPlant[3].setSeedName("Rose");
        listOfPlant[3].setCropType("Flower");
        listOfPlant[3].setHarvestTime(1);
        listOfPlant[3].setProductsProduce(1);
        listOfPlant[3].setExpYield(2.5);

        listOfPlant[4].setSeedName("Tulips");
        listOfPlant[4].setCropType("Flower");
        listOfPlant[4].setHarvestTime(2);
        listOfPlant[4].setProductsProduce(1);
        listOfPlant[4].setExpYield(5.0);


        listOfPlant[5].setSeedName("Sunflower");
        listOfPlant[5].setCropType("Flower");
        listOfPlant[5].setHarvestTime(3);
        listOfPlant[5].setProductsProduce(1);
        listOfPlant[5].setExpYield(7.5);


        listOfPlant[6].setSeedName("Mango");
        listOfPlant[6].setCropType("Fruit Tree");
        listOfPlant[6].setHarvestTime(10);
        listOfPlant[6].setProductsProduce(5+rnd.nextInt(10));
        listOfPlant[6].setExpYield(25.0);


        listOfPlant[7].setSeedName("Apple");
        listOfPlant[7].setCropType("Fruit Tree");
        listOfPlant[7].setHarvestTime(10);
        listOfPlant[7].setProductsProduce(10+rnd.nextInt(5));
        listOfPlant[7].setExpYield(25.0);

    }

    /**
     *
     * @param index index of different plants
     * @return the index of the plants
     */

    public Plants getPlantbyIndex(int index){
        return listOfPlant[index];
    }

    /**
     * Displays seed inventory if the farmer decides to buy and plant a crop
     */

    public void DispSeedMarket() {
        System.out.printf("\nSeed Name:       Crop Type       Harvest Time (in days)      Water Needs      Fertilizer Needs   Products Produced    Seed Cost   Base Selling Price   Experience Yield    ");
        System.out.printf("\n[1] Turnip       Root Crop                2                      1(2)               0(1)                 1-2               5               6                  5            ");
        System.out.printf("\n[2] Carrot       Root Crop                3                      1(2)               0(1)                 1-2              10               9                 7.5           ");
        System.out.printf("\n[3] Potato       Root Crop                5                      3(4)               1(2)                 1-10             20               3                12.5           ");
        System.out.printf("\n[4] Rose           Flower                 1                      1(2)               0(1)                  1                5               5                 2.5           ");
        System.out.printf("\n[5] Tulips         Flower                 2                      2(3)               0(1)                  1               10               9                  5            ");
        System.out.printf("\n[6] Sunflower      Flower                 3                      2(3)               1(2)                  1               20               9                 7.5           ");
        System.out.printf("\n[7] Mango        Fruit Tree              10                      7(7)               4(4)                 5-15            100               8                  25           ");
        System.out.printf("\n[8] Apple        Fruit Tree              10                      7(7)               5(5)                10-15            200               5                  25           ");
    }

    /**
     * Initialize the water, fertilizer needed, seed cost, and price base on the farmer type
     *
     * @param farmer represents the status of player for the whole game
     */
    public void CheckFarmerLevel(Farmer farmer){

        listOfPlant[0].setWaterNeeded(1 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[0].setFertilizerNeeded(0 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[0].setSeedCost(5 - farmer.getFarmerType().getScReduction());
        listOfPlant[0].setPricePerPiece(6.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[1].setWaterNeeded(1 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[1].setFertilizerNeeded(0 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[1].setSeedCost(10 - farmer.getFarmerType().getScReduction());
        listOfPlant[1].setPricePerPiece(9.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[2].setWaterNeeded(3 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[2].setFertilizerNeeded(1 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[2].setSeedCost(20 - farmer.getFarmerType().getScReduction());
        listOfPlant[2].setPricePerPiece(3.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[3].setWaterNeeded(1 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[3].setFertilizerNeeded(0 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[3].setSeedCost(5 - farmer.getFarmerType().getScReduction());
        listOfPlant[3].setPricePerPiece(5.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[4].setWaterNeeded(2 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[4].setFertilizerNeeded(0 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[4].setSeedCost(10 - farmer.getFarmerType().getScReduction());
        listOfPlant[4].setPricePerPiece(9.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[5].setWaterNeeded(2 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[5].setFertilizerNeeded(1 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[5].setSeedCost(20 - farmer.getFarmerType().getScReduction());
        listOfPlant[5].setPricePerPiece(19.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[6].setWaterNeeded(7 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[6].setFertilizerNeeded(4 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[6].setSeedCost(100 - farmer.getFarmerType().getScReduction());
        listOfPlant[6].setPricePerPiece(8.0 + farmer.getFarmerType().getBonusEarnings());

        listOfPlant[7].setWaterNeeded(7 + farmer.getFarmerType().getWaterBonusLimit());
        listOfPlant[7].setFertilizerNeeded(5 + farmer.getFarmerType().getFertilizerBonusLimit());
        listOfPlant[7].setSeedCost(200 - farmer.getFarmerType().getScReduction());
        listOfPlant[7].setPricePerPiece(5.0 + farmer.getFarmerType().getBonusEarnings());

    }

    /**
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     *
     */
    public void setPlant(Tile[][] lot){
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 10; col++){
                if(lot[row][col].getTileStatus().equals(TileStatus.HasActiveCrop)){
                    for(int cntr = 0; cntr < 8; cntr++){
                        if(lot[row][col].getPlant().getSeedName().equals(listOfPlant[cntr].getSeedName())){
                            lot[row][col].getPlant().setWaterNeeded(listOfPlant[cntr].getWaterNeeded());
                            lot[row][col].getPlant().setFertilizerNeeded(listOfPlant[cntr].getFertilizerNeeded());
                            lot[row][col].getPlant().setSeedCost(listOfPlant[cntr].getSeedCost());
                            lot[row][col].getPlant().setPricePerPiece(listOfPlant[cntr].getPricePerPiece());
                        }
                    }
                }
            }
        }
    }
}
