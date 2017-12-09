package com.example.diak.menu;

import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button btn_next, btn_save, btn_inform, btn_exit;
    private TextView textv_elso;
    private AlertDialog.Builder alert;
    private String seged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        onclicklisteners();
    }

    public void init() {
        btn_next = (Button) findViewById(R.id.btn_next);
        textv_elso = (TextView) findViewById(R.id.textv_elso);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_inform = (Button) findViewById(R.id.btn_inform);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        seged = sharedPreferences.getString("name","");
        textv_elso.append(seged);

        alert = new AlertDialog.Builder(Main2Activity.this);
        alert.setMessage("Ki akarsz lépni?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener(){     //Pozitív gomb = jobb oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener(){    //Negatív gomb = bal oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }

    public void onclicklisteners(){

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(gonext);
                finish();
            }
        });

        btn_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String information = sharedPreferences.getString("name","");
                Toast.makeText(Main2Activity.this,"SharedPreference informacio: " + information,Toast.LENGTH_SHORT).show();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gosave = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(gosave);
                finish();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        });
    }
}


