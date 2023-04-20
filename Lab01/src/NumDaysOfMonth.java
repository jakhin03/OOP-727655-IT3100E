import java.util.*;

public class NumsDaysOfAMonth {
    public static int findIndex(String arr[], String val)
    {
        for (int i=0; i<arr.length; i++){
            if (arr[i].equals(val)){
                return i;
            }
        }
        return -1;
    }
    private static boolean check(String[] arr, String val) {
        if (findIndex(arr,val) >= 0){
            return true;
        }
        return false;
    }    
    private static boolean checkLeap(int year) {
        boolean test = true;
        if ((year % 100 == 0 && year % 400 != 0) || year % 4 != 0) {
            test = false;
        }
        return test;
    }
    
    private static int convertMonthToInt(String[] months, String month){
        return (findIndex(months,month)%12 + 1);
    }
    
    private static void printAnswer(int month, int year) {
        int m = month;
        if (m % 2 != 0) {
            System.out.println("31");
        } else if(m != 2) {
            System.out.println("30");
        } else {
            if (checkLeap(year)) {
                System.out.println("29");
            } else {
                System.out.println("28");
            }
        }
    }
    
    public static void main(String args[]) {
        //Scan month and year
        String strMonth;
        int year,month;
        String[] months= {"1","2","3","4","5","6","7","8","9","10","11","12","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec","january","february","march","april","may","june","july","august","september","october","november","december","jan.","feb.","mar.","apr.","may.","jun.","jul.","aug.","sep.","oct.","nov.","dec."};
        Scanner input = new Scanner(System.in);

        //input
        while (true) {
        System.out.println("Input month: ");
        strMonth = input.nextLine();
            if (check(months,strMonth)) {
                break;
            }
        }
        System.out.println("Input year: ");
        year = input.nextInt();
        month = convertMonthToInt(months,strMonth);
        input.close();

        // print num days of month
        printAnswer(month,year);
    }
}
