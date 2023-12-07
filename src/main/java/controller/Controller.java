package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import model.FachadaModel;
import view.FachadaView;

public class Controller implements ActionListener {

	private FachadaView vp;
	private FachadaModel md;

	public Controller() {
		md = new FachadaModel();
		vp = new FachadaView();
		actionsListeners();
		vp.getView().setVisible(true);
	}

	public void actionsListeners() {
		vp.getView().getBtnAgregar().addActionListener(this);
		vp.getView().getBtnprueba().addActionListener(this);
		vp.getView().getExitMenuItem().addActionListener(this);
		vp.getView().getReiniciar().addActionListener(this);
		vp.getView().getMostrar().addActionListener(this);
		vp.getView().getHorarioitem().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Horario")) {
			md.getMateria().quemar();

//			vp.getMsj().mostrar(vp.getView().isNull(0, 1) + "");
			for (int i = 0; i < md.getMateria().getLista().size(); i++) {

				if (vp.getView().isNull(md.getMateria().getLista().get(i).getHoraInicial() - 7, md.getMateria().getLista().get(i).getDia())) {
				vp.getView().ponerEnHorario(md.getMateria().getLista().get(i).getHoraInicial() - 7,
						md.getMateria().getLista().get(i).getDia(),
						md.getMateria().getLista().get(i).getNombreMateria()+" "+md.getMateria().getLista().get(i).getGrupo());
				vp.getView().ponerEnHorario(md.getMateria().getLista().get(i).getHoraFinal() - 8,
						md.getMateria().getLista().get(i).getDia(),
						md.getMateria().getLista().get(i).getNombreMateria()+" "+md.getMateria().getLista().get(i).getGrupo());

				}
			}
			vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
			vp.getMsj().mostrarExito("Mostrado");
		}

		if (comando.equals("mostrar")) {
			for (int i = 0; i < md.getMateria().getLista().size(); i++) {
				System.out.println(md.getMateria().getLista().get(i).toString());
			}
			Set<String> materiasUnicas = md.getMateria().obtenerMateriasSinRepetir();
			System.out.println("Materias sin repetir: " + materiasUnicas);

			for (String materia : materiasUnicas) {
				List<Integer> opcionesParaMateria = md.getMateria().obtenerOpcionesPorNombre(materia);
				System.out.println("Opciones para la materia " + materia + ": " + opcionesParaMateria);
			}

			String materia = vp.getMsj().tomarString("Que materia quiere mostrar");
			int opcion = vp.getMsj().tomarInt("Que Opcion es");

			for (int i = 0; i < md.getMateria().getLista().size(); i++) {

				if (md.getMateria().getLista().get(i).getNombreMateria().equals(materia)
						&& md.getMateria().getLista().get(i).getOpcion() == opcion) {
					vp.getView().ponerEnHorario(md.getMateria().getLista().get(i).getHoraInicial() - 7,
							md.getMateria().getLista().get(i).getDia(),
							md.getMateria().getLista().get(i).getNombreMateria());
					vp.getView().ponerEnHorario(md.getMateria().getLista().get(i).getHoraFinal() - 7,
							md.getMateria().getLista().get(i).getDia(),
							md.getMateria().getLista().get(i).getNombreMateria());

				}

			}

			vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
			vp.getMsj().mostrarExito("Mostrado");

		}

		if (comando.equals("AgregarMas")) {
			String nombre = vp.getMsj().tomarString("Nombre Asignatura");
			int cuantasVeces = vp.getMsj().tomarInt("Cuantas veces a la semana se ve la materia");
			int cuantosProfesores = vp.getMsj().tomarInt("Cuantos profesores dan esa materia/Opciones de inscribir");
			for (int i = 0; i < cuantosProfesores; i++) {
				String grupo = vp.getMsj().tomarString("Numero Grupo");

				for (int j = 0; j < cuantasVeces; j++) {
					int hinicial = vp.getMsj().tomarInt("Hora Inicial en 24 Horas") - 7;
					int hfinal = vp.getMsj().tomarInt("Hora Final 24 Horas") - 8;
					int diaSemana = vp.getMsj().tomarInt("Dia que ves la asignatura ejemplo 2) martes .. ");
					md.getMateria().agregar(nombre, grupo, md.getMateria().mayorOpcion(nombre), hinicial + 7,
							hfinal + 7, diaSemana);

				}
			}

		}

		if (comando.equals("Agregar")) {
			try {
				String nombre = vp.getMsj().tomarString("Nombre Asignatura");
				int hinicial = vp.getMsj().tomarInt("Hora Inicial en 24 Horas") - 7;
				int hfinal = vp.getMsj().tomarInt("Hora Final 24 Horas") - 8;
				if ((hfinal == hinicial || hfinal < hinicial) && Math.abs(hfinal - hinicial) != 1) {
					vp.getMsj().mostrarAdvertencia("Error al digitar Horas de la materia");
				} else {

					int diaSemana = vp.getMsj().tomarInt("Dia que ves la asignatura ejemplo 2) martes .. ");
					if (diaSemana >= 1 && 7 <= diaSemana) {
						vp.getMsj().mostrarAdvertencia("Error al dia de la semana");

					} else {

						String grupo = vp.getMsj().tomarString("Numero grupo");

//						vp.getView().ponerEnHorario(hinicial, diaSemana, nombre);
//						vp.getView().ponerEnHorario(hfinal, diaSemana, nombre);
//
//						vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
						md.getMateria().agregar(nombre, grupo, md.getMateria().mayorOpcion(nombre), hinicial + 7,
								hfinal + 7, diaSemana);
						vp.getMsj().mostrarExito("Agregado");

					}
				}
			} catch (Exception e2) {

				vp.getMsj().mostrarError("Error");
			}
		}

		if (comando.equals("ReiniciarHorario")) {
//			vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
			vp.getView().reiniciar();

		}
		if (comando.equals("Exit")) {
			vp.getMsj().mostrar("Hasta Luego...");
			System.exit(0);
		}

	}

}
