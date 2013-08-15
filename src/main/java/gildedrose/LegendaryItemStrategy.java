package gildedrose;


public class LegendaryItemStrategy extends StandardAgingStrategy {

    public static final int LEGENDARY_ITEM_QUALITY = 80;

    @Override
    public void adjustQuality(Item item) {
        item.setQuality(LEGENDARY_ITEM_QUALITY);
    }

    @Override
    public void adjustSellIn(Item item) {
        //Do nothing - never needs to be sold
    }

    @Override
    public void applyPastSellByDatePolicy(Item item) {
        //Nothing required
    }
}
