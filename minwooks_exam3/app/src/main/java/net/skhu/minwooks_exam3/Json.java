package net.skhu.minwooks_exam3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.Call;
import okhttp3.Response;

public class Json extends AppCompatActivity {

    GetJson json2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        json2 = GetJson.getInstance();

        new Thread() {
            public void run() {
// 파라미터 2개와 미리정의해논 콜백함수를 매개변수로 전달하여 호출
                json2.requestWebServer(callback, "common.do", "method=getLottoNumber", "drwNo=809");

            }
        }.start();
    }
    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d("JSON", "콜백오류:" + e.getMessage());
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String body = response.body().string();
            Log.d("JSON", "서버에서 응답한 Body:" + body);
            Handler handler = new Handler(Looper.getMainLooper());

            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "email and Password were not correct", Toast.LENGTH_SHORT).show();
                }
            });

            try {
                JSONObject jsonObject = new JSONObject(body);
                int num11 = jsonObject.getInt("drwtNo2");
                String s = jsonObject.getString("returnValue");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
