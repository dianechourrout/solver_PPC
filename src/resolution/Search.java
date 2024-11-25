package resolution;

import definition.Constraint;
import definition.Csp;
import definition.Domain;
import definition.Variable;

public class Search {

    /* **************************************************************************************************
     * TP1
     ****************************************************************************************************/

    //-----------------------------------------------------------------------------------------
    // bruteForceSearch : 
    // on génère toutes les instanciations possibles 
    // aucune contrainte : toute instanciation complète est une solution
    //-----------------------------------------------------------------------------------------

    public static void bruteForceSearch(Csp csp) {
    	if (csp.allInstanciated()) {
	    // traitement du cas où une instanciation est complète
	    // (affichage, sauvegarde...)
    		Stats.incSolutions();
    		for (Variable var : csp.getVars()) {
	    		System.out.print(var.getName() + ": " +var.getDomain()+"\n");
	    	}
	    	System.out.println();
		}
    else {
	    // à compléter
	    Variable y = csp.nextVarToInstantiate();
	    Domain yDom = y.getDomain().clone();
	    for (int val : yDom) {
    		Stats.incInstantiations();
	    	y.instantiate(val);
	    	bruteForceSearch(csp);
	    }
	    y.setDomain(yDom);
	}
    }

    //-----------------------------------------------------------------------------------------
    // generateAndTest : 
    // on ajoute un test pour vérifier si une instanciation complète est une solution
    // Note : si le csp n'a aucune contrainte, c'est le même comportement que bruteForceSearch
    //-----------------------------------------------------------------------------------------

    public static void generateAndTest(Csp csp) {
	if (csp.allInstanciated()) {
	    if (csp.hasSolution()) {
		// test de l'existence d'une solution
		// traitement de la solution le cas échéant
	    	Stats.incSolutions();
	    	for (Variable var : csp.getVars()) {
	    		System.out.print(var.getName() + ": " +var.getDomain()+"\n");
	    	}
	    	System.out.println();
	    	
	    }
	}
	else {
	    // à compléter
	    Variable y = csp.nextVarToInstantiate();
	    Domain yDom = y.getDomain().clone();
	    for (int val : yDom) {
			Stats.incInstantiations();
	    	y.instantiate(val);
	    	generateAndTest(csp);
	    }
	    y.setDomain(yDom);
	}
    }

    /* **************************************************************************************************
     * TP2
     * backtrack : 
     * on n'attend pas que l'instanciation soit complète pour vérifier qu'elle est viable
     * (elle PEUT mener à une solution)
     ****************************************************************************************************/
   
    //-----------------------------------------------------------------------------------------
    // backtrack1 : 
    // on teste si les contraintes sont satisfaites 
    // au fur et à mesure qu'elles sont complètement instanciées
    //-----------------------------------------------------------------------------------------

    public static void backtrack1(Csp csp) {
	boolean ok = true;
	for (Constraint constraint : csp.getConstraints()) {
		if (constraint.allInstantiated()) {
			if (!constraint.isSatisfied()) {
				ok = false;
			}
		}
	}
	// ok = check()
	// (check : test de l'instanciation courante)
	if (ok) {
	    if (csp.allInstanciated()) {
		// une solution a été trouvée : 
		// à traiter   
	    	Stats.incSolutions();
	    	for (Variable var : csp.getVars()) {
	    		System.out.print(var.getName() + ": " +var.getDomain()+"\n");
	    	}
	    	System.out.println();
	    }
	    else {
	    	// à compléter (cf. bruteForceSearch ou generateAndTest)
	    	Variable y = csp.nextVarToInstantiate();
	    	Domain yDom = y.getDomain().clone();
	    	for (int val : yDom) {
	    		Stats.incInstantiations();
	    		y.instantiate(val);
	    		backtrack1(csp);
	    	}
	    	y.setDomain(yDom);
	    }
	}
    }

    //-----------------------------------------------------------------------------------------
    // backtrack2 : 
    // on teste si les contraintes PEUVENT ENCORE ëtre satisfaites 
    // dès qu'elles sont PARTIELLEMENT instanciées
    //-----------------------------------------------------------------------------------------

    public static void backtrack2(Csp csp) {
	boolean ok = true;
	for (Constraint constraint : csp.getConstraints()) {
		if (!constraint.isPossible()) {
			ok=false;
			break;
			}
	}
	// ok = check()
	// (check à définir : test de l'instanciation courante) 
	// ATTENTION : pas le même test que pour backtrack1

	if (ok) {
		if (csp.allInstanciated()) {
			// une solution a été trouvée : 
			// à traiter   
		    	Stats.incSolutions();
		    	for (Variable var : csp.getVars()) {
		    		System.out.print(var.getName() + ": " +var.getDomain()+"\n");
		    	}
		    	System.out.println();            
	    }
	    else {
		// à compléter
		Variable y = csp.nextVarToInstantiate();
		Domain yDom = y.getDomain().clone();
		for (int val : yDom) {
			Stats.incInstantiations();
		    y.instantiate(val);
		    backtrack2(csp);
		}
		y.setDomain(yDom);
	    }
	}
    }

    /* **************************************************************************************************
     * TP3
     ****************************************************************************************************/

    //-----------------------------------------------------------------------------------------
    // backtrack 3 : propagation/filtrage
    //-----------------------------------------------------------------------------------------
    
    public static void backtrack3(Csp csp) {
	boolean ok = true;

	// ok = check()
	// (check : test de l'instanciation courante) : utile ?

	if (ok) {
	    if (csp.allInstanciated()) {
		// une solution a été trouvée : 
		// à traiter            
	    }
	    else {
		// à compléter
		Variable y = csp.nextVarToInstantiate();
		Domain yDom = null;
		for (int val : yDom) {
		    y.instantiate(val);
		    	
		    }
		    backtrack3(csp);
		}
	    }
	}
    }

