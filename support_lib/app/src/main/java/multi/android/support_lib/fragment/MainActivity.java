package multi.android.support_lib.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import multi.android.support_lib.R;


public class MainActivity extends AppCompatActivity {

    // 화면에 연결할 프래그먼트 객체를 생성
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFirst = findViewById(R.id.btnAddFrag);
        Button btnRemove = findViewById(R.id.btnRemoveFrag);
        Button btnSecond = findViewById(R.id.btnSecondFrag);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("first");
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("remove");
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("second");
            }
        });

    }

    //구분해 놓은 영역에 fragement를 교체해서 보여줄 메소드
    public void setFragment(String name){

        //먼저 fragment객체를 관리하는 관리자 객체를 구해야 한다.
        FragmentManager fragmentManager = getSupportFragmentManager();

        //오라클에서 트렌잭션처리와 비슷하게시작 (명시작업 필요)
        //fragment작업을 시작하기 위한 트랜잭션객체를 구한다.
        //transction은 작업단위라고 생각하면 된다.
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (name){
            case "first":
                //지정한 fragment를 특정영역을 교체하는 작업 (replace)
                //main.xml의 linerlayout에 교체(container)
                transaction.replace(R.id.container,firstFragment);
                break;
            case"remove":
                //fisrtfragment를 안보이도록
                //detach()을 한번 사용하면 replcae를 못함. 따라서 remove사용
                transaction.remove(firstFragment);
                break;
            case"second":
                transaction.replace(R.id.container,secondFragment);
                break;
        }
        //commitNow는 지금 당장 처리해달라고 요청
        //transaction.commitNow();
        //commit은 스캐줄 고려해서 적당한 시기에 변경해달라고 요청을 의뢰
        //commit을 더 선호해서 사용. 둘중에 하나만 사용해야한다.
        transaction.commit();


    }
  
}
