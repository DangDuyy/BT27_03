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

public class MovieFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewMovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        List<ItemModel> movieItems = createMovieList();
        adapter = new ItemAdapter(movieItems);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private List<ItemModel> createMovieList() {
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Avengers", "Phim siêu anh hùng", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Batman", "Phim siêu anh hùng DC", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Spider-Man", "Người nhện", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Iron Man", "Người sắt", android.R.drawable.ic_menu_gallery));
        return list;
    }
} 