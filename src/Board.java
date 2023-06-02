public class Board {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACGROUND = "\u001B[43m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public Board(){}

    /**
     * displays the aesthetics of the board together with the representation of the board based on what is
     * planted and its corresponding statuses
     *
     * @param lot is a 10x5 array that represents the board of the entire game
     * @param farmer represents the status of player for the whole game
     */
    public void BoardDisp(Tile lot[][], Farmer farmer){
        int row, column;

        Divider();
        DisplayFarmerStats(farmer);
        Divider();

        System.out.printf("%n%n%65s%s%d", " ", "Day ", farmer.getDaysCount());
        System.out.printf("%n%n%40s", " ");
        for(column = 1; column <= 10; column++)
            System.out.printf("   %d  ", column);

        for(row = 0; row < 5; row++){

            System.out.printf("%n%40s%s%n%40d%s", " ",
                    "+-----------------------------------------------------------+", (row + 1), "|");
            for(column = 0; column < 10; column++){

                if(lot[row][column].getTileStatus().equals(TileStatus.Occupied)){
                    System.out.printf("%s     %s", ANSI_YELLOW_BACGROUND, ANSI_RESET);
                }
                else if(lot[row][column].getTileStatus().equals(TileStatus.HasRock)) {
                    System.out.printf("%s *** %s", ANSI_BLACK, ANSI_RESET);
                }
                else if(lot[row][column].getTileStatus().equals(TileStatus.Unplowed)) {
                    System.out.printf("%s ### %s", ANSI_GREEN, ANSI_RESET);
                }
                else if (lot[row][column].getTileStatus().equals(TileStatus.Plowed)) {
                    System.out.printf("%s     %s", ANSI_GREEN_BACKGROUND, ANSI_RESET);
                }
                else if (lot[row][column].getTileStatus().equals(TileStatus.HasWitheredCrop)) {
                    System.out.printf("%s  W  %s", ANSI_BLACK_BACKGROUND, ANSI_RESET);
                }
                else if (lot[row][column].getTileStatus().equals(TileStatus.HasActiveCrop) ||
                        lot[row][column].getTileStatus().equals(TileStatus.ReadyToHarvest)) {
                    if(lot[row][column].getPlant().getSeedName().equals("Turnip"))
                        System.out.printf("%s%s TTT %s", ANSI_PURPLE, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Carrot"))
                        System.out.printf("%s%s  C  %s", ANSI_RED, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Tomato"))
                        System.out.printf("%s%s  T  %s", ANSI_RED, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Rose"))
                        System.out.printf("%s%s  R  %s", ANSI_RED, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Tulips"))
                        System.out.printf("%s%s  T  %s", ANSI_WHITE, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Sunflower"))
                        System.out.printf("%s%s  S  %s", ANSI_YELLOW, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Mango"))
                        System.out.printf("%s%s  M  %s", ANSI_YELLOW, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    else if(lot[row][column].getPlant().getSeedName().equals("Apple"))
                        System.out.printf("%s%s  A  %s", ANSI_RED, ANSI_GREEN_BACKGROUND, ANSI_RESET);
                }
                System.out.printf("%s", "|");
            }
        }

        System.out.printf("%n%40s%s%n%n", " ",
                "+-----------------------------------------------------------+");
    }

    /**
     * divides the board
     */

    public void Divider(){

        System.out.printf("%n%n%s%s%s%n", "+-------------------------------------------------------",
                "--------------------------------------------------",
                "----------------------------------------------------------------------+");
    }

    /**
     * reports the status of the farmer throughout the game
     *
     * @param farmer represents the status of player for the whole game
     */
    public void DisplayFarmerStats(Farmer farmer){

        System.out.printf("%n%n%40s%s%s%10s%s%d", " ", "Farmer: ", farmer.getFarmerName(), " ", "Level: ", farmer.getFarmerLevel());
        System.out.printf("%8s%s%s%n%45s%s%.2f",  " ", "Farmer Type:",
                farmer.getFarmerType().getFarmerType(), " ", "ObjectCoins: ", farmer.getObjectCoins());

        System.out.printf("%10s%s%.2f", " ", "Exp: ", farmer.getCurrentExpCount());

    }


}
