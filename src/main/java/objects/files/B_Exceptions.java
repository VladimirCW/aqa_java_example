package main.java.objects.files;

public class B_Exceptions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        try {
            System.out.println(arr[10]);
        } catch (Exception e) {
            System.out.println("Out of bound");
        }
        callFn(arr);
    }

    public static void callFn(int[] arr) {
        try {
            printArray(arr);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("It is exception");
        } finally {
            System.out.println("Finaly block");
        }
    }

    public static void printArray(int[] arr) throws ArrayIndexOutOfBoundsException {
        System.out.println(arr[1]);
    }
}
