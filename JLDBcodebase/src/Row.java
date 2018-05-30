public class Row {

    String[] tuple;

    public final int size;
    public String user; //defines who this tuple belongs too
    public String rights; //defines who has the rights to see this tuple

    /**
     *
     */
    Row(){
        this(2,"nobody","nobody");
    }

    /**
     *
     * @param Size
     * @param User
     * @param Rights
     */
    Row(int Size, String User, String Rights){
        size = Size+2;   //+2 for adding size and rights blocks
        user = User;
        rights = Rights;
        tuple = new String[size];
        tuple[0] = user;
        tuple[1] = rights;
        for (int i=2;i<tuple.length;i++){
            tuple[i] = "EMPTY";
        }
    }

    public String RowAsString(){
        String build = "[";

        for(String s:tuple){
            build+=s+" , ";
        }

        build = build.substring(0,build.length()-1);
        build+="]";

        return build;
    }

    public void printRow(){
        System.out.println(RowAsString());
    }

}
