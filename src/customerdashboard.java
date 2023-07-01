import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class customerdashboard {
    String customer;
    public void update(int bal,String filePath){
        try{
            String bale= String.valueOf(bal);
            RandomAccessFile file = new RandomAccessFile(filePath,"rw");
            long filePointer =0;
            for(int i =1;i<2;i++){
                String line = file.readLine();
                filePointer=file.getFilePointer();
            }
            file.seek(filePointer);
            file.writeBytes(bale+"\n");

            file.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void dashboard() throws IOException {
        String folderPath = "./data/";
        String filePath = folderPath+customer+".txt";
        String l2=Files.readAllLines(Paths.get(filePath)).get(1);
        int cbal = Integer.parseInt(l2);

        while(true){
            System.out.println("-----------------------------------------------------------------------------------");
            Scanner sc =new Scanner(System.in);
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction");
            System.out.println("5. Exit");
            int op=sc.nextInt();
            if(op==5){
                break;
            }
            else if (op ==4){
                System.out.println("-----------------------------------------------------------------------------------");
                try(BufferedReader r= new BufferedReader(new FileReader(filePath))){
                    String line;
                    while((line = r.readLine())!=null){
                        System.out.println(line);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if (op==1){
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("The Available balance is :"+cbal);
            }
            else if (op ==3){
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Enter the amount you want to deposit :");
                int depamt=sc.nextInt();
                cbal=cbal+depamt;
                update(cbal,filePath);
                System.out.println("Amount Withdrawn Successfully");
                System.out.println("Present Balance: "+cbal);
                try(BufferedWriter br= new BufferedWriter(new FileWriter(filePath,true))){
                    Date currentDate = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = dateFormat.format(currentDate);
                    br.write(depamt+" Credited at "+formattedDateTime+": Available Balance: "+cbal+"\n");
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            else if(op==2){
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Enter the amount you want to withdraw :");
                int drawamt=sc.nextInt();
                if(drawamt>cbal){
                    System.out.println("Insufficient Fund");
                }
                else{
                    cbal=cbal-drawamt;
                    update(cbal,filePath);
                    System.out.println("Amount Withdrawn Successfully");
                    System.out.println("Present Balance: "+cbal);
                    try(BufferedWriter br= new BufferedWriter(new FileWriter(filePath,true))){
                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = dateFormat.format(currentDate);
                        br.write(drawamt+" Debited at "+formattedDateTime+": Available Balance: "+cbal+"\n");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    customerdashboard(String user){
        customer=user;
    }
}
