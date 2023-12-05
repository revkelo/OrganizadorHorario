package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("mostrar")) {
			for (int i = 0; i < md.getMateria().getLista().size(); i++) {
				System.out.println(md.getMateria().getLista().get(i).toString());
			}
		}

		if (comando.equals("AgregarMas")) {
			String nombre = vp.getMsj().tomarString("Nombre Asignatura");
			int cuantasVeces = vp.getMsj().tomarInt("Cuantas veces a la semana se ve la materia");
			int cuantosProfesores = vp.getMsj().tomarInt("Cuantos profesores dan esa materia/Opciones de inscribir");
			for (int i = 0; i < cuantosProfesores; i++) {
				String profesor = vp.getMsj().tomarString("Nombre Profesor");

				for (int j = 0; j < cuantasVeces; j++) {
					int hinicial = vp.getMsj().tomarInt("Hora Inicial en 24 Horas") - 7;
					int hfinal = vp.getMsj().tomarInt("Hora Final 24 Horas") - 8;
					int diaSemana = vp.getMsj().tomarInt("Dia que ves la asignatura ejemplo 2) martes .. ");
					md.getMateria().agregar(nombre, profesor, hinicial + 7, hfinal + 7, diaSemana);

				}
			}

		}

		if (comando.equals("Agregar")) {
			try {

				int hinicial = vp.getMsj().tomarInt("Hora Inicial en 24 Horas") - 7;
				int hfinal = vp.getMsj().tomarInt("Hora Final 24 Horas") - 8;
				if ((hfinal == hinicial || hfinal < hinicial) && Math.abs(hfinal - hinicial) != 1) {
					vp.getMsj().mostrarAdvertencia("Error al digitar Horas de la materia");
				} else {

					int diaSemana = vp.getMsj().tomarInt("Dia que ves la asignatura ejemplo 2) martes .. ");
					if (diaSemana >= 1 && 7 <= diaSemana) {
						vp.getMsj().mostrarAdvertencia("Error al dia de la semana");

					} else {
						String nombre = vp.getMsj().tomarString("Nombre Asignatura");
						String profesor = vp.getMsj().tomarString("Nombre Profesor");

						vp.getView().ponerEnHorario(hinicial, diaSemana, nombre);
						vp.getView().ponerEnHorario(hfinal, diaSemana, nombre);

						vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
						md.getMateria().agregar(nombre, profesor, hinicial + 7, hfinal + 7, diaSemana);
						vp.getMsj().mostrarExito("Agregado");

					}
				}
			} catch (Exception e2) {

				vp.getMsj().mostrarError("Error");
			}
		}

		if (comando.equals("ReiniciarHorario")) {
			vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
			vp.getView().reiniciar();

		}
		if (comando.equals("Exit")) {
			vp.getMsj().mostrar("Hasta Luego...");
			System.exit(0);
		}

	}

}
