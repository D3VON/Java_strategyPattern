package com.d3von;

public class ItemRegular extends Item {
    public ItemRegular(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    public void updateQuality(){
        // - At the end of each day our system lowers both values for every item
        sellIn -= 1;

        //- The Quality of an item is never negative
        if(0<quality){// do nothing if already zero
            if(0<sellIn){
                quality -= 1;
            }else{
                // Once the sell by date has passed, Quality degrades twice as fast
                quality -= 2;
            }
        }
    }




}
