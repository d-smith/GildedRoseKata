package gildedrose;

public class EventPassItemStrategy extends StandardAgingStrategy {

    @Override
    public void adjustQuality(Item item) {
        incrementQuality(item);
        if (item.getSellIn() < 11) {
            incrementQuality(item);
        }

        if (item.getSellIn() < 6) {
            incrementQuality(item);
        }
        enforceQualityBoundaryPolicies(item);
    }

    @Override
    public void applyPastSellByDatePolicy(Item item) {
        if (item.getSellIn() < 0) item.setQuality(MIN_QUALITY);
    }
}
