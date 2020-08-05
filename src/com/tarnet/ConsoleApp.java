package com.tarnet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConsoleApp {

    //    private final static MenuItem[] appMenuTree = new MenuItem[3];
    private final static List<MenuItem> appMenuTree = new ArrayList<>();// Inferring LinkedList
    private static BufferedReader consoleReader;
    private static boolean isExited = false;

    public static void main(String[] args) throws IOException {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        GenerateAppMenu();
        do {
            Run(-1);
        } while (!isExited);

    }

    private static void GenerateAppMenu() {
//        appMenuTree[0] = new MenuItem.Builder().withId(1).withTitle("Personel").withDisplayOrder(1).build();
//        appMenuTree[1] = new MenuItem.Builder().withId(2).withTitle("Satislar").withDisplayOrder(2).build();
//        appMenuTree[2] = new MenuItem.Builder().withId(3).withTitle("Krediler").withDisplayOrder(3).build();

        appMenuTree.add(new MenuItem.Builder().withId(1).withTitle("Personel").withParentId(-1).withDisplayOrder(1).build());

        appMenuTree.add(new MenuItem.Builder().withId(11).withTitle("Ekle").withParentId(1).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(12).withTitle("Cikar").withParentId(1).withDisplayOrder(2).build());
        appMenuTree.add(new MenuItem.Builder().withId(13).withTitle("Listele").withParentId(1).withDisplayOrder(3).build());
//----------------------------------------------------------------------------------------------------------------------------
        appMenuTree.add(new MenuItem.Builder().withId(2).withTitle("Satislar").withParentId(-1).withDisplayOrder(3).build());

        appMenuTree.add(new MenuItem.Builder().withId(21).withTitle("Ekle").withParentId(2).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(22).withTitle("Cikar").withParentId(2).withDisplayOrder(2).build());
        appMenuTree.add(new MenuItem.Builder().withId(23).withTitle("Listele").withParentId(2).withDisplayOrder(3).build());
//----------------------------------------------------------------------------------------------------------------------------
        appMenuTree.add(new MenuItem.Builder().withId(3).withTitle("Krediler").withParentId(-1).withDisplayOrder(2).build());

        appMenuTree.add(new MenuItem.Builder().withId(31).withTitle("Ekle").withParentId(3).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(32).withTitle("Cikar").withParentId(3).withDisplayOrder(2).build());
        appMenuTree.add(new MenuItem.Builder().withId(33).withTitle("Listele").withParentId(3).withDisplayOrder(3).build());
    }

    private static void Run(int parentId) throws IOException {
        System.out.println(parentId == -1 ? "0. Exit" : "0.Back"); // TERNARY OPERATOR
        long startTime = System.currentTimeMillis();
//        for (MenuItem menuItem : appMenuTree) {
//            if (menuItem.getParentId() == parentId)
//                System.out.println(menuItem);
//        }
//        long endTime = System.currentTimeMillis() - startTime;
//        System.out.printf("For Menu has been generated in %s ms.\n",endTime);
        //FUNCTIONAL INTERFACE
//        startTime = System.currentTimeMillis();
        appMenuTree
                .stream()
                .filter(menuItem -> menuItem.getParentId() == parentId)
                .sorted(Comparator.comparingInt(MenuItem::getDisplayOrder)) //METHOD REFERENCE OPERATOR
                .forEach(System.out::println);
//                .forEach(m -> System.out.println(m.getDisplayOrder() + "." + m.getTitle()));
//                endTime = System.currentTimeMillis() - startTime;
//        System.out.printf("Stream Menu has been generated in %s ms.\n",endTime);
        System.out.print("Seciminiz:");
        int selectedMenuItem = Integer.parseInt(consoleReader.readLine());
        if (selectedMenuItem == 0 && parentId==-1) {
            isExited = true;
        } else {
            Run(selectedMenuItem);
        }
    }
}
