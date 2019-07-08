package com.example.exotica;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customListView extends ArrayAdapter<String> {

    private String[] eventname;
    private Integer[] imgid;
    private Activity context;


    public customListView(Activity context , String[] eventname, Integer[] imgid) {

        super(context, R.layout.listview_layout,eventname);

        this.context=context;
        this.eventname=eventname;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View r=convertView;
         ViewHolder viewHolder=null;
         if (r==null)
         {
             LayoutInflater layoutInflater=context.getLayoutInflater();
             r=layoutInflater.inflate(R.layout.listview_layout,null,true);
             viewHolder=new ViewHolder(r);
             r.setTag(viewHolder);
         }
         else {
             viewHolder=(ViewHolder) r.getTag();
         }
         viewHolder.iw.setImageResource(imgid[position]);

         viewHolder.tw.setText(eventname[position]);




        return r;
    }
    class ViewHolder
    {
        TextView tw;
        ImageView iw;
        ViewHolder(View v)
        {
            tw= (TextView) v.findViewById(R.id.eventName);
            iw= (ImageView) v.findViewById(R.id.imageView);

        }
    }
}
