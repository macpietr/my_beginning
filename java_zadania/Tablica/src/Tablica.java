public class Tablica {
    public static void main(String[] args) {

        double[][] matrix = new double[3][];

        double[] w1= {1,1.5,2.0};
        double[] w2={1.5,2,2.5};
        double[] w3={2,2.5,3};

        matrix[0]=w1;
        matrix[1]=w2;
        matrix[2]=w3;

        System.out.println(w1[0]+" "+w1[1]+" "+w1[2]);

        System.out.println(matrix[0][0]+" "+matrix[0][1]+" "+matrix[0][2]);

        System.out.println("");
        System.out.println("");

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("");

        double y = 0;
        for (int i=0;i<matrix.length;i++){
            double x = matrix[i][i];
            y = y + x;

        }
        System.out.println(y);


    }
}
