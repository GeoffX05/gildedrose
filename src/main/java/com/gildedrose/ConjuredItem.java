package com.gildedrose;

/**
 * Conjured item class.
 * Items degrade in Quality twice as fast as normal items.
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public class ConjuredItem extends AbstractEnhancedItem {

    /**
     * Constructor to set the main properties
     *
     * @param item The item data
     */
    public ConjuredItem(Item item) {
        super(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        decreaseQuality();
        decreaseQuality();
        decreaseSellIn();
        if (getSellIn() < 0) {
            decreaseQuality();
            decreaseQuality();
        }
        bottomUpQuality();
    }
}
