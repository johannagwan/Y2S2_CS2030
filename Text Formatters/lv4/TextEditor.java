import java.util.*;

class TextEditor{
    List<TextFormatter> formatter;

    public TextEditor(List<TextFormatter> formatter) {
        this.formatter = formatter;
    }

    //add a string into Text Editor
    ArrayList<String> arr_str = new ArrayList<String>();    
    public void addString(String s) {
        arr_str.add(s);
    }

    ArrayList<TextFormatter> arr_tf = new ArrayList<TextFormatter>();
    public void assignTF() {       
        for (int i = 0; i < arr_str.size(); i++) {
            for(TextFormatter f : formatter) { //loop through each formatter
                arr_tf.add(f.clone(arr_str.get(i))); 
            }
        }
    }

    PriorityQueue<TextFormatter> pq = new PriorityQueue<TextFormatter>();
    public void sortASCII() {
        for (TextFormatter tf : arr_tf) {
            pq.add(tf);
        }
    } 

    // to print all formatted strings
    public void printAll() {
        int len = pq.size();
        for(int i = 0; i < len; i++) {
            System.out.println(pq.poll().format());
        }
    }
}
