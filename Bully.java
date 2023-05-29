package Assignment_6;

import java.util.Scanner;

public class Bully {
    static boolean[] state = new boolean[5];
    int coordinator;

    public static void up(int up) {
        if (state[up - 1]) {
            System.out.println("Process " +up+ " is Already Up");
        } else {
            int i;
            Bully.state[up - 1] = true;
            System.out.println("Process " +up+ " held Election");
            for (i = up; i < 5; ++i) {
                System.out.println("Election Message sent from Process " +up+ " to Process " + (i + 1));
            }
            for (i = up + 1; i <= 5; ++i) {
                if (!state[i - 1]) continue;
                System.out.println("Alive Message send from Process " + i + " to Process " + up);
                break;
            }
        }
    }

    public static void down(int down) {
        if (!state[down - 1]) {
            System.out.println("Process " + down + " is already Dowm.");
        } else {
            Bully.state[down - 1] = false;
        }
    }

    public static void mess(int mess) {
        if (state[mess - 1]) {
            if (state[4]) {
                System.out.println("OK");
            } else if (!state[4]) {
                int i;
                System.out.println("Process " + mess + " Election");
                for (i = mess; i < 5; ++i) {
                    System.out.println("Election Message sent from Process " + mess + " to Process " + (i + 1));
                }
                for (i = 5; i >= mess; --i) {
                    if (!state[i - 1]) continue;
                    System.out.println("Co-ordinator Message sent from Process " + i + " to All Processes");
                    break;
                }
            }
        } else {
            System.out.println("Prccess " + mess + " is Down");
        }
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; ++i) {
            Bully.state[i] = true;
        }
        System.out.println("5 Active Processes are: P1 P2 P3 P4 P5");
        System.out.println("Process 5 is Co-ordinator");
        do {
            System.out.println(" ");
            System.out.println("1. Up a Process");
            System.out.println("2. Down a Process");
            System.out.println("3. Send a Message");
            System.out.println("4. Exit");
            System.out.println(" ");
            System.out.print("Enter the Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Bring Proces Up: ");
                    int up = sc.nextInt();
                    if (up == 5) {
                        System.out.println("Process 5 is Co-ordinator");
                        Bully.state[4] = true;
                        break;
                    }
                    Bully.up(up);
                    break;
                }
                case 2: {
                    System.out.print("Bring Down any Process: ");
                    int down = sc.nextInt();
                    Bully.down(down);
                    break;
                }
                case 3: {
                    System.out.print("Which Process will send Message: ");
                    int mess = sc.nextInt();
                    Bully.mess(mess);
                }
            }
        } while (choice != 4);
    }
}

