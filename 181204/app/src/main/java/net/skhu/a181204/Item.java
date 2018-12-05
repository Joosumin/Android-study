package net.skhu.a181204;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    String title;
    Date createTime;
    boolean checked;

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Item(){
    }

    public Item(String title){
        this.title = title;
        this.createTime = new Date();
    }

    public String getTitle(){
        return title;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public String getCreateTimeFormatted(){
        return format.format(createTime);
    }

    public boolean isChecked() {
        return checked;
    }

    public String toString(){
        return String.format("(%s)", title);
    }
}
