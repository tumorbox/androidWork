package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment2 extends Fragment {

    public ViewFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.view2, container, false);
    }
}
