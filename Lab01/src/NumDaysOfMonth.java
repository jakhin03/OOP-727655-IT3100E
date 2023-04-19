public class NumsDaysOfAMonth {
    private static boolean check(String[] arr, String val) {
        boolean test = false;
        for (int element : arr) {
            if (element == val) {
                test = true;
                break;
            }
        }
        return test;
    }
    
    private static boolean chekLeap(int year) {
        boolean test = true;
        if ((year % 100 == 0 && year % 400 != 0) || year % 4 != 0) {
            test = false;
        }
        return test;
    }
    
    private static int convertMonthToInt(String[] months, String month){
        return (months.indexOf(month)%12 + 1);
    }
    
    private static void printAnswer(String month, int year) {
        int m = 2;
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
        String month;
        int year;
        String[] months= {"1","2","3","4","5","6","7","8","9","10","11","12","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec","january","february","march","april","may","june","july","august","september","october","november","december","jan.","feb.","mar.","apr.","may.","jun.","jul.","aug.","sep.","oct.","nov.","dec."};
        Scanner input = new Scanner(System.in);
        while true {
        month = input.nextInt();
            if check(months,month) {
                break;
            }
        }
        year = nextInt();
        month = convertMonthToInt(months,month);

        //Print answer
        printAnswer(month,year);
    }
}
