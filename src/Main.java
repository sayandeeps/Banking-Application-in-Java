import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Register Your self");
            System.out.println("2. Exit");
            int c= sc.nextInt();
            if(c==2){
                break;
            }
            else if (c==1){
                RegisterModule r= new RegisterModule();
                r.register();
            }
            else {
                System.out.println("Invalid choice ! ");
            }
        }
    }
}