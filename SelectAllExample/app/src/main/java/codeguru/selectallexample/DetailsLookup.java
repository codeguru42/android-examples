package codeguru.selectallexample;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

class DetailsLookup extends ItemDetailsLookup<Long> {
    private RecyclerView list;

    class ItemDetails extends ItemDetailsLookup.ItemDetails<Long> {
        private int position;

        ItemDetails(int position) {
            this.position = position;
        }

        @Override
        public int getPosition() {
            return position;
        }

        @Nullable
        @Override
        public Long getSelectionKey() {
            return (long) position;
        }
    }

    DetailsLookup(RecyclerView list) {
        this.list = list;
    }

    @Nullable
    @Override
    public ItemDetails getItemDetails(@NonNull MotionEvent e) {
        View view = list.findChildViewUnder(e.getX(), e.getY());
        if (view != null) {
            RecyclerView.ViewHolder holder = list.getChildViewHolder(view);
            return new ItemDetails(holder.getAdapterPosition());
        }
        return null;
    }
}
