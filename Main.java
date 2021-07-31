package solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    /* Usually don't bother yourself by looking here, it's just for testing purpose (Yeah, people before JUnit lives here) */
    public static void main(String[] args) throws IOException {
        int[] a = {1,3,5,2,4,6};
        int[] a2 = {1,3,5,2};

        Scanner scanner = new Scanner(new File("inputArr.txt"));
        int [] arr = new int [100000];
        int i = 0;
        while(scanner.hasNextInt()){
            arr[i++] = scanner.nextInt();
        }
        CountingInversions c = new CountingInversions();
        int[] b = arr.clone();
        long ans = c.countInversions(b);
        System.out.println("From naive: "+ c.naiveCountInversions(b));
        System.out.println("From rec: "+ ans);
    }
}
