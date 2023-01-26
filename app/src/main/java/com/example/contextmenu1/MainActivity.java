package com.example.contextmenu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText et1,et2;
    ToggleButton tg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tg = (ToggleButton) findViewById(R.id.tg);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);



        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        String st = item.getTitle().toString();
        if(st.equals("Cradits")){
            Intent dorel2 = new Intent(this,ThirdActivity.class);
            startActivity(dorel2);
        }
        return true;
    }


    public static boolean dorel6969(String doreli){
        if(doreli.equals("") || doreli.equals(".") || doreli.equals("-.") || doreli.equals("-")){
            return(false);
        }
        else{
            return (true);
        }
    }

    public void dorel1(View view) {
        String st1 = et1.getText().toString();
        String st2 = et2.getText().toString();
        boolean dorrrl = dorel6969(st1);
        boolean dorrrl2 = dorel6969(st2);
        if(dorrrl==true && dorrrl2==true){
            double x1 = Double.parseDouble(st1);
            double x2 = Double.parseDouble(st2);
            boolean nom = tg.isChecked();
            Intent si = new Intent(this,SecondActivity.class);
            si.putExtra("n",x1);
            si.putExtra("nn",x2);
            si.putExtra("nnn",nom);
            startActivity(si);
        }
        else{
            Toast.makeText(this, "you stupido!!", Toast.LENGTH_SHORT).show();
        }


    }
}