package multi.android.meterial_design_pro.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.meterial_design_pro.R;


public class ViewPagerExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3;
    ViewPager fragment_viewPager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    ArrayList<String> tabArrayList = new ArrayList<String>();
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        tabLayout = findViewById(R.id.tablist);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();

        //ArrayList에 fragment를 추가
        fragmentArrayList.add(viewFragment1);
        fragmentArrayList.add(viewFragment2);
        fragmentArrayList.add(viewFragment3);

        tabLayout.setTabTextColors(Color.CYAN,Color.BLACK);
        for(int i=1;i<=fragmentArrayList.size();i++) {
            tabArrayList.add("View" + i);
        }
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());

        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PageListner());

        tabLayout.setupWithViewPager(fragment_viewPager);
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabArrayList.get(position);
        }
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
