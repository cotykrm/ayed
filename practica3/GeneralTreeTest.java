package practica3;

import java.util.LinkedList;
import java.util.List;

public class GeneralTreeTest {

	
	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
	    
		RecorridosAG prueba = new RecorridosAG();
		List<Integer> impares;
                
                /*impares = prueba.numerosImparesMayoresQuePreOrden(a, 10);
		
		for(Integer num : impares) {
			System.out.println(num);
		}
		
		impares = prueba.numerosImparesMayoresQuePostOrden(a, 10);
		
		for(Integer num : impares) {
			System.out.println(num);
		}
                
                impares = prueba.numerosImparesMayoresQuePorNiveles(a, 10);
		
		for(Integer num : impares) {
			System.out.println(num);
		}
                */
                
                System.out.println("Árbol: ");
                a.porNiveles();
                
                System.out.println("altura: "+a.altura());
                System.out.println("nivel: "+a.nivel(21));
                System.out.println("ancho: "+a.ancho());
                
                
	}
}
