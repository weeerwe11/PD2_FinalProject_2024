import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
        String option3 = "";
        int day = 0;
        String schedule = "";

        //登陸or註冊
        while(true) {
            System.out.println("請選擇操作：");
            System.out.println("(1)-註冊帳號");
            System.out.println("(2)-登入帳號");
            
            while (!scanner.hasNextInt()) {
                System.out.println("請輸入有效選項（1或2）：");
                scanner.next();  //清除緩衝區
            }

            option1 = scanner.nextInt();
            scanner.nextLine();
            if(option1 == 1) {
                System.out.println("請輸入帳號名稱進行註冊：");
                accountName = scanner.nextLine();
                ar.SignUp(accountName);
                if(ar.exist(accountName)) {
                    break;
                }
            }
            else if(option1 == 2) {
                System.out.println("請輸入帳號名稱進行登錄：");
                accountName = scanner.nextLine();
                ar.LogIn(accountName);
                if(ar.exist(accountName)) {
                    break;
                }
            }
        }
        
        fileName = accountName + ".txt";
        Map<Integer, List<String>> operationFile = fr.parse(fileName); //讀入日記
        
        //操作
        while(true) {
            System.out.println("請選擇操作：");
            System.out.println("(1)-按日期查詢日程");
            System.out.println("(2)-按日程查詢日期");
            System.out.println("(3)-輸出所有日程");
            System.out.println("(4)-加入日程");
            System.out.println("(5)-刪除日程");
            System.out.println("其他數字-登出");

            while (!scanner.hasNextInt()) {
                System.out.println("請輸入有效選項：");
                System.out.println("(1)-按日期查詢日程");
                System.out.println("(2)-按日程查詢日期");
                System.out.println("(3)-輸出所有日程");
                System.out.println("(4)-加入日程");
                System.out.println("(5)-刪除日程");
                System.out.println("其他數字-登出");
                scanner.next();
            }
            
            option2 = scanner.nextInt();
            scanner.nextLine();

            if(option2 == 1) {  //按輸入日期查詢日程
                System.out.println("請輸入日期(例；一月一日請輸入0101)：");
                day = scanner.nextInt();
                scanner.nextLine();
                or.DQuery(day, operationFile);
            }
            else if(option2 == 2) {  //按輸入日程查詢日期
                System.out.println("請輸入日程：");
                schedule = scanner.nextLine();
                or.SQuery(schedule, operationFile);
            }
            else if(option2 == 3) {  //輸出日記中所有日程
                or.allOut(operationFile);
            }
            else if(option2 == 4) {  //加入日程
                System.out.println("請輸入日期(例；一月一日請輸入0101)：");
                day = scanner.nextInt();
                scanner.nextLine();
                System.out.println("請輸入日程：");
                schedule = scanner.nextLine();
                or.add(day, schedule, operationFile, fileName);
            }
            else if(option2 == 5) {  //刪除日程
                System.out.println("請輸入要刪除的日程：");
                schedule = scanner.nextLine();
                or.delete(schedule, operationFile, fileName);
            }
            else {  //logout
                System.out.println("登出成功。");
                break;
            }
            System.out.println("是否繼續操作(y/n)");
            option3 = scanner.nextLine();
            if(option3.equals("y")) {
                continue;
            }
            else if(option3.equals("n")) {
                break;
            }
            else {
                System.out.println("無效操作");
            }
        }
        scanner.close();
    }
}
