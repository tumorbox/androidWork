package multi.android.gotcha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class car_certificate extends Fragment {
    String carNumber,from;
    TextView carFromNumber;
    ImageView btnCertImg;

    public car_certificate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_car_certificate, container, false);
        // Inflate the layout for this fragment
        carFromNumber = v.findViewById(R.id.carFromNumber3);
        btnCertImg = v.findViewById(R.id.btnCertImg);
        Bundle bundle = this.getArguments();
        if (bundle!=null){
            bundle = getArguments();
            carNumber = bundle.getString("carNum");
            from = bundle.getString("carFrom");
        }


        carFromNumber.setText(from+" / "+carNumber);
        return v;
    }
    public void btnimg(View view){

    }
}
