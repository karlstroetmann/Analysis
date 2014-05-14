import sympy as sym

n = sym.symbols("n")
i = sym.symbols("i")

def proveSum(s, e, i, n):
    """
    s and e are expressions containing the variable n and i,
    respectively.  Let us write s = s(n) and e = e(i) to emphasize this.
    The call proveSum tries to prove the following formula by
    mathematical induction:
      sum(e(i), i=1..n) = s(n)
    """
    print
    print "Trying to prove sum(" + str(e) + ", i=1..n) = " + str(s) + " by induction."
    print
    print "Base Case: n = 1"
    print "The left hand side is:  "
    lhs = printAndSubstitute(e, i, 1)
    print "The right hand side is: "
    rhs = printAndSubstitute(s, n, 1)
    d0 = lhs - rhs
    print "the difference of", lhs, " -", rhs, " is"
    d1 = printAndSimplify(d0)
    if d1 == 0:
        print "As the difference of left hand side and right hand side simplifies to 0,"
        print "the claim is valid in the base case."
    else:
        print "Unable to prove the base case."
        return
    print
    print "Induction Step: n |-> n+1"
    lhs = s + e.subs(i, n+1)
    print "The left hand side is:  "
    print str(s) + " + " + str(e) + "[" + str(i) + " |-> " + str(n+1) + "] = " 
    lhs = printAndSimplify(lhs)
    print "The right hand side is: "
    rhs = printAndSubstitute(s, n, n + 1)
    d0 = lhs - rhs
    print "The difference of", lhs, " -", rhs, " is"
    d1 = printAndSimplify(d0)
    if d1 == 0:
        print "As the difference of left hand side and right hand side simplifies to 0,"
        print "the induction step is valid." 
        print "Therefore, the theorem has been proven by induction.  q.e.d"
    else:
        print "Unable to complete the induction step."
        return

def printAndSubstitute(general, v, w):
    expr = general.subs(v, w)
    print str(general) + "[" + str(v) + " |-> " + str(w) + "] = " + str(expr)
    simple = sym.simplify(expr)
    if expr != simple:
        print "This expression is simplified as:"
        print simple
    return simple

def printAndSimplify(expr):
    print expr
    simple = sym.simplify(expr)
    if expr != simple:
        print "This expression is simplified as:"
        print simple
    return simple
    
s = n * (n + 1) / 2
proveSum(s, i, i, n)

s = n * (2 * n + 1) * (n + 1) / 6
proveSum(s, i*i, i, n)

s = n / (n + 1) 
proveSum(s, 1/(i*(i+1)), i, n)
