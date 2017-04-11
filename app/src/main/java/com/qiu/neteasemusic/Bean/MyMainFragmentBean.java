package com.qiu.neteasemusic.Bean;

import com.qiu.neteasemusic.Base.BaseBean;

/**
 * Created by qiu on 2017/4/11.
 */

public class MyMainFragmentBean extends BaseBean{
    private int itemType;
    private String ItemName,ItemNumName;
    private int itemIco;

    public String getItemNumName() {
        return ItemNumName;
    }

    public void setItemNumName(String itemNumName) {
        ItemNumName = itemNumName;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemIco() {
        return itemIco;
    }

    public void setItemIco(int itemIco) {
        this.itemIco = itemIco;
    }
}
