package net.skhu.e06list;

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

    public void setTitle(String title) { this.title = title; }

    public String getTitle() {
        return title;
    }

    public void setCreateTimeFormatted(String s){
        try{
            this.createTime = format.parse(s);
        }catch (Exception e) {
        }
    }

    public Date getCreateTime(){
        return createTime;
    }

    public String getCreateTimeFormatted(){
        return format.format(createTime);
    }

    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }

    public String toString() {
        return String.format("(%s)", title);
    }
}