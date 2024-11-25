package definition;

import java.util.List;

public class Csp {

    private final List<Variable> vars; // l'ensemble des variables du CSP. Note: les domaines sont connus au travers des variables
    private final List<Constraint> cons; // l'ensemble des contraintes du CSP (éventuellement vide)

    public Csp(List<Variable> vars, List<Constraint> cons) {
        this.vars = vars;
        this.cons = cons;
    }

    public List<Variable> getVars() {
        return vars;
    }

    public List<Constraint> getConstraints() {
        return this.cons;
    }

    // QUESTION : est-ce qu'on teste si la contrainte y figure déjà ?
    public void addConstraint(Constraint constraint) {
        this.cons.add(constraint);
    }

    // retourne la premiere variable non instanciée du csp, null s'il n'y en a pas/plus (toutes les variables sont instanciées)
    public Variable nextVarToInstantiate() {
        // à compléter
    	for (Variable var : vars) {
    		if (!(var.isInstantiated())) {
    			return var;
    		}
    	}
    	return null;
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode nextVarToInstantiate() de la classe Csp");
    }

    // retourne vrai ssi toutes les variables sont instanciées
    public boolean allInstanciated() {
        // à compléter
    	return (this.nextVarToInstantiate()==null) && (!(this.vars.isEmpty()));
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode allInstanciated() de la classe Csp");
    }
    	

    // retourne vrai ssi le CSP possède (au moins) une solution : 
    // l'ensemble des contraintes du CSP est vérifié
    // ATTENTION : ce n'est pas la seule condition
    public boolean hasSolution() {
        // à compléter
    	if (!this.allInstanciated()) {
    		return false;
    	}
    	for (Constraint constraint : cons) {
    		if (!constraint.isSatisfied()) {
    			return false;
    		}
    	}
    	return true;
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode hasSolution() de la classe Csp");
    }


}
