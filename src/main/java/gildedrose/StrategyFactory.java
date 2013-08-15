package gildedrose;


public class StrategyFactory {
    private static final StandardAgingStrategy standardAgingStrategy = new StandardAgingStrategy();
    private static final CheesyItemStrategy cheesyItemStrategy = new CheesyItemStrategy();
    private static final EventPassItemStrategy eventPassItemStrategy = new EventPassItemStrategy();
    private static final LegendaryItemStrategy legendaryItemStrategy = new LegendaryItemStrategy();

    private static boolean isCheesyItem(Item item) {
        if(item.getName().equals("Aged Brie")) return true;
        else return false;
    }

    private static boolean isEventPassItem(Item item) {
        if(item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) return true;
        else return false;
    }

    private static boolean isLegendaryItem(Item item) {
        if(item.getName().equals("Sulfuras, Hand of Ragnaros")) return true;
        else return false;
    }

    public static final ItemAgingStrategy getStrategy(Item item) {
        if(isCheesyItem(item)) return cheesyItemStrategy;
        if(isEventPassItem(item)) return eventPassItemStrategy;
        if(isLegendaryItem(item)) return legendaryItemStrategy;
        else return standardAgingStrategy;
    }




}
