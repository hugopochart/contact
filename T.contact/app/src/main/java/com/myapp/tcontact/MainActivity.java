package com.myapp.tcontact;

/**
 * Created by hugo on 04/03/17.
 */

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHandler db = new DBHandler(this);

// Reading all Contact

        final ListView tvcontact = (ListView)  findViewById(R.id.tvcontact);

        final List<Contact> contacts1 = db.getAllContacts();

        final ListAdapter adapter = new TweetAdapter(MainActivity.this, contacts1);


//Long click on listviex item
        tvcontact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                View v = tvcontact.getChildAt(position);

                ImageView delete = (ImageView) v.findViewById(R.id.buttonDelete);
                delete.setVisibility(View.VISIBLE);

                ImageView edit = (ImageView) v.findViewById(R.id.buttonEdit);
                edit.setVisibility(View.VISIBLE);


                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int idi = contacts1.get(position).getId();
                        Intent intent12 = new Intent(MainActivity.this, MainActivity.class);
                        db.deleteContact(db.getContact(idi));
                        startActivity(intent12);

                    }
                });

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int idi = contacts1.get(position).getId();
                        String namecontacto = contacts1.get(position).getName();
                        String phonecontacto = contacts1.get(position).getNumber();
                        String hphonecontacto = contacts1.get(position).getHnumber();
                        String emailcontacto = contacts1.get(position).getEmail();



                        Intent intent = new Intent(MainActivity.this,Editprofiluser.class);


                        intent.putExtra("identite", idi);
                        intent.putExtra("contactName", namecontacto);
                        intent.putExtra("contactNumber", phonecontacto);
                        intent.putExtra("hNumber", hphonecontacto);
                        intent.putExtra("Email", emailcontacto);

                        startActivity(intent);
                    }
                });

                Intent intent = new Intent(MainActivity.this,TweetAdapter.class);
                return true;
            }
        });

        tvcontact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String contactname;
                String contactnumber;
                String hnumber;
                String email;
                int idi;


                idi = contacts1.get(position).getId();
                contactname = contacts1.get(position).getName();
                contactnumber = contacts1.get(position).getNumber();
                hnumber = contacts1.get(position).getHnumber();
                email = contacts1.get(position).getEmail();


                Intent intent2 = new Intent(MainActivity.this,Profiluser.class);

                intent2.putExtra("identite", idi);
                intent2.putExtra("contactname", contactname);
                intent2.putExtra("contactnumber", contactnumber);
                intent2.putExtra("hnumber", hnumber);
                intent2.putExtra("email", email);


                startActivity(intent2);

            }
        });

         tvcontact.setAdapter(adapter);

    }
    public void addpeople(View view)
    {
        Intent intent = new Intent(MainActivity.this,Addcontact.class);
        startActivity(intent);
    }

}
