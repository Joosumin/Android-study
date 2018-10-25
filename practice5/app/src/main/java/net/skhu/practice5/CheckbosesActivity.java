package net.skhu.practice5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class CheckbosesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboses);

        CompoundButton.OnCheckedChangeListener listener1 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String s = String.format("%s" : "%b", buttonView.getText(), isChecked);
                Toast.makeText(CheckbosesActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        final CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        checkBox1.setOnCheckedChangeListener(listener1);
        switch1.setOnCheckedChangeListener(listener1);

        RadioGroup.OnClickListener listener2 = new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void OnCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String s = radioButton.getText().toString();
                Toast.makeText(CheckbosesActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
    }
}
