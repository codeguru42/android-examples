package codeguru.roomexample;

import android.app.Activity;
import android.content.Context;
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
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private int mItemId;
    private Item mItem;
    private String mTitle;
    private EditText mDetailEditText;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItemId = arguments.getInt(ARG_ITEM_ID);

            final Activity activity = this.getActivity();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (activity != null) {
                        Context context = activity.getApplicationContext();
                        ExampleDatabase database = ExampleDatabase.getInstance(context);
                        mItem = database.exampleDao().getItem(mItemId).getValue();
                    }
                }
            });

            if (activity != null) {
                CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
                if (appBarLayout != null) {
                    mTitle = activity.getString(R.string.title_item, mItemId);
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

        if (mItem != null) {
            mDetailEditText.setText(mItem.details);
        }

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
