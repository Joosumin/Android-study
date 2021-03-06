package net.skhu.practice8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    String title;
    Date createTime;

    static SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

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
}
