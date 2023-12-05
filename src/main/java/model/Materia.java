package model;

public class Materia {
	private String nombreMateria;
	private String profesor;
	private int horaInicial;
	private int horaFinal;
	private int dia;

	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(String nombreMateria, String profesor, int horaInicial, int horaFinal, int dia) {
		super();
		this.nombreMateria = nombreMateria;
		this.profesor = profesor;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dia = dia;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(int horaInicial) {
		this.horaInicial = horaInicial;
	}

	public int getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Materia [nombreMateria=" + nombreMateria + ", profesor=" + profesor + ", horaInicial=" + horaInicial
				+ ", horaFinal=" + horaFinal + ", dia=" + dia + "]";
	}

}
