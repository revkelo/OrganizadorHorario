package model;

import java.util.ArrayList;

public class MateriaDAO {
	private ArrayList<MateriaDTO> lista;

	public MateriaDAO() {
		lista = new ArrayList<MateriaDTO>();

	}

	public void agregar(String nombreMateria, String profesor, int horaInicial, int horaFinal, int dia) {
		lista.add(new MateriaDTO(nombreMateria, profesor, horaInicial, horaFinal, dia));

	}

	public ArrayList<MateriaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<MateriaDTO> lista) {
		this.lista = lista;
	}



}
