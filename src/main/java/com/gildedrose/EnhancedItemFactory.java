package com.gildedrose;

/**
 * Factory class that creates enhanced items.
 *
 * @author Geoffrey Alfano
 * @since 21/06/2020
 */
public class EnhancedItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    /**
     * Creates an enhanced item.
     *
     * @param item The item data
     * @return An enhanced item
     */
    public EnhancedItem createEnhancedItem(Item item) {
        switch (item.name) {
            case AGED_BRIE: return new AgedBrieItem(item);
            case BACKSTAGE: return new BackstageItem(item);
            case SULFURAS: return new SulfurasItem(item);
            case CONJURED: return new ConjuredItem(item);
            default: return new OtherItem(item);
        }
    }
}
