package fpt.khanhbqph21610.lab5_demo5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        drawerLayout = findViewById(R.id.drawer_layout_52);
        navigationView = findViewById(R.id.navigation_view5);
        viewPager = findViewById(R.id.demo53_ViewPager);
        tabLayout = findViewById(R.id.demo53_TabLayout);
        addTablayout(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.demo5_menu_item1) {
                    viewPager.setCurrentItem(0);
                    closeDrawer();
                    return true;
                } else if (item.getItemId() == R.id.demo5_menu_item2) {
                    viewPager.setCurrentItem(1);
                    closeDrawer();
                    return true;
                } else if (item.getItemId() == R.id.demo5_menu_item3) {
                    viewPager.setCurrentItem(2);
                    closeDrawer();
                    return true;
                }
                return false;
            }
        });
    }
private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
}

    public void addTablayout(ViewPager viewPager) {
        //tao moi adapter
        Demo53_Adapter adapter = new Demo53_Adapter(getSupportFragmentManager());
        //them fragment vao adapter
        adapter.addFrag(new BlankFragment(), "One");
        adapter.addFrag(new BlankFragment2(), "Two");
        adapter.addFrag(new BlankFragment3(), "Three");
        viewPager.setAdapter(adapter);
    }
}