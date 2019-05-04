package assignment.mobile.playmp3;

import android.content.res.Resources;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Tools {
    private int normalColor;
    private int enableColor;

    public Tools(Resources resources) {
        normalColor = resources.getColor(R.color.white);
        enableColor = resources.getColor(R.color.enable);
    }

    public void setMenuEnable(ImageView imageView, int imageID, TextView textView) {
        imageView.setImageResource(imageID);
        textView.setTextColor(enableColor);
    }

    public void setMenuDisable(ImageView imageView, int imageID, TextView textView) {
        imageView.setImageResource(imageID);
        textView.setTextColor(normalColor);
    }
}
