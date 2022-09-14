package home.work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select method for entering figures: " +
                "\n1.Random 2.STDIN 3.File");
        String request=sc.nextLine();
        ArrayList<Figure> figures = new ArrayList<>();
        switch (request){
            case "1":
                System.out.println("Enter number of shapes to be generated: ");
                int number=sc.nextInt();
                figures =new RandomGenFactory().randomGenerator(number);

                break;
            case "2":
                System.out.println("Enter number of figures to be entered: ");
                int numberr = sc.nextInt();
                figures= new STDINFactory(sc).toFigures(numberr);
                break;
            case "3":
                File file = new File(".\\resources\\list.txt");
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()){
                    figures.add(new STDINFactory(fileReader).toFigure());
                }
                break;
            default:
                System.out.println("Invalid option entered");
        }

        System.out.println("Choose any of the following actions: " +
                "\n1.Print figures" +
                "\n2.Delete a figure" +
                "\n3.Clone a figure" +
                "\n4.Store figures in a file" +
                "\n5.Exit program");
        boolean canActionBeTaken = true;
        while (canActionBeTaken){

            int action = sc.nextInt();
            switch (action) {
                case 1:
                    for (int i = 0; i < figures.size(); i++) {
                        System.out.println(i + ". " + figures.get(i).toString());
                    }
                    break;
                case 2: {
                    System.out.println("Enter index of figure to be deleted");
                    int index = sc.nextInt();
                    figures.remove(index);
                    break;
                }
                case 3: {
                    System.out.println("Enter index of figure to be cloned");
                    int index = sc.nextInt();
                    figures.add(figures.get(index).clone());
                    break;
                }
                case 4:
                    System.out.println("Enter name of file(without extension) to be created");
                    String fileName = sc.next();
                    File result = new File(fileName + ".txt");
                    result.createNewFile();
                    FileWriter fileWriter = new FileWriter(fileName + ".txt");
                    for (int i = 0; i < figures.size(); i++) {
                        fileWriter.write(figures.get(i).toString() + "\n");
                    }
                    fileWriter.close();
                    System.out.println("Write to file");
                    break;
                case 5:
                    canActionBeTaken = false;
                    break;
            }
        }
        sc.close();

    }
}
