import java.util.*;
import java.io.*; 

public class StackExample {
    
    private static class Stack<T> {
        private List<T> items;

        public Stack() {
            this.items = new ArrayList<>();
        }

        public void push(T item) {
            this.items.add(item);
        }

        public T pop() {
            if (!is_empty()) {
                return this.items.remove(this.items.size() - 1);
            }
            return null;
        }

        public boolean is_empty() {
            return this.items.size() == 0;
        }

        public T peek() {
            if (!is_empty()) {
                return this.items.get(this.items.size() - 1);
            }
            return null;
        }

        public int size() {
            return this.items.size();
        }
    }
    
    private static class Person {
        private String name;
        private String major;
        private int height;
        private int weight;
        private String activity;
        
        public Person(String name, String major, int height, int weight, String activity) {
            this.name = name;
            this.major = major;
            this.height = height;
            this.weight = weight;
            this.activity = activity;

        }
        
        public String getName() {
            return this.name;
        }
        
        public String getMajor() {
            return this.major;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public int getWeight() {
            return this.weight;
        }
        
        public String getActivity() {
            return this.activity;
        }
    }
    
    public static void main(String[] args) {
        List<Person> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("dataset.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                String major = tokens[1];
                int height = Integer.parseInt(tokens[2]);
                int weight = Integer.parseInt(tokens[3]);
                String activity = tokens[4];
                Person person = new Person(name, major, height, weight, activity);
                data.add(person);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            System.exit(1);
        }
        
        Stack<Person> stack = new Stack<>();
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter search criteria (1 = major, 2 = height, 3 = hobby): ");
        String searchCriteria = input.nextLine();
        
        if (searchCriteria.equals("1")) {
            // Search for individuals with a major in "Teknik Informatika"
            for (Person person : data) {
                if (person.getMajor().equals("Teknik Informatika")) {
                    stack.push(person);
                }
            }
            
            // Print the individuals with a major in "Teknik Informatika"
            while (!stack.is_empty()) {
                Person person = stack.pop();
                System.out.println("Name: " + person.getName());
                System.out.println("Major: " + person.getMajor());
                System.out.println("Height: " + person.getHeight() + " cm");
                System.out.println("Weight: " + person.getWeight() + " kg");
                System.out.println("Activity: " + person.getActivity());
                System.out.println();
            }
        } else if (searchCriteria.equals("2")) {
            // Search for individuals with a height over 160 cm
            for (Person person : data) {
                if (person.getHeight() > 160) {
                    stack.push(person);
                }
            }
            
            
            while (!stack.is_empty()) {
                Person person = stack.pop();
                System.out.println("Name: " + person.getName());
                System.out.println("Major: " + person.getMajor());
                System.out.println("Height: " + person.getHeight() + " cm");
                System.out.println("Weight: " + person.getWeight() + " kg");
                System.out.println("Activity: " + person.getActivity());
                System.out.println();
            }
        } else if (searchCriteria.equals("3")) {
            
            for (Person person : data) {
                if(person.getActivity().equals("Futsal")) {
                    stack.push(person);
                }
            }
            
            while (!stack.is_empty()) {
                Person person = stack.pop();
                System.out.println("Name: " + person.getName());
                System.out.println("Major: " + person.getMajor());
                System.out.println("Height: " + person.getHeight() + " cm");
                System.out.println("Weight: " + person.getWeight() + " kg");
                System.out.println("Activity: " + person.getActivity());
                System.out.println();
            
            
            }
        }
    }
}


               
