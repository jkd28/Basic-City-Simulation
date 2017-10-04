import java.util.Random;

public class CitySim9005 {
    public static void main(String[] args){
        // Check format of arguments
        if (args.length != 1){
            System.out.println("USAGE: java CitySim9005 <integer seed> ");
            System.exit(1);
        }
        // Intitialize the seed with unimportant value
        int seed = 0;

        // Get proper seed value from arguments
        try{
            seed = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid seed. Ensure the Seed is a 32-bit Integer");
            System.exit(1);
        }

        // Create a psuedorandom generator with the provided seed
        Random generator = new Random((long)seed);


        // Create intitial city map
        // Create drivers
        // Place drivers psuedorandomly (based on seed)
        // Run simulation until a driver reaches an OC location
    }
}
