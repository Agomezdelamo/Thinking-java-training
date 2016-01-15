package alvaro.thinking.tema10.anonimas;

import com.bruceeckel.simpletest.Test;

interface Selector {
  boolean end();
  Object current();
  void next();
}

//clase externa
public class Sequence {
  private static Test monitor = new Test();
  private Object[] objects;
  private int next = 0;
  
  //constructor externo
  public Sequence(int size) { objects = new Object[size]; }
  
  public void add(Object x) {
    if(next < objects.length)
      objects[next++] = x;
  }
  
  /**
   * 
   * La clase interna accede a elementos de su clase externa. En este caso a "objects".
   * La clase interna Sselector accede a propiedades de Su clase externa aunque sean privados.
   * @author agomez
   *
   */
  private class SSelector implements Selector {
    private int i = 0;
    
    //devuelve true cuando el iterador i es igual que la distancia de el array de objects.
    public boolean end() { return i == objects.length; }
    
    //devuelve el objeto actual, puesto que next incrementa el iterador i cada vez.
    public Object current() { return objects[i]; }
    
    //incrementa el iterador mientras no sea tan largo como la distancia de objects.
    public void next() { if(i < objects.length) i++; }
  }
  
  public Selector getSelector() { return new SSelector(); }
  
  public static void main(String[] args) {
	//creo un array de objetos con 10 posiciones
    Sequence sequence = new Sequence(10);
  
    //añado 10 objetos primitivos int, de 0 a 9, con un for
    for(int i = 0; i < 10; i++) {
      sequence.add(Integer.toString(i));
    }
    
    //obtengo la clase inner con upCasting
    Selector selector = sequence.getSelector();
    
    //mientras el iterador de la clase inner no sea igual que los
    //objetos que tiene en total imprime el actual e itera con next. 
    while(!selector.end()) {
      System.out.println(selector.current());
      selector.next();
    }
    
    monitor.expect(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
  }
} 