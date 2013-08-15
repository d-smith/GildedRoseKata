package gildedrose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {


    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<Item> items = new ArrayList<Item>();

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE_PASS, 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
    }

    public static void updateQuality(List<Item> items) {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    public static void updateItemQuality(Item item) {
        ItemAgingStrategy agingStrategy = StrategyFactory.getStrategy(item);
        agingStrategy.adjustQuality(item);
        agingStrategy.adjustSellIn(item);
        agingStrategy.applyPastSellByDatePolicy(item);
    }

}