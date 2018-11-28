package net.skhu.e06list;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    List<String> keys = new ArrayList<String>();
    List<Item> items = new ArrayList<Item>();

    public Item get(int index){
        return items.get(index);
    }

    public String getKey(int index){
        return keys.get(index);
    }

    public int size(){
        return keys.size();
    }

    public int findIndex(String key){
        for(int i = 0; i< keys.size(); i++){
            if(keys.get(i).equals(key))
                return i;
            return -1;
        }
    }
}
