package multi.android.meterial_design_pro.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import multi.android.meterial_design_pro.R;

/*
*  Toolbar는 find해서 사용해야 하며 직접 만든 디자인을 연결할 수 있다.
*
* * */

public class ToolBarTest extends AppCompatActivity {
    TextView result;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_test);
        result = findViewById(R.id.result);
        toolbar = findViewById(R.id.toolbar);

        //액션봐 대신 툴바를 사용하겠다고 정의
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Log.d("menu",item.getItemId()+"");
        int id = item.getItemId();
        String msg="";
        switch (id){
            case R.id.search:
                msg = "첫번째 메뉴 선택";
                break;
            case R.id.option_1:
                msg = "공유";
                break;
        }
        result.setText(msg);
        return super.onOptionsItemSelected(item);
    }
}
