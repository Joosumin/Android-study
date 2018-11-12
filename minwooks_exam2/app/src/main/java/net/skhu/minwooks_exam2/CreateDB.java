package net.skhu.minwooks_exam2;

import android.provider.BaseColumns;

public class CreateDB implements BaseColumns {
    public static final String _TABLENAME="Log";
    public static final String _CREATE=
            "create table " + _TABLENAME + "(" + "num" + " text primary key," + "content " + "text not null);";

}
