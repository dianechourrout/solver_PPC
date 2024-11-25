package definition;

public class ConstraintDiff extends Constraint {

    public ConstraintDiff(Variable var1, Variable var2) {
        super(var1, var2);
    }

    @Override
    public boolean isSatisfied() {
    	return (this.allInstantiated())&&(this.getVars().get(0).getInf()!=
    			this.getVars().get(1).getInf());
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode isSatisfied() de la classe ConstraintDiff");
    }

    @Override
    public boolean isPossible() {
    	return (this.getVars().get(0).getDomainSize()>1||this.getVars().get(1).getDomainSize()>1) ||
    			(this.getVars().get(0).getInf()!=this.getVars().get(1).getInf());
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode isPossible() de la classe ConstraintDiff");
    }

    @Override
    public boolean allInstantiated() {
    	return this.getVars().get(0).isInstantiated() && this.getVars().get(1).isInstantiated();
        //throw new UnsupportedOperationException("Vous devez implémenter la méthode allInstantiated() de la classe ConstraintDiff");
    }
    public boolean filtrer() {
    	Variable var1 =this.getVars().get(0);
    	Variable var2 =this.getVars().get(1);
    	Domain dom1 = var1.getDomain();
    	Domain dom2 = var2.getDomain();
    	Domain dom1clone = var1.getDomain();
    	Domain dom2clone =var2.getDomain();
    	
    	if (var1.getDomainSize()==1){
    		for(int val : dom2) {
    			if(val == var1.getInf()) {
    				dom2.remove(val);
    			}
    		}	
    	}
    	if (var2.getDomainSize()==1){
    		for(int val : dom1) {
    			if(val == var2.getInf()) {
    				dom1.remove(val);
    			}
    		}
    	}
    	return dom1.size() != dom1clone.size() || dom2.size() != dom2clone.size();}
}
