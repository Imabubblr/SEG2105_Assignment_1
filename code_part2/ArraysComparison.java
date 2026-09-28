package code_part2;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class ArraysComparison {
    
    public static void main(String[] args) {
        int size = 600000000;

        int[] array = new int[size];
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arraylist = new ArrayList<>();

        Random rand = new Random();

        // Measure time for array construction and iteration
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10);
        }
        long arrayConstructionTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long arraySum = 0;
        for (int value : array) {
            arraySum += value;
        }
        long arrayTotalTime = System.nanoTime() - startTime + arrayConstructionTime;
        double arrayTime = (arrayTotalTime - arrayConstructionTime) / 1_000_000_000.0;

        // Measure time for vector construction and iteration
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            vector.add(rand.nextInt(10));
        }
        long vectorConstructionTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long vectorSum = 0;
        Iterator<Integer> vectorIterator = vector.iterator();
        while (vectorIterator.hasNext()) {
            vectorSum += vectorIterator.next();
        }
        long vectorTotalTime = System.nanoTime() - startTime + vectorConstructionTime;
        double vectorTime = (vectorTotalTime - vectorConstructionTime) / 1_000_000_000.0;

        // Measure time for ArrayList construction and iteration
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arraylist.add(rand.nextInt(10));
        }
        long arrayListConstructionTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long arrayListSum = 0;
        Iterator<Integer> arrayListIterator = arraylist.iterator();
        while (arrayListIterator.hasNext()) {
            arrayListSum += arrayListIterator.next();
        }
        long arrayListTotalTime = System.nanoTime() - startTime + arrayListConstructionTime;
        double arrayListTime = (arrayListTotalTime - arrayListConstructionTime) / 1_000_000_000.0;

        System.out.printf("Array sum: %d, construction time: %.3f seconds, iteration time: %.3f seconds%n",
            arraySum, arrayConstructionTime / 1_000_000_000.0, arrayTime);
        System.out.printf("Vector sum: %d, construction time: %.3f seconds, iteration time: %.3f seconds%n",
            vectorSum, vectorConstructionTime / 1_000_000_000.0, vectorTime);
        System.out.printf("ArrayList sum: %d, construction time: %.3f seconds, iteration time: %.3f seconds%n",
            arrayListSum, arrayListConstructionTime / 1_000_000_000.0, arrayListTime);
    }

}
