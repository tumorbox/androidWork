package multi.android.thread;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class Logo extends AppCompatActivity {
    Handler handler;
    //5초 후에 처리해야 하는 작업을 쓰레드로 정의
    //익명이너클래스로 정의
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Logo.this,HandlerExam2.class);
            startActivity(intent);
            finish();
            //메인 엑티비리토 전활될 때 애니매이션 효과를 추가

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        handler = new Handler();
        handler.postDelayed(runnable,5000);


    }
}