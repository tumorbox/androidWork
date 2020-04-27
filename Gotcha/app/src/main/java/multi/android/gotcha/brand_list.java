package multi.android.gotcha;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class brand_list extends AppCompatActivity {
    String[] brand_name= {"현대","기아","쉐보레","르노삼성","쌍용","BMW","도요타","벤츠","아우디"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_list);
        listView = findViewById(R.id.brand_list);


        ArrayAdapter adapter = new ArrayAdapter(this,
                                                android.R.layout.simple_list_item_1,
                                                brand_name);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(brand_list.this,car_regist.class);
                intent.putExtra("bn",parent.getItemAtPosition(position).toString());
                startActivity(intent);
                finish();
            }
        });
    }


}
