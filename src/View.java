import java.util.Scanner;

public class View {
    Scanner scanner  = new Scanner(System.in);
    public String getCommand()
    {
       return scanner.nextLine().toLowerCase();
    }
}
