package doneit.phonequeue.views;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import doneit.phonequeue.model.Model;
import doneit.phonequeue.R;
import doneit.phonequeue.actionlisteners.ListItemClickListener;
import doneit.phonequeue.actionlisteners.ListItemLongClickListener;

/**
 * Created by Brad on 9/7/2016.
 */
public class NumberListView {

    ////////////// List View //////////////

    ArrayAdapter<String> adapter;
    private ListView listView;
    private Model model;
    private Activity activity;

    public NumberListView(Model m, Activity a) {
        this.model = m;
        this.activity = a;
    }

    public void initListView() {

        if(this.adapter == null) {
            this.adapter = new ArrayAdapter<String>(this.activity,
                    R.layout.number_list,
                    this.model.getNumbersList());
        }

        if (this.listView == null) {
            this.listView = (ListView) this.activity.findViewById(R.id.list);
            this.listView.setAdapter(this.adapter);
        }

        // Action Listeners
        listView.setOnItemClickListener(new ListItemClickListener(this.adapter, this.model.getNumbersList(), this.activity));
        listView.setOnItemLongClickListener(new ListItemLongClickListener(this.adapter, this.model.getNumbersList()));


        // Create item that on short click opens

        // Create Item that on long click of backspace button the items get deleted every few timer iterations

        // On "Clear All" ask for confirmation that you want to clear all

        // Add undo from "Clear All" somehow.. some sort of cached array copy on the clear option to undo

    }

    public void notifyAdapterSetChanged() {
        this.adapter.notifyDataSetChanged();
    }


}
