interface TextFormatter extends Comparable<TextFormatter> {
    // create a clone of the TextFormatter with another String
    public TextFormatter clone(String s);

    // return a formatted String
    public String format();

    public int getASCII();

}
