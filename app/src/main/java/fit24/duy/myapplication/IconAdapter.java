package fit24.duy.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconViewHolder> implements Filterable {
    private List<IconModel> iconList;
    private List<IconModel> iconListFull;

    public IconAdapter(List<IconModel> iconList) {
        this.iconList = iconList;
        this.iconListFull = new ArrayList<>(iconList);
    }

    @NonNull
    @Override
    public IconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_icon_promotion, parent, false);
        return new IconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconViewHolder holder, int position) {
        IconModel currentItem = iconList.get(position);
        holder.icon.setImageResource(currentItem.getIconResource());
        holder.title.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    @Override
    public Filter getFilter() {
        return iconFilter;
    }

    private Filter iconFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<IconModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(iconListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (IconModel item : iconListFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            iconList.clear();
            iconList.addAll((List<IconModel>) results.values);
            notifyDataSetChanged();
        }
    };

    static class IconViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;

        IconViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }
} 