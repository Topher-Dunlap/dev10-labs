import java.util.Locale;
import java.util.Scanner;

public class Dungeon {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String userLocation = "Dungeon Entrance";
        String userCmd = " ";

        System.out.println("*** \n " +
                "You awaken in a dark dungeon \n " +
                "****** \n" +
                "There's an entrance in front of you and an exit behind you. \n" +
                "The exit is locked! \n" +
                "A message reads \" FIND THE KEY IN THE DUNGEON TO OPEN THE EXIT! \""
        );
        System.out.println();
        System.out.println();

        boolean hasKey = false;
        boolean hasMoved = false;

        System.out.println("* There is an exit door to your South \n");
        System.out.println("* There is an entrance door to your North \n");

        while (!userCmd.equalsIgnoreCase("quit")) {
            // TODO Tell user their location
            System.out.printf("*** You are in %s ***\n", userLocation);
            System.out.println();

            // TODO Tell user what they can see
            if (userLocation.equals("Dungeon Entrance")) {
                if (hasMoved) {
                    System.out.println("* There is an exit door to your South \n");
                    System.out.println("* There is an entrance door to your North \n");
                }
            } else if (userLocation.equals("Key Room")) {
                if (hasMoved) {
                    System.out.println("* There is a door to your South \n");
                }
                if (!hasKey) {
                    System.out.println("* There is a key on the floor!! \n");
                }
            } else {
                if (hasMoved) {
                    System.out.printf("There is nothing around \n");
                }
            }


            // TODO Prompt for user cmd
            System.out.print("What do you do? ");
            userCmd = userInput.nextLine();
            // COMMAND + " " + ITEM/DIRECTION
            String sysCommand = "";
            String sysItems = "";

            for (int i = 0; i < userCmd.length(); i++) {
                if (!Character.isWhitespace(userCmd.charAt(i))) {
                    sysCommand += userCmd.charAt(i);
                } else {
                    sysItems = userCmd.substring(i + 1);
                    sysItems = sysItems.toLowerCase();
                    break;
                }
            }

            // TODO Complete user action behind the scenes
            // MOVE
            if (sysCommand.equalsIgnoreCase("MOVE")) {
                if (userLocation.equals("Dungeon Entrance")) {
                    switch (sysItems) {
                        case "north":
                            System.out.println("You go North");
                            userLocation = "Key Room";
                            System.out.println(userLocation);
                            hasMoved = true;
                            break;
                        case "east":
                            System.out.println("There is no path \n");
                            hasMoved = false;
                            break;
                        case "west":
                            System.out.println("There is no path \n");
                            hasMoved = false;
                            break;
                        case "south":
                            System.out.println("The door is locked...is there a key?");
                            hasMoved = false;
                            break;
                    }
                } else {
                    switch (sysItems) {
                        case "north":
                            System.out.println("There is no path \n");
                            hasMoved = false;
                            break;
                        case "east":
                            System.out.println("There is no path \n");
                            hasMoved = false;
                            break;
                        case "west":
                            System.out.println("There is no path \n");
                            hasMoved = false;
                            break;
                        case "south":
                            System.out.println("You go South \n");
                            userLocation = "Dungeon Entrance";
                            hasMoved = true;
                            break;
                    }

                }
            } else if (sysCommand.equalsIgnoreCase("PICKUP")) {
                if (userLocation.equals("Dungeon Entrance")) {
                    System.out.println("Nothing to pick up here");
                } else {
                    switch (sysItems) {
                        case "key":
                            System.out.println("Picked up key");
                            hasKey = true;
                            hasMoved = false;
                            break;
                    }
                }
            } else if (sysCommand.equalsIgnoreCase("USE")) {
                if (userLocation.equals("Dungeon Entrance")) {
                    switch (sysItems) {
                        case "key":
                            if (hasKey) {
                                System.out.println("You open the door! You win!");
                                userCmd = "quit";
                            }
                            break;
                    }
                } else {
                    System.out.println("Nothing to USE here.");
                }
            }
            // PICKUP
            // USE


            // TODO Describe what happened


            // TODO End User Turn
        }

        System.out.println("Goodbye. Thanks for playing!");
    }
}
