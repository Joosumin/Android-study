package net.skhu.e06list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDbService implements ChildEventListener {
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    ItemList itemList;
    DatabaseReference databaseReference;
    String userId;

    public FirebaseDbService(Context context, MyRecyclerViewAdapter myRecyclerViewAdapter, ItemList itemList, String userId){
        this.myRecyclerViewAdapter = myRecyclerViewAdapter;
        this.itemList = itemList;
        this.userId = userId;
        databaseReference = FirebaseDatabase.getInstance().getReference("myServerData02");
    }

    public void addIntoServer(Item item){
        String key = databaseReference.child(userId).push().getKey();
        databaseReference.child(userId).child(key).setValue(item);
    }

    public void removeFromServer(String key){
        databaseReference.child(userId).child(key).removeValue();
    }

    public void updateInServer(int index){
        String key = itemList.getKey(index);
        Item item = itemList.get(index);
        databaseReference.child(userId).child(key).setValue(item);
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        String key = dataSnapshot.getKey();
        Item item = dataSnapshot.getValue(Item.class);
        int index = itemList.add(key,item);
        myRecyclerViewAdapter.notifyItemInserted(index);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        String key = dataSnapshot.getKey();
        Item item = dataSnapshot.getValue(Item.class);
        int index = itemList.update(key, item);
        myRecyclerViewAdapter.notifyItemChanged(index);
    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
        String key = dataSnapshot.getKey();
        int index = itemList.remove(key);
        myRecyclerViewAdapter.notifyItemRemoved(index);
    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.e("Firebase Error", databaseError.getMessage());
    }

}
