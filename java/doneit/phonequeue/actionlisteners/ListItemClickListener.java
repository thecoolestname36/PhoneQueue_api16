package doneit.phonequeue.actionlisteners;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Brad on 9/7/2016.
 */
public class ListItemClickListener implements AdapterView.OnItemClickListener {

    public ArrayAdapter<String> adapter;
    public ArrayList<String> listItems;
    public Activity activity;

    public ListItemClickListener(ArrayAdapter<String> a, ArrayList<String> li, Activity act) {
        this.adapter = a;
        this.listItems = li;
        this.activity = act;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String number = (String) adapterView.getAdapter().getItem(i);

        if (clearStr(number, "-").length() > 6 && number != null) {

            changeColor(view, i);
            call(number);
            if(number.charAt(0) != '~') {
                this.listItems.set(i, "~" + number);
            }
        }
    }

    public void changeColor(View view, int i) {
        view.setBackgroundColor(Color.parseColor("#C7FF33"));

        new CountDownTimer(1000, 1000) {

            public ArrayAdapter<String> adapter;
            public View view;
            public int iterator;

            public void onTick(long millisUntilFinished) {}

            public void onFinish() {
                this.view.setBackgroundColor(Color.parseColor("#ffffff"));
                this.adapter.notifyDataSetChanged();
            }

            public CountDownTimer init(ArrayAdapter<String> a, View v, int i) {
                this.adapter = a;
                this.view = v;
                this.iterator = i;
                return this;
            }
        }.init(this.adapter, view, i).start();
    }

    public void call(String number) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);

            callIntent.setData(Uri.parse("tel:" + clearStr(clearStr(number, "~"), "-")));

            try {

                this.activity.startActivity(callIntent);
            } catch(SecurityException e) {
                // FINISH ME!!!!
            }

        } catch (ActivityNotFoundException e) {
            Log.e("Android dialing error:", "Call Failed", e);
        }
    }

    public String clearStr(String num, String c) {
        String s = "";
        for(char ch : num.toCharArray()) {
            s += ch;
        }
        if(s.contains(c)) {
            int i = s.indexOf(c);
            String str = s;
            s = str.substring(0, i);
            if(str.length() > i) {
                s += str.substring(i+1, str.length());
            }
            s = clearStr(s, c);
        }
        return s;
    }
}