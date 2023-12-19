import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class WeatherModeling {

    public static double weatherModel(double a,double b,double c,double time) {

        //temp=a*(time**2)+b*time+c
        double temperature = a * Math.pow(time, 2) + b * time + c;
        return temperature;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double a = 0.1;
        double b = 2.0;
        double c = 20.0;
        double time=5;

        double temperature = weatherModel(a,b,c,time);

        System.out.println("Step 1: Hard-coded Variables for Weather Modeling");
        System.out.printf("At time %.2f, the estimated temperature is %.2f degrees.\n\n\n", time, temperature);


        System.out.println("Enter coefficients a,b,c");
        double input_a=scanner.nextFloat();
        double input_b=scanner.nextDouble();
        double input_c=scanner.nextDouble();
        System.out.println("Enter Time in Hours");
        double input_time=scanner.nextDouble();

        System.out.println("Step 2: Keyboard Input for Weather Modeling");
        System.out.printf("At time %.2f, the estimated temperature is %.2f degrees.\n\n\n", input_time, weatherModel(input_a, input_b, input_c, input_time));


        
        Path filePath=Paths.get("weather.txt");
        List<String> lines=Files.readAllLines(filePath);
        a=Double.parseDouble(lines.get(0)); 
        b=Double.parseDouble(lines.get(1));
        c=Double.parseDouble(lines.get(2));
        time=Double.parseDouble(lines.get(3));
        
        System.out.println("Step 3: Read from a File for Weather Modeling");
        System.out.printf("At time %.2f, the estimated temperature is %.2f degrees.\n", time, weatherModel(a,b,c,time));

        


    }
}
