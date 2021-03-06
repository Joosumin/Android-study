package net.skhu.practice8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView1, textView2;

        public ViewHolder(View view){
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            view.setOnClickListener(this);
        }

        public void setData(){
            Item item = arrayList.get(getAdapterPosition());
            textView1.setText(item.getTitle());
            textView2.setText(item.getCreateTimeFormatted());
        }

        public void onClick(View view){
            Item item = arrayList.get(super.getAdapterPosition());
            String s = String.format("index: %d,    title: %s", super.getAdapterPosition(), item.getTitle());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item> arrayList;

    public MyRecyclerViewAdapter(Context context, ArrayList<Item> arrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData();
    }
}
