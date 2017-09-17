package com.d3von;

import java.util.List;

public class ManageInventoryOOP {

        private List<Item> items;

        public ManageInventoryOOP(List<Item> items){
            this.items = items;
        }

        void UpdateQuality()
        {
            for (Item item : items) {
                item.updateQuality();
            }
        }
}
