
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static void readFileConfig() {
        File propertiesFile = new File("config.properties");
        Properties prop = new Properties();
        if (propertiesFile.exists()) {
            boolean checkFileConfig = checkFileConfig(propertiesFile);
            if (checkFileConfig == false) {
                System.out.println("System shutdown!");
                return;
            } else {
                try {
                    FileReader reader = new FileReader(propertiesFile);
                    prop.load(reader);
                    copyFolder(prop.getProperty("COPY_FOLDER"), prop.getProperty("PATH"));
                    reader.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            System.out.println("File configure is not found!");
            createFileConfig(propertiesFile, prop);
            readFileConfig();
        }
    }

    private static boolean checkFileConfig(File propertiesFile) {
        Properties prop = new Properties();
        InputStream input = null;
        boolean exist = false;
        try {
            input = new FileInputStream(propertiesFile);
            prop.load(input);
            if (prop.getProperty("COPY_FOLDER").length() == 0) {
                System.err.println("Folder Sourse is not input");
            }
            if (prop.getProperty("DATA_TYPE").length() == 0) {
                System.err.println("Data type is not input");
            }
            if (prop.getProperty("PATH").length() == 0) {
                System.err.println("Folder Destination is not input");
            }
            exist = prop.getProperty("COPY_FOLDER") != null
                    && prop.getProperty("DATA_TYPE") != null
                    && prop.getProperty("PATH") != null;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Can read file configure!");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("File configure is not found!");
                }
            }
        }
        return exist;
    }

    private static void createFileConfig(File propertiesFile, Properties prop) {
        OutputStream output = null;
        try {
            System.out.print("Copy Folder: ");
            String copyFolder = in.nextLine();
            System.out.print("Data Type: ");
            String dataType = in.nextLine();
            System.out.print("Path: ");
            String path = in.nextLine();
            output = new FileOutputStream(propertiesFile);
            prop.setProperty("COPY_FOLDER", copyFolder);
            prop.setProperty("DATA_TYPE", dataType);
            prop.setProperty("PATH", path);
            //save file config
            prop.store(output, null);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("File cannot create");
            System.out.println("System shutdown");
            return;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("File cannot create");
            System.out.println("System shutdown");
            return;
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("File cannot create");
                    System.out.println("System shutdown");
                    return;
                }
            }
        }
    }

    public static boolean checkInformationConfig(File f1, File f2) {
        boolean checkInformationConfig = f1.exists() && f1.isDirectory()
                && f2.exists() && f2.isDirectory();
        if (f1.exists() == false || f1.isDirectory() == false) {
            System.err.println("Can't find folder Sourse");
        }
        if (f2.exists() == false || f2.isDirectory() == false) {
            System.err.println("Can't make folder Destination");
        }
        return checkInformationConfig;
    }

    public static void copyFolder(String copyFolder, String path) {
        File f1 = new File(copyFolder);
        File f2 = new File(path);
        if (checkInformationConfig(f1, f2)) {
            File[] listOfFiles = f1.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    copyFile(copyFolder + "\\" + listOfFiles[i].getName(), path);
                    System.out.println("File name: " + listOfFiles[i].getName());
                }
            }
            System.out.println("Copy is finished...");
        } else {
            System.err.println("System shutdown");
            return;
        }
    }

    private static void copyFile(String file, String folder) {
        File f1 = new File(file);
        File f2 = new File(folder);
        if (f1.exists() && f1.isFile() && f2.exists() && f2.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(f1);
                FileOutputStream fos = new FileOutputStream(folder + "/" + f1.getName());
                int b;
                while ((b = fis.read()) != -1) {
                    fos.write(b);
                }
                fis.close();
                fos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        readFileConfig();
    }
}
