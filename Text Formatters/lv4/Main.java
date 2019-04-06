import java.util.*;

class Main {
    public static void main(String[] args) {
        ArrayList<TextFormatter> f = new ArrayList<TextFormatter>(); //list of formatters

        f.add(new SnakeCaseFormatter("")); //add formatter to the list of formatters
        f.add(new KebabCaseFormatter(""));
        f.add(new PascalCaseFormatter(""));
        f.add(new MixedCaseFormatter(""));
        TextEditor te = new TextEditor(f);
        Scanner sc = new Scanner(System.in);
        //for loop
        while (sc.hasNextLine()) {
            //read 1 line
            te.addString(sc.nextLine());            
        }
        te.assignTF();
        te.sortASCII();
        te.printAll();   
    }
}
