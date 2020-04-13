package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


public class DBHandler  {
    EditText edtName;
    EditText edtSu;
    EditText edtPrice;
    ListView listview;
    SQLiteDatabase db ;
    ExamDBHelper examDBHelper;




    public void btnIns(String edtName, String edtPrice, String edtSu) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",edtName);
        contentValues.put("price",edtPrice);
        contentValues.put("su",edtSu);

        db.insert("product",null,contentValues);


    }

    public void btnResult(View v){

        Cursor cursor = db.query("product",null,null,null,
                null,null,null);


        while (cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String edtName = cursor.getString(1);
            int edtSu= cursor.getInt(2);
            int edtPrice = cursor.getInt(3);
        }

    }

    public void btnResult2(View v){

    }

    public void btnSearch(View v){

    }

}
