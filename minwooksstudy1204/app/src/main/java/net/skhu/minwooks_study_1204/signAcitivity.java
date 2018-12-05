package net.skhu.minwooks_study_1204;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signAcitivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        Button b = (Button)findViewById(R.id.btn_sign);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_loginId = (EditText)findViewById(R.id.editText_id);
                String loginId = editText_loginId.getText().toString();
                if(isEmptyOrWhiteSpace(loginId))
                    editText_loginId.setError("로그인 아이디를 입력해주세요.");

                EditText editText_password = (EditText)findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();
                if(isEmptyOrWhiteSpace(password))
                    editText_password.setError("비밀번호를 입력해주세요.");

                EditText editText_nickname = (EditText)findViewById(R.id.editText_nickname);
                String nickname = editText_nickname.getText().toString();
                if(isEmptyOrWhiteSpace(nickname))
                    editText_nickname.setError("별명을 입력해주세요.");
            }
        };
        b.setOnClickListener(listener);
    }

    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}

