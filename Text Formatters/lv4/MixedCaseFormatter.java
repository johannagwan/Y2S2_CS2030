import java.util.*;
import java.lang.StringBuilder;

class MixedCaseFormatter implements TextFormatter {
    String str;
    int r;
    char c;
    int c_ascii;

    TextFormatter t = new SnakeCaseFormatter("I Love CS2030");

    public TextFormatter clone(String s) {
        return new MixedCaseFormatter(s);
    }

    public MixedCaseFormatter(String s) {
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

    public String format(){
        this.c = str.charAt(0);
        this.c_ascii = (int) c;
        this.r = c_ascii % 3;
        TextFormatter s;
        if (this.r == 0) {
            s = new SnakeCaseFormatter(str);
        } else if (this.r == 1) {         
            s = new KebabCaseFormatter(str);
        } else { // if r = 2             
            s = new PascalCaseFormatter(str);
        }
        
        if (s.compareTo(t) == 1) {
            return s.format();
        } else {
            return t.format();
        }
    }
}




