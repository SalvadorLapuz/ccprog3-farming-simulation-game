public class Farmer {

    private String farmerName;
    private FarmerType farmerType;

    private double objectCoins;
    private int farmerLevel;
    private int daysCount;
    private double experienceCount;
    private double currentExpCount;

    /**
     * initial amount of the player is capable to at the start of the game
     *
     * @param name gets the farmer/player's name
     */
    public Farmer(String name){
        this.farmerName = name;
        this.farmerType = new FarmerType("Farmer");
        this.objectCoins = 100;
        this.farmerLevel = 0;
        this.daysCount = 0;
        this.experienceCount = 0.0;
        this.currentExpCount = 0.0;
    }

    /** Getters **/
    /**
     *
     * @return the name of the farmer
     */
    public String getFarmerName() {
        return farmerName;
    }

    /**
     *
     * @return farmer's type together with its bonuses
     */
    public FarmerType getFarmerType() {
        return farmerType;
    }

    /**
     *
     * @return the money of the farmer
     */
    public double getObjectCoins() {
        return objectCoins;
    }

    /**
     *
     * @return farmer's level
     */

    public int getFarmerLevel() {
        return farmerLevel;
    }

    /**
     *
     * @return the count of the days
     */
    public int getDaysCount() {
        return daysCount;
    }

    /**
     *
     * @return temporary placeholder for the exp gained by the farmer
     */
    public double getCurrentExpCount() {
        return currentExpCount;
    }

    /** Setters **/

    /**
     *
     * @param objectCoins the games' gained or loss money
     */
    public void setObjectCoins(double objectCoins) {
        this.objectCoins = objectCoins;
    }

    /**
     *
     * @param advanceDay increments the day as it moves to
     *                   another day
     */
    public void setDaysCount(boolean advanceDay) {
        if(advanceDay == true){
            this.daysCount +=1;
        }
    }

    /**
     * updates the level and exp count of the farmer
     *
     * @param experienceAmt - exp gained by farming, harvesting, etc.
     */
    public void farmerLevelUp(double experienceAmt){
        this.experienceCount += experienceAmt;
        this.currentExpCount +=experienceAmt;

        if(this.currentExpCount >= 100){
            this.farmerLevel += 1;
            this.currentExpCount %= 100;

            System.out.printf("%n%45s%s%d", " ",
                    "Congratulations, you have advanced to the next level! Your level now is",
                    this.farmerLevel);
        }
    }

    /** Other Methods **/

    /**
     * checks if the farmer is eligible to register
     *
     * @param farmerLevel - level of the farmer
     */
    public void RegisterFarmer(int farmerLevel){

        double OC = getObjectCoins();
        double registrationFee = 0;
        String farmerType = "";

        if(farmerLevel < 5) {
            System.out.printf("%n%n%n%n%35s%s%n%n%n", " " +
                    "", "You haven't reached the level requirement for this category yet");
        }
        else if(farmerLevel > 4 && farmerLevel < 10) {
            registrationFee = 200;
            farmerType = "Registered Farmer";
        }
        else if (farmerLevel < 15) {
            registrationFee = 300;
            farmerType = "Distinguishable Farmer";
        }
        else {
            registrationFee = 400;
            farmerType = "Legendary Farmer";
        }


        if(getObjectCoins() >= registrationFee) {

            this.farmerType = new FarmerType(farmerType);
            this.objectCoins = OC - registrationFee;

            System.out.printf("%n%n%n%60s%s%n%60s%s%s%s%n%n", " ",
                    "         Congratulations!!", " ",
                    "You are now a ", getFarmerType().getFarmerType(), "!");
        }
        else System.out.printf("%n%n%55s%s%n%n", " ", "You do not have enough ObjectCoins to register");
    }
}
