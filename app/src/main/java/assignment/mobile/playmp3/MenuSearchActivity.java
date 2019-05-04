package assignment.mobile.playmp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuSearchActivity extends AppCompatActivity {

    private Tools tools;

    ImageView _img_home;
    ImageView _img_search;
    ImageView _img_library;
    ImageView _img_upload;
    TextView _text_home;
    TextView _text_search;
    TextView _text_library;
    TextView _text_upload;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_search);

        tools = new Tools(this.getResources());
        _img_home = findViewById(R.id.img_home);
        _img_search = findViewById(R.id.img_search);
        _img_library = findViewById(R.id.img_library);
        _img_upload = findViewById(R.id.img_upload);
        _text_home = findViewById(R.id.text_home);
        _text_search = findViewById(R.id.text_search);
        _text_library = findViewById(R.id.text_library);
        _text_upload = findViewById(R.id.text_upload);

        tools.setMenuEnable(_img_search, R.drawable.menu_search_enable, _text_search);
        tools.setMenuDisable(_img_home, R.drawable.menu_home, _text_home);
        tools.setMenuDisable(_img_library, R.drawable.menu_library, _text_library);
        tools.setMenuDisable(_img_upload, R.drawable.menu_upload, _text_upload);

        _img_home.setOnClickListener((View v) -> {
            Intent intent = new Intent(getApplicationContext(), MenuHomeActivity.class);
            startActivity(intent);
        });

        _img_library.setOnClickListener((View v) -> {
            Intent intent = new Intent(getApplicationContext(), MenuLibraryActivity.class);
            startActivity(intent);
        });

        _img_upload.setOnClickListener((View v) -> {
            Intent intent = new Intent(getApplicationContext(), MenuUploadActivity.class);
            startActivity(intent);
        });
    }
}
