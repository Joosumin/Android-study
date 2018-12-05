package net.skhu.a181204;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    ArrayList<Item> arrayList;
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
            Item

        }
    }
}
