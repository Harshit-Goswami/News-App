package com.harshit.goswami.newsupdate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.harshit.goswami.newsupdate.Modas.MainModal;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem fhome, fscience, fsport, fentertainment, ftechnology, fhelth, fBusiness;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    RecyclerView recyclerView;
    String ApiKey = "4f4023536ae14b40af4913dd68dcad18";
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            fhome = findViewById(R.id.home);
            fhelth = findViewById(R.id.helth);
            fscience = findViewById(R.id.science);
            fsport = findViewById(R.id.sport);
            fentertainment = findViewById(R.id.entertainment);
            ftechnology = findViewById(R.id.technology);
            fBusiness = findViewById(R.id.business);

            ViewPager viewPager = findViewById(R.id.fragmentcontainer);
            tabLayout = findViewById(R.id.include);

            pagerAdapter = new pagerAdapter(getSupportFragmentManager(), 7);
            viewPager.setAdapter(pagerAdapter);

            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                    if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 ||
                            tab.getPosition() == 4 || tab.getPosition() == 5 || tab.getPosition() == 6) {
                        pagerAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


      /*  toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent =new Intent(getApplicationContext(),SearchActivity.class);
                return true;
            }
        });
*/
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.search_menu, menu);
            MenuItem menuItem = menu.findItem(R.id.search_button);
            SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setQueryHint("Type here to search.");

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                    intent.putExtra("query", query);
                    startActivity(intent);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            return super.onCreateOptionsMenu(menu);

    }
}