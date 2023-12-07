package model;

public class MateriaDTO {
	private String nombreMateria;
	private String grupo;
	private int opcion;
	private int horaInicial;
	private int horaFinal;
	private int dia;

	public MateriaDTO() {
		// TODO Auto-generated constructor stub
	}



	public MateriaDTO(String nombreMateria, String grupo, int opcion, int horaInicial, int horaFinal, int dia) {
		super();
		this.nombreMateria = nombreMateria;
		this.grupo = grupo;
		this.opcion = opcion;
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



	public String getGrupo() {
		return grupo;
	}



	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}



	public int getOpcion() {
		return opcion;
	}



	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}



	@Override
	public String toString() {
		return "MateriaDTO [nombreMateria=" + nombreMateria + ", grupo=" + grupo + ", opcion=" + opcion
				+ ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + ", dia=" + dia + "]";
	}


}
