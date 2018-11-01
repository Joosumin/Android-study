package net.skhu.d201433040;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        String[] stringArray = { "관리자", "사용자", "손님" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner)findViewById(R.id.spinner_userType);
        spinner.setAdapter(adapter);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner1 = (Spinner)findViewById(R.id.spinner_userType);
                String text1 = spinner1.getSelectedItem().toString();
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                if(text1.equals("관리자")) {
                    editText1.setText("관리자");
                }
                else if(text1.equals("사용자")){
                    editText1.setText("사용자");
                }
                else if(text1.equals("손님")){
                    editText1.setText("손님");
                }
            }
        };
        Button button = (Button)findViewById(R.id.btnOk);
        button.setOnClickListener(listener1);
        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                String s = radioButton.getText().toString();
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                editText1.setText(s);
            }
        };
        final RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
        radioGroup1.setOnCheckedChangeListener(listener2);
    }

}
