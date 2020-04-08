package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private  Context context;
    private  int resId;
    private ArrayList<ActorItem> actorlist;

    HashMap<Integer,SaveCheckedState> saveData = new HashMap<Integer, SaveCheckedState>();

    public ExamAdapter(Context context, int resId, List<ActorItem> actorlist) {
        super(context, resId,  actorlist);

        this.context = context;
        this.resId = resId;
        this.actorlist = (ArrayList<ActorItem>) actorlist;
    }


    @Override
    public int getCount() {
        return actorlist.size();
    }

    @Override
    public ActorItem getItem(int position) {
        return actorlist.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ExamViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(resId, null);

             holder = new ExamViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            //================ 뷰를 만드는 최초작업이 아님 =================
            holder = (ExamViewHolder) convertView.getTag();

        }
        //ArrayList에서 리턴된 항목의 번호와 동일한 데이터를 구하기
        ActorItem actor = actorlist.get(position);
        if (actor != null) {

            //위에서 생성한뷰의 각 요소에 데이터를 연결
            ImageView imageView = holder.exImg;
            TextView nameView = holder.exName;
            TextView dateView = holder.exDate;
            TextView textView = holder.exText;
            final CheckBox checkView =holder.checkView;

            imageView.setImageResource(actor.exImg);
            nameView.setText(actor.exName);
            dateView.setText(actor.exDate);
            textView.setText(actor.exText);

            SaveCheckedState state = saveData.get(position);
            if(state==null){
                checkView.setChecked(false);
            }else {

                checkView.setChecked(state.data);
            }
            checkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean data = checkView.isChecked();
                    SaveCheckedState objstate = new SaveCheckedState();
                    objstate.data = data;
                    saveData.put(position,objstate);

                }
            });

        }
        return convertView;
    }
}
