import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRelated {

    public List<String> accountList = new ArrayList<>();
    FileRelated fr = new FileRelated();

    public void set (List<String> accountList) {
        this.accountList = accountList;
    }
    
    public void SignUp(String name) {
        System.out.println("Already exist");
    }
    
    public void LogIn(String name) {
        
        for(String account : accountList) {
            
            if(name.equals(account)) {
                fr.input(account);
                
            }
            else {
                System.out.println("Not exist, please sign up.");
            }
        }
    }

    public Boolean exist(String name) {
        
        return true;
    }
}
