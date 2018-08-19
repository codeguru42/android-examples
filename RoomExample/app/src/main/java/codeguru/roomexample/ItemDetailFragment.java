package codeguru.roomexample;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import codeguru.roomexample.database.ExampleDatabase;
import codeguru.roomexample.database.Item;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";

    private Item mItem;
    private String mTitle;
    private EditText mDetailEditText;
    private CollapsingToolbarLayout appBarLayout;

    private class ItemTask extends AsyncTask<Integer, Void, Item> {
        private Context context;

        ItemTask(Context context) {
            this.context = context;
        }

        @Override
        protected Item doInBackground(Integer... ids) {
            Context context = this.context.getApplicationContext();
            ExampleDatabase database = ExampleDatabase.getInstance(context);
            return database.exampleDao().getItem(ids[0]);
        }

        @Override
        protected void onPostExecute(Item item) {
            if (item != null) {
                appBarLayout.setTitle(item.content);
                mDetailEditText.setText(item.details);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(ARG_ITEM_ID)) {
            int itemId = arguments.getInt(ARG_ITEM_ID);

            final Activity activity = this.getActivity();
            new ItemTask(activity).execute(itemId);

            if (activity != null) {
                appBarLayout = activity.findViewById(R.id.toolbar_layout);
                if (appBarLayout != null) {
                    mTitle = activity.getString(R.string.title_item, itemId);
                    appBarLayout.setTitle(mTitle);
                }
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        mDetailEditText = rootView.findViewById(R.id.item_detail);

        return rootView;
    }

    public Item getItem() {
        if (mItem == null) {
            mItem = new Item();
        }

        mItem.content = mTitle;
        mItem.details = mDetailEditText.getText().toString();
        return mItem;
    }
}
