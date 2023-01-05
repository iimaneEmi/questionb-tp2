package com.example.calling;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int request = 1;

    private EditText mEditTextNumber;
    private static EditText editText1;
    private static EditText editText2;

    public static EditText editTextUrl;
    public static int sum_action = 0;
    private String N1,N2;


    Button EMI ;


    public void valider(View view){

        Intent intent = new Intent(MainActivity.this,call.class);

        startActivity(intent);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mEditTextNumber = findViewById(R.id.editText_number);
        ImageView imageCall = findViewById(R.id.image_call);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);



       imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });


        ImageView buttonweb = findViewById(R.id.buttonweb);


        buttonweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                N1= editText1.getText().toString();
                N2= editText2.getText().toString();


                Intent intent = new Intent(MainActivity.this,check.class);
                intent.putExtra("numero1",N1);
                intent.putExtra("numero2",N2);
                sum_action = 1;

                startActivityForResult(intent,5);
            }
        });


    }


    private void makePhoneCall(){
        // enregistrer nombre tapé sur nulber
        String number = mEditTextNumber.getText().toString();
        if(number.trim().length() > 0){

           if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
               ActivityCompat.requestPermissions(MainActivity.this,
                       new String[] {Manifest.permission.CALL_PHONE}, request);
           }

           else {//actial call
               String dial = "tel:" +number;
               startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
           }

        }
        //s'il ne tape rien show msg
        else {
            Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == request) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String n = data.getStringExtra("result");

        if(resultCode==5){
        String url = "";
        if (url.isEmpty()) {
            url = "https://www.emi.ac.ma/";
        } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        sum_action = 0;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);


        }

    }
}