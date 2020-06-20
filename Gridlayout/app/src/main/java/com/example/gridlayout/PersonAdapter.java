package com.example.gridlayout;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PersonAdapter  extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> people;

    public PersonAdapter (Context context, ArrayList<Person> list)
    {
        people = list;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView ivpref;
        TextView tvName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            ivpref = (ImageView)  itemView.findViewById(R.id.ivpref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tvName.setText(people.get(i).getName());

        if(people.get(i).getPreferences().equals("wet"))
        {
            viewHolder.ivpref.setImageResource(R.drawable.wet);
        }
        else
        {
            viewHolder.ivpref.setImageResource(R.drawable.wet);
        }


    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
