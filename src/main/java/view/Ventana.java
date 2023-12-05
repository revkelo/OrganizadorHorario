package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {
	public Ventana() {
		setTitle("Horario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setLayout(null);

		createMenuBar();

		JPanel horario = new JPanel();
		horario.setLayout(new BorderLayout());
		horario.setBounds(420, 50, 800, 535);

		// Initialize schedule data
		String[] diasSemana = { "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
		String[][] datos = new String[16][8];
		datos[0][0] = "7 am";
		datos[0][1] = "Complejidad Algoritmica";
		datos[1][1] = "Complejidad Algoritmica";
		datos[15][0] = "10 pm";

		DefaultTableModel modeloTabla = new DefaultTableModel(datos, diasSemana);
		JTable tabla = new JTable(modeloTabla);
		tabla.setRowHeight(32);

		JScrollPane scrollPane = new JScrollPane(tabla);

		horario.add(scrollPane, BorderLayout.CENTER);

		add(horario);
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("Menu");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

}
