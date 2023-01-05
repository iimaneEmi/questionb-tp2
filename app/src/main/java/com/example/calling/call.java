package com.example.calling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class call extends AppCompatActivity {
    Button btn_call;

    public void valider2(View view){

        Intent intent = new Intent(call.this,MainActivity.class);
        Toast.makeText(getApplicationContext(),"acces à l'appel",Toast.LENGTH_SHORT).show();


        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);



        btn_call = (Button) findViewById(R.id.Call);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(call.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"vous pouvez effectuer votre ",Toast.LENGTH_SHORT).show();

                startActivity(intent);



            }
        });
    }
}