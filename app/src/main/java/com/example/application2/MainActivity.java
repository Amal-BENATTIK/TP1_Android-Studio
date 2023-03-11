package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String[] item={"Euro","US Dollar"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    String choix,montant;
    Button btn;
    EditText etd;
    TextView txt;
    Double change;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        autoCompleteTextView=findViewById(R.id.auto_complete_textview);
        etd=findViewById(R.id.editTextNumberDecimal);
        txt=findViewById(R.id.textView3);
        adapterItems= new ArrayAdapter<String>(this,R.layout.list_item,item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l ) {
                choix=adapterView.getItemAtPosition(i).toString();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant=etd.getText().toString();
                if(choix!="")
                {

                    if(montant!="")
                    {
                        switch (choix){
                            case "Euro": change=Double.parseDouble(montant)*11;
                                break;
                            case "US Dollar": change=Double.parseDouble(montant)*10;
                                break;

                        }
                        txt.setText(change+" DHs");
                    }
                    else {
                        txt.setText("veuillez taper un montant");
                    }

                }
                else {
                    txt.setText("veuillez faire votre choix");
                }

            }
        });
    }
}