public class Output {
    public void drawGrid(char[] box) {
        System.out.println("\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
    public void printResult(Winner winner) {
        switch (winner) {
            case USER -> System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case PC -> System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case DRAW -> System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
