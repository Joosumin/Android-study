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

    public int getCheckedCount(){
        int count = 0;
        for (int i = 0; i < items.size(); ++i)
            if(items.get(i).isChecked())
                ++count;
        return count;
    }

    public int findIndex(String key){
        for(int i = 0; i< keys.size(); i++)
            if(keys.get(i).equals(key))
                return i;
            return -1;
    }

    public int remove(String key){
        int index = findIndex(key);
        keys.remove(index);
        items.remove(index);
        return index;
    }

    public int add(String key, Item item){
        keys.add(key);
        items.remove(item);
        return items.size() - 1;
    }

    public int update(String key, Item item){
        int index = findIndex(key);
        items.set(index, item);
        return index;
    }
}
