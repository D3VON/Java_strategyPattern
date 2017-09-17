package com.d3von;

import java.util.ArrayList;
import java.util.List;

public class InnDriverOOP {

        public static void main(String args[]) {

            // refactored to Java
            List<Item> items = new ArrayList<Item>() {
                {
                    add(new Item("+5 Dexterity Vest", 10, 20));
                    add(new ItemBrie("Aged Brie", 2, 0));
                    add(new Item("Elixir of the Mongoose", 5, 7));
                    add(new ItemSulfuras("Sulfuras, Hand of Ragnaros", 0, 80));
                    add(new ItemBackstage("Backstage passes to a TAFKAL80ETC concert", 15, 20));
                    add(new ItemConjure("Conjured Mana Cake", 3, 6));
                }
            };

            ManageInventoryOOP mgr = new ManageInventoryOOP(items);
            /*************************************************************************************************************
             * Since UpdateQuality() updates all the inventory,
             * and simulates 66 days worth of updates,
             * the following code isolates each item so the output is human-readable.
             * That means for testing I have to recompile and run for each item.
             **************************************************************************************************************/
            // UNCOMMENT THESE ONE AT A TIME, RECOMPILE AND RUN TO TEST.
            int x =0;
//            int x =1;
//            int x =2;
//            int x =3;
//            int x =4;
//            int x =5;
            // updateQuality() does all items; just show the one we're testing
            for (int i = 0; i<=66; i++){

                System.out.print(items.get(x).getName());
                System.out.print(", " + items.get(x).getSellIn());
                System.out.println(", " + items.get(x).getQuality());
                mgr.UpdateQuality();
            }
        }
}
