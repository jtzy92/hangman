package joey;

public class PrintHangedMan {
    public PrintHangedMan() {
    }
    public static void printHangMan(Integer wrongCount) {
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
                System.out.println("You Lose");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }
}


