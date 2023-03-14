package com.jmgl.centroEducativo.utils;


public class UtilsArrays {

	/**
	 * 
	 * @param longitud
	 * @param limInf
	 * @param limSup
	 * @return
	 */
	public static int[] creaArrayNumerosAzar (int longitud, int limInf, int limSup) {
		int array[] = new int[longitud];
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.obtenerNumeroAzar(limInf, limSup);
		}
		return array;
	}

	
	/**
	 * 
	 * @param array
	 */
	public static void mostrarArray (int[] array) {
		System.out.println("Contenido del array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @param array
	 */
	public static void mostrarArrayDecimal (double[] array) {
		System.out.println("Contenido del array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	
	/**
	 * 
	 * @param longitud
	 * @param limInf
	 * @param limSup
	 * @return
	 */
	public static int[] creaArrayNumerosUsuario (int longitud) {
		int array[] = new int[longitud];
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.obtenerEntero();
		}
		return array;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int sumaParesArays (int[] array) {
		System.out.print("Suma de los pares: ");
		int sumaPares = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 == 0 ) {
				sumaPares += array[i];
			}
		}

		return sumaPares;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int sumaImparesArays (int[] array) {
		System.out.print("Suma de los Impares: ");
		int sumaImpares = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 0 ) {
				sumaImpares += array[i];
			}
		}
		return sumaImpares;
	}
	
	/**
	 * 
	 * @param array
	 */
	public static void cambiarSignoPares (int[] array) {
		System.out.println("Asi quedan los pares con el signo cambiado: ");
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 == 0 ) {
				array[i] = - array[i];	
			}
			System.out.print(array[i] + " ");
		}
	}
	
	/**
	 * 
	 * @param filas
	 * @param columnas
	 * @param valorInicial
	 * @return
	 */
	public static int[][] crearEInicializarMatriz(int filas, int columnas, int valorInicial) {
		int matriz[][] = new int[filas][columnas];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = valorInicial;
			}
		}
		return matriz;
	}
	
	/**
	 * 
	 * @param matriz
	 */
	public static void mostrarMatriz(int[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 
	 * @param matriz
	 */
	public static void mostrarMatrizChar(char[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int longitudArray(int array[]) {
		if(array.length % 2 != 0) {
			return array[array.length /2]; 
		}
		else {
			return -1;
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static float calcularPorcentajePositivoArray(int[] array) {
		float contadorAprobadas = 0, resultado;
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] >= 5) {
				contadorAprobadas++;
			}
		}
		resultado = (contadorAprobadas/array.length)*100;
		return resultado;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static float calcularPorcentajeNegativoArray(int[] array) {
		float contadorSuspensas = 0, resultado;
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] <= 5) {
				contadorSuspensas++;
			}
		}
		resultado = (contadorSuspensas/array.length)*100;
		return resultado;
	}
	
	/**
	 * 
	 * @param longitud
	 * @return
	 */
	public static double[] crearArrayDecimal(int longitud) {
		double entero, decimal;
		
		double array[] = new double[longitud];
		
		for(int i = 0; i < array.length; i++) {
			entero = Utils.obtenerNumeroAzar(0, 99);
			decimal = Math.random();
			decimal =  entero + decimal;
			array[i] = decimal;
		}
		return array;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int contadorArraysNumerosDecimales (double[] array) {
		int contadorSuperior = 0, entero;
		double decimal;
		
		for(int i = 0; i < array.length; i++) {
			entero = (int) array[i];
			decimal = array[i] - entero;
			if(decimal > 0.49) {
				contadorSuperior++;
			}
		}
		return contadorSuperior;
	}
	
	/**
	 * 
	 * @param array
	 * @param buscado
	 * @param remplazado
	 */
	public static void findAndReplace (int array[], int buscado, int remplazado) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == buscado) {
				array[i] = remplazado;
			}
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param valorAContar
	 */
	public static int countOcurrences (int array[], int valorAContar) {
		int contador = 0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] == valorAContar) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * 
	 * @param array
	 * @param valorAAgregar
	 * @return
	 */
	public static int[] addInterger(int array[], int valorAAgregar) {
		int array2[] = new int[array.length +1];
		for(int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		array2[array2.length -1] = valorAAgregar;
		
		return array2;
	}
}
