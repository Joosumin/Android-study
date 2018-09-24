package net.skhu.practice2;

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

        Button b = (Button)findViewById(R.id.SwapButton);
        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v){
                EditText edit1 = (EditText)findViewById(R.id.EditText1);
                CharSequence s1 = edit1.getText();
                EditText edit2 = (EditText)findViewById(R.id.EditText2);
                CharSequence s2 = edit2.getText();

                edit1.setText(s2);
                edit2.setText(s1);
            }
        };
        b.setOnClickListener(listener);
    }
}
