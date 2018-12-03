package net.skhu.e06list;

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

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view){
            super(view);
            this.textView1 = view.findViewById(R.id.textView1);
            this.textView2 = view.findViewById(R.id.textView2);
            this.checkBox = view.findViewById(R.id.checkBox);
            this.checkBox.setOnCheckedChangeListener(this);
            view.setOnClickListener(this);
        }

        public void setData(){
            Item item = itemList.get(super.getAdapterPosition());
            this.textView1.setText(item.getTitle());
            this.textView2.setText(item.getCreateTimeFormatted());
            this.checkBox.setChecked(item.isChecked());
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            Item item = itemList.get(super.getAdapterPosition());
            item.setChecked(isChecked);
            if(isChecked) ++checkedItemCount; else --checkedItemCount;
            if(checkedItemCount <= 1)
                ((Activity)textView1.getContext()).invalidateOptionsMenu();
        }

        public void onClick(View view){
            MainActivity activity = (MainActivity)view.getContext();
            activity.showItemEditDialog(super.getAdapterPosition());
        }
    }

    LayoutInflater layoutInflater;
    ItemList itemList;
    int checkedItemCount = 0;

    public MyRecyclerViewAdapter(Context context, ItemList itemList){
        this.layoutInflater = LayoutInflater.from(context);
        this.itemList = itemList;
    }

    public int getItemCount(){
        return itemList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int index){
        viewHolder.setData();
    }
}
