package net.skhu.mw2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<kakao> {
    ArrayList<kakao> arrayList = new ArrayList<>();
    private final Activity context;
    public ListAdapter(Activity context) {
        super(context, R.layout.kakao);
        this.context = context;
    }
    public void add(Bitmap image, String t1, String t2, String t3){
        kakao kakao = new kakao(image,t1,t2,t3);
        arrayList.add(kakao);
    }
    public long getItemId(int position){
        return 0;
    }
    public int getCount(){
        return arrayList.size();
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            convertView = context.getLayoutInflater().inflate(R.layout.kakao, parent, false);

            holder = new ViewHolder();
            holder.icon = (ImageView)convertView.findViewById(R.id.image);
            holder.message = (TextView)convertView.findViewById(R.id.message);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.title = (TextView)convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
            holder.icon.setImageBitmap(arrayList.get(position).getImage());
            holder.message.setText(arrayList.get(position).getMessage());
            holder.name.setText(arrayList.get(position).getName());
            holder.title.setText(arrayList.get(position).getTitle());
        }
        return convertView;
    }

    static class ViewHolder{
        TextView name;
        TextView title;
        ImageView icon;
        TextView message;
    }
}
