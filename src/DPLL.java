import java.util.Iterator;

public abstract class DPLL {
    private static int nodeCount = 0;
    private static boolean verbose = false;
    private static int verbosityLevel = 0;

    public static int getNodeCount() {
        return nodeCount;
    }

    public static Clauselist reduceClauseList(Clauselist currentClauseList, Literal setTrue) {
        if (verbose || verbosityLevel >= 2)  System.out.println(setTrue + " = 1");

        Literal setFalse = Literal.getComplement(setTrue);
//        Literal setFalse = setTrue.complement;
        Clauselist newClauseList = new Clauselist(currentClauseList.currentClauseList);


        Iterator<Clause> klozIterator = newClauseList.currentClauseList.iterator();
        while(klozIterator.hasNext()) {
            Clause currentCloz = klozIterator.next();
            Iterator<Literal> it = currentCloz.literalList.iterator();
            while(it.hasNext()) {
                boolean clauseChanged = false;
                Literal test = it.next();
                if (test.equals(setFalse)) it.remove();
                if (test.equals(setTrue)) {
                    klozIterator.remove();
                    break;
                }
            }
        }

        return newClauseList;
    }

    public static void runDPLL(Clauselist clauselist, boolean verbose) {
        DPLL.verbose = true;
        runDPLL(clauselist);
    }

    public static void runDPLL(Clauselist clauselist, int verbosityLevel) {
        DPLL.verbosityLevel = verbosityLevel;
        runDPLL(clauselist);
    }

    public static boolean runDPLL(Clauselist clauselist) {
        if (clauselist.currentClauseList == null) return false;     // just in case
        nodeCount++;
        if (DPLL.verbose
            || DPLL.verbosityLevel >= 1 ) {
            System.out.print(nodeCount + ": ");
            System.out.println(clauselist);
        }

        if(Clauselist.isEmptySet(clauselist)) {
            System.out.println("True");
            return true;   // can set to false to prevent from exiting prematurely in case of OR
        }
        if(Clauselist.hasEmptyClause(clauselist)) {
            System.out.println("False");
            return false;
        }

        if(Clauselist.getUnitProp(clauselist) != null)
            return runDPLL(reduceClauseList(clauselist, Clauselist.getUnitProp(clauselist) ));
        else if(Clauselist.getPureLiteral(clauselist) != null)
            runDPLL(reduceClauseList(clauselist, Clauselist.getPureLiteral(clauselist) ));
        else return runDPLL(reduceClauseList(clauselist, Clauselist.getAbc(clauselist)))
                    && runDPLL(reduceClauseList(clauselist, Literal.getComplement(Clauselist.getAbc(clauselist))));
                // using AND to prevent exit on true
        return false;
    }

}
