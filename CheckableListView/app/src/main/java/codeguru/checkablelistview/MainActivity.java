package codeguru.checkablelistview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SQLiteOpenHelper dbHelper = new DbHelper(this);
        String[] columns = new String[]{"_id", "word"};
        Cursor cursor = dbHelper.getWritableDatabase().query("words", columns, null, null, null, null, null);
        startManagingCursor(cursor);

        String[] from = new String[]{"word"};
        int[] to = new int[]{android.R.id.text1};
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.add_menu) {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
