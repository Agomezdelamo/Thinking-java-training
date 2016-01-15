package alvaro.thinking.tema3.operadores;
/**
 * Los operadores de desplazamiento manipulan bits.
 * S�lo se pueden utilizar con tipos primitivos enteros.
 * 
 *  El operador de desplazamiento a la izquierda (<<) provoca que 
 *  el operando de la izquierda del operador sea desplazado a la izquierda,
 *  tantos bits como se especifique tras el operador (insertando ceros en los bits menos significativos).
 *  
 *  El operador de desplazamiento a la derecha con signo (>>) provoca 
 *  que el operando de la izquierda del operador sea desplazado a la derecha el n�mero 
 *  de bits que se especifique tras el operador. 
 *  
 *  El desplazamiento a la derecha con signo >> utiliza la extensi�n de signo: 
 *  si el valor es positivo se insertan ceros en los bits m�s significativos; 
 *  si el valor es negativo, se insertan unos en los bits m�s significativos. 
 *  
 *  Java tambi�n ha incorporado el operador de rotaci�n a la derecha sin signo >>>,
 *  que utiliza la extensi�n cero: independientemente del signo, se insertan ceros
 *  en los bits m�s significativos.
 *  Si se trata de desplazar un char, un byte o un short, �ste ser� convertido
 *  a int antes de que el desplazamiento tenga lugar y el resultado ser� tambi�n un int.
 *  
 *  Los desplazamientos pueden combinarse con el signo igual (<<= o >>= o >>>=). 
 *  El ivalor se reemplaza por el ivalor desplazado por el dvalor. 
 *  
 *  Hay un problema, sin embargo, con el desplazamiento sin signo a la derecha 
 *  combinado con la asignaci�n. Si se utiliza con un byte o short no se logra el resultado correcto.
 *  En vez de esto, los datos son convertidos a int y desplazados a la derecha, y anteriormente se 
 *  truncan al ser asignados de nuevo a sus variables, por lo que en esos casos el resultado 
 *  suele ser -1. El ejemplo siguiente demuestra esto:
 */
public class DesplazamientoBitsBasico {
	/**
	 * desplazamiento b�sico sin signo
	 */
		public static void main (String[] args) {
		int i = -1;
		i >>>= 10;
		System.out.println(i);
		long a = -1;
		a >>>= 10;
		short S = -1;
		S >>>= 10;
		System.out.println(S);
		byte b = -1;
		b >>>= 10;
		System.out.println(b);
		b = -1;
		System.out.println(b>>>10);
		}

}