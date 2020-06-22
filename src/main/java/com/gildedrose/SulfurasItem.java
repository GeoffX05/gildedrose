package com.gildedrose;

/**
 * Sulfuras item class.
 * It's being a legendary item, never has to be sold or decreases in Quality
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public class SulfurasItem extends AbstractEnhancedItem {

    /**
     * Constructor to set the main properties
     *
     * @param item The item data
     */
    public SulfurasItem(Item item) {
        super(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        // Do nothing
    }
}
