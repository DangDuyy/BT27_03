package fit24.duy.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<ItemModel> items;
    private List<ItemModel> itemsFull;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
        this.itemsFull = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImageResourceId());
        holder.titleTextView.setText(currentItem.getTitle());
        holder.descriptionTextView.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filter(String text) {
        items.clear();
        if (text.isEmpty()) {
            items.addAll(itemsFull);
        } else {
            text = text.toLowerCase();
            for (ItemModel item : itemsFull) {
                if (item.getTitle().toLowerCase().contains(text) ||
                    item.getDescription().toLowerCase().contains(text)) {
                    items.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
} 