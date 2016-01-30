import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Tester {
	
	public static void main(String[] args) throws IOException {
		
		List<String> list = Files.readAllLines(Paths.get("test_Maze.txt"));
		
		String[] maze = new String[list.size()]; 
		
		for(int i = 0; i < list.size(); i++) {
			maze[i] = list.get(i);
		}
		
		SearchPath.getPath(maze);
		
	}

}
