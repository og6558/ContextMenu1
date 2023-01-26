package com.example.contextmenu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements  View.OnCreateContextMenuListener {
    TextView tv7;
    ListView lisv3;
    String[] list1 = new String[20];
    Double[] arr2 = new Double[20];
    double first, num1;
    boolean nom1;

    int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv7 = findViewById(R.id.tv7);
        lisv3 = findViewById(R.id.lisv3);
        Intent gi = getIntent();
        first = gi.getDoubleExtra("n", 0);
        num1 = gi.getDoubleExtra("nn", 0);
        nom1 = gi.getBooleanExtra("nnn", true);
        lisv3.setOnCreateContextMenuListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list1);
        lisv3.setAdapter(adp);
        lisv3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lisv3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                res = i;
                return false;
            }
        });

        if (nom1 == true) {
            Mathemtical();
        } else {
            Geometrical();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);



        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("Cradits")) {
            Intent dorel2 = new Intent(this, ThirdActivity.class);
            startActivity(dorel2);
        }
        if(st.equals("Start")) {
            Intent dorel2 = new Intent(this, MainActivity.class);
            startActivity(dorel2);
        }
        return true;
    }


    public void Mathemtical() {
        for (int i = 0; i < 20; i++) {
            arr2[i] = first;
            int x = dorelkrief(Double.toString(first));
            String str1 = String.format("%.02f", first);
            if (x > 2) {
                list1[i] = str1 + "E" + Integer.toString(x - 2);
            } else {
                list1[i] = str1;
            }
            first = first + num1;
        }
    }

    public void Geometrical() {
        for (int ii = 0; ii < 20; ii++) {
            arr2[ii] = first;
            int y = dorelkrief(Double.toString(first));
            String str4 = String.format("%.02f", first);
            if (y > 2) {
                list1[ii] = str4 + "E" + Integer.toString(y - 2);
            } else {
                list1[ii] = str4;
            }
            first = first * num1;
        }
    }

    public int dorelkrief(String lol) {
        int q = lol.indexOf(".");
        int E = lol.indexOf("E");
        if (E == -1) {
            return (lol.substring(q + 1)).length();
        } else {
            return (lol.substring(q + 1)).length() + Integer.parseInt(lol.substring(E + 1));
        }
    }



    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Choose Carefuly");
        menu.add("place of this number:");
        menu.add("sum until this number:");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String oper = item.getTitle().toString();
        Double all = 0.0;

        if (oper.equals("place of this number:")) {
            tv7.setText("" + res);

        } else if (oper.equals("sum until this number:")) {
            for (int m = 0; m < res + 1; m++) {
                all = all + arr2[m];
            }
            String str5 = String.format("%.02f", all);
            tv7.setText( "" +str5);


        }
        return super.onContextItemSelected(item);
    }
}

