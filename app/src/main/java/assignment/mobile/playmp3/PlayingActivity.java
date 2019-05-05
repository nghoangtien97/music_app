package assignment.mobile.playmp3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity  {

    private boolean is_playing = true;
    private boolean is_shuffled = false;
    private int is_repeated = 0;

    ImageView _playing;
    ImageView _playing_shuffle;
    ImageView _playing_repeat;
    ImageView _playing_pre;
    ImageView _playing_next;
    ImageView _btn_back;
    ImageView _btn_add;
    TextView _name_song;
    TextView _name_author;

    ViewPager _view_pager;
    IntroViewPagerAdapter _pager_adapter;
    LinearLayout _dots_layout;
    TextView[] _dots;
    int[] _layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        _playing = findViewById(R.id.playing);
        _playing_shuffle = findViewById(R.id.playing_shuffle);
        _playing_repeat = findViewById(R.id.playing_repeat);
        _playing_pre = findViewById(R.id.playing_pre);
        _playing_next = findViewById(R.id.playing_next);
        _btn_back = findViewById(R.id.btn_back);
        _btn_add = findViewById(R.id.btn_add);
        _name_song = findViewById(R.id.name_song);
        _name_author = findViewById(R.id.name_author);

        _view_pager = findViewById(R.id.view_pager);
        _dots_layout = findViewById(R.id.layout_dots);
        _layouts = new int[]{R.layout.playing_main, R.layout.playing_lyrics};
        addBottomDots(0);
        _pager_adapter = new IntroViewPagerAdapter();
        _view_pager.setAdapter(_pager_adapter);
        _view_pager.addOnPageChangeListener(mViewPagerChangeListener);

        _playing.setOnClickListener((View v) -> {
            is_playing = !is_playing;
            if (is_playing) {
                // TODO: continue playing song.

                _playing.setImageResource(R.drawable.playing_play_enable);
            } else {
                // TODO: stop playing.

                _playing.setImageResource(R.drawable.playing_stop_enable);
            }
        });

        _playing_shuffle.setOnClickListener((View v) -> {
            is_shuffled = !is_shuffled;
            if (is_shuffled) {
                // TODO: random playlist

                _playing_shuffle.setImageResource(R.drawable.playing_shuffle_enable);
            } else {
                // TODO: disable random

                _playing_shuffle.setImageResource(R.drawable.playing_shuffle);
            }
        });

        _playing_repeat.setOnClickListener((View v) -> {
            // 0: disable, 1: enable (repeat list), 2: repeat one
            is_repeated = (++is_repeated) % 3;
            switch (is_repeated) {
                // TODO: disable repeated
                case 0: {

                    _playing_repeat.setImageResource(R.drawable.playing_repeat);
                    break;
                }
                // TODO: repeat all list
                case 1: {

                    _playing_repeat.setImageResource(R.drawable.playing_repeat_enable);
                    break;
                }
                // TODO: repeat current song
                case 2: {

                    _playing_repeat.setImageResource(R.drawable.playing_repeat_one);
                    break;
                }
                default: {
                }
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

        _btn_back.setOnClickListener((View v) -> {
            // Back to previous activity
            finish();
        });

        _btn_add.setOnClickListener((View v) -> {
            // TODO: Add current song to library

        });
    }


    // TODO: Implement methods here







    private ViewPager.OnPageChangeListener mViewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addBottomDots(int currentPage) {
        _dots = new TextView[_layouts.length];
        _dots_layout.removeAllViews();

        int normalColor = getResources().getColor(R.color.white);
        int enableColor = getResources().getColor(R.color.enable);

        for (int i = 0; i < _dots.length; i++) {
            _dots[i] = new TextView(this);
            _dots[i].setText(Html.fromHtml("."));
            _dots[i].setTextSize(35);
            _dots[i].setTextColor(normalColor);
            _dots_layout.addView(_dots[i]);
        }
        if (_dots.length > 0) {
            _dots[currentPage].setTextColor(enableColor);
        }
    }

    public class IntroViewPagerAdapter extends PagerAdapter {
        private LayoutInflater inflater;

        public IntroViewPagerAdapter() {
            super();
        }

        @Override
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(_layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return _layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view,@NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position,@NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}

