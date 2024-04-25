# PolyMath

## Overview
This Java project is part of my first assignment in a Data Structures class. It features classes for managing polynomials and tuples, allowing users to perform operations such as evaluating and integrating polynomials defined by tuples representing coefficients and powers.

## Features
- **Tuple Class**: Manages an ordered pair of doubles, commonly used here to represent the coefficient and power of a polynomial term.
- **Polynomial Class**: Handles operations on polynomials, including evaluation at a specific point and calculating definite integrals over a specified range.

## Example Usage
- Enter the lower bound: 0
- Enter the upper bound: 1
- The definite integral of the polynomial -2x^3 + 2/x^3 - 2/x^3 + 2x^2 between (0,1) is -1.5
- The time elapsed is : 120ms

### Prerequisites
- Java JDK 1.8 or newer.

### Running the Program
To compile and run the program, you'll need to have the Java files for both the `Tuple` and `Polynomial` classes. Here's how you can compile and execute the program:

```bash
javac Tuple.java Polynomial.java
java Polynomial
