package doneit.phonequeue.utilities;

import java.lang.String;

/**
 * Created by Brad on 12/14/2015.
 */
public class PhoneNumber {

    private String number;
    private boolean called;

    public PhoneNumber() {
        this.number = "";
        this.called = false;
    }

    public PhoneNumber(String s) {
        this.number = s;
        this.called = false;
    }

    public PhoneNumber(String s, boolean b) {
        this.number = s;
        this.called = false;
    }

    public void setNumber(String s) {
        this.number = s;
    }

    public String getNumber() {
        return this.number;
    }

    public void setCalled(boolean b) {
        this.called = b;
    }

    public boolean getCalled() {
        return this.called;
    }

}
