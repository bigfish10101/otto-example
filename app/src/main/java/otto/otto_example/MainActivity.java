package otto.otto_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ottotool.OttoEvent;
import ottotool.OttoTool;

import com.squareup.otto.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OttoTool.share().register(this);

        Button postBtn = (Button) findViewById(R.id.postOttoBtn);
        if (postBtn != null) {

            postBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    OttoTool.share().postOttoEvent(new OttoEvent(2));
                }
            });
        }
    }

    @Subscribe
    public void receiveOttoMessage(OttoEvent event) {

        Log.i("MainActivity", "receiveOttoMessage -> " + String.valueOf(event.event));

        Toast.makeText(this, "receiveOttoMessage" + String.valueOf(event.event), Toast.LENGTH_SHORT).show();
    }
}
