package multi.android.gotcha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class car_number extends AppCompatActivity implements View.OnClickListener {
    Button carSendStartButton;
    RadioButton carRadio1,carRadio2;
    EditText carNumber;
    String cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_number);
        carSendStartButton = findViewById(R.id.carSendStartButton);
        carSendStartButton.setOnClickListener(this);
        carRadio1 = findViewById(R.id.carRadio1);
        carRadio1.setOnClickListener(this);
        carRadio2 = findViewById(R.id.carRadio2);
        carRadio2.setOnClickListener(this);
        carNumber = findViewById(R.id.carNumber);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.carRadio1){
            cont = carRadio1.getText().toString();
        }else if (v.getId()==R.id.carRadio2){
            cont = carRadio2.getText().toString();
        }else if (v.getId()==R.id.carSendStartButton){
            Intent intent = new Intent(car_number.this,car_regist.class);
            intent.putExtra("carNumber",carNumber.getText().toString());
            intent.putExtra("from",cont);
            startActivity(intent);
        }
    }
}
