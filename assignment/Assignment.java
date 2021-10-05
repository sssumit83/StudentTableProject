package com.te.assignment;

import java.util.Scanner;

public class Assignment {
	public static void main(String[] args) {
		Connecting connecting = new Connecting();
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		displayOptions();
		try {
			while (!flag) {
				String choice = scanner.next();
				switch (choice) {
				case "1":
					connecting.displayAll();
					System.out.println("Do you want to Continue (y/n)");
					break;
				case "2": 
					System.out.println("enter the id number :");
					int id = scanner.nextInt();
					connecting.displayByID(id);
					System.out.println("Do you want to Continue (y/n)");
					break;	
				case "3":
					connecting.update();
					System.out.println("Do you want to Continue (y/n)");
					break;
				case "4":
					connecting.delete();
					System.out.println("Do you want to Continue (y/n)");
					break;
				case "5":
					connecting.insert();
					System.out.println("Do you want to Continue (y/n)");
					break;
				case "6":
					System.out.println("-------------------|Thank-You|------------------");
					System.exit(0);
					break;
				case "y":
					displayOptions();
					break;
				case "n":
					System.out.println("-------------------|Thank-You|------------------");
					System.exit(0);
					break;
				default:
					throw new StudentException("please enter a valid option, otherwise get lost!!!");
				}
			}
		} catch (StudentException e) {
			System.err.println(e.getMessage());
		}
		main(null);
	}
	private static void displayOptions() {
		System.out.println("====================================================");
		System.out.println("choose one option");
		System.out.println("----------------------------------------------------");
		System.out.println("press 1 for DisplayAll Details");
		System.out.println("----------------------------------------------------");
		System.out.println("press 2 for Display-By-ID");
		System.out.println("----------------------------------------------------");
		System.out.println("press 3 for update");
		System.out.println("----------------------------------------------------");
		System.out.println("press 4 for delete");
		System.out.println("----------------------------------------------------");
		System.out.println("press 5 for insert");
		System.out.println("----------------------------------------------------");
		System.out.println("press 6 for exit");
		System.out.println("====================================================");
	}
}