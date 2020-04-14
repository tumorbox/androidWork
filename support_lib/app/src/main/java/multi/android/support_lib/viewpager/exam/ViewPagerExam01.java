package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;
import multi.android.support_lib.fragment.exam.FragmentExam01;


public class ViewPagerExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    //ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;
    ListTestFragment viewFragment2;
    MapFragment viewFragment4;
    ViewPager fragment_viewPager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        viewFragment4 = new MapFragment();
        //ArrayList에 fragment를 추가
        fragmentArrayList.add(viewFragment1);
        fragmentArrayList.add(viewFragment2);
        fragmentArrayList.add(viewFragment3);
        fragmentArrayList.add(viewFragment4);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());

        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PageListner());
    }

    //tag 번호로 연결
    public  void btn_click(View view){
        fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }
    // FragmentStatePagerAdapter -> 메모리를 절약할 수 있다.(이미지 많을때)
    // FragmentPagerAdapter
    class FragAdapter extends FragmentStatePagerAdapter {

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
       /* @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //뷰와 fragment는 전혀상관이 없는 객체
            //따라서 PagerAdaper 상속X
            fragment_viewPager.addView(fragmentArrayList.get(position));
        }*/
    }

    class PageListner implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(ViewPagerExam01.this,"페이지 전환",
                    Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
