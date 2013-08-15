package gildedrose;

import org.junit.Test;

import static gildedrose.GildedRose.updateItemQuality;
import static junit.framework.Assert.assertEquals;

public class GildedRoseTest {

	@Test
	public void SimpleItemsDegradeInQuality() {
        Item myItem = new Item("test item", 2, 2);
        updateItemQuality(myItem);
        assertEquals(1, myItem.getQuality());
    }

    @Test
    public void SimpleItemsSellInDecreases() {
        Item myItem = new Item("test item", 20, 20);
        updateItemQuality(myItem);
        assertEquals(19, myItem.getSellIn());
    }

    @Test
    public void QualityDegradesTwiceAsFastPastSellByDate() {
        Item myItem = new Item("test item", 0, 10);
        updateItemQuality(myItem);
        assertEquals(8, myItem.getQuality());
    }

    @Test
    public void QualityIsNeverNegative() {
        Item myItem = new Item("Test item", 0, 0);
        updateItemQuality(myItem);
        assertEquals(0, myItem.getQuality());
    }

    @Test
    public void AgedBrieIncreasesInQualityWithAge() {
        Item brie = new Item("Aged Brie", 10, 10);
        updateItemQuality(brie);
        assertEquals(11, brie.getQuality());
    }

    @Test
    public void AgedBrieQualityIncreasesTwiceAsFastPastSellByDate() {
        Item brie = new Item("Aged Brie", 0, 10);
        updateItemQuality(brie);
        assertEquals(12, brie.getQuality());
    }

    @Test
    public void QualityNeverSurpassesFifty() {
        Item brie = new Item("Aged Brie", 10, 50);
        updateItemQuality(brie);
        assertEquals(50, brie.getQuality());
    }

    @Test
    public void SulfurasNeverHasToBeSoldAndQualityAlwaysEighty() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 50, 50);
        updateItemQuality(sulfuras);
        assertEquals(80, sulfuras.getQuality());
        assertEquals(50, sulfuras.getSellIn());
    }

    @Test
    public void BackstagePassesHaveZeroQualityAfterConcert() {
        Item pass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        updateItemQuality(pass);
        assertEquals(0, pass.getQuality());
    }

    @Test
    public void BackStagePassQualityIncreasesByOneMoreThanTenDaysBeforeConcert() {
        Item pass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        updateItemQuality(pass);
        assertEquals(21, pass.getQuality());
    }

    @Test
    public void BackStagePassQualityIncreasesByTwoTenDaysOrLessBeforeConcert() {
        Item pass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        updateItemQuality(pass);
        assertEquals(22, pass.getQuality());
    }

    @Test
    public void BackStagePassQualityIncreasesByThreeFiveDaysOrLessBeforeConcert() {
        Item pass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        updateItemQuality(pass);
        assertEquals(23, pass.getQuality());
    }

}
