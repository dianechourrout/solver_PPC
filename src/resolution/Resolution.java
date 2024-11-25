package resolution;

import definition.Csp;
import problemes.CspFournis;

public class Resolution {
    public static void main(String[] args) {
	Stats.resetAll();
	Stats.startTimer();
	/*
	 * Déclaration et création d'un csp (variables, contraintes)
	 */
    Csp Csp3 = CspFournis.buildCsp3();
    Stats.startResolutionTimer();
	/*
	 * Résolution du csp : exécution de l'algorithme d'exploration (search)
	 */
	//Search.generateAndTest(Csp3);
	Search.backtrack2(Csp3);
	
	Stats.EndTimer();
	Stats.printAll();
	
    }

}
