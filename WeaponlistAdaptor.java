package ph.edu.usc.boquecosa_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeaponlistAdaptor extends ArrayAdapter<String> {
    private final Context context;
    private final String[] weapon_name;
    private final String[] weapon_desc;
    private final Integer[] indexid;

    // ✅ Fix: Removed extra `context1` parameter in the constructor
    public WeaponlistAdaptor(@NonNull Context context, String[] weapon_name, String[] weapon_desc, Integer[] indexid) {
        super(context, R.layout.weaponlistlayout, weapon_name);
        this.context = context;
        this.weapon_name = weapon_name;
        this.weapon_desc = weapon_desc;
        this.indexid = indexid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.weaponlistlayout, parent, false);
        }

        ImageView img = rowView.findViewById(R.id.imageView2);
        TextView headtext = rowView.findViewById(R.id.headertxt);
        TextView subtxt = rowView.findViewById(R.id.subtext);

        img.setImageResource(indexid[position]);
        headtext.setText(weapon_name[position]);
        subtxt.setText(weapon_desc[position]);

        return rowView;
    }
}
