package sharedpreferences.androidatc.com.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText enterData;
    private TextView showData;
    private Button save;
    private Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showData = (TextView) findViewById(R.id.load_data);
        enterData = (EditText) findViewById(R.id.enter_data);
        save = (Button) findViewById(R.id.save);
        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);
        show.setEnabled(false);

        if (LoadPreferences().length() > 0) {
            show.setEnabled(true);
        }
        }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.save:
                    SavePreferences("save", enterData.getText().toString());
                    show.setEnabled(true);
                    break;
                case R.id.show:
                    showData.setText(LoadPreferences());
                    break;
            }
        }


    private void SavePreferences(String key, String value) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private String LoadPreferences() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedData = sharedPreferences.getString("save", "");
        return savedData;
    }
}



