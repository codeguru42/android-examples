package codeguru.selectallexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] data;
    private SelectionTracker<Long> tracker;

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    Adapter(Context context) {
        data = context.getResources().getStringArray(R.array.data);
        this.setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView view = new TextView(viewGroup.getContext());
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        TextView textView = (TextView) viewHolder.itemView;
        textView.setText(data[pos]);
        if (tracker.isSelected((long)pos)) {
            textView.setBackgroundResource(android.R.color.holo_red_dark);
        } else {
            textView.setBackgroundResource(android.R.color.transparent);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    void setSelectionTracker(SelectionTracker<Long> tracker) {
        this.tracker = tracker;
    }
}
