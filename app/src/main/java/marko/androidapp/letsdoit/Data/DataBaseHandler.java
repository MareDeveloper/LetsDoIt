package marko.androidapp.letsdoit.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import marko.androidapp.letsdoit.Model.Task;
import marko.androidapp.letsdoit.Util.Constants;

public class DataBaseHandler extends SQLiteOpenHelper {
    private Context ctx;
    public DataBaseHandler(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TASK_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY," + Constants.KEY_TASK_NAME + " TEXT,"
                + Constants.KEY_TASK_DESC + " TEXT," + Constants.KEY_TASK_NUMBER + " TEXT,"
                + Constants.KEY_DATE_NAME + " LONG,"
                + Constants.KEY_DO_DATE_NAME + "LONG);";

        db.execSQL(CREATE_TASK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

//    Add task
    public void addTask(Task task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_TASK_NAME, task.getName());
        values.put(Constants.KEY_TASK_DESC, task.getDescription());
        values.put(Constants.KEY_DATE_NAME, task.getDateItemAdded());
        values.put(Constants.KEY_DO_DATE_NAME, task.getDoDate());

//        Insert into row
        db.insert(Constants.TABLE_NAME, null, values);
        Log.d("SAVED!", "Saved to DB");
    }

//    Get a task
    private Task getTask(int id)
    {
//        TODO: You stopped here.
        return null;
    }

//    Get all tasks
    public List<Task> getAllTasks()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Task> taskList = new ArrayList<>();

        Cursor cursor = db.query(Constants.TABLE_NAME, new String[] {
            Constants.KEY_ID, Constants.KEY_TASK_NAME, Constants.KEY_TASK_DESC,
            Constants.KEY_DATE_NAME, Constants.KEY_DO_DATE_NAME}, null, null, null, null, Constants.KEY_DATE_NAME + " DESC");

        if(cursor.moveToFirst())
        {
            do {
                Task task = new Task();
                task.getId();
            }while (cursor.moveToNext());
        }

        return null;
    }

//    Update tasks
    public int updateTasks(Task task)
    {
        return 0;
    }

//    Delete task
    public void deleteTasl(int id)
    {

    }

//    Get count
    public int getTaskCount()
    {
        return 0;
    }
}
