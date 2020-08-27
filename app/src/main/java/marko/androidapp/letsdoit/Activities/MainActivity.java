package marko.androidapp.letsdoit.Activities;

import android.app.DatePickerDialog;
import android.os.Bundle;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import marko.androidapp.letsdoit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText title;
    private EditText description;
    private EditText datePicker;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                createPopUpDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createPopUpDialog()
    {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup, null);
        title = findViewById(R.id.title_task);
        description = findViewById(R.id.task_description);
        save = findViewById(R.id.save_btn);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();
        createCalendar();
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Todo: Save to DB
//                //Todo: Go to next screen
//
////                saveTaskToDB(v);

//            }
//        });

//        if(title.getText().toString().equals("") && description.getText().toString().equals(""))
//        {
//            title.setError("Please add name of your task");
//            description.setError("No without description, it is important!");
//        }
    }
    private void createCalendar()
    {
        //Calendar
        final Calendar calendar = Calendar.getInstance();
        datePicker = findViewById(R.id.datePicker);
        this.datePicker.setOnClickListener(this);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        datePicker.OnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        })
//        datePicker.OnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new DatePickerDialog(MainActivity.this, date,
//                        calendar.get(Calendar.YEAR),
//                        calendar.get(Calendar.MONTH),
//                        calendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
    }
//    Calendar setUp
    private void updateLabel()
    {
        String format = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ITALY);
    }
//  Update data from popup to DB
    private void saveTaskToDB(View v)
    {

    }

}