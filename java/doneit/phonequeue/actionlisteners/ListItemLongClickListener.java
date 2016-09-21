package doneit.phonequeue.actionlisteners;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Brad on 9/7/2016.
 */
public class ListItemLongClickListener implements AdapterView.OnItemLongClickListener {


    public ArrayAdapter<String> adapter;
    public ArrayList<String> listItems;

    public ListItemLongClickListener(ArrayAdapter<String> a, ArrayList<String> li) {
        this.adapter = a;
        this.listItems = li;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        // Delete phone number on long press

        if(this.listItems.size() > i && this.listItems != null && this.adapter != null ) {

            view.setBackgroundColor(Color.parseColor("#ebadaf"));

            new CountDownTimer(650, 650) {

                public ArrayAdapter<String> adapter;
                public ArrayList<String> listItems;
                public int iterator;
                public View view;

                public void onTick(long millisUntilFinished) {}

                public void onFinish() {
                    this.view.setBackgroundColor(Color.parseColor("#ffffff"));
                    if(this.iterator == 0) {
                        this.listItems.set(0, "");
                    } else {
                        this.listItems.remove(this.iterator);
                    }

                    this.adapter.notifyDataSetChanged();

                }

                public CountDownTimer init(ArrayAdapter<String> a, ArrayList<String> li, int i, View v) {
                    this.adapter = a;
                    this.listItems = li;
                    this.iterator = i;
                    this.view = v;
                    return this;
                }
            }.init(this.adapter, this.listItems, i, view).start();
        }
        return true;
    }
}
