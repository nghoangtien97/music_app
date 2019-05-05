package assignment.mobile.playmp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private App app;
    private static final int TAB_COUNT = 4;
    private TabLayout _tabLayout;
    private ViewPager _viewPager;
    private int[] tabIcons = {
            R.drawable.menu_home,
            R.drawable.menu_search,
            R.drawable.menu_library,
            R.drawable.menu_upload
    };
    private int[] tabIconsEnable = {
            R.drawable.menu_home_enable,
            R.drawable.menu_search_enable,
            R.drawable.menu_library_enable,
            R.drawable.menu_upload_enable
    };
    private int[] tabTexts = {
            R.string.menu_home,
            R.string.menu_search,
            R.string.menu_library,
            R.string.menu_upload
    };

    View _frag_playing;
    ImageView _playing;
    ImageView _playing_pre;
    ImageView _playing_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        app = new App(this);

        initTabLayout();
        initPlayingControl();

        _tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tab.setIcon(tabIconsEnable[position]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tab.setIcon(tabIcons[position]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        _frag_playing.setOnClickListener((View v) -> {
            Intent intent = new Intent(getApplicationContext(), PlayingActivity.class);
            startActivityForResult(intent, 1);
        });

        _playing.setOnClickListener((View v) -> {
            app.toggle_playing();
            if (app.isPlaying()) {
                // TODO: continue playing song.

//                _playing.setImageResource(R.drawable.playing_play_enable);
            } else {
                // TODO: stop playing.

//                _playing.setImageResource(R.drawable.playing_stop_enable);
            }
        });

        _playing_pre.setOnClickListener((View v) -> {
            // TODO: play previous song in list
            // Change name_song, name_author

        });

        _playing_next.setOnClickListener((View v) -> {
            // TODO: play next song in list
            // Change name_song, name_author

        });
    }

    private void initTabLayout() {
        _viewPager = findViewById(R.id.viewpager);
        setupViewPager(_viewPager);

        _tabLayout = findViewById(R.id.tabs);
        _tabLayout.setupWithViewPager(_viewPager);
        setupTab();
    }

    private void initPlayingControl() {
        _frag_playing = findViewById(R.id.frag_playing);
        _playing = findViewById(R.id.playing);
        _playing_pre = findViewById(R.id.playing_pre);
        _playing_next = findViewById(R.id.playing_next);

        _playing.setImageResource(app.isPlaying()?R.drawable.playing_play_enable:R.drawable.playing_stop_enable);
    }

    private void setupTab() {
        for (int i = 0; i < TAB_COUNT; i++) {
            _tabLayout.getTabAt(i).setIcon(tabIcons[i]);
            _tabLayout.getTabAt(i).setText(tabTexts[i]);
        }
        // Menu Activity open on Home tab firstly, need to set it enable
        _tabLayout.getTabAt(0).setIcon(tabIconsEnable[0]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MenuHomeFragment(), "Home");
        adapter.addFragment(new MenuSearchFragment(), "Search");
        adapter.addFragment(new MenuLibraryFragment(), "Library");
        adapter.addFragment(new MenuUploadFragment(), "Upload");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> fragments_title = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragments_title.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments_title.get(position);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        _playing.setImageResource(app.isPlaying()?R.drawable.playing_play_enable:R.drawable.playing_stop_enable);
    }
}
