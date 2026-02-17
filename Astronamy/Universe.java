package Astronamy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.ST;

public class Universe {

    ArrayList<Particle> particles = new ArrayList<>();

    int planetNum;
    double radius;

    public Universe(String path) {
        File uni = new File(path);
        try (Scanner myReader = new Scanner(uni)) {
            planetNum = myReader.nextInt();
            radius = myReader.nextDouble();
            for (int i = 0; i < planetNum; i++) {
                String data = myReader.nextLine();
                if (data == "") {
                    continue;
                }
                System.out.println(data);
                data = data.strip();
                String[] split = data.split(" ");
                String[] newData = new String[6];

                int j = 0;
                for (String s : split) {
                    if (s == "") {
                        newData[j]
                    }
                    j++;
                }
                particles.add(new Particle(Double.valueOf(split[0]),
                        Double.parseDouble(split[0]),
                        Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]),
                        split[4]));

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String toString() {
        for (Particle p : particles) {
            System.out.println(p.toString());
        }
        return "";
    }

    public static void main(String[] args) {
        Universe uni = new Universe("Astronamy/nbody/uniform3.txt");

        // uni.toString();
    }

}
