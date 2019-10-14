package lesson_five.hw5;

import java.util.Arrays;

public class MultiThreadsSpeedExample {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static void initArrWith(float a){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = a;
        }
    }
    static float changeValueByFormula(float x, int i){
        return (float)(x * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    static long findChangeArrTime(){
        long startTime, finalTime;
        initArrWith(1f);
        startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = changeValueByFormula(arr[i], i);
        }
        finalTime = System.nanoTime();

        return (finalTime - startTime)/1000000;
    }

    static long findChangeArrInMultiThreadTime(){
        long startTime, finalTime;
        initArrWith(1);
        startTime = System.nanoTime();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(new ChangeArr(a1, 0));
        Thread t2 = new Thread(new ChangeArr(a2, h));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
             e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        finalTime = System.nanoTime();
        return (finalTime - startTime)/1000000;
    }

    public static void main(String[] args) {
        float[] result1 = new float[arr.length];
        float[] result2 = new float[arr.length];
        System.out.println("Method1 (simple) time: " + findChangeArrTime() + "ms");
        System.arraycopy(arr, 0, result1, 0, arr.length);
        System.out.println("Method2 (MultiThread) time: " + findChangeArrInMultiThreadTime() + "ms");
        System.arraycopy(arr, 0, result2, 0, arr.length);
        System.out.println(Arrays.equals(result1, result2));

    }
}

class ChangeArr implements Runnable{
    int h;
    float[]arr;
    ChangeArr(float[] arr, int h){
        this.arr = arr;
        this.h =h;
    }
    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = MultiThreadsSpeedExample.changeValueByFormula(arr[i], i + h);
        }
    }
}