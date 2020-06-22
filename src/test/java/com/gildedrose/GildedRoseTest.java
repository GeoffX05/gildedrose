package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";
    private static final String OTHER = "other";
    private static final int MAX_VALUE = 50;

    @Test
    void testAgedBrieSellInMinusOneQualityPlusOne() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testAgedBrieSellInMinusOneQualityMax() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, MAX_VALUE) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(MAX_VALUE, app.items[0].quality);
    }

    @Test
    void testAgedBrieSellInNegativeQualityPlusTwo() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testAgedBrieSellInNegativeQualityMax() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, MAX_VALUE) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(MAX_VALUE, app.items[0].quality);
    }

    @Test
    void testBackstageSellInMinusOneQualityPlusOne() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testBackstageSellInMinusOneQualityPlusTwo() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testBackstageSellInMinusOneQualityPlusThree() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void testBackstageSellInMinusOneQualityMax() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 15, MAX_VALUE),
                                    new Item(BACKSTAGE, 10, MAX_VALUE),
                                    new Item(BACKSTAGE, 10, MAX_VALUE - 1),
                                    new Item(BACKSTAGE, 5, MAX_VALUE),
                                    new Item(BACKSTAGE, 5, MAX_VALUE - 1),
                                    new Item(BACKSTAGE, 5, MAX_VALUE - 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(MAX_VALUE, app.items[0].quality);
        assertEquals(BACKSTAGE, app.items[1].name);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(MAX_VALUE, app.items[1].quality);
        assertEquals(BACKSTAGE, app.items[2].name);
        assertEquals(9, app.items[2].sellIn);
        assertEquals(MAX_VALUE, app.items[2].quality);
        assertEquals(BACKSTAGE, app.items[3].name);
        assertEquals(4, app.items[3].sellIn);
        assertEquals(MAX_VALUE, app.items[3].quality);
        assertEquals(BACKSTAGE, app.items[4].name);
        assertEquals(4, app.items[4].sellIn);
        assertEquals(MAX_VALUE, app.items[4].quality);
        assertEquals(BACKSTAGE, app.items[5].name);
        assertEquals(4, app.items[5].sellIn);
        assertEquals(MAX_VALUE, app.items[5].quality);
    }

    @Test
    void testBackstageSellInNegativeQualityZero() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testSulfarSellInUnchangedQualityUnchanged() {
        Item[] items = new Item[] { new Item(SULFURAS, 10, 10),
                                    new Item(SULFURAS, 10, 0),
                                    new Item(SULFURAS, -1, 10),
                                    new Item(SULFURAS, -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(SULFURAS, app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
        assertEquals(SULFURAS, app.items[1].name);
        assertEquals(10, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(SULFURAS, app.items[2].name);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(10, app.items[2].quality);
        assertEquals(SULFURAS, app.items[3].name);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[3].quality);
    }

    @Test
    void testOtherSellInQualityMinusOne() {
        Item[] items = new Item[] { new Item(OTHER, 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(OTHER, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testOtherSellInMinusOneQualityMinusTwo() {
        Item[] items = new Item[] { new Item(OTHER, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(OTHER, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testOtherSellInMinusOneQualityZero() {
        Item[] items = new Item[] { new Item(OTHER, 10, 0),
                                    new Item(OTHER, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(OTHER, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(OTHER, app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void testConjuredSellInQualityMinusTwo() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testConjuredSellInMinusOneQualityMinusFour() {
        Item[] items = new Item[] { new Item(CONJURED, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void testConjuredSellInMinusOneQualityZero() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 0),
                                    new Item(CONJURED, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(CONJURED, app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }
}
