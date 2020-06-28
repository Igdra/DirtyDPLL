import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clauselist {
    public ArrayList<Clause> currentClauseList;         // = new ArrayList<>();

    Clauselist(ArrayList<Clause> currentClauseList) {
        this.currentClauseList = new ArrayList<>();
        for (Clause clause : currentClauseList) {
            Clause k = new Clause();
            for (Literal literal : clause.literalList) {
                k.add(literal);
            }
            this.currentClauseList.add(k);
        }
    }

    public Clauselist(Literal[][] clauseList) {
        this.currentClauseList = new ArrayList<>();
        for(Literal[] clause : clauseList) {
            Clause k = new Clause();
            for(Literal l : clause) {
                k.add(l);
            }
            this.currentClauseList.add(k);
        }
    }

//    public ArrayList<Clause> getCurrentClauseList() {
//        ArrayList<Clause> newList = new ArrayList<>();
//        for(Clause k : currentClauseList) {
//            Clause newkloz = new Clause();
//            for ( Literal l : k.literalList) {
//                newkloz.add(l);
//            }
//            newList.add(newkloz);
//        }
//        return newList;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<Clause> it = currentClauseList.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");

        return sb.toString();

    }

    // get the first in lexicographical order
    public static Literal getAbc(Clauselist kh) {
        // check for p
        for(Clause k : kh.currentClauseList) {
            if (k.literalList.contains(Literal.p)) return Literal.p;
        }
        for(Clause k : kh.currentClauseList) {
            if (k.literalList.contains(Literal.notP)) return Literal.notP;
        }


        for(Clause k : kh.currentClauseList) {
           if (k.literalList.contains(Literal.q)) return Literal.q;
        }
        for(Clause k : kh.currentClauseList) {
            if (k.literalList.contains(Literal.notQ)) return Literal.notQ;
        }


        for(Clause k : kh.currentClauseList) {
           if (k.literalList.contains(Literal.r)) return Literal.r;
        }
        for(Clause k : kh.currentClauseList) {
            if (k.literalList.contains(Literal.notR)) return Literal.notR;
        }


        for(Clause k : kh.currentClauseList) {
            if (k.literalList.contains(Literal.s)) return Literal.s;
        }
        for(Clause k : kh.currentClauseList) {
          if (k.literalList.contains(Literal.notS)) return Literal.notS;
        }

        return null;
    }

    public static boolean hasEmptyClause(Clauselist kh) {
        for(Clause k : kh.currentClauseList) {
            if (k.literalList.size() == 0) return true;
        }
        return false;
    }

    public static boolean isEmptySet(Clauselist kh) {
        return kh.currentClauseList.size() == 0;
    }

    public static Literal getUnitProp(Clauselist kh) {
        for(Clause k : kh.currentClauseList) {
            if (k.literalList.size() == 1) return k.literalList.get(0);
        }
        return null;
    }

    public static Literal getPureLiteral(Clauselist kh) {
        for(Clause k : kh.currentClauseList) {
            if ( checkifPure(kh, k.literalList, Literal.p) ) return Literal.p;
            if ( checkifPure(kh, k.literalList, Literal.notP) ) return Literal.notP;
            if ( checkifPure(kh, k.literalList, Literal.q) ) return Literal.q;
            if ( checkifPure(kh, k.literalList, Literal.notQ) ) return Literal.notQ;
            if ( checkifPure(kh, k.literalList, Literal.r) ) return Literal.r;
            if ( checkifPure(kh, k.literalList, Literal.notR) ) return Literal.notR;
            if ( checkifPure(kh, k.literalList, Literal.s) ) return Literal.s;
            if ( checkifPure(kh, k.literalList, Literal.notS) ) return Literal.notS;
        }
        return null;
    }

    public static boolean checkifPure(Clauselist kh, List<Literal> literalList, Literal check) {
        Literal complement = Literal.getComplement(check);
//        Literal complement = check.complement;
        if (literalList.contains(check)) {
            for(Clause k_2 : kh.currentClauseList) {
                if (k_2.literalList.contains(complement)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


}


