package net.skhu.practice4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_signUp){
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_memo){
            Intent intent = new Intent(this, MemoActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_buttons){
            Intent intent = new Intent(this, ButtonsActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_checkboxes){
            Intent intent = new Intent(this, CheckboxesActivity.class);
            startActivity(intent);
            return true;
        }
        return onOptionsItemSelected(item);
    }
}
