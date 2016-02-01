package toDoList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class saveLoad {
	
	public static void save(ToDoList list, String name) {
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(name + ".bin"))) {
			
			os.writeObject(list);
			
		} catch (FileNotFoundException e) {
			System.out.println("File could not be saved! Please try again");
		} catch (IOException e) {
			System.out.println("File could not be saved! Please try again");
		}
		
	}
	
	public static ToDoList load(String path) {
		
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(path + ".bin"))) {
			
			return (ToDoList) is.readObject();
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found! Please check the Filename");
		} catch (IOException e) {
			System.err.println("File not found! Please check the Filename");
		} catch (ClassNotFoundException e) {
			System.err.println("File not found! Please check the Filename");
		}
		return null;
		
	}

}
