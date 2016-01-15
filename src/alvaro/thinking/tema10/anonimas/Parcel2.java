package alvaro.thinking.tema10.anonimas;

// devolver una referencia de una clase interna (con un metodo to o cont)
public class Parcel2 {
  class Contents {
    private int i = 11;
    public int value() { return i; }
  }
  class Destination {
    private String label;
    Destination(String whereTo) {
      label = whereTo;
    }
    String readLabel() { return label; }
  }
  public Destination to(String s) {
    return new Destination(s);
  }
  public Contents cont() {
    return new Contents();
  }
  public void ship(String dest) {
    Contents c = cont();
    Destination d = to(dest);
    System.out.println(d.readLabel());
  }
  
  public static void main(String[] args) {
    Parcel2 p = new Parcel2();
    p.ship("Tanzania");
    Parcel2 q = new Parcel2();
    // Definimos referencias a las clases internas, para informar del tipo
    //aparece el nombre de la claseexterna.claseinterna
    
    //luego se  usan como valor los métodos que devuelven los objetos de esa clase.
    Parcel2.Contents c = q.cont();
    Parcel2.Destination d = q.to("Borneo");
    
    //compruebo que el objeto q al que apunta el puntero d, contiene su campo label con el string("Borneo");
    q.ship(d.label);
  }
} 