import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LifeGame n = new LifeGame(15,15);
        n.init();

        while(true){

            n.Draw();
            Scanner sc = new Scanner(System.in);
            if(!sc.nextLine().equals("n"))
                break;

        }
    }
}
