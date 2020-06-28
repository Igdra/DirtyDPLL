public class Literal {
    char id;
    boolean isPositive;    // pozitive literal  // currently not used
//    Literal complement;

    Literal(char id, boolean isPozitive) {
        this.id = id;
        this.isPositive = isPozitive;
    }

//    public static Literal getComplement(Literal find) {
//        return find.complement;
//    }

    public static Literal getComplement(Literal find) {
        if (find.equals(p)) return Literal.notP;
        if (find.equals(notP)) return Literal.p;

        if (find.equals(q)) return Literal.notQ;
        if (find.equals(notQ)) return Literal.q;

        if (find.equals(r)) return Literal.notR;
        if (find.equals(notR)) return Literal.r;

        if (find.equals(s)) return Literal.notS;
        if (find.equals(notS)) return Literal.s;

        return null;
    }

    @Override
    public String toString() {
        return (isPositive ? "" : "-") + id;
    }

    public static final Literal p = new Literal('p', true);
    public static final Literal q = new Literal('q', true);
    public static final Literal r = new Literal('r', true);
    public static final Literal s = new Literal('s', true);
    public static final Literal notP = new Literal('p', false);
    public static final Literal notQ = new Literal('q', false);
    public static final Literal notR = new Literal('r', false);
    public static final Literal notS = new Literal('s', false);
}
