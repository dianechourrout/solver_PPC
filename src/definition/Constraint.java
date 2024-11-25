package definition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Constraint {

    private final List<Variable> variables;

    public Constraint(Variable... variables) {
        this.variables = Collections.unmodifiableList(Arrays.asList(variables));
    }

    // Retourne les variables de la contrainte
    public final List<Variable> getVars() {
        return variables;
    }

    // Retourne vrai ssi toutes les variables de la contrainte sont instanciées et la contrainte est verifiée
    public abstract boolean isSatisfied();

    // Une condition nécessaire à la satisfaction de la contrainte :
    // retourne vrai ssi il existe encore un tuple satisfaisant la contrainte
    // (il est encore possible qu'elle soit satisfaite)
    public abstract boolean isPossible();

    // Filtre les domaines des variables de la contrainte
    // (supprime les valeurs inconsistantes)
    // Attention : comment savoir si un appel à filter a eu un effet (une valeur supprimée d'un domaine) ?
    //public ??? filter();

    // Toutes les variables sur lesquelles porte la contrainte sont instanciées
    public abstract boolean allInstantiated();


}
