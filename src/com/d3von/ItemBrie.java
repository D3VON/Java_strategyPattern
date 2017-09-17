package com.d3von;

public class ItemBrie extends Item {
    public ItemBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        // - "Aged Brie" actually increases in Quality the older it gets
        sellIn -= 1;

        // - The Quality of an item is never more than 50
        if(50>quality){
            quality += 1;
        }
    }

}
