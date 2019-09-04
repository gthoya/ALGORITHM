package gthoya.codility.tutorial.timecomplexty;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if (X > Y) {
            return 0;
        }

        int distance = Y - X;
        return (distance / D) + (distance % D == 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10, 85, 30));
    }
}
