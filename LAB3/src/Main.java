public class Main {
    public static void main(String[] args) throws Exception {
        var st = new SymbolTable();
        st.addIdentifier("a");
        st.addIntConstant(2);
        st.addStringConstant("b");
        System.out.println(st.hasIdentifier("b"));
        System.out.println(st.hasStringConstant("a"));
        System.out.println(st.hasStringConstant("b"));
        System.out.println(st.hasIntegerConstant(1));
        System.out.println(st.hasIntegerConstant(2));

    }
}
