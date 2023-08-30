import java.util.*;
import java.io.*;
import java.util.Queue;


public class main {
    private static class list<T>{
        private List<T> items;

    }

    private static class mahasiswa {
        private String name;
        private String major;
        private int height;
        private int weight;
        private String activity;

        public mahasiswa(String name, String major, int height, int weight, String activity) {
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
        List<mahasiswa> data = new LinkedList<>();
        try (Scanner scanner = new Scanner(new FileReader("dataset.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                String major = tokens[1];
                int height = Integer.parseInt(tokens[2]);
                int weight = Integer.parseInt(tokens[3]);
                String activity = tokens[4];
                mahasiswa Mahasiswa = new mahasiswa(name, major, height, weight, activity);
                data.add(Mahasiswa);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            System.exit(1);
        }

        Queue<mahasiswa> queue = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter search criteria (1 = major, 2 = height, 3 = hobby): ");
        String searchCriteria = input.nextLine();

        if (searchCriteria.equals("1")) {
            // Search for individuals with a major in "Teknik Informatika"
            for (mahasiswa Mahasiswa : data) {
                if (Mahasiswa.getMajor().equals("Teknik Informatika")) {
                    queue.add(Mahasiswa);
                }
            }

            // Print the individuals with a major in "Teknik Informatika"
            while (!queue.isEmpty()) {
                mahasiswa Mahasiswa = queue.remove();
                System.out.println("Name: " + Mahasiswa.getName());
                System.out.println("Major: " + Mahasiswa.getMajor());
                System.out.println("Height: " + Mahasiswa.getHeight() + " cm");
                System.out.println("Weight: " + Mahasiswa.getWeight() + " kg");
                System.out.println("Activity: " + Mahasiswa.getActivity());
                System.out.println();
            }
        } else if (searchCriteria.equals("2")) {
            // Search for individuals with a height over 160 cm
            for (mahasiswa Mahasiswa : data) {
                if (Mahasiswa.getHeight() > 160) {
                    queue.add(Mahasiswa);
                }
            }


            while (!queue.isEmpty()) {
                mahasiswa Mahasiswa = queue.remove();
                System.out.println("Name: " + Mahasiswa.getName());
                System.out.println("Major: " + Mahasiswa.getMajor());
                System.out.println("Height: " + Mahasiswa.getHeight() + " cm");
                System.out.println("Weight: " + Mahasiswa.getWeight() + " kg");
                System.out.println("Activity: " + Mahasiswa.getActivity());
                System.out.println();
            }
        } else if (searchCriteria.equals("3")) {

            for (mahasiswa Mahasiswa : data) {
                if(Mahasiswa.getActivity().equals("Basket")) {
                    queue.add(Mahasiswa);
                }
            }

            while (!queue.isEmpty()) {
                mahasiswa Mahasiswa = queue.remove();
                System.out.println("Name: " + Mahasiswa.getName());
                System.out.println("Major: " + Mahasiswa.getMajor());
                System.out.println("Height: " + Mahasiswa.getHeight() + " cm");
                System.out.println("Weight: " + Mahasiswa.getWeight() + " kg");
                System.out.println("Activity: " + Mahasiswa.getActivity());
                System.out.println();


            }
        }
    }
}
