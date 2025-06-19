//import java.lang.classfile.Signature;
import java.util.Arrays;

/*
 * In dieser Aufgabe soll das Zusammenspiel von Arrays und For-Schleifen geuebt
 * werden. In den meisten Methoden ist dem Parameter elements das Schluessel-
 * wort "final" vorangestellt. Das bedeutet, dass das Array in der Methode nur
 * gelesen, nicht aber beschrieben werden darf.
 */
public class ArraysAndLoops {
	
	// Diese Methode soll die Elemente des als Parameter (elements) uebergebenen
	// Arrays addieren und die Gesamtsumme zurueckgeben.
	public static int sum(final int[] elements){
		int sum =0;
		for (int i =0;i< elements.length;i++) {
			
			  sum =+ elements[i];
		}
		return sum;
	}
	
	// Diese Methode soll in einem als Parameter (elements) uebergebenen Array
	// das groesste Element finden. Rueckgabewert soll das Produkt aus dem
	// groessten Element und dem Index des groessten Elements sein.
	// Beispiel: Eingabe   = {2, 13, 56, 44, 5}
	//           Rueckgabe = 56 (groesstes Element) * 2 (Index von 56) = 112
	// Nicht vergessen, dass die Indizierung in einem Array mit 0 beginnt!
	public static int maxElement(final int[] elements){
	
		
		int max = elements[0];
		int sum = 0;
		for(int i =0;i<elements.length;i++) {
			if (max<elements[i]);
			max = elements[i];
			sum = max * i;
			
			
		}
		return sum;
	}

	// Diese Methode soll ein Array zurueckgeben, in dem alle Elemente des
	// uebergebenen Arrays dupliziert wurden und in der gleichen Reihenfolge
	// wie im Originalarray stehen. Beispiel:
	// Übergeben wird ein Array der Form {4, 16, 8},
	// Das zurueckgegebene Array soll dann {4, 4, 16, 16, 8, 8} beinhalten.
	public static int[] duplicateElements(final int[] elements){
		int y = 0;
		int x = 0;
		
		int[] d = new int[elements.length*2];
		for (int i =0;i<elements.length;i++) {
			for(int j =0;j<d.length;j+=2) {
				
			
			y= elements[i];
			x= y;
			 d[j]=x;
			 d[j+1]=x ;
			   
			}
		}
		return d;
	}
	
	// Diese Methode soll zu einem uebergebenen Array ein neues Array zurueck
	// geben, in dem zu jedem Element des Ausgangsarrays das Quadrat steht.
	// Beispiel: Eingabe   = {4,  12,  7}
	//           Rueckgabe = {16, 144, 49}
	public static int[] getSquares(final int[] elements){
		int[]s=new int[elements.length];
		int y = 0;
		int z =0;
		for(int i=0;i<elements.length;i++) {
			y=elements[i];
			z = y*y;
			s[i]=z	;	
			
		}
		return s;
	}
	
	// Diese Methode soll in einem uebergebenen Array die Reihenfolge der
	// Elemente umkehren.
	// Beispiel: Eingabe   = {4,  12,  7, 18}
	//           Rueckgabe = {18,  7, 12, 4}
	// ACHTUNG: Diese Methode hat keine Rueckgabe. Das Array Elements soll
	// nach Ausfuehrung der Methode das Ergebnis beinhalten.
	public static void reverseArray(int[] elements){
		
		
		int i=0;
		int j=elements.length-1;
		while(i<j) {
			
		
		
				int t = 0;
				
				
				t =elements[i];
				elements[i]=elements[j];
				elements[j]=t;
			    i++;
			    j--;
				
			}
			
		}
	

	// Hier koennt ihr eure Methoden testen.
	public static void main(String[] args) {

		int [][] x = new int[][]{
				{1,2,3},
				{4,5,5},
				{6,6,7}};
		System.out.println(x.length);
		System.out.println(x[0].length);
		System.out.println(x[1].length);
		System.out.println(x[2].length);

		int [] y = new int[x[0].length];


		for (int i = 0; i < x.length; i++) {
			int sum = 0;
			for (int j = 0; j < x[i].length; j++) {
				sum = sum + x[i][j];


			}
			y[i] = sum;
		}


		System.out.println(Arrays.toString(y));
	}
}