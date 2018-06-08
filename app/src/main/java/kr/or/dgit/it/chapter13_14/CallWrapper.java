package kr.or.dgit.it.chapter13_14;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallWrapper {
    public ImageView personImageView;
    public TextView nameView;
    public TextView dateView;
    public ImageView dialerImageView;
    public CallWrapper(View root){
        personImageView=(ImageView)root.findViewById(R.id.imgHong);
        nameView=(TextView)root.findViewById(R.id.name);
        dateView=(TextView)root.findViewById(R.id.pNum);
        dialerImageView=(ImageView)root.findViewById(R.id.imgDial);
    }
}
