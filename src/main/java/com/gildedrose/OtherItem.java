package com.gildedrose;

/**
 * An other item class.
 * Once the sell by date has passed, Quality degrades twice as fast
 * The Quality of an item is never negative
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public class OtherItem extends AbstractEnhancedItem {

    /**
     * Constructor to set the main properties
     *
     * @param item The item data
     */
    public OtherItem(Item item) {
        super(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (getSellIn() < 0) {
            decreaseQuality();
        }
        bottomUpQuality();
    }

}
