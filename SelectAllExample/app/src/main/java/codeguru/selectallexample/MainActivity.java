package codeguru.selectallexample;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.selection.Selection;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private SelectionTracker<Long> tracker;
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        tracker = new SelectionTracker.Builder<>(
            "selection-id",
            list,
            new StableIdKeyProvider(list),
            new DetailsLookup(list),
            StorageStrategy.createLongStorage()
        ).build();
        tracker.addObserver(new SelectionObserver(this));
        adapter.setSelectionTracker(tracker);
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode actionMode) {
        super.onSupportActionModeStarted(actionMode);
        this.actionMode = actionMode;
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        super.onSupportActionModeFinished(mode);
        tracker.clearSelection();
    }

    public void showSelected() {
        Selection<Long> selection = tracker.getSelection();
        List<Long> selectedIds = new ArrayList<>();

        for (long id: selection) {
            selectedIds.add(id);
        }
        Toast.makeText(this, selectedIds.toString(), Toast.LENGTH_LONG).show();
        actionMode.finish();
    }
}
