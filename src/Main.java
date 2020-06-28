public class Main {
    public static void main(String[] args) {

        // possibly implement string to clauseList conversion
//        String clauseString = "{ {p, -r, s}, {s}, {-p,-q}, {-p, q, -r}, {-p, q} }";

        // Literals:
        // Literal.p
        // Literal.notP
        // Literal.q
        // Literal.notQ
        // Literal.r
        // Literal.notR
        // Literal.s
        // Literal.notS
        Literal[][] clauseList = {
                // Write your literals here
                {Literal.p, Literal.r},
                {Literal.p, Literal.notR, Literal.notS},
                {Literal.p, Literal.notQ},
                {Literal.notP, Literal.notQ},
                {Literal.notQ, Literal.notS},
                {Literal.q, Literal.notR}
        };

        Clauselist clauselist = new Clauselist(clauseList);

        // run DPLL and write out number of iterations (nodes)
        DPLL.runDPLL(clauselist);
        System.out.println("Node count: " + DPLL.getNodeCount());

    }
}
