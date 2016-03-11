package alvaro.thinking.tema10.anonimas;

// innerclasses/CasaEcologicaMandos24.java
// TIJ4 Chapter Innerclasses, Exercise 24, page 382
/* En CasaEcologicaMandos.java, añade inner clases de Eventos que cambien interruptores de on a off.
 * Configura GreenhouseController.java para usar estos nuevos objetos de Eventos.
*/


public class CasaEcologicaMandos extends Controlador {
		/****** APARATO 1 *****/
		private boolean ventilador = false; //booleano que nos dice el estado del Evento
		
			/****** Evento 1 *****/
			public class VentiladorOn extends Evento {
				public VentiladorOn(long delayTime) { super(delayTime); }
				public void action() {
					// Put hardware control code here to
					// physically turn on the ventilador.
					ventilador = true;
				}
				public String toString() { return "ventilador is on"; }
			}
			/****** Evento 2 *****/
			public class VentiladorOff extends Evento {
				public VentiladorOff(long delayTime) { super(delayTime); }
				public void action() {
					// Put hardware control here to
					// physically turn off the ventilador.
					ventilador = false;
				}
				public String toString() { return "ventilador is off"; }
			}
		
		/****** APARATO 2 *****/
		private boolean light = false;//booleano que nos dice el estado del Evento
			/****** Evento 1 *****/
			public class LuzOn extends Evento {
				public LuzOn(long delayTime) { super(delayTime); }
				public void action() {
					// Put hardware control code here to
					// physically turn on the light.
					light = true;
				}
				public String toString() { return "Light is on"; }
			}
			/****** Evento 2 *****/
			public class LuzOff extends Evento {
				public LuzOff(long delayTime) { super(delayTime); }
				public void action() {
					// Put hardware control here to
					// physically turn off the light.
					light = false;
				}
				public String toString() { return "Light is off"; }
			}
		
		/****** APARATO 3 *****/
		private boolean water = false;//booleano que nos dice el estado del Evento
			/****** Evento 1 *****/
			public class AguaOn extends Evento {
				public AguaOn(long delayTime) { super(delayTime); }
				public void action() {
					// Put hardware control code here
					water = true;
				}
				public String toString() { 
					return "Greenhouse water is on";
				} 
			}
			/****** Evento 2 *****/
			public class AguaOff extends Evento {
				public AguaOff(long delayTime) { super(delayTime); }
				public void action() {
					// Put hardware control code here
					water = false;
				}
				public String toString() {
					return "Greenhouse water is off";
				}
			}
			
		/****** APARATO 4 *****/
		private String thermostat = "Day";//booleano que nos dice el estado del Evento
			/****** Evento 1 *****/
			public class TermostatoNocturno extends Evento {
				public TermostatoNocturno(long delayTime) {
					super(delayTime);
				}
				public void action() {
					// Put hardware control code here
					thermostat = "Night";
				}
				public String toString() {
					return "Termostato seteado de noche";
				}
			}
			/****** Evento 2 *****/
			public class TermostatoDiurno extends Evento {
				public TermostatoDiurno(long delayTime) {
					super(delayTime);
				}	
				public void action() {
					// Put hardware control code here
					thermostat = "Day";
				}
				public String toString() {
					return "Termostato seteado de dia";
				}
			}
		
			
			/****** APARATO 5 *****/
			private boolean vapor = false;//booleano que nos dice el estado del Evento
			/****** Evento 1 *****/
			public class VaporOn extends Evento {
				public VaporOn(long delayTime) {
					super(delayTime);
				}
				public void action() {
					// Put hardware control code here to 
					// physically turn on water mist generator
					vapor = true;
				}
				public String toString() { 
					return "Generador de vapor en on";  
				}
			}	
			/****** Evento 2 *****/
			public class VaporOff extends Evento {
				public VaporOff(long delayTime) {
					super(delayTime);
				}
				public void action() {
					// Put hardware control code here to
					// physically turn off water mist generator
					vapor = false;
				}
				public String toString() {
					return "Generador de vapor en off";
				}
			}
			
		
		// Un ejemplo de una acción que inserta otra nueva 
		//a si misma dentro de la lista de Eventos
		public class Campana extends Evento {
			public Campana(long delayTime) { super(delayTime); }
			public void action() {
				addEvento(new Campana(delayTime));//se añade a si misma y con el tiempo de retardo del constructor
			}
			public String toString() { return "Ding Dong!"; }
		}
		
		public class Restart extends Evento { //Reiniciar
			private Evento[] EventoList; //lista de Eventos
			
			//CONSTRUCTOR
			public Restart(long delayTime, Evento[] EventoList) {
				super(delayTime); //seteo el tiempo de retardo al padre
				this.EventoList = EventoList; //seteo la lista de Eventos
				for(Evento e : EventoList)
					addEvento(e); //los añado
			}
			
			public void action() { //acciono los Eventos
				for(Evento e : EventoList) { //paseo por la lista 
					e.start(); // los relanzo todos
					addEvento(e); //y los añado
				}
				start(); // Relanzo este mismo Evento
				addEvento(this); //lo añado
			}
			public String toString() {
				return "Reiniciando el sistema \r\n";
			}
		}
		
		public static class Terminate extends Evento { //Extiendo la abstracta Evento para añadir metodos de finalizado
			public Terminate(long delayTime) { super(delayTime); }
			public void action() { System.exit(0); }
			public String toString() { return "Terminating"; }
		}
}	
