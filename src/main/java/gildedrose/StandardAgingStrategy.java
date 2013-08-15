package gildedrose;


public class StandardAgingStrategy implements ItemAgingStrategy {

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    protected void incrementQuality(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    protected void decrementQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    protected void decrementSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }


    @Override
    public void adjustQuality(Item item) {
        decrementQuality(item);
        enforceQualityBoundaryPolicies(item);
    }

    @Override
    public void adjustSellIn(Item item) {
        decrementSellIn(item);
    }

    @Override
    public void applyPastSellByDatePolicy(Item item) {
        if(item.getSellIn() < 0) adjustQuality(item);
    }

    @Override
    public void enforceQualityBoundaryPolicies(Item item) {
        if(item.getQuality() < MIN_QUALITY) item.setQuality(MIN_QUALITY);
        else if(item.getQuality() > MAX_QUALITY) item.setQuality(MAX_QUALITY);
    }
}
