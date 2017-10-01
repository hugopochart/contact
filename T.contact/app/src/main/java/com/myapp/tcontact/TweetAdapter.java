package com.myapp.tcontact;

/**
 * Created by hugo on 04/03/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.List;

public class TweetAdapter extends ArrayAdapter<Contact> {



    public TweetAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_tweet,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }

        Contact contact = getItem(position);
        viewHolder.pseudo.setText(contact.getName());
        viewHolder.text.setText(contact.getNumber());

        return convertView;
    }

    public void EditItem (View view){}

    private class TweetViewHolder{
        public TextView pseudo;
        public TextView text;

    }
}

