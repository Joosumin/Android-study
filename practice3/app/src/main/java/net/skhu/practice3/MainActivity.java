package net.skhu.practice3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;

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

    @Override public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_singUp){
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
            return true;
        } else if(id == R.id.action_memo){
            Intent intent = new Intent(this, MemoActivity.class);
            startActivity(intent);
            return true;
        } else if(id == R.id.action_buttons){
            Intent intent = new Intent(this, ButtonsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}