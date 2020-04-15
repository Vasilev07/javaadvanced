public class BoxedPrimitives {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        nonBoxedSum();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }

    private static long boxedSum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    private static long nonBoxedSum() {
        long sum = 0L;
        long IntMaxValue = Integer.MAX_VALUE;
        for (long i = 0; i <= IntMaxValue; i++)
            sum += i;
        return sum;
    }
}
