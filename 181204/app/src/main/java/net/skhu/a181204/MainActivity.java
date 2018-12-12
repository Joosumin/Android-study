package net.skhu.a181204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter myRecyclerViewAdapter;
    List<Item> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Item>();
        arrayList.add(new Item("One"));
        arrayList.add(new Item("Two"));

        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(myRecyclerViewAdapter);

        Button b = (Button) findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String s = editText.getText().toString();
                editText.setText("");
                arrayList.add(new Item(s));
                myRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_remove);
        menuItem.setVisible(myRecyclerViewAdapter.checkedItemCount > 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_remove) {
            for (int i = arrayList.size() - 1; i >= 0; --i)
                if (arrayList.get(i).isChecked())
                    arrayList.remove(i);
                myRecyclerViewAdapter.notifyDataSetChanged();
                return true;
            }
            return super.onOptionsItemSelected(item);
    }
}


