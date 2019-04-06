import java.util.*;
import java.lang.StringBuilder;

class PascalCaseFormatter implements TextFormatter {

    String str;
    // create a clone of the TextFormatter with another String
    public TextFormatter clone(String s){ //s is a whole line of words
        return new PascalCaseFormatter(s);
    }

    public PascalCaseFormatter(String s) {
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

    // return a formatted String
    public String format(){
        String temp = str.toLowerCase();
        char init = Character.toUpperCase(temp.charAt(0));
        StringBuilder sb = new StringBuilder(temp);
        sb.replace(0, 1, "" + init);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
               char upp = Character.toUpperCase(sb.charAt(i+1));
               sb.replace(i+1, i+2, "" + upp);
               sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}
