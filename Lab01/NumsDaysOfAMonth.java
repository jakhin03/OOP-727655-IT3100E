public class NumsDaysOfAMonth {
    private static boolean check(int[] arr, int val) {
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
        boolean test = false;
        if ((year % 100 == 0 && year % 400 != 0) || year % 4 != 0){
            test = 
        }
        }
    public static void main(String args[]) {
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


    }
}
