package IODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadByScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sample.txt"));
        int[] arr = new int[6];
        int index = 0;
        while (sc.hasNextInt()){
            arr[index] = sc.nextInt();
            index++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
