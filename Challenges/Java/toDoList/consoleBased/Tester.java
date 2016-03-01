package toDoList;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		ToDoList test = new ToDoList();
		boolean run = true;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Your List is empty...");
		System.out.println();
		
		System.out.println("Commands: \n----------\nload\nsave\nprint\nadd\ndelete\nsort\nshuffle\nupdate\nnew\nexit\n----------");
		
		while (run) {
			
			String currIn = scanner.nextLine();

			switch (currIn) {
			case "new":
				test.clearList();
				break;
			case "help":
				System.out.println("Commands: \n----------\nload\nsave\nprint\nadd\ndelete\nsort\nshuffle\nupdate\nnew\nexit\n----------");
				break;
			case "save":
				System.out.println("What name do you want your file to have?...");
				saveLoad.save(test, scanner.nextLine());
				break;
			case "load":
				System.out.println("What's the name of the file?...");
				test = saveLoad.load(scanner.nextLine());
				break;
			case "print":
				test.print();
				break;
			case "add":
				System.out.println("How many task do you want to add?...");
				int temp = scanner.nextInt();
				scanner.nextLine();
				for(int i = 0; i < temp; i++){
					System.out.print("(" + (i + 1) + ")");
					test.addItems(scanner.nextLine());
				}
				break;
			case "delete":
				System.out.println("Which Item do you want to delete?...(index)");
				test.removeItem(scanner.nextLine());
				break;
			case "sort":
				test.sort();
				break;
			case "shuffle":
				test.shuffle();
				break;
			case "update":
				System.out.println("Which task do you want to update?...(old, new)");
				String oldTemp = scanner.nextLine();
				String newTemp = scanner.nextLine();
				test.updateItem(oldTemp, newTemp);
				break;
			case "exit":
				run = false;
				scanner.close();
				break;
			default:
				System.out.println("No fitting command");
				break;
			}
			
			System.out.println("----------");
	
		}
		
		System.out.println("ToDoList closed...");
	}
	
}
