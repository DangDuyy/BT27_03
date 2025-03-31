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

public class SongFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        List<ItemModel> songItems = createSongList();
        adapter = new ItemAdapter(songItems);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private List<ItemModel> createSongList() {
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Shape of You", "Ed Sheeran", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Blinding Lights", "The Weeknd", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Dance Monkey", "Tones and I", android.R.drawable.ic_menu_gallery));
        list.add(new ItemModel("Stay With Me", "Sam Smith", android.R.drawable.ic_menu_gallery));
        return list;
    }
} 