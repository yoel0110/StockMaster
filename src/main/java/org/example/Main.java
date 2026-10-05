package org.example;


import stockmarker.entities.Inventori;

import java.math.BigDecimal;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isClose = false;
    public static Inventori _inventory;

    static void main() {
       _inventory = new Inventori();
        while (isClose == false){
            DisplayMenu();
        }
    }

    static void DisplayMenu(){
        IO.println("------------------[ StockMaster ]-----------------------");
        IO.println("1.Listar productos");
        IO.println("2.Regristrar un producto");
        IO.println("3.Actualizar un producto");
        IO.println("4.Eliminar un producto");
        IO.println("0. Salir");
        InteractionMenu();
    }

    static void InteractionMenu(){
        Scanner scanner = new Scanner(System.in);
        IO.println("Seleccione una opción: ");
        var opcion = scanner.nextInt();

        switch (opcion){
            case 1:
                _inventory.ListProducts();
                break;
            case 2:
                _inventory.AddProduct();
                break;
            case 3:
                IO.println("Inserte el id del producto: ");
                _inventory.UpdateProduct(scanner.nextInt());
                break;
            case 4:
                IO.println("Inserte el id del producto: ");
                _inventory.DeleteProduct(scanner.nextInt());
                break;
            case 5:
                isClose = true;
                System.exit(0);
                break;

        }
    }
}
