package problemes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import definition.Constraint;
import definition.ConstraintDiff;
import definition.ConstraintLT;
import definition.ConstraintLeq;
import definition.Csp;
import definition.Domain;
import definition.DomainBitSet;
import definition.Variable;

public class CspFournis {

    /*
      — X1 = {x0, x1, x2}
      — D1 = {d0, d1, d2} avec d0 = d1 = d2 = {0, 1, 2}
      — C1 = ∅ (aucune contrainte)
     */
    public static Csp buildCsp1() {
	List<Variable> vars = new ArrayList<>();
	int nbVars = 3;
	for (int i = 0 ; i < nbVars ; i++) {
	    vars.add(new Variable("x_"+i, new DomainBitSet(0, 2)));
	}

	List<Constraint> cons = new ArrayList<>();
	
	return new Csp(vars, cons);
    }

    /*
      — X2 = {x0, x1, x2}
      — D2 = {d0, d1, d2} avec d0 = d1 = d2 = {0, 1, 2}
      — C2 = {(x0 < x1), (x0 ≠x2)}
     */
    public static Csp buildCsp2() {
	Csp csp = buildCsp1();
	csp.addConstraint(new ConstraintLT(csp.getVars().get(0), csp.getVars().get(1)));
	csp.addConstraint(new ConstraintDiff(csp.getVars().get(0), csp.getVars().get(2)));

	return csp;
    }

    /*
     - X3 = {x0, x1, x2}
     — D3 = {d0, d1, d2} avec d0 = {2, 3, 4, 5, 6}, d1 = {4, 5, 6, 7} et d2 = {6, 7, 8, 9}
     — C3 = {(x2 ≤ x1), (x0 ≥ x1)}
    */
    public static Csp buildCsp3() {
	List<Variable> vars = new ArrayList<>();
	Domain d0 = new DomainBitSet(2, 6);
	Domain d1 = new DomainBitSet(4, 7);
	Domain d2 = new DomainBitSet(6, 9);
	vars.add(new Variable("x_0", d0));
	vars.add(new Variable("x_1", d1));
	vars.add(new Variable("x_2", d2));

	List<Constraint> cons = new ArrayList<>();
	cons.add(new ConstraintLeq(vars.get(2), vars.get(1)));
	cons.add(new ConstraintLeq(vars.get(1), vars.get(0)));
	
	return new Csp(vars, cons);
    }
    
    public Csp buildPb2013(int valMax) {	
	int nbVars = 10;
	List<Variable> vars = new ArrayList<>();
	for (int i = 0 ; i < nbVars ; i++) {
	    vars.add(new Variable("x_"+i, new DomainBitSet(1, valMax)));
	}
	
	// Les contraintes
	List<Constraint> cons = new ArrayList<Constraint>();

	// 1 : x9 <= x0
	cons.add(new ConstraintLeq(vars.get(9), vars.get(0)));
	// 2 : x9 <= x2
	cons.add(new ConstraintLeq(vars.get(9), vars.get(2)));
	// 3 : x9 < x4
	cons.add(new ConstraintLT(vars.get(9), vars.get(4)));
	// 4 : x0 < x1
	cons.add(new ConstraintLT(vars.get(0), vars.get(1)));
	// 5 : x0 < x4
	cons.add(new ConstraintLT(vars.get(0), vars.get(4)));
	// 6 : x0 <= x7
	cons.add(new ConstraintLeq(vars.get(0), vars.get(7)));
	// 7 : x1 <= x6
	cons.add(new ConstraintLeq(vars.get(1), vars.get(6)));
	// 8 : x2 != x4
	cons.add(new ConstraintDiff(vars.get(2), vars.get(4)));
	// 9 : x2 != x5
	cons.add(new ConstraintDiff(vars.get(2), vars.get(5)));
	// 10 : x4 != x5
	cons.add(new ConstraintDiff(vars.get(4), vars.get(5)));
	// 11 : x4 < x6
	cons.add(new ConstraintLT(vars.get(4), vars.get(6)));
	// 12 : x4 < x3
	cons.add(new ConstraintLT(vars.get(4), vars.get(3)));
	// 13 : x7 != x8
	cons.add(new ConstraintDiff(vars.get(7), vars.get(8)));
	// 14 : x5 <= x8
	cons.add(new ConstraintLeq(vars.get(5), vars.get(8)));
	// 15 : x6 != x3
	cons.add(new ConstraintDiff(vars.get(6), vars.get(3)));
	// 16 : x8 < x6
	cons.add(new ConstraintLT(vars.get(8), vars.get(6)));
	// 17 : x3 <= x8
	cons.add(new ConstraintLeq(vars.get(3), vars.get(8)));


	return new Csp(vars, cons);
	
        /* Probleme 2013
         * valMax : nombre de solutions
         * 3 : 0
         * 4 : 36
         * 5 : 744
         * 6 : 6859
         * 7 : 40761
         * 8 : 182028
         * 9 : 663300
         * 10 : 2073951
         */

    }
    
    public Csp buildPb00(int valMax) {
	
	// problème test supplémentaire fourni aux élèves
	// l'autre problème fourni est 2013
	
        int nbVars = 10;
        List<Variable> vars = new ArrayList<>();
        for (int i = 0 ; i < nbVars ; i++) {
            vars.add(new Variable("x_"+i, new DomainBitSet(1, valMax)));
        }
        Vector<Constraint> cons = new Vector<Constraint>();

        // Les contraintes

        // 1 : x0 < x5
        cons.add(new ConstraintLT(vars.get(0), vars.get(5)));
        // 2 : x0 <= x6
        cons.add(new ConstraintLeq(vars.get(0), vars.get(6)));
        // 3 : x0 > x7, ou x7 < x0
        cons.add(new ConstraintLT(vars.get(7), vars.get(0)));
        // 4 : x1 <= x6
        cons.add(new ConstraintLeq(vars.get(1), vars.get(6)));
        // 5 : x2 < x3
        cons.add(new ConstraintLT(vars.get(2), vars.get(3)));
        // 6 : x2 != x4
        cons.add(new ConstraintDiff(vars.get(2), vars.get(4)));
        // 7 : x3 >= x8, ou x8 <= x3
        cons.add(new ConstraintLeq(vars.get(8), vars.get(3)));
        // 8 : x4 <= x6
        cons.add(new ConstraintLeq(vars.get(4), vars.get(6)));
        // 9 : x4 != x7
        cons.add(new ConstraintDiff(vars.get(4), vars.get(7)));
        // 10 : x4 != x9
        cons.add(new ConstraintDiff(vars.get(4), vars.get(9)));
        // 11 : x5 <= x9
        cons.add(new ConstraintLeq(vars.get(5), vars.get(9)));
        // 12 : x6 < x8
        cons.add(new ConstraintLT(vars.get(6), vars.get(8)));
        // 13 : x6 < x9
        cons.add(new ConstraintLT(vars.get(6), vars.get(9)));
        // 14 : x7 < x9
        cons.add(new ConstraintLT(vars.get(7), vars.get(9)));
        // 15 : x8 > x9, ou x9 < x8
        cons.add(new ConstraintLT(vars.get(9), vars.get(8)));

        return new Csp(vars, cons);
        
        /* Probleme "Test supplémentaire"
         * valMax : nombre de solutions
         * 3 : 0
         * 4 : 4
         * 5 : 100
         * 6 : 1020
         * 7 : 6460
         * 8 : 30148
         * 9 : 113476
         * 10 : 363748
         */
    }



}
