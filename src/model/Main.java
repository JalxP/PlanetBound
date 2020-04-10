package model;

import controller.GameController;
import ui.TextUI;

public class Main
{
    public static void main(String[] args)
    {
        TextUI textUI = new TextUI(new GameController());
        textUI.run();
    }
}
