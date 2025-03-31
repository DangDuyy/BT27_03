package fit24.duy.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FoodFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        List<ItemModel> foodItems = createFoodList();
        adapter = new ItemAdapter(foodItems);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private List<ItemModel> createFoodList() {
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Phở", "Món ăn truyền thống Việt Nam", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Bánh mì", "Bánh mì thịt ngon", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Cơm sườn", "Cơm sườn nướng", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Bún chả", "Bún chả Hà Nội", android.R.drawable.ic_menu_gallery));
        return list;
    }
} 