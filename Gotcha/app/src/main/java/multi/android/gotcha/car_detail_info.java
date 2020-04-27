package multi.android.gotcha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class car_detail_info extends Fragment {
    String carNumber,from;
    TextView carFromNumber;
    public car_detail_info() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_car_detail_info, container, false);
        carFromNumber = v.findViewById(R.id.carFromNumber1);

        Bundle bundle = this.getArguments();
        if (bundle!=null){
            bundle = getArguments();
            carNumber = bundle.getString("carNum");
            from = bundle.getString("carFrom");
        }

        carFromNumber.setText(from+" / "+carNumber);

        return v;
    }
}
