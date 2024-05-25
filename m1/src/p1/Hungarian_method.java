package p1;

public class Hungarian_method {

    int[][] matrix;

    public Hungarian_method(int[][] matrix){
        this.matrix = matrix;
    }

   /*
    1: Find the min value of each row, denote at r
    2: Subtract the element of each row by the min value of the row
    */

    public void row_helper(){
        // The array contains the min value of each row
        int[] row_min = new int[this.matrix.length];
        for(int i = 0; i<this.matrix.length; i++){
            row_min[i] = Integer.MAX_VALUE;
        }
        // Loop through each row to find the min value of each row
        for(int j = 0; j< this.matrix.length; j++){
            for(int i: matrix[j]){
                if(i<row_min[j]){
                    row_min[j] = i;
                }
            }
        }
        // For each element inside the row, minus the min value of the current row

        for(int i = 0; i<this.matrix.length;i++){
            for(int j = 0; j<this.matrix.length; j++){
                matrix[i][j] = matrix[i][j]-row_min[i];
            }
        }
    }

    public void col_helper(){
        int[] col_min = new int[this.matrix.length];
        for(int i=0; i<col_min.length; i++){
            col_min[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i<this.matrix.length; i++){
            for(int j = 0; j<this.matrix.length; j++){
                if(matrix[i][j]<col_min[j]){
                    col_min[j] = matrix[i][j];
                }
            }
        }

        for(int i = 0; i<this.matrix.length; i++){
            for (int j = 0; j < this.matrix.length; j++) {
                matrix[i][j] = matrix[i][j]-col_min[j];
            }
        }
    }
}
