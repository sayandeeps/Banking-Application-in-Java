import java.io.*;
import java.util.Scanner;

public class RegisterModule {
    public  boolean validregister(String name, String phone, String pin)  {
        String filepath="credentials.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true))){
            String line = name+","+phone+","+pin;
            writer.write(line);
            writer.newLine();
            String[] parts = line.split(",");
            String folderPath = "./data/";
            new File(folderPath).mkdirs();
            String filename=parts[1];
            String filePath = folderPath +filename+ ".txt";
            BufferedWriter newuser = new BufferedWriter(new FileWriter(filePath,true));
            String bal="0";
            newuser.write("Account balance:\n");
            newuser.write(bal+"\n");
            newuser.close();
            writer.close();
            return true;


        }
        catch (Exception e){
            System.out.println("There is some problem with the input credentials");
        }
        return false;

    }
    public void register(){
        System.out.println("-----------------------------------------------------------------------------------");
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your Name");
        String name = sc.nextLine();
        System.out.println("Enter your phone number");
        String phone=sc.next();
        System.out.println("Enter a pin");
        String pin = sc.next();
        if(validregister(name,phone,pin)==true){
            System.out.println("Registration Sccessful!!");
        }
        else{
            System.out.println("Registration Not Successful!!");
        }
    }
}
