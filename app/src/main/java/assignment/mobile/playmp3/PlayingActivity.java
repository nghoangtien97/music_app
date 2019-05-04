package assignment.mobile.playmp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
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
}
