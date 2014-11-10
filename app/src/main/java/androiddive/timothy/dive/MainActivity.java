package androiddive.timothy.dive;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Timothy on 11/4/2014.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private Button bStart,bStop, db, da;
    private EditText eh,em,es;
    private long totalTime,incrementalTime;
    private CountDownTimer countDownTimer;
    private KeyListener lh,lm,ls;
    public int x = 600;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bStart = (Button)findViewById(R.id.buttonStartTimer);
        bStop = (Button)findViewById(R.id.buttonStopTimer);
        db = (Button)findViewById(R.id.dummy_button);
        da = (Button)findViewById(R.id.dummy_add);
        eh = (EditText) findViewById(R.id.editHour);
        em = (EditText) findViewById(R.id.editMin);
        es = (EditText) findViewById(R.id.editSeconds);

        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
        db.setOnClickListener(this);
        da.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        if(v.getId()==R.id.buttonStartTimer){

            setTimer();
            bStop.setVisibility(View.VISIBLE);
            bStart.setVisibility(View.GONE);
            lh=eh.getKeyListener();
            lm=em.getKeyListener();
            ls=es.getKeyListener();
            sl(eh);
            sl(em);
            sl(es);

            startTimer();
        } else if (v.getId() == R.id.buttonStopTimer){
            countDownTimer.cancel();
            bStop.setVisibility(View.GONE);
            bStart.setVisibility(View.VISIBLE);
            eh.setKeyListener(lh);
            em.setKeyListener(lm);
            es.setKeyListener(ls);
            stl(eh);
            stl(em);
            stl(es);
        } else if(v.getId()==R.id.dummy_button){
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        } else if(v.getId()==R.id.dummy_add){
            startActivity(new Intent(MainActivity.this, AddTimer.class));
        }
    }
    private void setTimer() {

        try{
            totalTime = ((Integer.parseInt(eh.getText().toString())*3600)+
                    (Integer.parseInt(em.getText().toString())*60)+
                    (Integer.parseInt(es.getText().toString())))*1000;

        } catch (NumberFormatException nfe){
            Log.e("nfe", "could not parse" + nfe);
        }

    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(totalTime,500) {
            @Override
            public void onTick(long leftTimeInMilliseconds){
                long sec = leftTimeInMilliseconds/1000;

                eh.setText(String.format("%02d",sec/3600));
                em.setText(String.format("%02d",(sec/60)%60));
                es.setText(String.format("%02d",sec%60));

            }

            @Override
            public void onFinish() {
                bStop.setVisibility(View.GONE);
                bStart.setVisibility(View.VISIBLE);
            }
        }.start();

    }
    public void sl(EditText ek){
        ek.setKeyListener(null);
        ek.setClickable(false);
        ek.setCursorVisible(false);
        ek.setFocusable(false);
        ek.setFocusableInTouchMode(false);
    }
    public void stl(EditText ek){
        ek.setClickable(true);
        ek.setCursorVisible(true);
        ek.setFocusable(true);
        ek.setFocusableInTouchMode(true);
    }

}


