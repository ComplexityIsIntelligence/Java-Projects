
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PatientManager implements Cloneable{
    private int counter;
    private int counting;
    PriorityQueue<Patient> waitingList = new PriorityQueue<>();
    PriorityQueue<Patient> copysaver = new PriorityQueue<>();

    public void printMenu() {
        System.out.println("----------------------------------------------------------");
        System.out.println(" (1)   New Patient ");
        System.out.println(" (2)   Next Patient");
        System.out.println(" (3)   Waiting List");
        System.out.println(" (4)      Exit         ");
        System.out.println("--------------------------------------------------------");
    }
    

    public void start() {
        counting++;
        if (counting == 1) {
            printMenu();
        }
        try (Scanner in = new Scanner(System.in)) {

            int Patientinput = 0;
            int emergency = 0;
            boolean InputReciever = true;
            boolean InputRecieverforEmergency = true;

            while (InputReciever == true) {
                try {

                    System.out.print("Choose an item from the menu: ");
                    Patientinput = in.nextInt();
                    if (Patientinput == 1) {

                    } else if (Patientinput == 2) {

                    } else if (Patientinput == 3) {

                    } else if (Patientinput == 4) {

                    } else {
                        throw new InputMismatchException();
                    }
                    in.nextLine();

                    InputReciever = false;
                } catch (InputMismatchException e) {
                    System.out.println("(X) Wrong Choice");

                    in.nextLine();

                }
            }
            if (Patientinput == 1) {
                System.out.print("enter your name ");
                String name = in.nextLine();

                while (InputRecieverforEmergency == true) {
                    try {
                        System.out.print("enter emergency from 1 to 5 (1=low, and 5=life-and-death) ");

                        emergency = in.nextInt();
                        in.nextLine();
                        if (emergency == 1) {

                        } else if (emergency == 2) {

                        } else if (emergency == 3) {

                        } else if (emergency == 4) {

                        } else if (emergency == 5) {

                        } else {
                            throw new InputMismatchException();
                        }
                        InputRecieverforEmergency = false;
                    } catch (InputMismatchException e) {
                        System.out.println("(X) Wrong Choice  Try Again ");

                        in.nextLine();

                    }
                }
                Patient patient = new Patient(counter++, name, emergency);

                waitingList.offer(patient);
                copysaver.offer(patient);
                System.out.println("Patient has been added to waiting list");

                start();
            } else if (Patientinput == 2) {
                if (waitingList.isEmpty()) {
                    System.out.println("No more patients");
                } else {
                    System.out.println(waitingList.poll().getName() + " has been treated");
                    copysaver.poll();
                }

                start();
            } else if (Patientinput == 3) {
                if (copysaver.isEmpty()) {
                    System.out.println("no more patients");
                 }   
                 while (!copysaver.isEmpty()) {
                    if (!copysaver.isEmpty()) {
                   System.out.println(copysaver.poll());

                  }
                 }
                  copysaver=new PriorityQueue<>(waitingList);
               
                
              
                
                start();
            } else {
                System.out.println("program terminated GoodBye");
                System.exit(-1);
            }

        }
        
 

}
  
}
