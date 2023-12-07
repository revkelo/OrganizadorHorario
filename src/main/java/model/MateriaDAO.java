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

	public void agregar(String nombreMateria, String grupo, int opcion, int horaInicial, int horaFinal, int dia) {
		lista.add(new MateriaDTO(nombreMateria, grupo, opcion, horaInicial, horaFinal, dia));

	}

	public int mayorOpcion(String nombreMateria) {
		int mayor = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombreMateria().equals(nombreMateria)) {
				if (lista.get(i).getOpcion() >= mayor) {
		
					mayor = lista.get(i).getOpcion()+1;
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
