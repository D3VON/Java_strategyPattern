package com.d3von;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageInventorySimple {

    private List<Item> items;

    private static final Map<String, Integer> namesMap;


    static  // static initializer
    {
        namesMap = new HashMap<String, Integer>();
        namesMap.put("Aged Brie", 1);
        namesMap.put("Backstage passes to a TAFKAL80ETC concert", 2);
        namesMap.put("Sulfuras, Hand of Ragnaros", 3);
        namesMap.put("Conjured Mana Cake", 4);
    }   //Note: if not here, then it's a regular item, so no key/valure pair: test if keyExists

    public ManageInventorySimple(List<Item> items){
        this.items = items;
    }

    /**
     * @param item
     * @return int representing special type; if regular, then type is 0
     */
    private int categorize(Item item){
        if(namesMap.containsKey(item.getName())){
            return namesMap.get(item.getName());
        }
        else
        {
            return 0;
        }
    }


    void UpdateQuality()
    {
        //C#: for (var i = 0; i < Items.Count; i++)
        //for (int i = 0; i < items.size(); i++) {
        for (Item item : items) {
            switch (categorize(item)) {

                case 0: // regular item

                    // lower both values for every item
                    item.setSellIn(item.getSellIn() - 1);

                    //- The Quality of an item is never negative
                    if (0 < item.getQuality()) {// skip if already zero
                        item.setQuality(item.getQuality() - 1);
                        if (0 > item.sellIn) { // Once the sell by date has passed, Quality degrades twice as fast
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                    break;
                case 1: //Aged Brie
                    item.setSellIn(item.getSellIn() - 1);

                    // - "Aged Brie" actually increases in Quality the older it gets
                    // - The Quality of an item is never more than 50
                    if (50 > item.getQuality()) {
                        item.setQuality(item.getQuality() + 1);
                    }
                    break;
                case 2: //Backstage passes to a TAFKAL80ETC concert
                    item.setSellIn(item.getSellIn() - 1);

                    if (0 <= item.getSellIn()) {// concert hasn't happened yet
                        // - The Quality of an item is never more than 50
                        if (50 > item.getQuality()) {
                            // "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
                            item.setQuality(item.getQuality() + 1);
                            // Quality increases by 2 when there are 10 days or less
                            if (11 > item.getSellIn()) {
                                item.setQuality(item.getQuality() + 1);
                                // and by 3 when there are 5 days or less
                                if (6 > item.getSellIn()) {
                                    item.setQuality(item.getQuality() + 1);
                                }
                            }
                        }
                        // a little guard in case quality gets above 50, which it can't.
                        if (50 < item.getQuality()) {
                            item.setQuality(50);
                        }
                    } else {
                        // but Quality drops to 0 after the concert
                        item.setQuality(0);
                    }
                    break;
                case 3: //Sulfuras, Hand of Ragnaros
                    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                    //Just for clarification, an item can never have its Quality increase above 50,
                    // however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
                    break;
                case 4: //Conjured Mana Cake
                    item.setSellIn(item.getSellIn() - 1);

                    // "Conjured" items degrade in Quality twice as fast as normal items
                    //- The Quality of an item is never negative
                    if (0 < item.getQuality()) {// skip if quality already zero
                        item.setQuality(item.getQuality() - 2);
                        if (0 > item.sellIn) { // Once the sell by date has passed, Quality degrades twice as fast
                            item.setQuality(item.getQuality() - 4);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}