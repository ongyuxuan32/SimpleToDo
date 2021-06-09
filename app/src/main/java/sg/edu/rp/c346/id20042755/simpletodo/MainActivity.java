package sg.edu.rp.c346.id20042755.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnadd, btnclearall;
    ListView lvToDo;
    ArrayList<String> altodo;
    ArrayAdapter<String>aatodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnadd = findViewById(R.id.buttonAdd);
        btnclearall = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.Listviewtask);

        altodo = new ArrayList<>();
        aatodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, altodo);
        lvToDo.setAdapter(aatodo);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = editText.getText().toString();
                altodo.add(newTodo);
                aatodo.notifyDataSetChanged();
                editText.setText(null);
            }
        });

        btnclearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altodo.clear();
                aatodo.notifyDataSetChanged();
            }
        });
    }
}