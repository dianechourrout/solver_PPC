package definition;

public class ConstraintEq extends Constraint {

    public ConstraintEq(Variable var1, Variable var2) {
        super(var1, var2);
    }

    @Override
    public boolean isSatisfied() {
    	return (this.allInstantiated())&&(this.getVars().get(0).getInf()==
    			this.getVars().get(1).getInf());
    	//throw new UnsupportedOperationException("Vous devez implémenter la méthode isSatisfied() de la classe ConstraintEq");
    }

    @Override
    public boolean isPossible() {
    	return this.allInstantiated()&&(this.getVars()).get(0).getInf()<=
    			this.getVars().get(1).getSup()&&(this.getVars().get(1).getInf()<=
    			this.getVars().get(0).getSup());
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode isPossible() de la classe ConstraintEq");
    }

    @Override
    public boolean allInstantiated() {
    	return (this.getVars().get(0).isInstantiated()) &&
    			(this.getVars().get(1).isInstantiated());
       //throw new UnsupportedOperationException("Vous devez implémenter la méthode allInstantiated() de la classe ConstraintEq");
    }
    public boolean filtrer() {
    	Variable var1 =this.getVars().get(0);
    	Variable var2 =this.getVars().get(1);
    	Domain dom1 = var1.getDomain();
    	Domain dom2 = var2.getDomain();
    	Domain dom1clone = var1.getDomain();
    	Domain dom2clone =var2.getDomain();
    	
    	for (int val1 : dom1) {
    		if (val1 < var2.getInf()) {
    			dom1.remove(val1);
    			}
    		if (val1 > var2.getSup()) {
    			dom1.remove(val1);	
    		}
    	for (int val2 : dom2) {
        		if (val2 < var1.getInf()) {
        			dom1.remove(val1);
        			}
        		if (val2 > var1.getSup()) {
        			dom1.remove(val1);	
        		}
    	}
    	}
    	
    	return dom1.size() != dom1clone.size() || dom2.size() != dom2clone.size();
}}
