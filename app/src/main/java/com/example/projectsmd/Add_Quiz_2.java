package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Add_Quiz_2 extends AppCompatActivity {

    EditText question;
    Button btn_add_question;
    Button view_question;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper databaseHelper;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz2);
        question = findViewById(R.id.question_type_2);
        btn_add_question = findViewById(R.id.add_btn);
        view_question = findViewById(R.id.view_btn);
        openHelper = new DatabaseHelper(this);
        databaseHelper = new DatabaseHelper(this);

        //Intent key_intent = getIntent();
//        key = key_intent.getExtras().getString("Key");
        getData();

        //type and add question here
        btn_add_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String statement = question.getText().toString();


                if (statement.length() != 0) {


                    insertData(statement,key);
                    question.setText("");


                } else {

                    Toast.makeText(Add_Quiz_2.this, "ADD QUESTION IN THE TEXT BOX.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //view remaining questions
        view_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Add_Quiz_2.this, Fill_in_the_blank_quiz.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {

        ArrayList<String> list = new ArrayList<String>();
        db = openHelper.getReadableDatabase();

        Cursor data = databaseHelper.getQuizList();

        if (data.getCount() == 0) {

            Toast.makeText(this, "no q list", Toast.LENGTH_SHORT).show();
        } else {

            while (data.moveToNext()) {

                list.add(data.getString(1));

            }

            for (String str : list) {

                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            }
        }
    }

    //adding data in database
    private void insertData(String statement, String key) {


        db= openHelper.getWritableDatabase();
/*
        Cursor cursor = db.rawQuery("SELECT TITLE" +
                " FROM " +
                DatabaseHelper.TABLE_NAME4 +
                " WHERE " +
                DatabaseHelper.COL_17 +
                "=?", new String[]{key});


        if (cursor.getCount() != 0) {

            //String name = cursor.getString(1);


            Toast.makeText(this,"dtaa", Toast.LENGTH_SHORT).show();


        } else {

            Toast.makeText(this, "no data in t4", Toast.LENGTH_SHORT).show();


        }*/
        ContentValues contentValues = new ContentValues();
        // contentValues.put(DatabaseHelper.COL_2 , type);
       // contentValues.put(DatabaseHelper.COL_8, key);
        contentValues.put(DatabaseHelper.COL_7, statement);
        contentValues.put(DatabaseHelper.COL_18, "Fill in the blank");

        long id = db.insert(DatabaseHelper.TABLE_NAME2, null, contentValues);

        if (id == -1) {

            Toast.makeText(this, "data write failed", Toast.LENGTH_SHORT).show();

        } else {


            Toast.makeText(this, "data write successful", Toast.LENGTH_SHORT).show();
        }


    }
}