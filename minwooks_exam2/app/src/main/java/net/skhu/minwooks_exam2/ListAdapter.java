package net.skhu.minwooks_exam2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<profile> {
    ArrayList<profile> arrayList = new ArrayList<>();
    private final Activity context;
    public ListAdapter(Activity context){
        super(context, R.layout.profile);
        this.context = context;
    }
    public void add(Bitmap image, String t1){
        profile profile = new profile(image,t1);
        arrayList.add(profile);
    }
    public long getItemId(int position){ return 0; }
    public int getCount() { return arrayList.size(); }
    public profile getItem(int position){
        return arrayList.get(position);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            convertView = context.getLayoutInflater().inflate(R.layout.profile, parent, false);

            holder = new ViewHolder();
            holder.icon = (ImageView)convertView.findViewById(R.id.image);
            holder.title = (TextView)convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
            holder.icon.setImageBitmap(arrayList.get(position).getImage());
            holder.title.setText(arrayList.get(position).getName());
        }
        return convertView;
    }

    static class ViewHolder{
        TextView title;
        ImageView icon;
    }
}