package net.skhu.practice7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }
    LayoutInflater layoutInflater;
    ArrayList<String> arrayList;

    public MyRecyclerViewAdapter(Context context, ArrayList<String> arrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    public int getItemCount(){
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int index){
        viewHolder.textView.setText(arrayList.get(index));
    }
}
