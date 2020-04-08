package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import exam.day03.view.selectview.R;

public class MyAdapter extends ArrayAdapter<User> {
    private Context context;
    private  int resId;
    private ArrayList<User> datalist;

    public MyAdapter(Context context, int resId,ArrayList<User> datalist) {
        super(context, resId, datalist);
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }

    //리스트 갯수를 반환
    @Override
    public int getCount() {
        //본인것
        return datalist.size();
    }

    //매개변수로 전달받은 순서에 있는 항목을 반환
    @Override
    public User getItem(int position) {
        return datalist.get(position);
    }

    //리스트의 한 항목을 만들 때 호출되는 메소드 - 리스트 항목이 100개면 100번호출된다.
    //position => 리스트순서
    //convertView => 한 항목에 대한 뷰
    @Override
                        //position => 항목의 순서
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("getview","getview:"+position);
        long start = System.nanoTime();
        //뷰를 생성
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                    //뷰에 대한 리소스
        convertView = inflater.inflate(resId, null);

        //ArrayList에서 리턴된 항목의 번호와 동일한 데이터를 구하기
        User user = datalist.get(position);
        //위에서 생성한뷰의 각 요소에 데이터를 연결
        ImageView imageView = convertView.findViewById(R.id.img);
        TextView nameVeiw = convertView.findViewById(R.id.txtcust1);
        TextView telNumView = convertView.findViewById(R.id.txtcust2);

        imageView.setImageResource(user.myImg);
        nameVeiw.setText(user.name);
        telNumView.setText(user.telNum);
        long end = System.nanoTime();
        Log.d("getview",(end-start)+"");
        return convertView;
    }
}