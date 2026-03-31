import java.io.*;
public class Program6 {
public static void main(String[] args) {
// Give directory path (you can change this)
File dir = new File(".");
// Get list of files
File[] files = dir.listFiles();
if (files == null) {
System.out.println("Invalid Directory!");
return;
}
System.out.println("Files in Directory:");
for (File file : files) {
if (file.isFile()) {
System.out.println(file.getName())
;
}
}
}
}