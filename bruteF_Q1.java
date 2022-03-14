import java.util.Random;
//MARC NAGY NASRY 19P3041
public class bruteF_Q1 {
    static void MagicBox(int n){
int matrix[][]=new int[n][n];
int row=0,col=0,rowSum[]=new int[n],colSum[]=new int[n];
matrix[1][1]=5;
boolean check=true;
        for (int i=0;i<=4;i++) {
            matrix[row][col]=i;
            colSum[col]+=i;
            rowSum[row]+=i;
            if(col==0) {
                if (row == 0) {
                    matrix[row + 2][col + 2] = 10 - i;
                    col++;
                }
                else if (row == 1) {
                    matrix[row][col + 2] = 10 - i;
                    row++;
                } else {
                    matrix[row + 2][col + 2] = 10 - i;
                    col++;
                }
            }
            else if (col==1){
                if (row==0){matrix[row+2][col]=10-i;col++;}
                else{matrix[row-2][col]=10-i;col++;}
            }
            else {
                if (row == 0) {
                    matrix[row + 2][col - 2] = 10 - i;
                    row++;
                } else if (row == 1) {
                    matrix[row][col - 2] = 10 - i;
                    row++;
                } else {
                    matrix[row - 2][col -2] = 10 - i;
                }
            }
            colSum[col]+=10-i;
            rowSum[row]+=10-i;}
        do{   Random random = new Random();
            for (int i = matrix.length-1; i > 0; i--) {
                for (int j = matrix.length-1; j > 0; j--) {
                    int m = random.nextInt(i + 1);
                    int x = random.nextInt(j + 1);
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[m][x];
                    matrix[m][x] = temp;
                }
            }
            int rowA = matrix[0][0] + matrix[0][1] + matrix[0][2];
            int rowB = matrix[1][0] + matrix[1][1] + matrix[1][2];
            int  rowC = matrix[2][0] + matrix[2][1] + matrix[2][2];
            int colA = matrix[0][0] + matrix[1][0] + matrix[2][0];
            int colB = matrix[0][1] + matrix[1][1] + matrix[2][1];
            int colC = matrix[0][2] + matrix[1][2] + matrix[2][2];
            int  diagA = matrix[0][0] + matrix[1][1] + matrix[2][2];
            int diagB = matrix[2][0] + matrix[1][1] + matrix[0][2];

            if (rowA == rowB & rowB == rowC & rowC == colA & colA == colB & colB == colC & colC == diagA & diagA == diagB )
                check=false;}while (check);
            for (row = 0; row < n; row++) {
            for (col = 0; col < n; col++)
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
MagicBox(3);
    }
}
