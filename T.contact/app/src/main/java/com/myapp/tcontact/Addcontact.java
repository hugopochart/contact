package com.myapp.tcontact;

/**
 * Created by hugo on 04/03/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class Addcontact extends AppCompatActivity {


    EditText editText1;
    EditText editText2;
    EditText editText12;
    EditText editText13;
    Contact contact = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
    }

    public void editcontact(View view)
    {

        DBHandler db = new DBHandler(this);

        editText1 = (EditText) findViewById (R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);

        String chainename = editText1.getText().toString();
        String chainenumber = editText2.getText().toString();
        String chainehnumber = editText12.getText().toString();
        String chaineemail = editText13.getText().toString();

        Random generator = new Random();
        int r = generator.nextInt(1000000000) + 1;

        contact.setId(r);
        contact.setName(chainename);
        contact.setNumber(chainenumber);
        contact.setHnumber(chainehnumber);
        contact.setEmail(chaineemail);

        db.addContact(contact);

        Intent intent = new Intent(Addcontact.this,MainActivity.class);
        startActivity(intent);

    }
}
