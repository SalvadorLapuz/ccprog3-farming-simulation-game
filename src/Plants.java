public class Plants {


    public Plants(){}
    private String seedName;
    private String cropType;
    private int harvestTime;
    private int waterNeeded;
    private int fertilizerNeeded;

    private int productsProduce;
    private int seedCost;
    private double pricePerPiece;
    private double expYield;
    private int currentWater;
    private int currentFertilizer;

    private int currentDay;


    /** Getters **/

    /**
     *
     * @return name of the seed
     */
    public String getSeedName() {
        return seedName;
    }

    /**
     *
     * @return type of crop
     */

    public String getCropType() {
        return cropType;
    }

    /**
     *
     * @return time of the crop is available for harvesting
     */
    public int getHarvestTime() {
        return harvestTime;
    }

    /**
     *
     * @return water needed by a certain crop
     */
    public int getWaterNeeded() {
        return waterNeeded;
    }

    /**
     *
     * @return fertilizer needed by a certain crop
     */
    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    /**
     *
     * @return products produced once the crop is ready for harvest
     */

    public int getProductsProduce() {
        return productsProduce;
    }

    /**
     *
     * @return cost of the seed
     */
    public int getSeedCost() {
        return seedCost;
    }

    /**
     *
     * @return selling price of the crop
     */
    public double getPricePerPiece() {
        return pricePerPiece;
    }

    /**
     *
     * @return exp produced
     */
    public double getExpYield() {
        return expYield;
    }

    /**
     *
     * @return current water of the crop
     */
    public int getCurrentWater() {
        return currentWater;
    }

    /**
     *
     * @return current fertilizer of the crop
     */
    public int getCurrentFertilizer() {
        return currentFertilizer;
    }

    /**
     *
     * @return current day of the game
     */
    public int getCurrentDay() {
        return currentDay;
    }

    /** Setters **/

    /**
     *
     * @param seedName name of the seed
     */
    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    /**
     *
     * @param cropType type of the crop planted
     */
    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    /**
     *
     * @param harvestTime time of the crop available for harvest
     */
    public void setHarvestTime(int harvestTime) {
        this.harvestTime = harvestTime;
    }

    /**
     *
     * @param waterNeeded water needed for the crop
     */
    public void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }

    /**
     *
     * @param fertilizerNeeded fertilizer needed for the crop
     */
    public void setFertilizerNeeded(int fertilizerNeeded) {
        this.fertilizerNeeded = fertilizerNeeded;
    }

    /**
     *
     * @param productsProduce number of products produced by the crop
     */
    public void setProductsProduce(int productsProduce) {
        this.productsProduce = productsProduce;
    }

    /**
     *
     * @param seedCost cost of the seed
     */
    public void setSeedCost(int seedCost) {
        this.seedCost = seedCost;
    }

    /**
     *
     * @param pricePerPiece selling price of the crop per produce
     */
    public void setPricePerPiece(double pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    /**
     *
     * @param expYield exp produced by the farmer
     */
    public void setExpYield(double expYield) {
        this.expYield = expYield;
    }

    /**
     *
     * @param currentWater current water of a certain crop
     */
    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    /**
     *
     * @param currentFertilizer current fertilzer of a certain crop
     */
    public void setCurrentFertilizer(int currentFertilizer) {
        this.currentFertilizer = currentFertilizer;
    }

    /**
     *
     * @param currentDay current day of the game
     */


    public void setCurrentDay(int currentDay) {
        this.currentDay = 1 + currentDay;
    }

    /**
     *
     * @param firstDay day one of the game
     */
    public void initializeDay(int firstDay){
        this.currentDay = firstDay;
    }
}
