
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    //Declare Scanner
    private static final Scanner SC = new Scanner(System.in);
    //private static final String TASK_PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public static int checkIntLimit(String msg, int min, int max, boolean mode) {
        int rs = -1;
        do {
            try {
                System.out.print(msg);
                String input = SC.nextLine();

                if (mode == false && input.equalsIgnoreCase("nope")) {
                    break;
                }

                rs = Integer.parseInt(input);

                if (rs < min || rs > max) {
                    throw new NumberFormatException();
                }
                break;
            } catch (Exception e) {
                System.err.println("Please input data value in range "
                        + min + " to " + max);
            }
        } while (true);
        return rs;
    }

    public static double checkDouble(String MSG, double min, double max, boolean mode) {
        double rs = 0.0;

        do {
            System.out.print(MSG);
            String input = SC.nextLine();

            if (mode == false && input.equalsIgnoreCase("nope")) {
                break;
            }
            try {
                rs = Double.parseDouble(input);
                double check = rs % 0.5;
                if (rs >= min && rs <= max && check == 0) {
                    break;
                }
                System.err.println("Out of range, Please enter a number in range " + min + " - " + max);
            } catch (Exception e) {
                System.err.println("Incorrect input, Please enter again!");
            }
        } while (true);

        return rs;
    }

    public static String checkInputString(String msg, String regex, boolean mode) {
        String input = null;
        do {
            System.out.print(msg);
            input = SC.nextLine().trim();

            if (!input.isEmpty()) {
                if (input.matches(regex)) {
                    if (mode == false && input.equalsIgnoreCase("nope")) {
                        break;
                    } else {
                        if (!input.equalsIgnoreCase("nope")) {
                            break;
                        } else {
                            String modeStr = mode == true ? "ADD" : "UPDATE";
                            System.err.println("Cant enter \"nope\" in "
                                    + modeStr + " mode");
                        }
                    }
                } else {
                    System.err.println("Incorrect Valid Data - Enter Again");
                }
            } else {
                System.err.println("You've enter empty String - Enter Again");
            }
        } while (true);
        return input;
    }

    public static String checkInputTaskTypeID(String mes, boolean mode) {
        String rs = null;
        int taskTypeID = checkIntLimit(mes, 1, 4, mode);
        switch (taskTypeID) {
            default:
                break;
            case 1:
                rs = "Code";
                break;
            case 2:
                rs = "Test";
                break;
            case 3:
                rs = "Design";
                break;
            case 4:
                rs = "Review";
                break;
        }
        return rs;
    }

    public static Date checkInputDate(String msg, String format, boolean mode) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        do {
            System.out.print(msg);
            String input = SC.nextLine();
            try {
                if (mode == false && input.equalsIgnoreCase("nope")) {
                    break;
                }
                date = sdf.parse(input);
                break;
            } catch (ParseException e) {
                System.err.println("Date format "
                        + format + " - Please Enter Again");
            }
        } while (true);
        return date;
    }

    public static Task checkIDExist(int taskID, ArrayList<Task> listTask) {
        for (Task task : listTask) {
            if (task.getID() == taskID) {
                return task;
            }
        }
        return null;
    }

}
