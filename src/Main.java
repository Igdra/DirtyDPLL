public class Main {
    public static void main(String[] args) {

        // possibly implement string to clauseList conversion
//        String clauseString = "{ {p, -r, s}, {s}, {-p,-q}, {-p, q, -r}, {-p, q} }";

        // Write your literals here
        // Literal.
        Literal[][] clauseList = {
                {Literal.p, Literal.notR, Literal.s},
                {Literal.s},
                {Literal.notP, Literal.notQ},
                {Literal.notP, Literal.q, Literal.notR},
                {Literal.notP, Literal.q}
        };

        Clauselist clauselist = new Clauselist(clauseList);

        // run DPLL and write out how many times it ran
        DPLL.runDPLL(clauselist);
        System.out.println("Node count: " + DPLL.getNodeCount());

    }
}
