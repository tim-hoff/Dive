package androiddive.timothy.dive;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;


public class AddTimer extends Activity implements View.OnClickListener  {
    private ImageButton bCheck,bCross;
    private Button bAdd;
    private LinearLayout lay,nlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timer);


        bCheck = (ImageButton)findViewById(R.id.buttonCheck);
        bCheck.setOnClickListener(this);
        bAdd=(Button) findViewById(R.id.buttonAdd);
        bAdd.setOnClickListener(this);
        lay = (LinearLayout) findViewById(R.id.LayTon);





    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonAdd){
            // do this with a struct later
            nlay= new LinearLayout(this);
            nlay.setOrientation(LinearLayout.HORIZONTAL);
            lay.addView(nlay);
            nlay.setGravity(Gravity.TOP);

            EditText nh= createEditText((String)getText(R.string.dummy_Ihour),10,0,0,0);
            nlay.addView(nh);
            nh.setNextFocusRightId(1);
            nh.setGravity(Gravity.TOP);


            TextView col1= createTextView((String)getText(R.string.dummy_col),0,0,0,0);
            nlay.addView(col1);

            EditText nm= createEditText((String)getText(R.string.dummy_Imin),0,0,0,0);
            nlay.addView(nm);

            TextView col2= createTextView((String) getText(R.string.dummy_col),0,0,0,0);
            nlay.addView(col2);

            EditText ns= createEditText((String)getText(R.string.dummy_Isec),0,0,0,0);
            nlay.addView(ns);

            TextView x = createTextView((String)getText(R.string.dummy_x),35,0,15,0);
            nlay.addView(x);

            EditText inc= createEditText((String)getText(R.string.dummy_Inc),0,0,0,0);
            nlay.addView(inc);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_timer, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private EditText createEditText(String str,int l,int t,int r,int b)
    {
        EditText edittext = new EditText(this);
        edittext.setText(str);
        edittext.setTextColor(Color.WHITE);
        edittext.setTextSize(30);
        edittext.setMaxLines(1);
        edittext.setTypeface(null, Typeface.NORMAL);



        edittext.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
        edittext.setPadding(l,t,r,b);
        edittext.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        edittext.setSelectAllOnFocus(true);
        return edittext;
    }
    private TextView createTextView(String str,int l,int t,int r,int b)
    {
        TextView textview = new TextView(this);
        textview.setText(str);
        textview.setTextColor(Color.WHITE);
        textview.setTextSize(30);
        textview.setMaxLines(1);
        textview.setTypeface(null, Typeface.NORMAL);


        if(textview.length()==1){
            textview.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            textview.setCursorVisible(false);
            textview.setFocusable(false);
            textview.setFocusableInTouchMode(false);
            textview.setFreezesText(true);
            textview.setClickable(false);

        } else {
            textview.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});

            textview.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        textview.setPadding(l,t,r,b);
        textview.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        textview.setSelectAllOnFocus(true);
        return textview;
    }

}
