package mundo.util;

import java.util.List;

public class SVD {

    private double[][] S;
    private double[][] U;
    private double[][] V;

    public Matriz compose() {
        Matriz matrixS = new Matriz(S);
        Matriz matrixU = new Matriz(U);
        Matriz matrixV = new Matriz(V);

        Matriz US = matrixU.multiplyMatrix(matrixS);
        Matriz composed = US.multiplyMatrix(matrixV);
        composed.convertToInt();

        return composed;
    }

    public void createS(double[] eigenValues, int rows, int columns) {
        for (int i = 0, eigenLength = eigenValues.length; i < eigenLength; i++) {
            eigenValues[i] = Math.sqrt(eigenValues[i]);
        }

        Matriz matrixS = new Matriz();
        matrixS.createZeroIdentityFromVector(eigenValues, rows, columns);
        S = matrixS.getMatrix();
    }

    public void createV(List<Matriz> eigenMatrices) {
        Matriz V = new Matriz(
              new Jama.Matrix(eigenMatrices
                    .get(0)
                    .getMatrix())
                    .eig()
                    .getV()
                    .getArray());

        double[][] e = V.getMatrix();
        int size = e.length;
        for (int i = 0; i < e.length; i++) {
            double[] temp = e[i];
            e[i] = e[size - 1];
            e[size - 1] = temp;
        }

        this.V = new Matriz(e).transposeMatrix().getMatrix();
    }

    public void createU(Matriz matrix) {
        Matriz US = new Matriz(matrix.multiplyMatrix(new Matriz(this.V)));

        Matriz U = new Matriz();
        U.createUnitMatrix(US);

        this.U = U.getMatrix();
    }

    public double[][] getS() {
        return this.S;
    }

    public double[][] getU() {
        return this.U;
    }

    public double[][] getV() {
        return this.V;
    }
}
