import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File; 
import java.io.IOException;
import java.util.Calendar;


public class PrimeNumbers extends Thread {

    private static int size;
    private static double totalofAllPrimes = 0;
    List<Integer> PrimeNumberList = new ArrayList<Integer>();


    public List<Integer> getPrimeNumberList() {
        return PrimeNumberList;
    }

    void sieveOfEratosthenes(int n) {

        String name = "threadName";
        Thread t;
        t = new Thread(this, name);

        t.start();
        
        boolean prime[] = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            prime[i] = true;

        }

        try {
            for (int p = 2; p * p <= n; p++) {
                // If prime[p] is not changed, then it is a prime
                if (prime[p] == true) {
                    // Update all multiples of p
                    for (int test = p * p; test <= n; test += p) {
                        prime[test] = false;
                        
                    }
                    Thread.sleep(1 / 1000000000);
                }

            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                PrimeNumberList.add(i);

            }
        }
        
        // Put in all prime numbers

        for (int i = 0; i < PrimeNumberList.size(); i++) {
            totalofAllPrimes += PrimeNumberList.get(i);

        }

        size = PrimeNumberList.size();

    }


    // Driver Program to test above function
    public static void main(String args[]) {

        int n = 100000000;


        PrimeNumbers g = new PrimeNumbers();

        long startTime = Calendar.getInstance().getTimeInMillis();
        g.sieveOfEratosthenes(n);
        long endTime = Calendar.getInstance().getTimeInMillis();


        List<Integer> lastPrime = g.getPrimeNumberList().subList(g.getPrimeNumberList().size() - 10, g.getPrimeNumberList().size());


        //<execution time>  <total number of primes found>  <sum of all primes found>  <top ten maximum primes, listed in order from lowest to highest> 
        
    
            File myObj = new File("primes.txt");


        try
        {
            FileWriter myWriter = new FileWriter("primes.txt");
            myWriter.write("Time taken: " + (endTime - startTime) + " ms\n");
            myWriter.write(String.valueOf(totalofAllPrimes) + "\n");
            myWriter.write(String.valueOf(size) + "\n");
    
            BufferedWriter bw = new BufferedWriter(myWriter);
            for (int i = 0; i < 10; i++) {
                bw.write(lastPrime.get(i).toString() + ", ");
            }
            bw.flush();
            bw.close();
            myWriter.close();
        }
        catch(IOException e)
        {

        }


    }

}
