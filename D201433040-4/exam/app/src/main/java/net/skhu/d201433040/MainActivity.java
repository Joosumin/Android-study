package net.skhu.d201433040;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnExam2_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.ok);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                if(editText1.getText().toString().equals("삭제")){
                    editText1.setText(" ");
                }
                else
                    editText1.setText("삭제");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public boolean btnExam1_clicked(View button){
        Intent intent = new Intent(this, Exam1Activity.class);
        startActivity(intent);
        return true;
    }
}
