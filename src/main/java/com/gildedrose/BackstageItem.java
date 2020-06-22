package com.gildedrose;

/**
 * Backstage item class.
 * It increases in Quality as its SellIn value approaches
 * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
 * Quality drops to 0 after the concert
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public class BackstageItem extends AbstractEnhancedItem {

    /**
     * Constructor to set the main properties
     *
     * @param item The item data
     */
    public BackstageItem(Item item) {
        super(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        decreaseSellIn();
        if (getSellIn() < 0) {
            setQuality(0);
        } else {
            increaseQuality();
            if (getSellIn() < 10) {
                increaseQuality();
            }
            if (getSellIn() < 5) {
                increaseQuality();
            }
            topOffQuality();
        }
    }
}
