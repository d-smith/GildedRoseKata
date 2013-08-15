package gildedrose;


public interface ItemAgingStrategy {
    void adjustQuality(Item item);
    void adjustSellIn(Item item);
    void applyPastSellByDatePolicy(Item item);
    void enforceQualityBoundaryPolicies(Item item);
}
