package assignment.mobile.playmp3;

import android.app.Activity;
import android.widget.ImageView;

public class App {
    private Activity activity;

    private static boolean has_played = false;
    private static boolean playing = false;
    private static boolean shuffle = false;
    private static int repeated = 0;    // 0: disable, 1: enable (repeat list), 2: repeat one

    public App(Activity activity) {
        this.activity = activity;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
        this.has_played = true;
    }

    public boolean isHas_played() {
        return has_played;
    }

    public boolean isPlaying() {
        return playing;
    }

    public int getRepeated() {
        return repeated;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void toggle_playing() {
        this.playing = !this.playing;
        this.has_played = true;
        ImageView _playing = activity.findViewById(R.id.playing);
        _playing.setImageResource(playing?R.drawable.playing_play_enable:R.drawable.playing_stop_enable);
    }

    public void toggle_shuffle() {
        this.shuffle = !this.shuffle;
        ImageView _playing_shuffle = activity.findViewById(R.id.playing_shuffle);
        _playing_shuffle.setImageResource(shuffle?R.drawable.playing_shuffle_enable:R.drawable.playing_shuffle);
    }

    public void toggle_repeated() {
        this.repeated = (++this.repeated) % 3;
        ImageView _playing_repeat = activity.findViewById(R.id.playing_repeat);
        if (repeated == 0) {
            _playing_repeat.setImageResource(R.drawable.playing_repeat);
        } else if (repeated == 1) {
            _playing_repeat.setImageResource(R.drawable.playing_repeat_enable);
        } else {
            _playing_repeat.setImageResource(R.drawable.playing_repeat_one);
        }
    }
}
