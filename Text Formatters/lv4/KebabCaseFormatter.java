import java.util.*;
import java.lang.StringBuilder;

class KebabCaseFormatter implements TextFormatter{
    String str;
    public TextFormatter clone(String s) {
        return new KebabCaseFormatter(s);
    }

    public KebabCaseFormatter(String s) {
        this.str = s;
    }

    public int getASCII() {
        int counter = 0;
        String formatted_str = this.format();
        for(int i = 0; i < formatted_str.length(); i++) {
            char chara = formatted_str.charAt(i);
            int ascii = (int) chara;
            counter = counter + ascii;
        } 
        return counter;
    }

    public int compareTo(TextFormatter o) { //compare ASCII of elements of array of formatted str
        if (this.getASCII() < o.getASCII()) {
            return -1;
        } else if (this.getASCII() > o.getASCII()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String format() {
        String temp = str.toLowerCase();
        StringBuilder sb = new StringBuilder(temp);
        for (int i = 0; i < sb.length(); i++) {
            if (temp.charAt(i) == ' ') {
                sb.replace(i, i+1, "-");
            }
        }
        return sb.toString();
    }
}
