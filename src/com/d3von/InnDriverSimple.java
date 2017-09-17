package com.d3von;

import java.util.ArrayList;
import java.util.List;

public class InnDriverSimple {
    public static void main(String args[]) {

        // refactored to Java
        List<Item> items = new ArrayList<Item>() {
            {
                add(new Item("+5 Dexterity Vest", 10, 20));
                add(new Item("Aged Brie", 2, 0));
                add(new Item("Elixir of the Mongoose", 5, 7));
                add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
                add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
                add(new Item("Conjured Mana Cake", 3, 6));
            }
        };

        ManageInventorySimple mgrSimple = new ManageInventorySimple(items);
        /*************************************************************************************************************
         * Since UpdateQuality() updates all the inventory,
         * and simulates 66 days worth of updates,
         * the following code isolates each item so the output is human-readable.
         * That means for testing I have to recompile and run for each item.
         **************************************************************************************************************/
        // UNCOMMENT THESE ONE AT A TIME, RECOMPILE AND RUN TO TEST.
        int x =0; // +5 Dexterity Vest
//        int x =1; // Aged Brie
//        int x =2; // Elixir of the Mongoose
//        int x =3; // Sulfuras, Hand of Ragnaros
//        int x =4; // Backstage passes to a TAFKAL80ETC concert
//        int x =5; // Conjured Mana Cake
        // updateQuality() does all items; just show the one we're testing
        for (int i = 0; i<=66; i++){

            System.out.print(items.get(x).getName());
            System.out.print(", " + items.get(x).getSellIn());
            System.out.println(", " + items.get(x).getQuality());
            mgrSimple.UpdateQuality();
        }

    }




}
