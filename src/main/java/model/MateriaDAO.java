package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MateriaDAO {
	private ArrayList<MateriaDTO> lista;

	public MateriaDAO() {
		lista = new ArrayList<MateriaDTO>();

	}

	public void quemar() {
		lista.add(new MateriaDTO("BD", "G2", 0, 7, 9, 1));
		lista.add(new MateriaDTO("BD", "G2", 0, 7, 9, 2));
		lista.add(new MateriaDTO("BD", "G2", 0, 7, 9, 3));

		lista.add(new MateriaDTO("BD", "G3", 1, 14, 16, 1));
		lista.add(new MateriaDTO("BD", "G3", 1, 11, 13, 2));
		lista.add(new MateriaDTO("BD", "G3", 1, 7, 9, 3));

		lista.add(new MateriaDTO("BD", "G4", 2, 20, 22, 1));
		lista.add(new MateriaDTO("BD", "G4", 2, 11, 13, 2));
		lista.add(new MateriaDTO("BD", "G4", 2, 7, 9, 3));

		lista.add(new MateriaDTO("Ingles Virtual Intro", "G1", 0, 16, 18, 1));
		
		lista.add(new MateriaDTO("COMPLEJIDAD ALGORITMICA", "G5", 0, 14, 16, 2));
		
		lista.add(new MateriaDTO("MATEMATICAS APLICADAS", "G6", 0, 9, 11, 3));
		
		lista.add(new MateriaDTO("DIRECCION Y PLANEACION", "G2", 0, 14, 16, 1));
		
		lista.add(new MateriaDTO("SISTEMAS DIGITALES Y ARQUITECTURA DE COMPUTADOR", "G3", 0, 16, 18, 2));
		
		lista.add(new MateriaDTO("ESTR. DEL PENSAMIENTO 3 - DESC. Y ANALISIS PROC.MULT", "G4", 0, 9, 11, 3));

	}

	public void agregar(String nombreMateria, String grupo, int opcion, int horaInicial, int horaFinal, int dia) {
		lista.add(new MateriaDTO(nombreMateria, grupo, opcion, horaInicial, horaFinal, dia));

	}

	public int mayorOpcion(String nombreMateria) {
		int mayor = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombreMateria().equals(nombreMateria)) {
				if (lista.get(i).getOpcion() >= mayor) {

					mayor = lista.get(i).getOpcion() + 1;
				}
			}

		}
		return mayor;

	}

	public List<Integer> obtenerOpcionesPorNombre(String nombreMateria) {
		List<Integer> opciones = new ArrayList<>();
		for (MateriaDTO materia : lista) {
			if (materia.getNombreMateria().equals(nombreMateria)) {
				opciones.add(materia.getOpcion());
			}
		}
		return opciones;
	}

	public Set<String> obtenerMateriasSinRepetir() {
		Set<String> materiasSinRepetir = new HashSet<String>();
		for (MateriaDTO materia : lista) {
			materiasSinRepetir.add(materia.getNombreMateria());
		}
		return materiasSinRepetir;
	}

	public ArrayList<MateriaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<MateriaDTO> lista) {
		this.lista = lista;
	}

}
