import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clause {
    public List<Literal> literalList;           // = new ArrayList<>();

//    Clause(List<Literal> literalList) {
//        this.literalList = literalList;
//    }

    Clause() {
        literalList = new ArrayList<>();
    }

    public void add(Literal l) {
        literalList.add(l);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<Literal> it = literalList.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");

        return sb.toString();
    }
}