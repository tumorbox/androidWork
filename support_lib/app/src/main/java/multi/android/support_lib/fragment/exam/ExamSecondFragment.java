package multi.android.support_lib.fragment.exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamSecondFragment extends Fragment {

    public ExamSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.view2, container, false);
    }
}
