package codeguru.selectallexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        SelectionTracker<Long> tracker = new SelectionTracker.Builder<>(
            "selection-id",
            list,
            new StableIdKeyProvider(list),
            new DetailsLookup(list),
            StorageStrategy.createLongStorage()
        ).build();
        adapter.setSelectionTracker(tracker);
    }
}
