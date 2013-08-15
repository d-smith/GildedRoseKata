package gildedrose;


public class CheesyItemStrategy extends StandardAgingStrategy {
    @Override
    public void adjustQuality(Item item) {
        incrementQuality(item);
        enforceQualityBoundaryPolicies(item);
    }

    @Override
    public void applyPastSellByDatePolicy(Item item) {
        if(item.getSellIn() < 0) adjustQuality(item);
    }
}
