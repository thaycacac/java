
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static void formatName(ArrayList<CSV> ls) {
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    private static void formatAddress(ArrayList<CSV> ls) {
        for (int i = 0; i < ls.size(); i++) {
            String address = ls.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    private static void importFile(ArrayList<CSV> ls) {
        String line = "";
        BufferedReader fileReader = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
//                System.out.println(line);
                String[] splitCSV = line.split(COMMA_DELIMITER);
                ls.add(new CSV(Integer.parseInt(splitCSV[0]), splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.err.println("Import: Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void exportFile(ArrayList<CSV> ls) {
        FileWriter fileWriter = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine();
        try {
            fileWriter = new FileWriter(fileName);
            for (CSV listCSV : ls) {
                fileWriter.append(String.valueOf(listCSV.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.err.println("Export Done!!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void print(ArrayList<CSV> ls) {
        for (int i = 0; i < ls.size(); i++) {
            System.out.printf("%d,%s,%s,%s,%s\n", ls.get(i).getId(),
                    ls.get(i).getName(), ls.get(i).getEmail(), ls.get(i).getPhone(),
                    ls.get(i).getAddress());
        }
    }

    private static void display(ArrayList<CSV> ls) {
        while (true) {
            System.out.println("1. Import CSV");
            System.out.println("2. Format Address");
            System.out.println("3. Format Name");
            System.out.println("4. Export CSV");
            System.out.println("5. Exit");
            System.out.print("Please choice one option:");
            int n = checkIntLimit(1, 5);
            switch (n) {
                case 1:
                    importFile(ls);
                    print(ls);
                    break;
                case 2:
                    formatAddress(ls);
                    print(ls);
                    break;
                case 3:
                    formatName(ls);
                    print(ls);
                    break;
                case 4:
                    exportFile(ls);
                    break;
                case 5:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<CSV> ls = new ArrayList<>();
        ls.add(new CSV(1, "pham   Ngoc hoA", "thaycacac@gmail.com", "'0968038714", "khaNh Cong   - yEN  KhanH -    Ninh binh"));
        ls.add(new CSV(2, "NGUyen hai         nAM   ", "namhai@gmail.com", "'0984481345", "ThaCH  HOA - thach that   -   Ha noI"));
        ls.add(new CSV(3, "Nguyen   van a      	", "uyenthao@gmail.com", "'0986246814", "Cau Giay     - Ha    Noi    - Viet Nam    "));
//        display(ls);
    }
}
