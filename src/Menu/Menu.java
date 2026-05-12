package Menu;

import Utilities.MenuMessage;

public class Menu implements MenuInterface{

    @Override
    public void displayMenu() {
        System.out.println(MenuMessage.MainMenu);
    }
}