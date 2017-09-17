package com.d3von;

// properties refactored to Java
public class Item {
    protected String name;
    protected int sellIn;
    protected int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void updateQuality(){
        // - At the end of each day our system lowers both values for every item
        sellIn -= 1;

        //- The Quality of an item is never negative
        if(0 < quality){// do nothing if already zero
            quality -= 1;
            if(0 > sellIn){
                quality -= 1;
            }
        }

    }

}