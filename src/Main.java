import javax.tools.Tool;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board display = new Board();
        Tile[][] arrTile =  new Tile[5][10];
        RockGenerator rock = new RockGenerator();
        ListOfPlant plantList = new ListOfPlant();
        Tools tool = new Tools();
        Farmer farmer;
        boolean gameOver, cntr;
        int row = 0, column = 0;

        /** Initialize Array **/
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++) {
                arrTile[i][j] = new Tile();
            }
        }


        /** Getting the player's name **/
        System.out.printf("%40s%s", " ", "Please Enter Your Name: ");
        farmer = new Farmer(scan.nextLine());

        /**     Random Rock Generator    **/
        rock.GenRock(arrTile);
        /** initialize all plants' value base on the farmer's type **/
        plantList.CheckFarmerLevel(farmer);

        do {

            cntr = false;/**    indication if the player wants to change tile  **/

            display.BoardDisp(arrTile, farmer); /** display the whole farm land **/


            /** Getting the row and column of the chosen tile **/
            System.out.printf("%40s%s%n", " ", "Pick a Tile");
            System.out.printf("%40s%s", " ", "Enter Row: ");
                row = scan.nextInt();

            System.out.printf("%40s%s", " ", "Enter Column: ");
                column = scan.nextInt();

            do {

                /** Display the whole farmland **/
                display.BoardDisp(arrTile, farmer);

                cntr = checkTileStat(arrTile, (row - 1), (column - 1), plantList, cntr, farmer, tool);

                gameOver = isGameOver(arrTile, farmer, plantList);

            }while(!cntr);

        }while(gameOver == false);

        display.Divider();
        System.out.printf("%n%n%n%55s%s%n%n%n", " ", "GAME OVER");
        display.Divider();

    }

    /**
     * checks the Status of the tile and gets input from the user based on the status of tile
     *
     * @param lot - is the array of Tile
     * @param row - indicates the row of the chosen tile
     * @param col - indicates the column of the chosen tile
     * @param plant - contains all the list of Plants that can be planted
     * @param cntr - indicates if the player wants to switch tile
     * @param farmer - the farmer details
     * @param tool - the tool details
     * */

    public static boolean checkTileStat(Tile[][] lot, int row, int col, ListOfPlant plant, boolean cntr, Farmer farmer, Tools tool) {
        Scanner scan = new Scanner(System.in);
        String answer = "";

        /**
         * prints the limited choices of actions that the user is allowed to do
         * and only accepts what is in the choices
         **/


        /**     if the tile is plowed    **/
        if(lot[row][col].getTileStatus().equals(TileStatus.Plowed)){
            System.out.printf("%60s%s%n%n%35s%s%n", " ", "Land is Ready", " ", "Select an action: ");
            System.out.printf("%35s%s%n%35s%s%n", " ", "[P]lant crop", " ", "[S]hovel Crop");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day"," ", "[C]hange tile",
                    " ", "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer){
                case "A":
                case "a": AdvanceDay(lot, farmer);
                    cntr = true;
                    break;
                case "C":
                case "c": cntr = true;
                    break;
                case "L":
                case "l": farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                    break;
                case "P":
                case "p": BuySeed(lot, row, col, plant, farmer);
                    break;
                case "S":
                case "s": tool.Shovel(lot[row][col], farmer);
                    break;
                default:
                    System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /** if the tile has rock */
        else if(lot[row][col].getTileStatus().equals(TileStatus.HasRock)){
            System.out.printf("%55s%s%n%n%35s%s%n", " ", "ಥ_ಥ Land Has Rock ಥ_ಥ", " ", "Select an action: ");
            System.out.printf("%35s%s%n%35s%s%n", " ", "[R]emove rock using Pickaxe Tool", " ", "[S]hovel crop");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day"," ", "[C]hange tile", " ", "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer) {
                case "A", "a" -> {
                    AdvanceDay(lot, farmer);
                    cntr = true;
                }
                case "C", "c" -> cntr = true;
                case "L", "l" -> {farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                }
                case "R", "r" -> tool.PickAxe(lot[row][col], farmer);
                case "S", "s" -> {
                    tool.Shovel(lot[row][col], farmer);
                }
                default -> System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /**     if the tile has a crop      */
        else if (lot[row][col].getTileStatus().equals(TileStatus.HasActiveCrop)) {
            System.out.printf("%40s%s%d%15s%s%d%15s%s%d%n%n", " ", "Water: ", lot[row][col].getPlant().getCurrentWater(),
                    " ", "Fertilizer: ", lot[row][col].getPlant().getCurrentFertilizer(), " ",
                    "Day: ", lot[row][col].getPlant().getCurrentDay());
            System.out.printf("%60s%s%n%n%35s%s%n", " ", " Land Has Active Crop ", " ", "Select an action: ");
            System.out.printf("%35s%s%n%35s%s%n%35s%s%n", " ", "[F]ertilize Crop", " ", "[W]ater crop", " ", "[S]hovel crop");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day", " ", "[C]hange tile", " ", "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer) {
                case "A", "a" -> {
                    AdvanceDay(lot, farmer);
                    cntr = true;
                }
                case "C", "c" -> cntr = true;
                case "F", "f" -> tool.Fertilizer(lot,row,col, farmer);
                case "L", "l" ->{ farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                }
                case "S", "s" -> {
                    tool.Shovel(lot[row][col], farmer);
                }
                case "W", "w" -> tool.WateringCan(lot[row][col], farmer);
                default -> System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /** if the crop is ready to harvest in the tile  */
        else if(lot[row][col].getTileStatus().equals(TileStatus.ReadyToHarvest)){
            System.out.printf("%59s%s%n%n%35s%s%n", " ", "Crop is Ready to Harvest! ",
                    " ", "Select an action: ");
            System.out.printf("%35s%s%n%35s%s%n%35s%s%n%35s%s%n",  " ", "[F]ertilize tile"," ",
                    "[H]arvest crop", " ", "[W]ater crop", " ", "[S]hovel crop");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day"," ", "[C]hange tile",
                    " ", "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer) {
                case "A", "a" -> {
                    AdvanceDay(lot, farmer);
                    cntr = true;
                }
                case "C", "c" -> cntr = true;
                case "F", "f" -> tool.Fertilizer(lot,row,col, farmer);
                case "H", "h" -> HarvestTime(farmer, lot, row, col);
                case "L", "l" ->{ farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                }
                case "S", "s" -> {
                    tool.Shovel(lot[row][col], farmer);
                }
                case "W", "w" -> tool.WateringCan(lot[row][col], farmer);
                default -> System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /**  If the tile has withered crop   */
        else if (lot[row][col].getTileStatus().equals(TileStatus.HasWitheredCrop)){
            System.out.printf("%60s%s%n%n%35s%s%n", " ", " Crop Has Withered ", " ", "Select an action: ");
            System.out.printf("%35s%s%n",  " ", "[S]hovel crop");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day"," ", "[C]hange tile", " ",
                    "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer) {
                case "A", "a" -> {
                    AdvanceDay(lot, farmer);
                    cntr = true;
                }
                case "C", "c" -> cntr = true;
                case "L", "l" -> { farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                }
                case "S", "s" -> {
                    tool.Shovel(lot[row][col], farmer);
                }
                default -> System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /** If the tile is unplowed  */
        else if (lot[row][col].getTileStatus().equals(TileStatus.Unplowed)){
            System.out.printf("%60s%s%n%n%35s%s%n", " ", " Land is  Unplowed ", " ", "Select an action: ");
            System.out.printf("%35s%s%n%35s%s%n", " ", "[U]se Plowing Tool", " ", "[S]hovel crop");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day", " ", "[C]hange tile", " ", "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer){
                case "A":
                case "a": //AdvanceDay(lot, farmer);
                    cntr = true;
                    break;
                case "C":
                case "c": cntr = true;
                    break;
                case "L":
                case "l": farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                    break;
                case "S":
                case "s": tool.Shovel(lot[row][col], farmer);
                    break;
                case "U":
                case "u": tool.PlowingTool(lot[row][col], farmer);
                    break;
                default: System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /**     If the tile has a fruit tree crop planted beside it     **/
        else if(lot[row][col].getTileStatus().equals(TileStatus.Occupied)) {
            System.out.printf("%60s%s%n%n%60s%s%n", " ", "Land is Occupied", " ", "Please Change tile");
            System.out.printf("%n%n%35s%s%n%35s%s%n%35s%s", " ", "[A]dvance Day", " ", "[C]hange tile",
                    " ", "[L]evel up Farmer Status");
            System.out.printf("%n%n%35s%s", " ", "Enter option: ");
            answer = scan.nextLine();

            switch (answer){
                case "A":
                case "a": AdvanceDay(lot, farmer);
                    cntr = true;
                    break;
                case "C":
                case "c": cntr = true;
                    break;
                case "L":
                case "l": farmer.RegisterFarmer(farmer.getFarmerLevel());
                    plant.CheckFarmerLevel(farmer);
                    plant.setPlant(lot);
                    break;
                default: System.out.printf("%50s%s", " ", "Invalid Input");
            }
        }

        /**
         * false - if the player doesn't want to change tile
         * true - if the player wants to change tile
         * */

        return cntr;

    }

    /**
     * This function update the status of the tile as well as the plant in it
     *
     * @param lot - is the array of Tile
     * @param row - indicates the row of the chosen tile
     * @param col - indicates the column of the chosen tile
     * @param plant - contains all the list of Plants that can be planted
     * @param option - is the index of chosen crop to be planted
     **/
    public static boolean PlantSeed(Tile[][] lot, int row, int col, ListOfPlant plant, int option) {

        boolean isPlanted = true;
        if(!plant.getPlantbyIndex(option - 1).getCropType().equals("Fruit Tree")){
            lot[row][col].setPlant(plant.getPlantbyIndex(option - 1));
            lot[row][col].setTileStatus(TileStatus.HasActiveCrop);

        }
        else{
            if(lot[row-1][col-1].getTileStatus() == TileStatus.Plowed &&
                    lot[row][col-1].getTileStatus() == TileStatus.Plowed &&
                    lot[row + 1][col-1].getTileStatus() == TileStatus.Plowed &&
                    lot[row - 1][col].getTileStatus() == TileStatus.Plowed &&
                    lot[row + 1][col].getTileStatus() == TileStatus.Plowed &&
                    lot[row - 1][col + 1].getTileStatus() == TileStatus.Plowed &&
                    lot[row][col + 1].getTileStatus() == TileStatus.Plowed &&
                    lot[row + 1][col + 1].getTileStatus() == TileStatus.Plowed) {

                lot[row-1][col-1].setTileStatus(TileStatus.Occupied);
                lot[row][col-1].setTileStatus(TileStatus.Occupied);
                lot[row + 1][col-1].setTileStatus(TileStatus.Occupied);
                lot[row - 1][col].setTileStatus(TileStatus.Occupied);
                lot[row + 1][col].setTileStatus(TileStatus.Occupied);
                lot[row - 1][col + 1].setTileStatus(TileStatus.Occupied);
                lot[row][col + 1].setTileStatus(TileStatus.Occupied);
                lot[row + 1][col + 1].setTileStatus(TileStatus.Occupied);

                lot[row][col].setTileStatus(TileStatus.HasActiveCrop);

                lot[row][col].setPlant(plant.getPlantbyIndex(option - 1));
            }
            else {

                System.out.printf("%42s%s%n%30s%s", " ",
                        "You cannot plant the tree in this tile", " ",
                        "Please make sure all the tiles beside the planting spot are plowed");
                isPlanted = false;
            }

        }

        return isPlanted;

    }

    /**
     * This allows the user to buy seed and plant it
     *
     * @param plant - is the list of available seed/plant
     * @param row - indicates the row of the chosen tile
     * @param col - indicates the column of the chosen tile
     * @param  plant - is the list of seed/crop that can be planted
     * @param farmer - is the details of the farmer
     * */
    public static void BuySeed(Tile[][] lot, int row, int col, ListOfPlant plant, Farmer farmer) {
        Scanner scan = new Scanner(System.in);
        String answer;
        int option;
        boolean isPlanted = false;
        double objectCoins = farmer.getObjectCoins();

        System.out.printf("%n%n");

        plant.DispSeedMarket();

        System.out.printf("%n%n%20s%s", " ", "Enter your choice: ");
        option = scan.nextInt();


        if(objectCoins > plant.getPlantbyIndex(option - 1).getSeedCost()){
            System.out.printf("%n%n%15s%s%n%15s%s%n%10s%s%s%s", " ",  "[Y] - Yes", " ", "[N] - No",
                    " ", "Do you want to purchase ", plant.getPlantbyIndex(option - 1).getSeedName(), "? ");

            scan.nextLine();
            answer = scan.nextLine();
            if (answer.equals("Y") || answer.equals("y"))
                isPlanted = PlantSeed(lot, row, col, plant, option);

            if (isPlanted) {
                objectCoins = objectCoins - plant.getPlantbyIndex(option - 1).getSeedCost();
                farmer.setObjectCoins(objectCoins);

                System.out.printf("%n%n%n%55s%s%n%n%n", " ", " The seed has been planted ");
            }
        }

        else System.out.printf("%n%n%n%25s%s%n%n%n", " ", "Insufficient ObjectCoins!");


    }



    /**
     * This advances the time and updates the status of every tile
     *
     * @param lot - is the array of tiles
     * @param farmer - is the details of the farmer
     **/
    public static void AdvanceDay(Tile[][] lot, Farmer farmer) {

        farmer.setDaysCount(true);

        int currDay = 0;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                /*if the tile has active crop*/
                if (lot[row][col].getTileStatus().equals(TileStatus.HasActiveCrop)) {
                  // updates how many days the crop has been planted
                    lot[row][col].getPlant().setCurrentDay(lot[row][col].getPlant().getCurrentDay());
                    //if the harvest time is reached by the crop's day in the tile
                    if ((lot[row][col].getPlant().getHarvestTime()) == lot[row][col].getPlant().getCurrentDay()) {
                        //if water and fertilizer requirement is met
                        if (lot[row][col].getPlant().getCurrentWater() >= lot[row][col].getPlant().getWaterNeeded() &&
                                lot[row][col].getPlant().getCurrentFertilizer() >= lot[row][col].getPlant().getFertilizerNeeded()) {
                            //update tile status
                            lot[row][col].setTileStatus(TileStatus.ReadyToHarvest);
                        } else lot[row][col].setTileStatus(TileStatus.HasWitheredCrop);
                    }
                }
                else if (lot[row][col].getTileStatus().equals(TileStatus.ReadyToHarvest)) {
                    lot[row][col].setTileStatus(TileStatus.HasWitheredCrop);
                }
            }
        }
    }

    /**
     * This method harvest the crop, updates the tile status and farmer status
     *
     * @param farmer - the farmer details
     * @param lot - array of tile
     * @param row - the row of the chosen tile
     * @param col - the column of the chosen tile
     * */
    public static void HarvestTime(Farmer farmer, Tile[][] lot, int row, int col){

        farmer.farmerLevelUp((lot[row][col]).getPlant().getExpYield());
        double OC = farmer.getObjectCoins();

        System.out.printf("%n%n%55s%s%s%n", " ", lot[row][col].getPlant().getSeedName(),
                " is harvested successfully");
        System.out.printf("%35s%s%d%s%.2f%s%.2f%n", " ", "Products Produced: ",
                lot[row][col].getPlant().getProductsProduce(), "      ObjectCoins gained: ",
                FinalHarvestPrice(lot[row][col]), "       Exp gained: ",
                lot[row][col].getPlant().getExpYield());

        if(lot[row][col].getPlant().getCropType().equals("Fruit Tree")){
            lot[row-1][col-1].setTileStatus(TileStatus.Unplowed);
            lot[row][col-1].setTileStatus(TileStatus.Unplowed);
            lot[row + 1][col-1].setTileStatus(TileStatus.Unplowed);
            lot[row - 1][col].setTileStatus(TileStatus.Unplowed);
            lot[row + 1][col].setTileStatus(TileStatus.Unplowed);
            lot[row - 1][col + 1].setTileStatus(TileStatus.Unplowed);
            lot[row][col + 1].setTileStatus(TileStatus.Unplowed);
            lot[row + 1][col + 1].setTileStatus(TileStatus.Unplowed);
        }

        lot[row][col].setTileStatus(TileStatus.Unplowed);
        farmer.setObjectCoins(OC + FinalHarvestPrice((lot[row][col])));
        lot[row][col].getPlant().initializeDay(0);
        lot[row][col].getPlant().setCurrentFertilizer(0);
        lot[row][col].getPlant().setCurrentWater(0);


    }


    /**
     * This function computes for the harvest total
     *
     * @param  lot - a single tile with crop that is to be computed
     * @return the harvest total
     * */
    public static double HarvestTotal(Tile lot){

        return lot.getPlant().getProductsProduce() * lot.getPlant().getPricePerPiece();

    }

    /**
     * This function computes for the water bonus
     *
     * @param lot - a single tile with crop that is to be computed
     * @return the water bonus
     * */
    public static double WaterBonus(Tile lot){

        return HarvestTotal(lot) * 0.2 * (lot.getPlant().getWaterNeeded() - 1);
    }

    /**
     * This function computes for the fertilizer bonus
     *
     * @param lot - a single tile with crop that is to be computed
     * @return the fertilizer bonus
     * */
    public static double FertilizerBonus(Tile lot){

        return HarvestTotal(lot) * 0.5 * lot.getPlant().getFertilizerNeeded();
    }

    /**
     * This function computes for the final harvest price
     *
     * @param lot - a single tile with crop that is to be computed
     * @return the final harvest price        */
    public static double FinalHarvestPrice(Tile lot){
        return HarvestTotal(lot) + WaterBonus(lot) + FertilizerBonus(lot);
    }

    /**
     * This function checks if the game is over
     *
     * @param lot - array of tiles
     * @param farmer - farmer details
     * @param plant - list of seed in the market
    * */
    public static boolean isGameOver(Tile[][] lot, Farmer farmer, ListOfPlant plant){

        int cropCntr = 0, seedCntr = 0;
        boolean Over = false;

        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 10; col++){
                if(lot[row][col].getTileStatus() == TileStatus.HasActiveCrop ||
                        lot[row][col].getTileStatus() == TileStatus.ReadyToHarvest )
                    cropCntr++;
            }
        }

        for(int plantNum = 0; plantNum < 8; plantNum++){
            if(farmer.getObjectCoins() >= plant.getPlantbyIndex(plantNum).getSeedCost())
                seedCntr++;
        }

        if(seedCntr == 0 && cropCntr == 0)
            Over = true;

        return Over;
    }
}
