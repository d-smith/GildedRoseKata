package gildedrose;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class StrategyTests {
    @Test
    public void standardItemQualityDecreasesByOne() {
        Item myItem = new Item("plain item", 5, 2);
        getStrategyAndApplyPolicies(myItem);
        assertEquals(1, myItem.getQuality());
    }

    @Test
    public void standardItemSellInDecreasesByOne() {
        Item myItem = new Item("plain item", 5, 2);
        getStrategyAndApplyPolicies(myItem);
        assertEquals(4, myItem.getSellIn());
    }

    @Test
    public void cheesyItemQualityImprovesWithAge() {
        Item brie = new Item("Aged Brie", 5, 5);
        getStrategyAndApplyPolicies(brie);
        assertEquals(6, brie.getQuality());
    }

    @Test
    public void cheesyItemQualityIncreasesTwiceAsFastWhenPastSellByDate() {
        Item brie = new Item("Aged Brie", 0, 5);
        getStrategyAndApplyPolicies(brie);
        assertEquals(7, brie.getQuality());
    }

    private void getStrategyAndApplyPolicies(Item myItem) {
        ItemAgingStrategy agingStrategy = StrategyFactory.getStrategy(myItem);
        agingStrategy.adjustQuality(myItem);
        agingStrategy.adjustSellIn(myItem);
        agingStrategy.applyPastSellByDatePolicy(myItem);
    }


}
