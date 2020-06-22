package com.gildedrose;

/**
 * Aged Brie item class.
 * It increases in Quality the older it gets.
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public class AgedBrieItem extends AbstractEnhancedItem {

    /**
     * Constructor to set the main properties
     *
     * @param item The item data
     */
    public AgedBrieItem(Item item) {
        super(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if (getSellIn() < 0) {
            increaseQuality();
        }
        topOffQuality();
    }
}
