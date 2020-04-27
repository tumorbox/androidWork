package multi.android.gotcha;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class car_info extends Fragment implements View.OnClickListener {
    Button btnBrand,next;
    String carNumber,from,bn;
    TextView carFromNumber;

    public car_info() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_car_info, container, false);
        btnBrand = v.findViewById(R.id.btnBrand);
        btnBrand.setOnClickListener(this);
        carFromNumber = v.findViewById(R.id.carFromNumber);
        next = v.findViewById(R.id.btnNext);
        next.setOnClickListener(this);

        Bundle bundle = this.getArguments();
        if (bundle!=null){
            bundle = getArguments();
            carNumber = bundle.getString("carNum");
            from = bundle.getString("carFrom");
            bn = bundle.getString("bn");
            btnBrand.setText(bn);
        }

        carFromNumber.setText(from+" / "+carNumber);

        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBrand:
                Log.d("check","브랜드 고르기");
                Intent intent = new Intent(getContext(), brand_list.class);
                getActivity().startActivity(intent);
                break;
            case R.id.btnNext:
                Toast.makeText(getContext(), "다음으로", Toast.LENGTH_SHORT).show();
        }
    }




}
