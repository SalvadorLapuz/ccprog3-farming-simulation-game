public class FarmerType {

    private String farmerType;
    private int bonusEarnings;
    private int scReduction;
    private int waterBonusLimit;
    private int fertilizerBonusLimit;


    /**
     * bonuses that can be acquired by the farmer once it registered
     *
     * @param farmerType type of the farmer
     */
    public FarmerType(String farmerType)
    {
        this.farmerType = farmerType;
        setBonusEarnings(farmerType);
        setScReduction(farmerType);
        setWaterBonusLimit(farmerType);
        setFertilizerBonusLimit(farmerType);
    }



    /** Getters **/

    /**
     *
     * @return type of the farmer
     */

    public String getFarmerType() {
        return farmerType;
    }

    /**
     *
     * @return bonus from harvesting crops
     */
    public int getBonusEarnings() {
        return bonusEarnings;
    }

    /**
     *
     * @return reduced price of the seeds to be planted
     */
    public int getScReduction() {
        return scReduction;
    }

    /**
     *
     * @return bonus of an amount of water that can be capped and added
     * to the earnings of the farmer
     */
    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    /**
     *
     * @return bonus of an amount of fertilizer that can be capped and
     * added to the earnings of the farmer
     */
    public int getFertilizerBonusLimit() {
        return fertilizerBonusLimit;
    }









    /** Setters **/

    /**
     *
     * @param farmerType type of farmer based on its register status
     */
    public void setBonusEarnings(String farmerType) {
        switch (farmerType){
            case "Farmer":
                this.bonusEarnings = 0;
                break;
            case "Registered Farmer":
                this.bonusEarnings = 1;
                break;
            case "Distinguished Farmer":
                this.bonusEarnings = 2;
                break;
            case "Legendary Farmer":
                this.bonusEarnings = 4;
                break;

            default:
                this.bonusEarnings = 0;

        }

    }

    /**
     *
     * @param FarmerType type of farmer based on its register status
     */

    public void setScReduction(String FarmerType) {
        switch (farmerType){
            case "Farmer":
                this.scReduction = 0;
                break;
            case "Registered Farmer":
                this.scReduction = 1;
                break;
            case "Distinguished Farmer":
                this.scReduction = 2;
                break;
            case "Legendary Farmer":
                this.scReduction = 3;
                break;

            default:
                this.scReduction = 0;

        }
    }

    /**
     *
     * @param farmerType type of farmer based on its register status
     */
    public void setWaterBonusLimit(String farmerType) {
        switch (farmerType){
            case "Farmer":
                this.waterBonusLimit = 0;
            case "Registered Farmer":
                this.waterBonusLimit = 0;
            case "Distinguished Farmer":
                this.waterBonusLimit = 1;
            case "Legendary Farmer":
                this.waterBonusLimit = 2;

            default:
                this.waterBonusLimit = 0;
        }
    }

    /**
     *
     * @param farmerType type of the farmer based on its register status
     */
    public void setFertilizerBonusLimit(String farmerType) {

        switch (farmerType){
            case "Farmer":
                this.fertilizerBonusLimit = 0;
            case "Registered Farmer":
                this.fertilizerBonusLimit = 0;
            case "Distinguished Farmer":
                this.fertilizerBonusLimit = 0;
            case "Legendary Farmer":
                this.fertilizerBonusLimit = 1;

            default:
                this.fertilizerBonusLimit = 0;
        }
    }
}
