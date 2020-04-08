package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ExamViewHolder {
    CheckBox checkView;
    ImageView exImg;
    TextView exName;
    TextView exDate;
    TextView exText;

    public ExamViewHolder(View parentView) {
        this.exImg = parentView.findViewById(R.id.img);
        this.exName = parentView.findViewById(R.id.txtcust1);
        this.exDate = parentView.findViewById(R.id.txtcust2);
        this.exText = parentView.findViewById(R.id.txtcust3);
        this.checkView = parentView.findViewById(R.id.chkinfo);
    }

}
