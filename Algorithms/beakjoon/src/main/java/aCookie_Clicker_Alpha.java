import java.util.Scanner;

public class aCookie_Clicker_Alpha {
    public static void main(String[] args) {
        System.out.println("-------------------------");

        solution("500.0 4.0 2000.0");
        System.out.println("-------------------------");

    }

    private static void solution(int i) {
        for (int j = 0; j < i; j++) {
            Scanner sc=new Scanner(System.in);
            String lineInput = sc.nextLine();
            Double res= solution(lineInput);
        }
    }

    private static Double solution(String lineInput) {
        String[] s = lineInput.split(" ");
        Double C=Double.parseDouble(s[0]);
        Double F=Double.parseDouble(s[1]);
        Double X=Double.parseDouble(s[2]);
        double CF=0.0;
        if (C<X){X-=C;System.out.println(C/2.0);F+=2;}
        while (true){
            if (X-C<C) break;
             CF = C / F;
            System.out.println(CF);
            X-=C;
            F+=2;
        }


         return 0.0;
    }
}
