package net.skhu.practice6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();
        arrayList.add("One");
        arrayList.add("Two");
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        Button b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argv0) {
                EditText e = (EditText)findViewById(R.id.editText);
                CharSequence s = e.getText();
                e.setText("");
                arrayList.add(s.toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
