# Linear Regression in Java (From Scratch)

This Java program implements **Simple Linear Regression** using **Gradient Descent** from scratch, without relying on any third-party ML libraries.

---

## File Structure

```
.
├── LinearRegression.java
└── data/
    └── training_data.csv
```

---

## Overview

This program:
- Loads a dataset of input features and target values from a CSV file.
- Trains a linear regression model using gradient descent.
- Prints the final learned equation of the best-fitting line.

---

## Input Format

The `training_data.csv` file must follow this format:

```
x,y
1.0,2.1
2.0,3.9
3.0,6.0
...
```

Each line contains:
- `x`: Independent variable (feature)
- `y`: Dependent variable (target)

---

## How the Code Works

### 1. `obtain_data(String filePath)`
- Reads the CSV file.
- Skips the header.
- Parses `x` and `y` values and stores them in arrays.

### 2. `train_model(double lr, double minMSE, int maxIterations)`
- Initializes weights `m` (slope) and `c` (intercept) to 0.
- Iteratively updates `m` and `c` using **gradient descent**:
  - **Loss Function**: Mean Squared Error (MSE)
  - **Gradient w.r.t m**:  
    \
    (2/n) * Σ((y_pred - y) * x)
  - **Gradient w.r.t c**:  
    \
    (2/n) * Σ(y_pred - y)
- Stops when:
  - MSE falls below `minMSE`, or
  - `maxIterations` is reached.
- Prints the final equation:  
  \
  y = m * x + c

### 3. `main(String[] args)`
- Calls `obtain_data()` to load CSV.
- Calls `train_model()` with learning rate `0.001`, minimum MSE `0.001`, and max iterations `50000`.

---

## 🧠 Example Output

```
Data loaded successfully.

Training Complete.
Best Fitting Line Equation:
y = 1.957816 * x + 0.054321
```

---

## 🛠️ Requirements

- Java JDK 8 or higher
- A CSV file with training data located at `data/training_data.csv`

---

## 🚀 How to Run

1. **Compile the program:**
   ```bash
   javac LinearRegression.java
   ```

2. **Run the program:**
   ```bash
   java LinearRegression
   ```

---

## Notes

- Ensure the CSV file has no missing or malformed values.
- You can tune:
  - `learning rate (lr)` for speed and stability
  - `minMSE` for precision
  - `maxIterations` for convergence guarantee

---

## Concepts Covered

- Data parsing from CSV
- Gradient descent optimization
- Linear regression theory
- Java file I/O and exception handling

---

