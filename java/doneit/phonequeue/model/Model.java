package doneit.phonequeue.model;

import java.util.ArrayList;

/**
 * Created by Brad on 12/16/2015.
 */
public class Model {

    public ArrayList<String> numbersList;

    public Model() {
        this.numbersList = new ArrayList();
    }

    public ArrayList<String> getNumbersList() {
        return this.numbersList;
    }

    public void setNumbersList(ArrayList<String> newList) {
        this.numbersList = newList;
    }

    public void addLast(String s) {
        this.numbersList.add(s);
    }

    public void addFirst(String s) {
        this.numbersList.add(0, s);
    }

    public void addAt(int n, String s) {
        this.numbersList.add(n, s);
    }

    public void setAt(int n, String s) {
        this.numbersList.set(n, s);
    }

    public String getLast() {
        String s = "";
        if(this.numbersList.size() > 0) {
            s = this.numbersList.get(this.numbersList.size());
        }
        return s;
    }

    public String getFirst() {
        String s = "";
        if(this.numbersList.size() > 0) {
            s = this.numbersList.get(0);
        }
        return s;
    }

    public String getAt(int n) {
        String s = "";
        if(this.numbersList.size() > n) {
            s = this.numbersList.get(n);
        }
        return s;
    }

    public int listSize() {
        return this.numbersList.size();
    }

    public void clearList() {
        this.numbersList.clear();
    }

}
