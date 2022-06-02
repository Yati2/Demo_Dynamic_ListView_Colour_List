package sg.edu.rp.c346.id20028056.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etColour,etIndex;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.etColour);
        etIndex=findViewById(R.id.etIndex);
        btnAdd = findViewById(R.id.btnAddColour);
        lvColour = findViewById(R.id.listViewColour);

        alColour = new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");

        aaColour = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alColour);

        lvColour.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String colour = etColour.getText().toString();
                colour = colour.substring(0, 1).toUpperCase() + colour.substring(1, colour.length()).toLowerCase();
                int index=Integer.parseInt(etIndex.getText().toString());
                alColour.add(index,colour);
                etColour.setText("");
                etIndex.setText("");

                aaColour.notifyDataSetChanged();

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,alColour.get(i),Toast.LENGTH_SHORT).show();

            }
        });

    }
}