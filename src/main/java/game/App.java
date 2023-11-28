package game;

import java.util.logging.Logger;

public class App {
        Logger logger = Logger.getLogger(App.class.getName());
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public void startGame () {
        Welcome welcome = new Welcome();
        Human human = new Human();
        Computer computer = new Computer();
        while (true) {
            welcome.start(box);
            if (human.playerMove(box)) {
                logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if (computer.computerMove(box)) {
                logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if (new BoxIsAvailble().isAvailbl(box)) {
                logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
        }
    }
}
