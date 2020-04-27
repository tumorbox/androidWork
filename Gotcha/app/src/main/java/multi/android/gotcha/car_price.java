package multi.android.gotcha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class car_price extends Fragment implements View.OnClickListener {
    String carNumber,from;
    TextView carFromNumber;
    Button priceNormal,priceLease1,priceLease2;
    LinearLayout normalPriceView,leasePriceView1,leasePriceView2;
    FrameLayout frameLayout;
    public car_price() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_car_price, container, false);
        priceNormal = v.findViewById(R.id.priceNormal);
        priceLease1 = v.findViewById(R.id.priceLease1);
        priceLease2 = v.findViewById(R.id.priceLease2);
        priceNormal.setOnClickListener(this);
        priceLease1.setOnClickListener(this);
        priceLease2.setOnClickListener(this);
        carFromNumber = v.findViewById(R.id.carFromNumber2);
        normalPriceView = v.findViewById(R.id.normalPriceView);
        leasePriceView1 = v.findViewById(R.id.leasePriceView1);
        leasePriceView2 = v.findViewById(R.id.leasePriceView2);
        frameLayout = v.findViewById(R.id.framelayout);

        frameLayout.removeAllViews();
        frameLayout.addView(normalPriceView);

        Bundle bundle = this.getArguments();
        if (bundle!=null){
            bundle = getArguments();
            carNumber = bundle.getString("carNum");
            from = bundle.getString("carFrom");
        }

        carFromNumber.setText(from+" / "+carNumber);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.priceNormal:
                frameLayout.removeAllViews();
                frameLayout.addView(normalPriceView);
                normalPriceView.setVisibility(View.VISIBLE);
                leasePriceView1.setVisibility(View.INVISIBLE);
                leasePriceView2.setVisibility(View.INVISIBLE);
                break;
            case R.id.priceLease1:
                frameLayout.removeAllViews();
                frameLayout.addView(leasePriceView1);
                normalPriceView.setVisibility(View.INVISIBLE);
                leasePriceView1.setVisibility(View.VISIBLE);
                leasePriceView2.setVisibility(View.INVISIBLE);
                break;
            case R.id.priceLease2:
                frameLayout.removeAllViews();
                frameLayout.addView(leasePriceView2);
                normalPriceView.setVisibility(View.INVISIBLE);
                leasePriceView1.setVisibility(View.INVISIBLE);
                leasePriceView2.setVisibility(View.VISIBLE);
        }
    }
}
