package net.skhu.b201433040;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


public class B201433040Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b201433040);

        Button b = (Button) findViewById(R.id.button);
        View.OnClickListener listenerobj = new View.OnClickListener() {
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.editText);
                CharSequence s1 = e1.getText();

                EditText e2 = (EditText) findViewById(R.id.editText2);
                CharSequence s2 = e1.getText();

                e2.setText(s1);
                e1.setText("");
            }
        };
        b.setOnClickListener(listenerobj);
    }

}
