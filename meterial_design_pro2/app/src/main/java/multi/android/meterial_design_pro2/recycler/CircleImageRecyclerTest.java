package multi.android.meterial_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.meterial_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {

    RecyclerView imglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        imglist = findViewById(R.id.imglist);

        List<CircleItem> cirlce_img_data = new ArrayList<CircleItem>();
        List<Integer> img_data = new ArrayList<>();
            img_data.add(R.drawable.gong);
            img_data.add(R.drawable.jang);
            img_data.add(R.drawable.jung);
            img_data.add(R.drawable.lee);
            img_data.add(R.drawable.so);

        for(int i=0;i<img_data.size();i++){
            CircleItem circleItem = new CircleItem(img_data.get(i));
            cirlce_img_data.add(circleItem);
        }

        // 2. Adapter 생성
        RecyclerCircleAdapter adapter =new RecyclerCircleAdapter(this,
                                                    R.layout.circle_item,
                                                    cirlce_img_data);

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        imglist.setHasFixedSize(true);
        imglist.setLayoutManager(manager);
        imglist.setAdapter(adapter);

    }
}
