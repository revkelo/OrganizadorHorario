package model;

public class FachadaModel {
	private MateriaDAO materia;

	public FachadaModel() {
		materia = new MateriaDAO();
	}

	public MateriaDAO getMateria() {
		return materia;
	}

	public void setMateria(MateriaDAO materia) {
		this.materia = materia;
	}

}
