package funciones;

/** 
 * Clase de utilidades
 * @author David
 *
 */
public class Utilidades {

	/**
	 * Instancia un objeto de la clase
	 */
	public Utilidades() {
	}
	
	/**
	 * Constante que contiene el número de horas de una joranda normal
	 * {@value}
	 */
	public static final int HORASJORNADA = 38;
	
	/**
	 * Método de la clase que devuelve la representación textual de la nota
	 * pasada como parámetro
	 * @param nota double con la nota a comprobar
	 * @return Una cadena de tipo String con el texto resultante (Suspenso, Bien,
	 * Notable, Sobresaliente o Matrícula)
	 * @throws ArithmeticException cuando la nota no está entre 0 y 10
	 */
	public String devuelveNota(double nota) {
		if (nota <0 || nota >10) {
			throw new ArithmeticException("La nota debe ser negativo");
		} else if (nota>=0 && nota<5){
			return "Suspenso";
		} else if (nota>=5 && nota<6.5) {
			return "Bien";
		} else if (nota<8.5) {
			return "Notable";
		} else if (nota<10) {
			return "Sobresaliente";
		} else {
			return "Matrícula";
		}
	}
	
	/**
	 * Método que calcula el salario de un empleado dado el numeros de horas que ha trabajado
	 * el precio por hora y el precio de la horas extras.
	 * Se pagarán hasta {@link HORASJORNADA} con el precioHoras, el resto se pagarán a precioExtras
	 * @param numHoras numeros horas de jornada laboral del empleado
	 * @param precioHoras precio al que cobra la hora ordinaria
	 * @param precioExtras precio al que cobra las horas extras
	 * @return double con el valor del salario completo
	 * @throws ArithmeticException se lanza cuando el numero de horas o los precio son negativos o 
	 * cero
	 */
	public double calculaSalario(int numHoras, double precioHoras, double precioExtras) {
		int extras=0;
		int horas=numHoras;
		if (numHoras<=0 || precioHoras<=0 || precioExtras <= 0 ) {
			throw new ArithmeticException(); 
		}
		if (numHoras>HORASJORNADA) {
			extras = numHoras-HORASJORNADA;
			horas = HORASJORNADA;
		}
		return horas*precioHoras+extras*precioExtras;		
	}
	

	/**
	 * Método que devuelve el numero de divisores que tiene el número pasado como parámetro
	 * 
	 * @param num número a comprobar
	 * @return el número de divisores 
	 */
	public int cuentaDivisores(int num) {
		int cuenta=0;
		
		for (int i = 1; i <= num; i++) {
			if (num%i==0) {
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * Método que deveulve el menor elemento de un array dado como parámetro, 
	 * por ejemplo un vector [2,3,-1,9] devolvería -1
	 * @param v int [] vector de enteros con los números
	 * @return int con el menor número del vector.
	 */
	public double devuelveMenor(int v[]) {
		
		int menor=v[0];
		for (int i = 0; i < v.length; i++) {
			if(v[i]<menor) {
				menor=v[i];
			}
		}
		return menor;
	}
	
	/**
	 * Algoritmo que ordena un vector a través del método de la burbuja
	 * @param v int [] vector a ordenar, que no será modificado
	 * @return int [] con el vector ordenado
	 */
	public int [] burbuja(int[] v)
    {
      int auxiliar;
      int[] ordenado;
      for(int i = 1; i < v.length; i++)
      {
        for(int j = 0;j < v.length-i;j++)
        {
          if(v[j] > v[j+1])
          {
            auxiliar = v[j];
            v[j] = v[j+1];
            v[j+1] = auxiliar;
          }   
        }
      }
      ordenado = v;
      return ordenado;
    }
}
