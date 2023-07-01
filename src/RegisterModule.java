import java.io.*;
import java.util.Scanner;

public class RegisterModule {
    public  boolean validregister(String name, Long phone, int pin)  {
        String filepath="credentials.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true))){
            writer.write(name+","+phone+","+pin);
            writer.newLine();
            return true;
        }
        catch (Exception e){
            System.out.println("There is some problem with the input credentials");
        }
        return false;

    }
    public void register(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your Name");
        String name = sc.nextLine();
        System.out.println("Enter your phone number");
        Long phone=sc.nextLong();
        System.out.println("Enter a pin");
        int pin = sc.nextInt();
        if(validregister(name,phone,pin)==true){
            System.out.println("Registration Sccessful!!");
        }
        else{
            System.out.println("Registration Not Successful!!");
        }
    }
}
