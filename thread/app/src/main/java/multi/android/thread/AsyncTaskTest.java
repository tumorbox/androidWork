package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        view1 = findViewById(R.id.txtView1);
        view2 = findViewById(R.id.txtView2);

        AsysncTaskExam asysncTaskExam = new AsysncTaskExam();
        //매개변수를 정의하면 매개변수가 doInBackground를 호출할 때 전달
        asysncTaskExam.execute(10,20);
                            //doInBackground로 전달된다. (가변적, 임의로)

    }
    public void btn_click(View view){
        long now_time = System.currentTimeMillis();
		view1.setText(now_time+"");
    }

    //AsyncTask클래스를 상속하여 작업할 클래스를 정의
    //                                  타입이 없으면 Void로 지정
    class AsysncTaskExam extends  AsyncTask<Integer,Long,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myasync","onPreExecute호출...작업시작...");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int num1 = integers[0];
            int num2 = integers[1];
            //무한루프 돌려도된다.
            for(int i=1;i<=10;i++){
                SystemClock.sleep(1000);
                Log.d("myasync","i="+i+", num1="+num1+", num2="+num2);
                long now_time = System.currentTimeMillis();
                //발생되는 값으로 ui를 변경하고 싶은 경우
                publishProgress(now_time);
                            // onPrograssUpdate로 전달된다.
            }
            return "모든 처리 작업이 완료";
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            //doInBackground에서 발생하는 값을 이용해서 화면을 변경하고 싶은 경우
            view2.setText("Async테스트 : "+values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {
                                    // doInBackground의 return값이 매개변수로 전달
            super.onPostExecute(s);
            view1.setText("반환값: "+s);
        }
    }
   
}
