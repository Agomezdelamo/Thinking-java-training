package alvaro.thinking.tema3.operadores;

import java.lang.*;


class CalculadorVelocidad {
	static float velocity(float dparam, float tparam) {
		if (tparam==0) return 0f;
		else return dparam/tparam;
	}
}

public class TestVelocidad {
	public static void main(String[] args) {
		/**
		 * distancia 500.5 kilometros;
		 */
		float d = 500.5f;
		
		/**
		 * tiempo 3.5 horas
		 */
		float t = 3.5f;
		
		System.out.println("Distance: " + d);
		System.out.println("Time: " + t);
		
		/**
		 * velocidad en kilometros por hora.
		 */
		float v = CalculadorVelocidad.velocity(d, t);
		System.out.println("Velocity :" + v);
	}
}
