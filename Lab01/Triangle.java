 class Triangle{
    public static void main(String[] args) {
        int n;
        Scanner keyboard = new Scanner(System.in);
        n = keyboard.nextInt();
        scan.close();
        System.out.println(n);
        
        for (int i=0; i<n; i++){
            for (int j=0; j<(n-i); j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j=0; j<(n-1); j++){
                System.out.print(" ");
            }
        }
    }
}
