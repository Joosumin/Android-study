package net.skhu.mw2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText_name);
        editText2 = findViewById(R.id.editText_password);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        final ListAdapter adapter = new ListAdapter(this);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText1.getText().toString();
                String password = editText2.getText().toString();
                if(id.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "이름과 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    String result = "이름: " + id + " " +  "비밀번호: " + password;
                    adapter.add(BitmapFactory.decodeResource(getResources(), android.R.mipmap.sym_def_app_icon), id, password, "2018.10.31" );
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}