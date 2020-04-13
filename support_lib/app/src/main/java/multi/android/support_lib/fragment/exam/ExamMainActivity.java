package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;


public class ExamMainActivity extends AppCompatActivity {
    ExamFisrtFragment examFisrtFragment = new ExamFisrtFragment();
    ExamSecondFragment examSecondFragment = new ExamSecondFragment();
    ExamThirdFragment examThirdFragment = new ExamThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("button");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("button2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("button3");
            }
        });

    }

    public  void setFragment(String name){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch(name) {
            case "button":
                transaction.replace(R.id.container,examFisrtFragment);
                break;
            case "button2":
                transaction.replace(R.id.container,examSecondFragment);
                break;
            case "button3":
                transaction.replace(R.id.container,examThirdFragment);
                break;
        }
        transaction.commit();

    }
}
