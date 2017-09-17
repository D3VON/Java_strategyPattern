package com.d3von;
import java.util.List;

public class ManageInventory {

    public List<Item> items;

    public ManageInventory(List<Item> items){
        this.items = items;
    }

    void UpdateQuality()
    {
        //C#: for (var i = 0; i < Items.Count; i++)
        //for (int i = 0; i < items.size(); i++) {
        for (Item item : items)
        {
            /*************************
             *  SellIn ADJUSTMENTS
             *************************/
            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) // decrement all but sulfuras
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            /*************************
             *  Quality ADJUSTMENTS
             *************************/
            // all but brie or backstage
            if (!item.getName().equals("Aged Brie") && !item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                if (item.getQuality() > 0) // skip if already zero
                {
                    // just regular and Conjure
                    if (!item.getName().equals("Sulfuras, Hand of Ragnaros"))
                    {
                        item.setQuality(item.getQuality() - 1);// degrade regular
                        if (item.getName().equals("Conjured Mana Cake")){ // degrade twice as fast as regular
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                }
            } else
            // brie or backstage
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);

                    // only backstage
                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    } // done with backstage
                }
            }// done with brie and backstage


            /*************************
             *  Quality ADJUSTMENTS when SellIn is negative
             *  Once the sell by date has passed, Quality degrades twice as fast
             *  (make additional decrements)
             *************************/
            if (item.getSellIn() < 0)
            {
                if (!item.getName().equals("Aged Brie"))
                {
                    if (!item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (item.getQuality() > 0)
                        {
                            // adjust SellIn of regular and conjure
                            if (!item.getName().equals("Sulfuras, Hand of Ragnaros"))
                            {
                                item.setQuality(item.getQuality() - 1);
                                if (item.getName().equals("Conjured Mana Cake")){ // degrade twice as fast as regular
                                    item.setQuality(item.getQuality() - 1);
                                }
                            }
                        }
                    } else
                    {
                        item.setQuality(0); // Backstage passes now worthless
                    }
                }
            }
        }
    }
}