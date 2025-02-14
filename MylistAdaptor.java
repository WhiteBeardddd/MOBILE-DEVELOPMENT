package ph.edu.usc.boquecosa_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MylistAdaptor extends ArrayAdapter<String> {
    private final Context context;
    private final String[] ourCourses;
    private final String[] topics;
    private final Integer[] indexid;

    public MylistAdaptor(@NonNull Context context, Activity context1, String[] ourCourses, String[] topics, Integer[] indexid) {
        super(context, R.layout.mylistlayout, ourCourses);
        this.context = context1;
        this.ourCourses = ourCourses;
        this.topics = topics;
        this.indexid = indexid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.mylistlayout, parent, false);
        }

        ImageView img = rowView.findViewById(R.id.imageView2);
        TextView headtext = rowView.findViewById(R.id.headertxt);
        TextView subtxt = rowView.findViewById(R.id.subtext);

        img.setImageResource(indexid[position]);
        headtext.setText(ourCourses[position]);
        subtxt.setText(topics[position]);

        return rowView;
    }
}
