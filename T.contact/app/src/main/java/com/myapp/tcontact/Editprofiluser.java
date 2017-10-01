package com.myapp.tcontact;

/**
 * Created by hugo on 04/03/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Editprofiluser extends AppCompatActivity {

    Contact contact = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofiluser);

        EditText namecontact1 = (EditText) findViewById(R.id.editTextEname);
        EditText numbercontact1 = (EditText) findViewById(R.id.editTextEpnumber);
        EditText hnumbercontact1 = (EditText) findViewById(R.id.editTextEhnumber);
        EditText email1 = (EditText) findViewById(R.id.editTextEemail);

        String namecontacto1 = getIntent().getExtras().getString("contactName");
        String phonecontacto1 = getIntent().getExtras().getString("contactNumber");
        String hphonecontacto1 = getIntent().getExtras().getString("hNumber");
        String emailcontacto1 = getIntent().getExtras().getString("Email");

        namecontact1.setText(namecontacto1);
        numbercontact1.setText(phonecontacto1);
        hnumbercontact1.setText(hphonecontacto1);
        email1.setText(emailcontacto1);
    }


    public void Savechangecontact(View view){
        Intent intent = new Intent(Editprofiluser.this,MainActivity.class);

        DBHandler db = new DBHandler(this);

        EditText namecontact1 = (EditText) findViewById(R.id.editTextEname);
        EditText numbercontact1 = (EditText) findViewById(R.id.editTextEpnumber);
        EditText hnumbercontact1 = (EditText) findViewById(R.id.editTextEhnumber);
        EditText email1 = (EditText) findViewById(R.id.editTextEemail);

        int idi = getIntent().getExtras().getInt("identite");
        String chainename = namecontact1.getText().toString();
        String chainenumber = numbercontact1.getText().toString();
        String chainehnumber = hnumbercontact1.getText().toString();
        String chaineemail = email1.getText().toString();

        contact = db.getContact(idi);
        db.deleteContact(contact);
        contact.setName(chainename);
        contact.setNumber(chainenumber);
        contact.setHnumber(chainehnumber);
        contact.setEmail(chaineemail);
        contact.setId(idi);
        db.addContact(contact);

        startActivity(intent);
    }
}
