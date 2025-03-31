package fit24.duy.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IconAdapter adapter;
    private SearchView searchView;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewFlipper viewFlipper;
    private ImageView circle1, circle2, circle3;
    private Handler handler;
    private Runnable runnable;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        recyclerView = findViewById(R.id.rcIcon);
        searchView = findViewById(R.id.searchView);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewFlipper = findViewById(R.id.viewFlipper);
        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        // Thiết lập ViewFlipper
        setupViewFlipper();

        // Thiết lập RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<IconModel> iconList = createIconList();
        adapter = new IconAdapter(iconList);
        recyclerView.setAdapter(adapter);

        // Thiết lập SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        // Thiết lập ViewPager2 và TabLayout
        viewPager.setAdapter(new FragmentAdapter(this));
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Food");
                    break;
                case 1:
                    tab.setText("Movie");
                    break;
                case 2:
                    tab.setText("Song");
                    break;
                default:
                    tab.setText("Tab " + (position + 1));
            }
        }).attach();
    }

    private void setupViewFlipper() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == 3) {
                    currentPage = 0;
                }
                viewFlipper.setDisplayedChild(currentPage);
                updateCircleIndicator(currentPage);
                currentPage++;
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private void updateCircleIndicator(int position) {
        circle1.setImageResource(R.drawable.circle_unselected);
        circle2.setImageResource(R.drawable.circle_unselected);
        circle3.setImageResource(R.drawable.circle_unselected);

        switch (position) {
            case 0:
                circle1.setImageResource(R.drawable.circle_selected);
                break;
            case 1:
                circle2.setImageResource(R.drawable.circle_selected);
                break;
            case 2:
                circle3.setImageResource(R.drawable.circle_selected);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (handler != null && runnable != null) {
            handler.postDelayed(runnable, 3000);
        }
    }

    private List<IconModel> createIconList() {
        List<IconModel> list = new ArrayList<>();
        list.add(new IconModel(android.R.drawable.ic_menu_share, "Share"));
        list.add(new IconModel(android.R.drawable.ic_menu_send, "Send"));
        list.add(new IconModel(android.R.drawable.ic_menu_edit, "Edit"));
        list.add(new IconModel(android.R.drawable.ic_menu_delete, "Delete"));
        return list;
    }
} 