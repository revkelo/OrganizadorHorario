package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FachadaView;
import view.Ventana;

public class Controller implements ActionListener {

	private FachadaView vp;

	public Controller() {
		vp = new FachadaView();

		vp.getView().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
