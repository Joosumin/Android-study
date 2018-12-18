package net.skhu.testlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter myRecyclerViewAdapter;
    ItemList itemList;
    FirebaseDbService firebaseDbService;
    int selectedIndex;
    ItemEditDialogFragment itemEditDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ItemList();

        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, itemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecyclerViewAdapter);

        firebaseDbService = new FirebaseDbService(this, myRecyclerViewAdapter, itemList);

        Button b = (Button) findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText e = (EditText) findViewById(R.id.editText);
                String title = e.getText().toString();
                e.setText("");
                Item item = new Item(title);
                firebaseDbService.addIntoServer(item);
            }
        });
    }

    public void showItemEditDialog(int position){
        if (itemEditDialogFragment == null)
            itemEditDialogFragment = new ItemEditDialogFragment();
        selectedIndex = position;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_remove);
        menuItem.setVisible(myRecyclerViewAdapter.checkedItemCount > 0);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_remove) {
            for (int i = itemList.size() - 1; i >= 0; --i)
                if (itemList.get(i).isChecked()) {
                    String key = itemList.getKey(i);
                    firebaseDbService.removeFromServer(key);
                }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
