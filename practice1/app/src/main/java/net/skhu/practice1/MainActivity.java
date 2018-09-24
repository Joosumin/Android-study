package net.skhu.practice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.button);
        View.OnClickListener listenerObj = new View.OnclickListener(){
            @Override
            public void onClick(View v){
                EditText e = (EditText)findViewById(R.id.editText);
                CharSequence s = e.getText();
                TextView t = (TextView)findViewById(R.id.textView);
                t.setText(s);
            }
        };
        b.setOnClickListener(listenerObj);
    }
}
