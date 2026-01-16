import java.io.*;

public class Read {
    public void readFile() {
        try {
            String path = "C:/Users/Rajesh Ramdev/Desktop/EAT.txt";
            FileInputStream fis = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("File Not Found to read");
        }
    }
    public void writeFile()
    {
        try{
            String path1 = "C:/Users/Rajesh Ramdev/Desktop/EAT.txt";
            FileOutputStream fos = new FileOutputStream(path1);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.flush();
            writer.newLine();
            writer.write("Hello JAVA");
            writer.close();

        } catch (Exception e)
        {
            System.out.println("File Not found to write");
        }
    }
    public static void main(String[] args) {
        Read fr = new Read();
        fr.readFile();
        fr.writeFile();
    }
}


