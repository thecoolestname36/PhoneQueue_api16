package doneit.phonequeue.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import doneit.phonequeue.R;
import doneit.phonequeue.model.Model;
import doneit.phonequeue.views.NumberListView;
import doneit.phonequeue.utilities.Utils;


public class MainActivity extends Activity {

    public Model model;
    public NumberListView numberListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (this.model == null) {
            this.model = new Model();
        }
        if (this.model.getNumbersList().size() == 0) {
            this.model.addAt(0, "");
        }
        if (this.numberListView == null) {
            this.numberListView = new NumberListView(this.model, this);
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        this.numberListView.initListView();
    }



//////////////// Button Actions //////////////

    public void addItems(View v) {


        if((Utils.clearStr(this.model.getAt(0), "-").length() > 6) && (this.model.listSize() > 0)) {

            this.model.addAt(this.model.listSize(), this.model.getAt(0));
            this.model.setAt(0, "");
            this.numberListView.notifyAdapterSetChanged();

        }
    }

    public void numberPress(View v) {

        if (!(this.model.listSize() > 0)) {
            this.model.addAt(0, "");
        }
        Button b = (Button) v;
        String num = b.getText().toString();

        String s = this.model.getAt(0);
        int order = 0;

        if(s.length() == 0) {
            s += num;
        } else {
            if (s.charAt(0) == '1') {
                order = 1;
            }
            if(s.length() == 3+order) {
                s += "-" + num;
            } else if (s.length() == 7+order) {
                s += num;
            }
            else if (s.length() == 10+order) {
                String str = s;
                s = str.substring(0, 7+order) + "-" + str.substring(7+order) + num;
            }
            else {
                s += num;
            }
        }


        this.model.setAt(0, s);
        this.numberListView.notifyAdapterSetChanged();
    }

    public void clearAll(View v) {
        this.model.clearList();
        this.model.addAt(0, "");
        this.numberListView.notifyAdapterSetChanged();
    }

    public void clearEntry(View v) {
        if(this.model.listSize() > 0 && this.model.getAt(0).length() > 0) {
            this.model.setAt(0, "");
            this.numberListView.notifyAdapterSetChanged();
        }
    }

    public void backspc() {
        if(this.model.listSize() > 0) {
            String item = this.model.getAt(0);
            if (item.length() > 0) {

                this.model.setAt(0, item.substring(0, item.length() - 1));
                this.numberListView.notifyAdapterSetChanged();
            }
        }
    }

    public void backspace(View v) {
        backspc();
    }

    @Override
    public void onBackPressed()
    {
        if (this.model.getAt(0).length() == 0) {
            minimizeApp();
        } else {
            backspc();
        }
    }

    public void minimizeApp() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
