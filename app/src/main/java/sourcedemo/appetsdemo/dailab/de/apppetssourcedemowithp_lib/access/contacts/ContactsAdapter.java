package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.access.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.R;

/**
 * Created by arik on 05.07.2017.
 */

public class ContactsAdapter extends ArrayAdapter<Person> {

    private List<Person> listData;
    private LayoutInflater layoutInflater;

    public ContactsAdapter(Context context, int resourceId, List<Person> listData) {

        super(context, resourceId, listData);
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        for (Person ff : listData) {
            ff.setSelected(false);
        }
    }


    @Override
    public int getCount() {

        return listData.size();
    }

    @Override
    public Person getItem(int position) {

        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final Person p = listData.get(position);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.contact_entry, null);
            holder = new ViewHolder();
            holder.layout = convertView.findViewById(R.id.contact);
            holder.name = convertView.findViewById(R.id.name);
            holder.number = convertView.findViewById(R.id.number);
            holder.ch = convertView.findViewById(R.id.ch_select);
            holder.image = convertView.findViewById(R.id.image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.layout = convertView.findViewById(R.id.contact);
            holder.name = convertView.findViewById(R.id.name);
            holder.number = convertView.findViewById(R.id.number);
            holder.ch = convertView.findViewById(R.id.ch_select);
            holder.image = convertView.findViewById(R.id.image);
        }

        holder.name.setText(p.getName());
        holder.number.setText(p.getNumber());
        holder.ch.setChecked(p.isSelected());
        holder.ch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                p.setSelected(holder.ch.isChecked());
            }
        });
        holder.ch.setChecked(p.isSelected());
        if (p.getUrl() != null) {
            holder.image.setImageURI(p.getUrl());
        } else {
            holder.image.setImageResource(R.drawable.dai_person);
        }

        int size = 175;
        holder.image.setMinimumWidth(size);
        holder.image.setMaxWidth(size);
        holder.image.setMinimumHeight(size);
        holder.image.setMaxHeight(size);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setSelected(!p.isSelected());
                holder.ch.setChecked(p.isSelected());
            }
        });
        return convertView;
    }


    public List<Person> getData() {

        return listData;

    }

    static class ViewHolder {

        RelativeLayout layout;
        ImageView image;
        TextView name;
        TextView number;
        CheckBox ch;

    }

}
