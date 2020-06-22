package com.gildedrose;

/**
 * Abstract class to enhance the functionality of an item.
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public abstract class AbstractEnhancedItem implements EnhancedItem {

    private static final int MAX_VALUE = 50;
    private static final int MIN_VALUE = 0;

    private Item item;

    /**
     * Constructor to set the main properties
     *
     * @param item The item data
     */
    AbstractEnhancedItem(Item item) {
        this.item = item;
    }

    /**
     * Returns the quality of the item
     *
     * @return The quality
     */
    public int getQuality() {
        return item.quality;
    }

    /**
     * Sets the quality
     *
     * @param quality The quality
     */
    void setQuality(int quality) {
        item.quality = quality;
    }

    /**
     * Returns the sellIn of the item
     *
     * @return The sellIn
     */
    public int getSellIn() {
        return item.sellIn;
    }

    /**
     * Increases the quality of the item
     */
    void increaseQuality() {
        item.quality++;
    }

    /**
     * Decreases the quality of the item
     */
    void decreaseQuality() {
        item.quality--;
    }

    /**
     * Decreases the sellIn of the item
     */
    void decreaseSellIn() {
        item.sellIn--;
    }

    /**
     * If the quality gets bigger than it's MAX, set the quality to MAX
     */
    void topOffQuality() {
        if (getQuality() > MAX_VALUE) {
            setQuality(MAX_VALUE);
        }
    }

    /**
     * If the quality gets smaller than it's MIN, set the quality to MIN
     */
    void bottomUpQuality() {
        if (getQuality() < MIN_VALUE) {
            setQuality(MIN_VALUE);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void update();
}
