package doneit.phonequeue.utilities;

/**
 * Created by Brad on 9/7/2016.
 */
public class Utils {

    /**
     * Clears string of given string
     * @param s String that you want to remove something from
     * @param c String to remove from s
     * @return String clear of contents of c
     */
    public static String clearStr(String s, String c) {
        if(s.contains(c)) {
            int i = s.indexOf(c);
            String str = s;
            s = str.substring(0, i);
            if(str.length() > i) {
                s += str.substring(i+1, str.length());
            }
            //
            //.out.println("Phone:" + s);
            s = clearStr(s, c);
        }
        return s;
    }

}
