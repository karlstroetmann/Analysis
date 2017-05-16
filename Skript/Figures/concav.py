import matplotlib.pyplot as plt
import numpy as np

def f(x):
    return 12 - (x-1)**2 

def g(x):
    a = -1.0
    b =  4.0
    return (x-a)/(b-a)*f(b)+(x-b)/(a-b)*f(a)

# plt.ion()  # plotting interactively is slow

x = np.linspace(-2, 5, 256, endpoint = True)
y = f(x)
plt.plot(x, y, color="blue", label="f")

lx = np.linspace(-1,4, 200, endpoint = True)
ly = g(lx)
plt.plot(lx, ly, color="red", label="g")

plt.xlim(-3, 6)
plt.ylim(-5,18)

plt.legend(loc="upper left")

ax = plt.gca()
ax.spines['right'].set_color('none')
ax.spines['top'].set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.spines['bottom'].set_position(('data',0))
ax.yaxis.set_ticks_position('left')
ax.spines['left'].set_position(('data',0))

t = -1
plt.scatter([t,],[f(t),], 50, color ='blue')
plt.annotate(r'$\langle x_1, f(x_1) \rangle$', xy=(t, f(t)), xycoords='data', xytext=(-80, 20), textcoords='offset points', fontsize=12, arrowprops=dict(width=0.1,shrink=0.2))

t = 4
plt.scatter([t,],[f(t),], 50, color ='blue')
plt.annotate(r'$\langle x_2, f(x_2) \rangle$', xy=(t, f(t)), xycoords='data', xytext=(+20, 20), textcoords='offset points', fontsize=12, arrowprops=dict(width=0.11,shrink=0.2))

t = 1.5
plt.scatter([t,],[f(t),], 50, color ='blue')
plt.annotate(r'$\langle t\cdot x_1 + (1-t)\cdot x_2, f(t\cdot x_2 + (1-t)\cdot x_2) \rangle$', xy=(t, f(t)), xycoords='data', xytext=(-60, 20), textcoords='offset points', fontsize=12, arrowprops=dict(width=0.1,shrink=0.3,headwidth=5))
plt.scatter([t,],[g(t),], 50, color ='red')
plt.annotate(r'$\langle t\cdot x_1 + (1-t)\cdot x_2, g(t\cdot x_2 + (1-t)\cdot x_2) \rangle$', xy=(t, g(t)), xycoords='data', xytext=(+25, -55), textcoords='offset points', fontsize=12, arrowprops=dict(width=0.1,shrink=0.2),horizontalalignment='center')

plt.plot([t,t],[0,g(t)], color ='red', linestyle="--")
plt.plot([t,t],[g(t),f(t)], color ='blue', linestyle="--")


plt.savefig("concav.eps",dpi=300)
