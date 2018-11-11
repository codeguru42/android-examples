package codeguru.selectallexample;

import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.view.ActionMode;

public class ActionModeCallback implements ActionMode.Callback {
    private MainActivity activity;

    ActionModeCallback(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        activity.getMenuInflater().inflate(R.menu.context, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done:
                activity.showSelected();
                break;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
