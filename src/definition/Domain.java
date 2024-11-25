package definition;

import java.util.Iterator;

public interface Domain extends Iterable<Integer> {
    Domain clone();
    
    int size();

    // retourne vrai ssi la valeur v est dans le domaine
    boolean contains(int v);

    // retourne la première valeur du domaine
    int firstValue();

    // retourne la dernière valeur du domaine
    int lastValue();

    // supprime la valeur v du domaine
    void remove(int v);

    void remove(int from, int to);
    
    void removeAll();

    // supprime toutes les valeurs du domaine excepté v
    void instantiate(int v);


    Iterator<Integer> iterator();


}
