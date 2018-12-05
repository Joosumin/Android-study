package net.skhu.minwooks_study_1204;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button sign = (Button)findViewById(R.id.btnSign);
        Button login = (Button)findViewById(R.id.btnLogin);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_id = (EditText)findViewById(R.id.editText_id);
                String id = editText_id.getText().toString();

                EditText editText_password = (EditText)findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();

            }
        };

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        }

    }
}
