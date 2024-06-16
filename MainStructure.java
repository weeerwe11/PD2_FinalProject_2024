import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import Code.AccountRelated.AccountRelated;
import Code.FileRelated.FileRelated;
import Code.OperationRelated.OperationRelated;

public class MainStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountRelated ar = new AccountRelated();
        FileRelated fr = new FileRelated();
        OperationRelated or = new OperationRelated();


        String accountName;
        String fileName;
        int option1 = 0;
        int option2 = 0;
        String weight = "";
        int day = 0;
        String schedule = "";
        
        //String name = "";
        //do{

        //}
        //while(name=="");

        //登陸or註冊
        while(true) {
            System.out.println("Sign in press 1, Log in press 2");
            option1 = scanner.nextInt();
            if(option1 == 1) {
                accountName = scanner.next();
                ar.LogIn(accountName);
                if(ar.exist(accountName)) {
                    break;
                }
            }
            else if(option1 == 2) {
                accountName = scanner.next();
                ar.SignUp(accountName);
                if(ar.exist(accountName)) {
                    break;
                }
            }
        }
        fileName = accountName + ".txt";
        fr.parse(fileName); //讀入日記
        
        //操作
        while(true) {
            option2 = scanner.nextInt();
            if(option2 == 1) {  //按輸入日期查詢日程
                day = scanner.nextInt();
                //hashmap裡找對應的key
                or.DQuary(day);
            }
            else if(option2 == 2) {  //按輸入日程查詢日期
                schedule = scanner.next();
                //hashmap裡找對應的value
                or.SQuary(schedule);
            }
            else if(option2 == 3) {  //直接查權重為Emergency的日程和其日期
                or.searchEme();
            }
            else if(option2 == 4) {  //輸出日記中所有日程
                or.allOut();
            }
            else if(option2 == 5) {  //加入日程
                day = scanner.nextInt();
                schedule = scanner.next();
                or.add();
            }
            else if(option2 == 6) {  //刪除日程
                or.delete();
            
            }
            else if(option2 == 7) {  //刪除已過日期前的日程
            
            }
            else {  //logout
                break;
            }
        }
    }
}
