import java.io.*;

public class AccountRelated {

    FileRelated fr = new FileRelated();

    public void SignUp(String name) { //註冊
        File accListFile = new File("accList.txt");
    
        //不存在就創一個
        if(!accListFile.exists()) {
            try {
                accListFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        boolean isExist = false;
    
        //檢查帳號是否已經存在
        try(BufferedReader br = new BufferedReader(new FileReader(accListFile))) {
            String account;
            while ((account = br.readLine()) != null) {
                if (name.equals(account)) {
                    isExist = true;
                    break;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    
        if(isExist) {
            System.out.println("帳號已存在。");
            System.out.println("登錄成功。");
        }
        else {
            //帳號不存在就加入
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(accListFile, true))) {
                bw.write(name);
                bw.newLine();
                fr.create(name); //創建對應的diary.txt
                System.out.println("帳號已創建。");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void LogIn(String name) { //登入
        File accListFile = new File("accList.txt");
    
        //不存在就創一個
        if(!accListFile.exists()) {
            try {
                accListFile.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    
        boolean isExist = false;
    
        //檢查帳號是否存在
        try(BufferedReader br = new BufferedReader(new FileReader(accListFile))) {
            String account;
            while((account = br.readLine()) != null) {
                if(name.equals(account)) {
                    isExist = true;
                    break;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    
        if(!isExist) {
            System.out.println("帳號不存在，請註冊。");
        }
        else {
            System.out.println("登錄成功。");
        }
    }
    
    public Boolean exist(String name) { //檢查帳號是否已經存在
        File accListFile = new File("accList.txt");
        boolean isExist = false;
    
        //檢查帳號是否已經存在
        try(BufferedReader br = new BufferedReader(new FileReader(accListFile))) {
            String account;
            while ((account = br.readLine()) != null) {
                if (name.equals(account)) {
                    isExist = true;
                    break;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return isExist;
    }
}
