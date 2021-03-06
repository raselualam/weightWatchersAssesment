import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.nio.file.Files;

/*There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

Apple – a fruit, a tech firm

Table – an object, contains rows and columns when used in context of computers

Orange – a fruit

Given a path to the file, do the following:

Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception. Read each word and its possible meanings and print them out. Your output should look like this:

Word1

Meaning 1

Meaning 2

Word2

Meaning1

Meaning2

Use appropriate data structures wherever necessary.*/

public class Solution1 { 

	public static void main(String[] args) {

		doesFileExist(System.getProperty("user.dir") + "/file.txt");
		readFileContents();
	}

	public static void doesFileExist(String path) {

		File f = new File(path);
		if (f.exists() && !f.isDirectory()) {
			System.out.println("file exists");

		} else {

			System.out.println("file does not exist");
		}

	}

	public static void readFileContents() {

		String fileName = System.getProperty("user.dir") + "/file.txt";

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;

			List<String> list = new ArrayList<String>();
			while ((str = in.readLine()) != null) {
				list.add(str);
			}

			String[] stringArr = list.toArray(new String[0]);

			String[] word1 = stringArr[0].split("–");
			System.out.println(word1[0]);

			String[] meaning = word1[1].split(",");
			System.out.println(meaning[0]);
			System.out.println(meaning[1]);

			String[] stringArr2 = list.toArray(new String[1]);

			String[] word2 = stringArr2[1].split("–");
			System.out.println(word2[0]);

			String[] meaning2 = word2[1].split(",");
			System.out.println(meaning2[0]);
			System.out.println(meaning2[1]);


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
