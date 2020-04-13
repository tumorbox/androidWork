package multi.android.datamanagementpro.sqlite.exam;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;
import multi.android.datamanagementpro.R;

public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {

	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;
    DBHandler handler;
    SQLiteDatabase db ;
    ExamDBHelper examDBHelper;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//handler = DBHandler.open(this);

		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);

		edtName = findViewById(R.id.edtName);
		edtSu = findViewById(R.id.edtSu);
		edtPrice = findViewById(R.id.edtPrice);

        examDBHelper = new ExamDBHelper(this);
        examDBHelper.getWritableDatabase();
        handler = new DBHandler();
	}

    @Override
    public void onClick(View v) {
	    if(v.getId()==R.id.btnIns){
	        handler.btnIns(v);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



















