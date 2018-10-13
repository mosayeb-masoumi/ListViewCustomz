package com.example.tornado.listviewcustomz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tornado.listviewcustomz.R;
import com.example.tornado.listviewcustomz.model.Contact;

import java.util.ArrayList;

/**
 * Created by tornado on 10/13/2018.
 */

public class CustomAdapter extends BaseAdapter {

  private Context context;
  private ArrayList<Contact> data;
  private LayoutInflater inflater;

   //constructor
    public CustomAdapter(Context context, ArrayList<Contact> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    public static class viewHolder{
        public TextView txtName;
        public TextView txtMessage;
        public TextView txtDate;

        public ImageView imgProfile;

        public LinearLayout lnrContainer;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         View vi = convertView;
          viewHolder holder= new viewHolder();

        if (vi == null)
        {
            vi = inflater.inflate(R.layout.contact_item, null);
            holder.txtName = (TextView) vi.findViewById(R.id.contact_txtName);
            holder.txtDate = (TextView) vi.findViewById(R.id.contact_txtDate);
            holder.txtMessage = (TextView) vi.findViewById(R.id.contact_txtMessage);
            holder.imgProfile = (ImageView) vi.findViewById(R.id.contact_imgProfile);
            holder.lnrContainer = (LinearLayout) vi.findViewById(R.id.contact_lnrContainer);

            vi.setTag(holder);

        }
        else
            holder = (viewHolder) vi.getTag();


        if (data.size() > 0)
        {
            Contact tempValue = data.get(position);

            holder.txtName.setText(tempValue.getName());
            holder.txtMessage.setText(tempValue.getMessage());
            holder.txtDate.setText(tempValue.getDate());

            //jahat namayesh picture
            String uri = "@drawable/" + tempValue.getImage();
            int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
            holder.imgProfile.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), imageResource, null));


            //agar message seen shode bud textha siz normal va background rang default dashte bashad
            if (tempValue.isSeen())
            {
                holder.txtName.setTypeface(null, Typeface.NORMAL);
                holder.txtMessage.setTypeface(null, Typeface.NORMAL);
                holder.txtDate.setTypeface(null, Typeface.NORMAL);
                holder.lnrContainer.setBackgroundColor(Color.parseColor("#efefef"));
            }

            //agar message seen nashode bud textha siz bold va background rang white dashte bashad
            else
            {
                holder.txtName.setTypeface(null, Typeface.BOLD);
                holder.txtMessage.setTypeface(null, Typeface.BOLD);
                holder.txtDate.setTypeface(null, Typeface.BOLD);
                holder.lnrContainer.setBackgroundColor(Color.parseColor("#ffffff"));
            }

        }

        return vi;
    }
}
