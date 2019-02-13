package mundo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import mundo.util.Image;
import mundo.util.Matriz;
import mundo.util.SVD;


public class Runner {

	public Runner() {
		
	}
    public void run(String path) throws Exception {
        // Create matrix from image
        Image image = new Image(path);
        double[][] imageMatrix = image.getImageMatrix();
       // svdCommented(imageMatrix);

        int rank = 30;

        imageMatrix = svd(imageMatrix, rank);
        image.setImageMatrix(imageMatrix);
        image.createImageFromMatrix();

        ImageIO.write(image.getImage(), "jpg", new File("src/images/imageUpdated.jpg"));
    }

    public  double[][] svd(double[][] imageMatrix, int rank) throws Exception {
        Jama.Matrix matrix = new Jama.Matrix(imageMatrix);

        int maxRank = matrix.rank();

        if (rank > maxRank) {
            rank = maxRank;
        }

        Jama.Matrix S = matrix.svd().getS();
        Jama.Matrix V = matrix.svd().getV();
        Jama.Matrix U = matrix.svd().getU();

        S = new Jama.Matrix(Matriz.rankedMatrixS(new Matriz(S.getArray()), rank));
        V = new Jama.Matrix(Matriz.rankedMatrixUV(new Matriz(V.getArray()), rank));
        U = new Jama.Matrix(Matriz.rankedMatrixUV(new Matriz(U.getArray()), rank));

        ImageIO.write(new Image().createImage(S.getArray()), "jpg", new File("src/images/S.jpg"));
        ImageIO.write(new Image().createImage(V.getArray()), "jpg", new File("src/images/V.jpg"));
        ImageIO.write(new Image().createImage(U.getArray()), "jpg", new File("src/images/U.jpg"));

        Matriz composed = new Matriz(U.times(S).times(V.transpose()).getArray());
        return composed.getMatrix();
    }

    }
