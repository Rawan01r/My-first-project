package A6;
import java.nio.file.Paths;
import java.util.Scanner;

public class ParmcySystem {
    static  SinglyLinkedList<Patient> p = new SinglyLinkedList<Patient>();
    static LinkedQueue<prescriptions> PharmcyQueue = new LinkedQueue<prescriptions>();

    public static Scanner input;
    public ParmcySystem() throws Exception {
        input = new Scanner(Paths.get("Patient.txt"));
        while (input.hasNextLine()) {

            p.addLast(new Patient(input.nextInt(), input.nextInt(), input.next())); //id , age , name 
        }
    }
    public Patient Search_Patient(int id) {
        p.moveToStart();
        for (int i = 0; i < p.size(); i++) {
            if (p.getValue().getId() == id) {
                return p.getValue(); 
            } else {
                p.next(); 
            }
        }
        return null; 
    }
    public void PrintPatients() {
        p.moveToStart();
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.getValue()); 
            p.next();
        }
    }
    public static void main(String[] args) throws Exception {
        ParmcySystem myPharmcy = new ParmcySystem(); 
        int choice;
        input = new Scanner(System.in);
        do {
            System.out.println("-------------------------");
            System.out.println("1- print patient data ");
            System.out.println("2- Doctor System ");
            System.out.println("3- pharmacist System ");
            System.out.println("4- Exit");
            System.out.println("-------------------------");
            System.out.println("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    myPharmcy.PrintPatients();
                    break;
                case 2://Doctor
                    System.out.println("Please enter the patient Id: ");
                    int id = input.nextInt();
                    Patient p = myPharmcy.Search_Patient(id);
                    if (p == null) {
                        System.out.print("invalid Id");
                        break;
                    } else {
                        System.out.println("Id is found And the patient data is :" + p.toString());
                        System.out.println("Please enter a medicine name :");
                        String name = input.next();
                        System.out.println("Please enter a medicine dose:");
                        String dose = input.next();
                        System.out.println("Please enter a medicine amount: ");
                        int amount = input.nextInt();

                        Medication m = new Medication(name, dose, amount);
                        prescriptions presc = new prescriptions(id, m);
                        PharmcyQueue.enqueue(presc);
                        System.out.println("prescriptions has been added successfully to the queue");
                    }
                    break;
                case 3:
                    System.out.printf("Hello,  there are %d unprepared prescriptions %n", PharmcyQueue.size());
                    if (PharmcyQueue.size() != 0) {
                        System.out.println("The first prescriptions is \n");
                        PharmcyQueue.first().print();
                        System.out.println("Once it is done please enter \"Done\" \n");
                        if (input.next().equals("Done")) {
                            PharmcyQueue.dequeue();
                        }
                    }
                    break;
            }
        } while (choice != 4);
    }
}
