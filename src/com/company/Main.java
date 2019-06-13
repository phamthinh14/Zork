package com.company;

import java.util.*;

public class Main {
    static double currentGold = 0;
    //    static boolean hasEntered;
    static List<Integer> enteredRoom = new ArrayList<>();
    static Map<Integer, String> castleMap = new HashMap<>();
    static Map<Integer, String> roomItems = new HashMap<>();
    static List<String> acquiredItems = new ArrayList<>();
    static boolean foyerEntered = false;
    static boolean isFoyerEntered = true;
    static boolean libraryEntered = false;
    static boolean isLibraryEntered = true;
    static boolean frontRoomEntered = false;
    static boolean isFrontRoomEntered = true;
    static boolean kitchenEntered = false;
    static boolean isKitchenEntered = true;
    static boolean diningRoomEntered = false;
    static boolean isDiningRoomEntered = true;
    static boolean parlorEntered = false;
    static boolean isParlorEntered = true;
    static boolean vaultEntered = false;
    static boolean isVaultEntered = true;

    public static void main(String[] args) {
        // write your code here
        String answer;
        int userInput;
        castleMap.put(1, "Foyer");
        castleMap.put(2, "Library");
        castleMap.put(3, "Kitchen");
        castleMap.put(4, "Vault");
        castleMap.put(5, "Front Room");
        castleMap.put(6, "Dining Room");
        castleMap.put(7, "Parlor");
        castleMap.put(8, "Secret Room");

        roomItems.put(1, "Dead Scorpion");
        roomItems.put(2, "Spiders");
        roomItems.put(3, "Bats");
        roomItems.put(4, "Skeletons");
        roomItems.put(5, "Piano");
        roomItems.put(6, "Dust");
        roomItems.put(7, "Empty Box");
        roomItems.put(8, "Treasure");
        roomItems.put(9, "Piles of Gold");

        do {
            Welcome();
            userInput = new Scanner(System.in).nextInt();
            if (userInput == 1) {
                Foyer();
                FoyerDirection();
                userInput = new Scanner(System.in).nextInt();
                switch (userInput) {
                    case 1:
                        Foyer();
                        FoyerDirection();
                        break;
                    case 2:
                        Library();
                        LibraryDirection();
                        break;
                    case 3:
                        Kitchen();
                        KitchenDirection();
                        break;
                    case 6:
                        DiningRoom();
                        DiningRoomDirection();
                        break;
                    default:
                        System.out.println("Invalid selection");
                }
            } else if (userInput == 5) {
//                    enteredRoom.add(userInput);
                FrontRoom();
                FoyerDirection();
            } else {
                System.out.println("invalid number");
            }


            System.out.println("Do you want to stop the game? If yes, press q");
            answer = new Scanner(System.in).nextLine();
        } while (!answer.equalsIgnoreCase("q"));
        System.out.println("Your current gold is: $" + String.format("%.2f", currentGold));
        System.out.print("You have met: ");
        acquiredItems.forEach(s -> System.out.print(s + " "));
    }

    private static void EnterByFoyer() {
        int userInput;


//        while (userInput<9) {
//            if (userInput == 2) {
//                Library();
//                LibraryDirection();
//                userInput = new Scanner(System.in).nextInt();
//                if (userInput == 1) {
//                    Foyer();
//                    FoyerDirection();
//                }
//                userInput = new Scanner(System.in).nextInt();
//                if (userInput == 2) {
//                    Library();
//                    LibraryDirection();
//                }
//                userInput = new Scanner(System.in).nextInt();
//
//            }
//            if (userInput == 5) {
//                FrontRoom();
//
//            }
//        }
    }


    public static void Welcome() {
        System.out.println("Welcome to the castle");
        System.out.println("*********************");
        System.out.println("Which room to you want to enter? Press 1 for Foyer and 5 for Front Room");
        System.out.println("You can enter the castle through Foyer or Front Room only");
    }

    private static double computeGold() {
        double gold;
        double min = 0;
        double max = 1000;
        gold = min + (max - min) * new Random().nextDouble();
        System.out.println("This room has $" + String.format("%.2f", gold));
        currentGold += gold;
        System.out.println("Your current gold is: $" + String.format("%.2f", currentGold));
        return currentGold;
    }

    private static double hasGold() {
        return currentGold;
    }

    private static void Foyer() {

        if (foyerEntered == false) {
            System.out.println("You are in the Foyer room");
            computeGold();
            System.out.println("You have met " + roomItems.get(1));
            acquiredItems.add(roomItems.get(1));
            foyerEntered = true;
            enteredRoom.add(1);
        }

        if (isFoyerEntered != true) {
            System.out.println("You are in the Foyer room");
            System.out.println("Your current gold is: $" + String.format("%.2f", hasGold()));
            System.out.println("You have met " + roomItems.get(1));
        }

    }

    private static void FoyerDirection() {
        System.out.println("Your next direction can be " + castleMap.get(2) + " or " + castleMap.get(5));
        System.out.println("Enter 2 to go to " + castleMap.get(2) + " or 5 to go to " + castleMap.get(5));

    }


    private static void Library() {
        System.out.println("You have entered the Library");
        if (libraryEntered == false) {
            System.out.println("You are in the Library");
            computeGold();
            System.out.println("You have met " + roomItems.get(2));
            acquiredItems.add(roomItems.get(2));
            libraryEntered = true;
            enteredRoom.add(2);
        }
        if (isLibraryEntered != true) {
            System.out.println("You are in the Library");
            System.out.println("Your current gold is: $" + String.format("%.2f", hasGold()));
            System.out.println("You have met " + roomItems.get(2));
        }
    }

    private static void LibraryDirection() {
        System.out.println("Your next direction can be " + castleMap.get(1) + " or " + castleMap.get(3) + " or " + castleMap.get(6));
        System.out.println("Enter 1 to go to " + castleMap.get(1) + " or 3 to go to " + castleMap.get(3) + " or 6 to go to " + castleMap.get(6));
    }


    private static void DiningRoom() {
        System.out.println("You have entered the Dining Room");
        if (diningRoomEntered == false) {
            System.out.println("You are in the Dining Room");
            computeGold();
            System.out.println("You have met " + roomItems.get(6) + " and " + roomItems.get(7));
            acquiredItems.add(roomItems.get(6));
            acquiredItems.add(roomItems.get(7));
            diningRoomEntered = true;
            enteredRoom.add(6);
        }
        if (isDiningRoomEntered != true) {
            System.out.println("You are in the Library");
            System.out.println("Your current gold is: $" + String.format("%.2f", hasGold()));
            System.out.println("You have met " + roomItems.get(6) + " and " + roomItems.get(7));
        }
    }

    private static void DiningRoomDirection() {
        System.out.println("Your next direction can be " + castleMap.get(2) + " or " + castleMap.get(5) + " or " + castleMap.get(7));
        System.out.println("Enter 2 to go to " + castleMap.get(2) + " or 5 to go to " + castleMap.get(5) + " or 7 to go to " + castleMap.get(7));
    }

    private static void FrontRoom() {
        System.out.println("You have entered the Front Room");
        if (frontRoomEntered == false) {
            System.out.println("You are in the Front Room");
            computeGold();
            System.out.println("You have met " + roomItems.get(5));
            acquiredItems.add(roomItems.get(5));
            frontRoomEntered = true;
            enteredRoom.add(5);
        }
        if (isFrontRoomEntered != true) {
            System.out.println("You are in the Library");
            System.out.println("Your current gold is: $" + String.format("%.2f", hasGold()));
            System.out.println("You have met " + roomItems.get(5));
        }
    }

    private static void FrontRoomDirection() {
        System.out.println("Your next direction can be " + castleMap.get(1) + " or " + castleMap.get(6));
        System.out.println("Enter 1 to go to " + castleMap.get(1) + " or 6 to go to " + castleMap.get(6));

    }

    private static void Kitchen() {
        System.out.println("You have entered the Kitchen");
        if (kitchenEntered == false) {
            System.out.println("You are in the Kitchen");
            computeGold();
            System.out.println("You have met " + roomItems.get(3));
            acquiredItems.add(roomItems.get(3));
            kitchenEntered = true;
            enteredRoom.add(3);
        }
        if (isKitchenEntered != true) {
            System.out.println("You are in the Library");
            System.out.println("Your current gold is: $" + String.format("%.2f", hasGold()));
            System.out.println("You have met " + roomItems.get(3));
        }
    }

    private static void KitchenDirection() {
        System.out.println("Your next direction can be " + castleMap.get(2) + " or " + castleMap.get(4) + " or " + castleMap.get(7));
        System.out.println("Enter 2 to go to " + castleMap.get(2) + " or 4 to go to " + castleMap.get(4) + " or 7 to go to " + castleMap.get(7));
    }


}
