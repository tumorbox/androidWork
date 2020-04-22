package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class HandlerExam2 extends AppCompatActivity {
    int num;
    Handler handler;
    TextView numView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        numView = findViewById(R.id.numView);
        handler = new Handler();
    }
    public void btn_click(View view){
        //버튼을 누르면 쓰레드를 start
        new NumThread().start();
    }
    //TextView의 값을 지속적으로 변경하는 쓰레드
    class UIUpdateThread implements Runnable{

        @Override
        public void run() {
            numView.setText(num+"");
        }
    }
    //지속해서 값을 만드는 쓰레드
    class  NumThread extends  Thread {
        public void run(){
            for(int i=1;i<=10;i++){
                num=i;
                //핸들러에게 UI를 변경하는 쓰레드를 전달하며 요청
                //대신 지속적으로 처리하는 작업을 handler한테 요청하면 안된다.
                handler.post(new UIUpdateThread());
                SystemClock.sleep(1000);
            }
        }

    }
}
