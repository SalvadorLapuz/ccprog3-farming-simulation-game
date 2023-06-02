public class Tools {
    /**
     * Can plow a tile once tile status is plowed
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     * @param farmer represents the status of player for the whole game
     */

    public void PlowingTool(Tile lot, Farmer farmer){
        lot.setTileStatus(TileStatus.Plowed);
        farmer.farmerLevelUp(0.5);
    }

    /**
     * Can water a tile once it is planted
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     * @param farmer represents the status of player for the whole game
     */

    public void WateringCan(Tile lot, Farmer farmer){
        int quan = lot.getPlant().getCurrentWater();
        quan++;
        lot.getPlant().setCurrentWater(quan);

        farmer.farmerLevelUp(0.5);
    }

    /**
     * Can fertilize a tile once it is planted
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     * @param farmer represents the status of player for the whole game
     */

    public void Fertilizer(Tile[][] lot, int row, int col, Farmer farmer){

        if(farmer.getObjectCoins() >= 50) {
            double money = farmer.getObjectCoins() - 10;
            farmer.setObjectCoins(money);

            int quan = lot[row][col].getPlant().getCurrentFertilizer();
            quan++;
            lot[row][col].getPlant().setCurrentFertilizer(quan);

            farmer.farmerLevelUp(4);
            System.out.println("Current Water: " + quan);
        }
        else{
            System.out.printf("%45s%s", " ",
                    "You do not have enough ObjectCoins to complete this action");

        }
    }
    /**
     * Can use pickaxe on a tile that has rocks
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     * @param farmer represents the status of player for the whole game
     */
    public void PickAxe(Tile lot, Farmer farmer){

        if(farmer.getObjectCoins() >= 50) {
            double money = farmer.getObjectCoins() - 50;
            farmer.setObjectCoins(money);

            lot.setTileStatus(TileStatus.Unplowed);
            farmer.farmerLevelUp(15);

        }
        else {
            System.out.printf("%45s%s", " ",
                    "You do not have enough ObjectCoins to complete this action");

        }
    }
    /**
     * Can shovel anytime throughout the game
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     * @param farmer represents the status of player for the whole game
     */
    public void Shovel(Tile lot, Farmer farmer){

        if(farmer.getObjectCoins() >= 7) {
            double money = farmer.getObjectCoins() - 7;
            farmer.setObjectCoins(money);


            if (!lot.getTileStatus().equals(TileStatus.HasRock))
                lot.setTileStatus(TileStatus.Unplowed);

            farmer.farmerLevelUp(2);

            if (lot.getPlant() != null) {
                lot.getPlant().initializeDay(0);
                lot.getPlant().setCurrentFertilizer(0);
                lot.getPlant().setCurrentWater(0);
            }
        }

        else {
            System.out.printf("%45s%s", " ",
                    "You do not have enough ObjectCoins to complete this action");
        }

    }

}
