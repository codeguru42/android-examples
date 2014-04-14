package codeguru.checkablelistview;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddActivity extends ActionBarActivity {

    private SQLiteOpenHelper mDbHelper;

    private EditText mWordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDbHelper = new DbHelper(this);

        mWordText = (EditText) findViewById(R.id.word_text);

        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                CharSequence word = mWordText.getText();

                if (db != null && word != null) {
                    ContentValues values = new ContentValues();
                    values.put("word", word.toString());
                    db.insert("words", null, values);

                    mWordText.setText("");
                }
            }
        });
    }

}
