package practica3;

import java.util.List;

/*Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo
sucesivamente hasta llegar a cada una de las casas.
Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo
con las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas. Es
decir, si un caño maestro recibe 1000 litros y tiene por ejemplo 4 bifurcaciones se divide en 4 partes
iguales, donde cada división tendrá un caudal de 250 litros.
Luego, si una de esas divisiones se vuelve a dividir, por ej. en 5 partes, cada una tendrá un caudal de
50 litros y así sucesivamente hasta llegar a un lugar sin bifurcaciones.
Se debe implementar una clase RedDeAguaPotable que contenga el método con la siguiente firma:
public double minimoCaudal(double caudal)
que calcule el caudal de cada nodo y determine cuál es el caudal mínimo que recibe una casa. Asuma
que la estructura de caños de la red está representada por una variable de instancia de la clase
RedAguaPotable y que es un GeneralTree<Character>.
*/

public class RedDeAguaPotable {
    private GeneralTree<Double> red;

    public RedDeAguaPotable(GeneralTree<Double> red) {
        this.red = red;
    }

    private double calcularMinimoCaudal(GeneralTree<Double> ab, double caudal){
        ab.setData(caudal);
        if(ab.isLeaf()){
            return caudal;
        }
        double minimo = Double.MAX_VALUE;
        List<GeneralTree<Double>> children = ab.getChildren();
        caudal = caudal / children.size();
        for (GeneralTree<Double> child : children) {
            double caudalHijo = calcularMinimoCaudal(child, caudal);
            if (caudalHijo < minimo) { // Comparación manual para encontrar el mínimo
                minimo = caudalHijo;
            }
        }

        return minimo;
    }
        

    public double minimoCaudal(double caudal){
        if(red != null && !red.isEmpty()){
            double minimo = calcularMinimoCaudal(red,caudal);
            return minimo;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Crear el árbol de la red de agua potable
        GeneralTree<Double> root = new GeneralTree<>(null); // Nodo raíz (caño maestro)
        GeneralTree<Double> child1 = new GeneralTree<>(null); // Primera bifurcación
        GeneralTree<Double> child2 = new GeneralTree<>(null); // Segunda bifurcación
        GeneralTree<Double> leaf1 = new GeneralTree<>(null); // Hoja (casa 1)
        GeneralTree<Double> leaf2 = new GeneralTree<>(null); // Hoja (casa 2)
        GeneralTree<Double> leaf3 = new GeneralTree<>(null); // Hoja (casa 3)
    
        // Construir el árbol
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(leaf1);
        child1.addChild(leaf2);
        child2.addChild(leaf3);
    
        // Crear la red de agua potable
        RedDeAguaPotable red = new RedDeAguaPotable(root);
    
        // Calcular el caudal mínimo
        double caudalInicial = 1000; // Caudal inicial en el caño maestro
        double caudalMinimo = red.minimoCaudal(caudalInicial);

        root.porNiveles();
    
        // Imprimir el resultado
        System.out.println("El caudal mínimo que recibe una casa es: " + caudalMinimo);
    }
}
