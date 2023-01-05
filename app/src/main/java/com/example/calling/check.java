package com.example.calling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class check extends AppCompatActivity {

    private EditText edittextsum;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);





        String newString1;
        String newString2;





        TextView text1 = findViewById(R.id.vide);
        TextView text2 = findViewById(R.id.vide2);

        Bundle extras = getIntent().getExtras();
        newString1 = extras.getString("numero2");
        newString2 = extras.getString("numero1");





        text1.setText(newString1);
        text2.setText(newString2);





        Button btn1 = findViewById(R.id.buttonOK);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result;


                EditText editTextSomme = findViewById(R.id.somme);
                int userSum = Integer.parseInt(editTextSomme.getText().toString());


                result = userSum;
                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(5,intent);
                finish();
            }
        });

    }






    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(isFinishing()){
            System.exit(0);
        }
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart(){
        super.onRestart ();


        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_SHORT).show();

    }



}

