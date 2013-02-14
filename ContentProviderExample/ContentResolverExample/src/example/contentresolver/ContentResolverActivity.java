package example.contentresolver;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import example.contentprovider.ExampleContract;

public class ContentResolverActivity extends ListActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Cursor cursor = this.getContentResolver().query(ExampleContract.EXAMPLE_URI, ExampleContract.ALL_COLS, null, null, null);
        int[] to = {android.R.id.text1};
        ListAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, ExampleContract.ALL_COLS, to);
        this.startManagingCursor(cursor);
        this.setListAdapter(adapter);
    }
}
