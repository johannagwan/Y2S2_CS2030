import java.util.*;
import java.lang.StringBuilder;

class SnakeCaseFormatter implements TextFormatter {

    String str;
    // create a clone of the TextFormatter with another String
    public TextFormatter clone(String s){ //s is a whole line of words
        return new SnakeCaseFormatter(s);
    }

    public SnakeCaseFormatter(String s) {
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
        StringBuilder sb = new StringBuilder(temp);
        for (int i = 0; i < sb.length(); i++) {
            if (temp.charAt(i) == ' ') {
                sb.replace(i, i+1, "_");
            }
        }
        return sb.toString();
    }
}
