package net.skhu.a181204;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    List<Item> arrayList;
    int checkedItemCount = 0;

    class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view){
            super(view);
            this.textView1 = view.findViewById(R.id.textView1);
            this.textView2 = view.findViewById(R.id.textView2);
            this.checkBox = view.findViewById(R.id.checkBox);
            this.checkBox.setOnCheckedChangeListener(this);
        }

        public void setData(){
            Item item = arrayList.get(super.getAdapterPosition());
            this.textView1.setText(item.getTitle());
            this.textView2.setText(item.getCreateTimeFormatted());
            this.checkBox.setChecked(item.isChecked());
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Item item = arrayList.get(super.getAdapterPosition());
            item.setChecked(isChecked);
            if (isChecked) ++checkedItemCount; else --checkedItemCount;
            if(checkedItemCount <= 1)
                ((Activity)textView1.getContext()).invalidateOptionsMenu();
        }
    }

    public MyRecyclerViewAdapter(Context context, List<Item> arrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData();
    }
}
