package view;

import javax.swing.JOptionPane;

public class Mensaje {
	public void mostrar(String msj) {
		JOptionPane.showMessageDialog(null, msj);

	}

	public String tomarString(String msj) {
		String aux = JOptionPane.showInputDialog(msj);
		return aux;

	}

	public int tomarInt(String msj) {
		String aux = JOptionPane.showInputDialog(msj);
		return Integer.parseInt(aux);

	}

	public double tomarDouble(String msj) {
		String aux = JOptionPane.showInputDialog(msj);
		return Double.parseDouble(aux);

	}

	public long tomarLong(String msj) {
		String aux = JOptionPane.showInputDialog(msj);
		return Long.parseLong(aux);

	}
}
