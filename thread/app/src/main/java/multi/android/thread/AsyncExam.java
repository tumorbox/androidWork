package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncExam extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    ProgressBar progressBar;
    Button button,button2;
    MyTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button2.setEnabled(false);
    }
    public void btn_click(View view){

        if(view.getId() == R.id.button){
            task = new MyTask();
            task.execute(0);
        }
    }

    class MyTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            progressBar.setMax(50);
            button.setEnabled(false);
            button2.setEnabled(true);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int cnt = integers[0].intValue();
            int sum = 0;
            for(int i=0;i<50;i++){
                if(isCancelled() == true){
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                sum += i;
                publishProgress(i);
            }
            return sum;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int i = values[0].intValue();
            progressBar.setProgress(i);
            textView.setText(i+"");
            if(i%2 == 0){
                imageView.setImageResource(R.drawable.d1);
            }else{
                imageView.setImageResource(R.drawable.d2);
            }
        }

        @Override
        protected void onPostExecute(Integer s) {
            textView.setText(s);
            button.setEnabled(true);
            button2.setEnabled(false);
        }

      
    }

}

