import java.util.List;
import java.util.Map;

public class OperationRelated { //form:
                                //0101 sleep
                                //1209 homework...
    public void DQuery(int date, Map<Integer, List<String>> operator) {
        List<String> schedules = operator.get(date);
        int month = date / 100;
        int day = date % 100;
        System.out.println(month + "月" + day + "日 的日程：");
        if(schedules != null && !schedules.isEmpty()) {
            for(String schedule : schedules) {
                System.out.println(schedule);
            }
        }
        else {
            System.out.println("無預定行程");
        }
    }

    public void SQuery(String schedule, Map<Integer, List<String>> operator) {
        boolean hasFound = false;
        System.out.println("有該預定行程的日期：");
        for(Map.Entry<Integer, List<String>> entry : operator.entrySet()) {
            if(entry.getValue().contains(schedule)) {
                int month = entry.getKey() / 100;
                int day = entry.getKey() % 100;
                System.out.println(month + "月" + day + "日");
                hasFound = true;
            }
        }
        if(!hasFound) {
            System.out.println("無");
        }
    }

    public void allOut(Map<Integer, List<String>> operator) {
        System.out.println("所有日程：");
        for(Map.Entry<Integer, List<String>> entry : operator.entrySet()) {
            int month = entry.getKey() / 100;
            int day = entry.getKey() % 100;
            System.out.println(month + "月" + day + "日" + " 的日程：");
            for(String schedule : entry.getValue()) {
                System.out.println(schedule);
            }
        }
    }

    public void add(int date, String schedule, Map<Integer, List<String>> operator, String accountData) {
        
    }

    public void delete(String schedule, Map<Integer, List<String>> operator, String fileName) {

    }
}
