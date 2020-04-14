package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;


public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);

        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ViewFragment2();
        viewFragment3 = new ViewFragment3();

       /* Button button = findViewById(R.id.button);
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
        });*/

    }

    public  void btn_click(View view){
        setFragment(view.getTag().toString());
    }

    public  void setFragment(String name){
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프레그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch(name) {
            case "0":
                transaction.replace(R.id.container, viewFragment1);
                break;
            case "1":
                transaction.replace(R.id.container, viewFragment2);
                break;
            case "2":
                transaction.replace(R.id.container, viewFragment3);
                break;
        }
        transaction.commit();

    }
}
