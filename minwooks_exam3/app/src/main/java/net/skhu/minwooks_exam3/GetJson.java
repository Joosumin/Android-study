package net.skhu.minwooks_exam3;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class GetJson {
    private String url="http://www.nlotto.co.kr/";
    private OkHttpClient client;
    private static GetJson instance = new GetJson();
    public static GetJson getInstance() {
        return instance;
    }

    private GetJson(){ this.client = new OkHttpClient(); }

    /** 웹 서버로 요청을 한다. */
    public void requestWebServer(Callback callback, String php, String ... param) {
        String purl = url + php + "?" + param[0];

        for(int i=0; i<param.length; i++){
            purl += "&";
            purl += param[i];
        }

        RequestBody body = new FormBody.Builder()

                .build();
        Request request = new Request.Builder()
                .url(purl) //통신하고자하는 url
                .post(body) //받은 데이터
                .build();
        client.newCall(request).enqueue(callback); //통신후 콜백될 함수
    }
}
