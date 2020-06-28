Quick and dirty implementation of DPLL in order to calculate number of nodes visited in a full tree.

Literal has static objects for 4 positive literals and their complements.\
Literals are hardcoded.\
This implementation runs for the full tree, and doesn't stop on true, so it can return the number of nodes in the DPLL tree.

# Instructions

Add literals to Literals[][], compile and run.

## Usage Example
`{{p, r}, {p, -r, -s}, {p, -q}, {-p, -q}, {-q, -s}, {q, -r}}`
#### Main.java
```Java
Literal[][] clauseList = {
        {Literal.p, Literal.r},
        {Literal.p, Literal.notR, Literal.notS},
        {Literal.p, Literal.notQ},
        {Literal.notP, Literal.notQ},
        {Literal.notQ, Literal.notS},
        {Literal.q, Literal.notR}
};
```
#### Output
```Java
True
False
Node count: 8
```

DPLL overloads:
```java
DPLL.runDPLL(clauselist);
DPLL.runDPLL(clauselist, boolean verbosity);
DPLL.runDPLL(clauselist, int verbosityLevel);   // 1-3
```

### Recursive algorithm pseudocode:
```java
runDPLL(Set) {
    if (emptySet) return true
    if (hasEmptyClause)  return false
    if for some literal l, {l} is an element of Set then
        runDPLL( Set where l=1 )
        // IF MULTIPLE APPLIES, GET FIRST IN LEXICOGRAPHICAL ORDER
    if for some literal l element of Set
        if -l is not element of Set
            runDPLL( Set where l=1 )
        // IF MULTIPLE APPLIES, GET FIRST IN LEXICOGRAPHICAL ORDER
    get first literal in lexicographical order 
        return runDPLL( Set where l=1 ) AND runDPLL( Set where l=0 )
}
```
The use of AND in the final route is specifically so all nodes are visited.


Possible updates:
- Change Lists to Sets
- More comfortable input (not hardcoded)
- Cleaner handling of Literals
- Verbosity levels

