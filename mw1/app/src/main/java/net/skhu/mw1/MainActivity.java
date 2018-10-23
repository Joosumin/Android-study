package net.skhu.mw1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = getLayoutInflater();
        LinearLayout toastView = (LinearLayout)layoutInflater.inflate(R.layout.mytoast, null);

        EditText edit=(EditText)findViewById(R.id.EditText);
        TextView.OnEditorActionListener listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_GO){
                    Toast.makeText(MainActivity.this,"첫번째",Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(actionId == EditorInfo.IME_ACTION_NEXT){
                    Toast.makeText(MainActivity.this, "두번째", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        };

        Toast t = new Toast(this);
        t.setView(toastView);
        t.setGravity(Gravity.CENTER, 100, 50);
        t.setDuration(Toast.LENGTH_LONG);
        t.show();
    }
}
