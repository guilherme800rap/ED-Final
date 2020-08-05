package programa;

import java.util.ArrayList;


public class Programa1 {

	
		private ArrayList<Arma>ListaArmas;
		
		
		
		
		//Construtor
		public Programa1() {
			ListaArmas = new ArrayList();
			
			
			Janela janArma = new Janela(ListaArmas);

		}
		//Todo o sistema vai ser inicializado a partir deste metodo
		public static void main (String[] args) {
			Programa1 app = new Programa1();
		}
		
}		
		
			

	
