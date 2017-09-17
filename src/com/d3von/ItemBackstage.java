package com.d3von;

public class ItemBackstage extends Item {
    public ItemBackstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality(){

        sellIn -= 1;

        if(0 <= sellIn){// concert hasn't happened yet
            // - The Quality of an item is never more than 50
            if(50 > quality){
                // "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
                quality += 1;
                // Quality increases by 2 when there are 10 days or less
                if(11 > sellIn){
                    quality += 1;
                    // and by 3 when there are 5 days or less
                    if(6 > sellIn){
                        quality += 1;
                    }
                }
            }
            // a little guard in case quality gets above 50, which it can't.
            if (50 < quality) {
                quality = 50;
            }
        }else{
            // but Quality drops to 0 after the concert
            quality=0;
        }

    }


}
