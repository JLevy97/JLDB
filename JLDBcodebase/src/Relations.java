import javax.management.relation.Relation;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * class to represent a relation table of the database
 * format of arraylist matrix.
 *      first element of each "down list" is the column name
 *
 * Created by User on 4/9/2018.
 */
public class Relations implements Serializable{

    ArrayList<Row> R;

    static int undefinedNameCounter = 0;
    String name;
    int rowSize;

    Relations(){
        new ArrayList<Row>();
        name = "undefined_"+undefinedNameCounter;
        undefinedNameCounter++;
        rowSize = 0;
    }

    /**
     *
     * @param Name
     */
    Relations(String Name, int RowSize){
        new ArrayList<Row>();
        name = Name;
        rowSize = RowSize;
    }

    public void printRelation(){
        for(Row t: R){
            t.printRow();
        }
    }

    //add Row


}
