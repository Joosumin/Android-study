package net.skhu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button)findViewById(R.id.button_add);
        Button subButton = (Button)findViewById(R.id.button_sub);
        Button mulButton = (Button)findViewById(R.id.button_mul);
        Button divButton = (Button)findViewById(R.id.button_div);
        Toast.makeText(this,"숫자 2개를 입력해주세요.",Toast.LENGTH_LONG).show();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_num1 = (EditText)findViewById(R.id.editText_num1);
                int num1 = Integer.parseInt(editText_num1.getText().toString());
                EditText editText_num2 = (EditText)findViewById(R.id.editText_num2);
                int num2 = Integer.parseInt(editText_num2.getText().toString());
                TextView result = (TextView)findViewById(R.id.result);

                switch(v.getId()){
                    case R.id.button_add:
                        if(editText_num1.getText().length() == 0 || editText_num2.getText().length() == 0) {
                            break;
                        }
                        else{
                            result.setText(num1 + num2);
                        }
                    case R.id.button_sub:
                        if(editText_num1.getText().length() == 0 || editText_num2.getText().length() == 0) {
                            break;
                        }
                        else{
                            result.setText(num1 - num2);
                        }
                    case R.id.button_mul:
                        if(editText_num1.getText().length() == 0 || editText_num2.getText().length() == 0) {
                            break;
                        }
                        else{
                            result.setText(num1 * num2);
                        }
                    case R.id.button_div:
                        if(editText_num1.getText().length() == 0 || editText_num2.getText().length() == 0 || editText_num1.getText().equals(0)) {
                            break;
                        }
                        else{
                            result.setText(num1 / num2);
                        }
                        break;
                }
            }
        };
        addButton.setOnClickListener(listener);
        subButton.setOnClickListener(listener);
        mulButton.setOnClickListener(listener);
        divButton.setOnClickListener(listener);

    }
}
