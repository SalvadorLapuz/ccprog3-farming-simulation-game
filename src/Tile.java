public class Tile {
    private TileStatus tileStatus;
    private boolean doesTileHaveRocks;
    private Plants plant = new Plants();
    public Tile(){}

    /** Getters **/
    /**
     *
     * @return status of the tile
     */
    public TileStatus getTileStatus() {
        return tileStatus;
    }

    /**
     *
     * @return the status of the tile if it has rock
     */
    public boolean isDoesTileHaveRocks() {
        return doesTileHaveRocks;
    }

    /**
     *
     * @return plants' details
     */
    public Plants getPlant() {
        return plant;
    }

    /** Setters **/

    /**
     *
     * @param doesTileHaveRocks checks if the tile has rocks
     */
    public void setDoesTileHaveRocks(boolean doesTileHaveRocks) {
        this.doesTileHaveRocks = doesTileHaveRocks;
    }

    /**
     *
     * @param tileStatus status of the tile
     */
    public void setTileStatus(TileStatus tileStatus) {
        this.tileStatus = tileStatus;
    }

    /**
     *
     * @param plant details of the plants
     */

    public void setPlant(Plants plant){
        this.plant.setSeedName(plant.getSeedName());
        this.plant.setCropType(plant.getCropType());
        this.plant.setHarvestTime(plant.getHarvestTime());
        this.plant.setProductsProduce(plant.getProductsProduce());
        this.plant.setExpYield(plant.getExpYield());
        this.plant.setWaterNeeded(plant.getWaterNeeded());
        this.plant.setFertilizerNeeded(plant.getFertilizerNeeded());
        this.plant.setSeedCost(plant.getSeedCost());
        this.plant.setPricePerPiece(plant.getPricePerPiece());



    }
}
