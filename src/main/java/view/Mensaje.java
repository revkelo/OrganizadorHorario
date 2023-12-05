package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mensaje {

	public void mostrarError(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarAdvertencia(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	public void mostrarExito(String msj) {
		ImageIcon iconoExito = new ImageIcon("./img/exito.png");
		Image imagenExito = iconoExito.getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenExito);
		JOptionPane.showMessageDialog(null, msj, "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
	}

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
