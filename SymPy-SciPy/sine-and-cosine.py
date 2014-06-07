import matplotlib.pyplot as plt
import numpy as np
xs = np.linspace(-2*np.pi, 2*np.pi, 200)
ys = [np.sin(x) for x in xs]
plt.ion()
plt.plot(xs, ys)
zs = np.cos(xs)
plt.plot(xs, zs)
plt.title("The functions sin(x) and cos(x)")
plt.xlabel("x")
plt.ylabel("sin(x) vs. cos(x)")
plt.savefig("sine-and-cosine.eps")
