package androiddive.timothy.dive;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Timothy on 11/4/2014.
 */
public class Timer extends Activity {
    public int x = 600;
    public Timer(){
       Log.v("1","New Timer Default value"+x);
    }
    public Timer(int a)
    {
        x = a;
        Log.v("1","New Timer value "+x);
    }
}
