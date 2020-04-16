package view.text;

import controller.GameController;
import model.data.GameEnums;
import model.states.concrete.AwaitShipSelection;
import model.states.concrete.StartGame;

import java.util.Scanner;

public class TextUI implements GameEnums
{
    private GameController gameController;
    private final Scanner scanner;
    private boolean exit;

    public TextUI(GameController gameController)
    {
        this.gameController = gameController;
        this.scanner = new Scanner(System.in);
        this.exit = false;
    }

    public void run()
    {
        while (!exit)
        {
            if (gameController.getState() instanceof StartGame)
            {
                System.out.println("\n\n<Start game phase started.>\n\n");
                startGameInteraction();
            }
            else if (gameController.getState() instanceof AwaitShipSelection)
            {
                System.out.println("\n\n<Ship Selection phase started.>\n\n");
                shipSelectionInteraction();
            }
        }
    }

    /* Interactions */

    /* Start Game */
    private void startGameInteraction()
    {
        System.out.print(startGameMenu());
        int op = readOption();
        switch (op)
        {
            case 1:
                gameController.startGame();
                break;
            case 2:
                System.out.println("TODO"); // TODO
                break;
            case 3:
                System.out.println("Exiting Game..."); // TODO
                exit = true;
            default: break;
        }
    }

    private String startGameMenu()
    {
        StringBuilder s = new StringBuilder();
        s.append("1 - Start game\n");
        s.append("2 - Load game\n");
        s.append("3 - Exit\n");
        s.append("\n$");

        return s.toString();
    }

    /* Ship Selection */
    private void shipSelectionInteraction()
    {
        System.out.print(shipSelectionMenu());
        int op = readOption();
        switch (op)
        {
            case 1:
                gameController.selectShip(ShipType.MINING);
                break;
            case 2:
                gameController.selectShip(ShipType.MILITARY);
                break;
        }
    }

    private String shipSelectionMenu()
    {
        StringBuilder s = new StringBuilder();
        s.append("Choose your ship type:\n");
        s.append("1 - Mining Space Ship\n");
        s.append("2 - Military Space Ship\n");
        s.append("\n$");

        return s.toString();
    }

    /* Utility */
    private int readOption()
    {
        int op;
        while(!scanner.hasNextInt()) scanner.next();
        op = scanner.nextInt();
        return op;
    }
}
