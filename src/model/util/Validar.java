package model.util;

public abstract class Validar {
	
	public static boolean validarLetraCaixaBaixa(String nome) {
		boolean valid = nome.matches("[a-z]");
		return valid;
	}
	public static boolean nomeCaixaBaixaCincoCaracteres(String nome) {
		boolean valid = nome.matches("[a-z] {5}");
		return valid;
	}
	public static boolean nomeCaixaBaixaMinimoCaracter(String nome) {
		boolean valid = nome.matches("[a-z] {5,}");
		return valid;
	}
	public static boolean nomeUmCaixaAlta(String nome) {
		boolean valid = nome.matches("[A-Z][a-z]{1,} ");
		return valid;
	}
	public static boolean numeroInteiro(int numero) {
		boolean valid = String.valueOf(numero).matches("[0-9]");
		return valid;
	}
	public static boolean numeroSeteInteiros(int numero) {
		boolean valid = String.valueOf(numero).matches("[0-9]{7}");
		return valid;
	}
	
}
