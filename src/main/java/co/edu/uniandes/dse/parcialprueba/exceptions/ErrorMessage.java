package co.edu.uniandes.dse.parcialprueba.exceptions;

public final class ErrorMessage {
	public static final String NUMERO_INVALIDO = "El telefono debe tener 11 digitos y empezar con 311 o 601";
    public static final String PACIENTE_NO_EXISTENTE = "El paciente no existe";

	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}
