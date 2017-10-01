package com.myapp.tcontact;

/**
 * Created by hugo on 04/03/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profiluser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiluser);

        TextView namecontact = (TextView) findViewById(R.id.textViewName);
        TextView numbercontact = (TextView) findViewById(R.id.textViewPhone);
        TextView hnumbercontact = (TextView) findViewById(R.id.textViewHphone);
        TextView email = (TextView) findViewById(R.id.textViewEmail);

        int idi = getIntent().getExtras().getInt("identite");
        String namecontacto = getIntent().getExtras().getString("contactname");
        String phonecontacto = getIntent().getExtras().getString("contactnumber");
        String hphonecontacto = getIntent().getExtras().getString("hnumber");
        String emailcontacto = getIntent().getExtras().getString("email");

        namecontact.setText(namecontacto);
        numbercontact.setText(phonecontacto);
        hnumbercontact.setText(hphonecontacto);
        email.setText(emailcontacto);

    }

    public void Editeditcontact (View view)
    {
        int idi = getIntent().getExtras().getInt("identite");
        String namecontacto = getIntent().getExtras().getString("contactname");
        String phonecontacto = getIntent().getExtras().getString("contactnumber");
        String hphonecontacto = getIntent().getExtras().getString("hnumber");
        String emailcontacto = getIntent().getExtras().getString("email");

        Intent intent = new Intent(Profiluser.this,Editprofiluser.class);

        intent.putExtra("identite", idi);
        intent.putExtra("contactName", namecontacto);
        intent.putExtra("contactNumber", phonecontacto);
        intent.putExtra("hNumber", hphonecontacto);
        intent.putExtra("Email", emailcontacto);

        startActivity(intent);
    }

    public void deletecontact (View view){

        Intent intent = new Intent(Profiluser.this,MainActivity.class);
        int idi = getIntent().getExtras().getInt("identite");
        final DBHandler db = new DBHandler(this);
        db.deleteContact(db.getContact(idi));
        startActivity(intent);
    }
    public void backto (View view)
    {
        Intent intent = new Intent(Profiluser.this,MainActivity.class);
        startActivity(intent);

    }
}
