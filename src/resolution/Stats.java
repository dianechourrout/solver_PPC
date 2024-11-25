package resolution;

import java.text.NumberFormat;

public class Stats {
    private static int nbSolutions = 0;
    private static int nbInstantiations = 0;
    private static int nbFilterings = 0;
    private static long nanoStartTime = 0;
    private static long nanoStartResolutionTime = 0;
    private static long nanoEndTime = 0;

    public static void resetAll() {
	nbSolutions = 0;
	nbInstantiations =  0;
	nbFilterings =  0;
	nanoStartTime = 0;
	nanoStartResolutionTime = 0;
	nanoEndTime = 0;
    }

    //------------------------------------------------------------------
    // Timers
    //------------------------------------------------------------------

    public static void startTimer() {
	nanoStartTime = System.nanoTime();
    }

    public static void startResolutionTimer() {
	nanoStartResolutionTime = System.nanoTime();
    }

    public static void EndTimer() {
	nanoEndTime = System.nanoTime();
    }

    public static long getBuildingTime() {
	return nanoStartResolutionTime - nanoStartTime;
    }

    public static long getResolutionTime() {
	return nanoEndTime - nanoStartResolutionTime;
    }

    public static long getTotalTime() {
	return nanoEndTime - nanoStartTime;
    }

    //------------------------------------------------------------------
    // Compteurs
    //------------------------------------------------------------------

    public static void incSolutions() {
	nbSolutions++;
    }

    public static int getNbSolutions() {
	return nbSolutions;
    }

    public static void incInstantiations() {
	nbInstantiations++;
    }

    public static int getNbInstantiations() {
	return nbInstantiations;
    }

    public static void incFilterings() {
	nbFilterings++;
    }

    public static int getNbFilterings() {
	return nbFilterings;
    }

    //------------------------------------------------------------------
    // Affichage
    //------------------------------------------------------------------
    
    public static void printNbSolutions() {
	System.out.println("Nb solutions = " + getNbSolutions());
    }
    
    
    public static void printNbInstantiations() {
	System.out.println("Nb instantiations = " + getNbInstantiations());
    }
    
    
    public static void printNbFilterings() {
	System.out.println("Nb appels au filtrage = " + getNbFilterings());
    }
    
    
    public static void printBuildingTime() {
	System.out.println("Temps de construction = " + NumberFormat.getNumberInstance().format(getBuildingTime()) + " ns" 
		 + " ( = " + NumberFormat.getNumberInstance().format(getBuildingTime()/1000000) + " ms)");
    }
    
    
    public static void printResolutionTime() {
	System.out.println("Temps de résolution = " + NumberFormat.getNumberInstance().format(getResolutionTime()) + " ns"
		+ " ( = " + NumberFormat.getNumberInstance().format(getResolutionTime()/1000000) + " ms)");
    }
    
    public static void printAll() {
	System.out.println("----------------------- Stats -----------------------");
	printNbSolutions();
	printNbInstantiations();
	printNbFilterings();
	printBuildingTime();
	printResolutionTime();
    }

}
