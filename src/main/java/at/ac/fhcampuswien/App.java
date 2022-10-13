/**
 * Author: Ferdaws Kukcha
 * Title: My Solutions for the Exercises 2
 * Date of commit: 13.10.2022
 */

package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);

    //todo Task 1
    public void largestNumber(){
        // input your solution here
        int count = 1;
        System.out.print("Number " + count + ": ");
        double number = scanner.nextDouble();
        double largestNum = 0.00;
        count += 1;

        if (number <= 0)
            System.out.println("No number entered.");

        else {
            while (number > 0) {
                System.out.print("Number " + count + ": ");
                number = scanner.nextDouble();
                count += 1;

                if (number > largestNum)
                    largestNum = number;
            }

            System.out.printf("The largest number is %.2f\n", largestNum);

        }

    }

    //todo Task 2
    public void stairs(){
        // input your solution here
        System.out.print("n: ");
        int zeilenAnzahl = scanner.nextInt();

        if (zeilenAnzahl > 0) {
            for (int zeile=1; zeile<=zeilenAnzahl; zeile++) {
                for (int spalte=0; spalte<zeile; spalte++) {
                    // Formel für die Folge 1, 2, 4, 7, ... : a(n) = 1 + (n * (n-1)) / 2
                    System.out.print(spalte + (zeile * (zeile - 1)) / 2 + 1 + " ");
                }
                System.out.println("");
            }
        }
        else
            System.out.println("Invalid number!");
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
        final int reihenAnzahl = 6;
        int count = 0;

        for (int i=1; i<=reihenAnzahl; i++) {
            while (count<reihenAnzahl-i) {
                System.out.print(" ");
                count += 1;
            }
            count = 0;
            for (int j=0; j<2*i-1;j++)
                System.out.print("*");
            System.out.println("");
        }
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
        System.out.print("h: ");
        int h = scanner.nextInt();
        int getH = h;
        System.out.print("c: ");
        char c = scanner.next().charAt(0);
        int count = 0;

        if (h % 2 != 0) {
            while (h > 0) {

                for (int i=0; i<h/2; i++)                   // Diese Schleife ist zuständig für die Leerzeichen der
                    System.out.print(" ");                  // oberen Teil der Pyramide.

                for (int i=count; i>=0; i--)                // Diese Schleife ist zuständig für die Einträge der
                        System.out.print((char) (c - i));   // links oberen Teil der Pyramide inkl. Mitte.

                for (int i=1; i<=count;i++)                 // Diese Schleife ist zuständig für die Einträge der
                    System.out.print((char) (c - i));       // rechts oberen Teil der Pyramide inkl. mitte.

                count += 1;
                h -= 2;

                System.out.println("");
            }

            count -= 2;

            while (h > -(getH + 1) / 2) {

                for (int i=-h; i>0; i--)                    // Diese Schleife ist zuständig für die Leerzeichen der
                    System.out.print(" ");                  // unteren Teil der Pyramide.

                for (int i=count; i>=0; i--)                // Diese Schleife ist zuständig für die Einträge der
                    System.out.print((char) (c - i));       // links unteren Teil der Pyramide exkl. Mitte.

                for (int i=1; i<=count;i++)                 // Diese Schleife ist zuständig für die Einträge der
                    System.out.print((char) (c - i));       // rechts unteren Teil der Pyramide exkl. Mitte.

                count -= 1;
                h -= 1;

                System.out.println("");
            }
        }
        else
            System.out.println("Invalid number!");
    }

    //todo Task 5
    public void marks(){
        // input your solution here
        System.out.print("Mark 1: ");
        int note = scanner.nextInt();
        int count = 2;


        double notenZusammenAddiert = note;
        int negetiveMarks = 0;


        while (note != 0) {

            if (note < 0 || note > 5) {
                System.out.println("Invalid mark!");
                count -=1;
                notenZusammenAddiert -= note;
            }

            if (note == 5)
                negetiveMarks += 1;

            System.out.print("Mark " + count + ": ");
            note = scanner.nextInt();

            notenZusammenAddiert += note;
            count += 1;
        }

        if (count == 2) {
            System.out.println("Average: 0.00");
            System.out.println("Negative marks: 0");
            return;
        }

        System.out.printf("Average: %.2f", notenZusammenAddiert / (count - 2));
        System.out.println("");
        System.out.println("Negative marks: " + negetiveMarks);


    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
        System.out.print("n: ");
        int number = scanner.nextInt();

        int ziffer = 0;
        int zifferZumQuadrat = 0;
        int len = String.valueOf(number).length();
        int neueZiffer = 0;


        if (number == 1)
            System.out.println("Happy number!");
        else {
            while (len > 0) {
                ziffer = number % 10;
                number /= 10;
                zifferZumQuadrat +=  Math.pow(ziffer, 2);
                if ( number == 0 && String.valueOf(zifferZumQuadrat).length() > 1) {
                    number = zifferZumQuadrat;
                    len = String.valueOf(zifferZumQuadrat).length() + 1;
                    zifferZumQuadrat = 0;
                }

                len -= 1;
            }

            if (zifferZumQuadrat == 1)
                System.out.println("Happy number!");
            else
                System.out.println("Sad number!");
        }

    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}