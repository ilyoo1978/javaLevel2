package lesson2.hw2;

import java.util.Arrays;

public class HomeWork2 {
    private static String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static final int MATRIX_SIZE = 4;

    private static String[][] stringToMultiArr (String str) throws MatrixSizeException{
        String[][] resultArr;
        String[] lines = str.split("\n");
        resultArr = new String[lines.length][];
        for(int i=0; i < lines.length; i++){
            resultArr[i] = lines[i].split(" ");
            if(resultArr[i].length != MATRIX_SIZE){
                throw new MatrixSizeException();
            }
        }
        if(resultArr.length != MATRIX_SIZE ){
            throw new MatrixSizeException();
        }
        return resultArr;
    }

    private static int[][] stringArrToIntArr(String[][] arr) throws NumberFormatException{
        int[][]resultArr = new int[MATRIX_SIZE][MATRIX_SIZE];
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                resultArr[i][j] = Integer.parseInt(arr[i][j]);
            }
        }
        return resultArr;
    }

    private static float findHalfSumOfArrElements(int[][]arr){
        float result = 0;
        for(int[] line: arr){
            result += Arrays.stream(line).sum();
        }
        return result / 2;
    }

    public static void main(String[] args) {
        try {
            String[][] matrixOfString;
            int[][] matrixOfint;
            float result;
            matrixOfString = stringToMultiArr(str);
            matrixOfint = stringArrToIntArr(matrixOfString);
            result = findHalfSumOfArrElements(matrixOfint);
            System.out.println(result);

            //ну или в одну строчку с кучей смайлов на конце)
            System.out.println(findHalfSumOfArrElements(stringArrToIntArr(stringToMultiArr(str))));

        }catch (MatrixSizeException e){
            System.out.println("тут надо что-то сделать, но я не знаю что, поэтому просто выводим ошибку.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("В вашей строке должны быть только цифры.");
            e.printStackTrace();
        }

    }

}

class MatrixSizeException extends IllegalArgumentException{
    MatrixSizeException(){
        super("The input string is not valid.");
    }
}
