package net.skhu.minwooks_exam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class qwe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Intent intent = getIntent();
        String s = intent.getStringExtra("name");
        TextView textView = (TextView)findViewById(R.id.confirm_title);
        textView.setText(s);
    }
}
