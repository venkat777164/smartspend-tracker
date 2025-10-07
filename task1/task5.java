class task{
    public static void main(String[] args) {
        int limit = 5;
        for (int i = 1; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                for (int k = 1; k <= limit; k++) {
                    System.out.println("i=" + i + " j=" + j + " k=" + k);
                }
            }
        }
    }
}
