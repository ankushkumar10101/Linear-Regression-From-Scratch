import java.io.*;

public class LinearRegression {
    static double[] x;
    static double[] y_actual;

    // load data
    public static void obtain_data(String filePath) {
        try {
            BufferedReader count = new BufferedReader(new FileReader(filePath));
            int n = -1;
            while (count.readLine() != null) n++;
            count.close();

            x = new double[n];
            y_actual = new double[n];

            BufferedReader file = new BufferedReader(new FileReader(filePath));
            file.readLine();
            String line;
            int i = 0;
            while ((line = file.readLine()) != null && i < n) {
                String[] words = line.split(",");
                if (words.length == 2) {
                    x[i] = Double.parseDouble(words[0].trim());
                    y_actual[i] = Double.parseDouble(words[1].trim());
                    i++;
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error Found: " + e.getMessage());
        }
    }

    // Performs gradient descent
    public static void train_model(double lr, double minMSE, int maxIterations) {
        if (x == null || y_actual == null) {
            System.out.println("Data not loaded. Exiting.");
            return;
        }

        int data_lt = x.length;
        double m = 0.0, c = 0.0;
        double m_predicted = 0.0, c_predicted = 0.0;
        double MSE = minMSE;
        int iterations = 0;

        while (MSE >= minMSE && iterations < maxIterations) {
            iterations++;
            double sum = 0.0;
            double error_m = 0.0;
            double error_c = 0.0;

            for (int i = 0; i < data_lt; i++) {
                double y_predicted = m * x[i] + c;
                double error = y_predicted-y_actual[i];
                sum += error * error;
                error_m += error * x[i];
                error_c += error;
            }

            MSE = sum / data_lt;
            double grad_m = (2.0 * error_m) / data_lt;
            double grad_c = (2.0 * error_c) / data_lt;

            m = m - lr * grad_m;
            c = c - lr * grad_c;
        }

        m_predicted = m;
        c_predicted = c;
        System.out.println("\nTraining Complete.");
        System.out.println("Best Fitting Line Equation:");
        System.out.printf("y = %.6f * x + %.6f\n", m_predicted, c_predicted);
    }

    public static void main(String[] args) {
        String filePath = "data/training_data.csv";

        obtain_data(filePath);
        System.out.println("Data loaded successfully.\n");

        train_model(0.001, 0.001, 50000);
    }
}
