package androiddive.timothy.dive;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Timothy on 11/4/2014.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button button = (Button) ;
        findViewById(R.id.dummy_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Timer Timer1 = new Timer();
            }
        });
        findViewById(R.id.dummy_add).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = 0;

                EditText eh = (EditText) findViewById(R.id.editHour);
                EditText em = (EditText) findViewById(R.id.editHour);
                EditText es = (EditText) findViewById(R.id.editHour);
                try{
                    a = ((Integer.parseInt(eh.getText().toString())*3600)+
                         (Integer.parseInt(em.getText().toString())*60)+
                         (Integer.parseInt(es.getText().toString())));

                    //a = (Integer.parseInt(eh.getText().toString()));
                } catch (NumberFormatException nfe){
                    Log.e("nfe", "could not parse" + nfe);
                }

                Timer Timer2 = new Timer(a);
            }
        });
    }

}


