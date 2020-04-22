package multi.android.thread;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class AsyncTaskExam01 extends AppCompatActivity {
    Button button;
    Button button2;
    TextView textView;
    ProgressBar progressBar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);




    }
    AsysncTaskExam asysncTaskExam = new AsysncTaskExam();
    public void ck_bt(View view){
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              asysncTaskExam.execute(10);
          }
      });


    }

    //AsyncTask클래스를 상속하여 작업할 클래스를 정의
    //                                  타입이 없으면 Void로 지정
    class AsysncTaskExam extends  AsyncTask<Integer,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myasync","onPreExecute호출...작업시작...");
            button.setEnabled(false);
            button2.setEnabled(true);
            progressBar.setMax(50);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int num1 = integers[0];
            int sum = 0;
            String result = null;


            for(int i=1;i<=50;i++){
                SystemClock.sleep(100);
                sum = sum+i;
                result = Integer.toString(sum);


            }
            return result;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            button.setEnabled(true);
            button2.setEnabled(false);
            textView.setText(s);
        }
    }
   
}
