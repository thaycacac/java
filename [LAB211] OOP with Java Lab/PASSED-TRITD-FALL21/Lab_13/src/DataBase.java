
import java.io.*;
import java.util.*;

public class DataBase {

    private static File file = new File("");
    private List<Person> personList = new ArrayList<Person>();
    List<String> listMoi = new ArrayList<>();
    Validation vali = new Validation();
    private static FileReader fr = null;
    Validation Validati = new Validation();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setDataBase(String path) throws IOException {
        file = new File(path);
        String line;

        if (isValidPath(path, file)) {
            try {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    personList.add(dataMining(line));
                }
                fr.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (fr == null) {
                    throw new FileNotFoundException("Can't read file");
                }
            }
        } else {
            throw new IOException("Path doesn't exist");
        }
    }

    public static boolean isValidPath(String path, File file) {
        if (path == null || !file.exists()) {
            return false;
        } else {
            return file.isFile();
        }
    }

    public Person dataMining(String line) {
        String[] source = line.split("; ");
        double salary = 0;
        try {
            salary = Double.parseDouble(source[2]);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Can not convert String to Double in file");
         //   System.out.println(e);
        }
        return new Person(source[0], source[1], salary);
    }

    public static List<List<String>> setList(int length) {
        List<List<String>> list = new ArrayList<List<String>>();
        
        while (length > 0) {
            list.add(new ArrayList<String>());
            length--;
        }
        return list;
    }
    
    public  void coppyNewFile() {
        String pathFileInput = Validati.checkInputPathFile();
        String pathFileOutput = Validati.checkInputPathFile();
        String content = getNewContent(pathFileInput);
        System.out.println(content);
        writeNewContent(pathFileOutput, content);
    }
    
    public  String getNewContent(String pathFileInput) {
        ArrayList<String> newContent = new ArrayList<>();
    //    HashSet<String> newContent = new HashSet<>();
        File file = new File(pathFileInput);
        try {
            Scanner input = new Scanner(file);
            int count = 0;
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word + " ");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }
        String content = "";
        for (String line : newContent) {
            content += line;
        }
        listMoi.add(content);
        return content;
    }
    
    public void searchWorld(){
        System.out.print("Enter source file: ");
        String pathFileInput = Validati.checkInputPathFile();
        System.out.print("File to copy: ");
        String pathFileOutput = Validati.checkInputPathFile();
        getNewContent(pathFileInput);
        System.out.print("Enter string that you want to find: ");
        String s = vali.checkInputString();
        System.out.println(listMoi);
        if(listMoi.get(0).contains(s)){
         //   System.out.println("Copy done...");
            writeNewContent(pathFileOutput, s);
        }
        else
            System.err.println("Not found!");
    }

    //write new content to file
    public static void writeNewContent(String pathFileOutput, String content) {
        FileWriter fileWriter = null;
        File file = new File(pathFileOutput);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(content);
            bufferWriter.close();
            System.err.println("Write successful");
        } catch (IOException ex) {
            System.err.println("Can’t write file");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
