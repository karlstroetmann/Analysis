from sympy import * 

n = symbols("n")
i = symbols("i")

def verifySum(s, e, i, n):
    """
    check by induction whether the folowing equation holds:
           sum(e(i), i=1..n) == s
    """
    lhs = e.subs(i, 1)
    rhs = s.subs(n, 1)
    base_case = simplify(lhs - rhs)
    lhs = s + e.subs(i, n+1)
    rhs = s.subs(n, n + 1)
    induction_step = simplify(lhs - rhs) 
    return base_case == 0 and induction_step == 0

def test(s, e, i, n):
    if verifySum(s, e, i, n):
        print "sum(" + str(e) + ", " + str(i) + "= 1.." + str(n) + ") = " + str(s)
    else:
        print "unable to prove:"
        print "sum(" + str(e) + ", " + str(i) + "= 1.." + str(n) + ") == " + str(s)
        
s = n * (n + 1) / 2
test(s, i, i, n)
s = n * (2 * n + 1) * (n + 1) / 6
test(s, i*i, i, n)

s = n / (n + 1) 
test(s, 1/(i*(i+1)), i, n)

s = n / (n + 1) 
test(s, 1/(i*i), i, n)
