package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FachadaView;

public class Controller implements ActionListener {

	private FachadaView vp;

	public Controller() {
		vp = new FachadaView();
		actionsListeners();
		vp.getView().setVisible(true);
	}

	public void actionsListeners() {
		vp.getView().getBtnAgregar().addActionListener(this);
		vp.getView().getExitMenuItem().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Agregar")) {
			try {

				int hinicial = vp.getMsj().tomarInt("Hora Inicial") - 7;
				int hfinal = vp.getMsj().tomarInt("Hora Final") -8;
				int diaSemana = vp.getMsj().tomarInt("Dia que ves la asignatura ejemplo 2) martes .. ");
				String nombre = vp.getMsj().tomarString("Nombre Asignatura");

				vp.getView().ponerEnHorario(hinicial, diaSemana, nombre);
				vp.getView().ponerEnHorario(hfinal, diaSemana, nombre);

				vp.getView().getTabla().setModel(vp.getView().getModeloTabla());
				vp.getMsj().mostrar("Agregar");
			} catch (Exception e2) {
				vp.getMsj().mostrar("Error");
			}
		}
		if (comando.equals("Exit")) {
			vp.getMsj().mostrar("Hasta Luego...");
			System.exit(0);
		}

	}

}
