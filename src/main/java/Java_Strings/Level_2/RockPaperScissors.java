package Java_Strings.Level_2;

import java.util.Scanner;

public class RockPaperScissors {
    static String computerChoice() {
        int n = (int) (Math.random() * 3);
        if (n == 0) return "rock";
        if (n == 1) return "paper";
        return "scissors";
    }

    static String winner(String user, String computer) {
        if (user.equals(computer)) return "Draw";

        if ((user.equals("rock") && computer.equals("scissors"))
                || (user.equals("paper") && computer.equals("rock"))
                || (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    static String[][] stats(int user, int computer, int draw, int games) {
        String[][] data = new String[3][4];

        data[0][0] = "User";
        data[0][1] = String.valueOf(user);
        data[0][2] = String.valueOf((double) user / games);
        data[0][3] = String.valueOf(Math.round(user * 10000.0 / games) / 100.0);

        data[1][0] = "Computer";
        data[1][1] = String.valueOf(computer);
        data[1][2] = String.valueOf((double) computer / games);
        data[1][3] = String.valueOf(Math.round(computer * 10000.0 / games) / 100.0);

        data[2][0] = "Draw";
        data[2][1] = String.valueOf(draw);
        data[2][2] = String.valueOf((double) draw / games);
        data[2][3] = String.valueOf(Math.round(draw * 10000.0 / games) / 100.0);

        return data;
    }

    static void showStats(String[][] data) {
        System.out.println("\nPlayer\t\tWins\tAverage\tPercentage");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]
                    + "\t" + data[i][2] + "\t" + data[i][3] + "%");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of games: ");
        int games = sc.nextInt();

        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 1; i <= games; i++) {
            System.out.print("Choose rock, paper or scissors: ");
            String user = sc.next().toLowerCase();
            String computer = computerChoice();
            String result = winner(user, computer);

            if (result.equals("User")) userWins++;
            else if (result.equals("Computer")) computerWins++;
            else draws++;

            System.out.println("Computer: " + computer);
            System.out.println("Winner: " + result);
        }

        showStats(stats(userWins, computerWins, draws, games));
        sc.close();
    }
}