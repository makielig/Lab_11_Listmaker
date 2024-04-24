import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> lines = new ArrayList<>();
    private static String line = "";

    public static void main(String[] args) {
        String menuPrompt = "A - Add  D - Delete  P - Print  Q - Quit";
        String cmd = ""; // A D V or Q

        boolean done = false;
        boolean confirmQuit = false;

        do {
            displayList();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    confirmQuit = SafeInput.getYNConfirm(in,"Are you sure you want to quit");
                    if(confirmQuit)
                        System.exit(0);
                    break;
            }
        }while(!done);
    }


    private static void printList() {
        displayList();
    }

    private static void addItem() {
        line = SafeInput.getNonZeroLenString(in, "Enter the new item to add to the list");
        lines.add(line);
    }

    private static void deleteItem() {
        int itemToDelete = 0;
        itemToDelete = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, lines.size());
        itemToDelete = itemToDelete - 1;
        lines.remove(itemToDelete);
    }

    private static void displayList()
    {
        System.out.println("==================================================");
        if (lines.size() > 0)
        {
            int itemNum = 1;
            for (String l : lines)
            {
                System.out.println(itemNum + ". " + l);
                itemNum++;
            }
        }
        else {
            System.out.println("Currently, the list is empty!");
        }
        System.out.println("=================================================");
    }
    }

