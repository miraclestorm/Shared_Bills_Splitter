package splitter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static boolean checkTR(String command) {
        String[] cmd = command.split(" ");
        Boolean result = true;
        if (cmd.length < 5) {
            result = false;
        } else {
            try {
                Double num = Double.parseDouble(cmd[4]);
            } catch (NumberFormatException e) {
                result = false;
            }
        }
        return result;
    }

    public static int newID(String command, ArrayList<Pair> pairs) {
        int newID = 0;
        String[] cmd = command.split(" ");
        if (pairs.size() > 0) {
            for (int i = 0; i < pairs.size(); i++) {
                if ((cmd[2].equals(pairs.get(i).getPerson1()) | cmd[2].equals(pairs.get(i).getPerson1())) && (cmd[1].equals(pairs.get(i).getPerson1()) | cmd[1].equals(pairs.get(i).getPerson1()))) {
                    newID = pairs.get(i).getID();
                }
            }
            if (newID == 0) {
                newID = pairs.size();
            }
        }
        return newID;
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        String debtor;
        String creditor;
        String command = "";
        String formattedDate = null;
        int trID = 0;
        int trPay = 0;

        do {
            command = scanner.nextLine();
            String[] cmd = command.split(" ");
            if (!isValidDate(cmd[0])) {
                LocalDate localDate = LocalDate.now();
                formattedDate = localDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                command = formattedDate + " " + command;
                cmd = command.split(" ");
            }

            switch (cmd[1]) {
                case "help":
                    new Help();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "borrow":
                    if (checkTR(command)) {
                        trID = newID(command, pairs);
                        trPay = Integer.parseInt(cmd[4]);
                        transactions.add(new Transaction(trID, cmd[0], trPay, cmd[3], cmd[2]));
                    } else {
                        System.out.println("Illegal command arguments");
                    }
                    break;
                case "repay":
                    if (checkTR(command)) {
                        trID = newID(command, pairs);
                        trPay = Integer.parseInt(cmd[4]);
                        transactions.add(new Transaction(trID, cmd[0], trPay, cmd[2], cmd[3]));
                    } else {
                        System.out.println("Illegal command arguments");
                    }
                    break;
                case "balance":


                    break;
                default:
                    System.out.println("Unknown command. Print help to show commands list");
            }
        } while (true);
    }
}


