package view;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {

	private JMenuItem exitMenuItem;
	private JPanel horario;
	private JButton btnAgregar;
	private String[][] datos;
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private String[] diasSemana = { "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

	public Ventana() {
		setTitle("Horario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);

		crearMenuBar();

		btnAgregar = new JButton("Agregar Materia");
		btnAgregar.setBounds(0, 0, 150, 40);
		btnAgregar.setFocusable(false);
		btnAgregar.setActionCommand("Agregar");
		add(btnAgregar);

		horario = new JPanel();
		horario.setLayout(new BorderLayout());
		horario.setBounds(420, 50, 800, 535);

		datos = new String[16][8];

		for (int i = 0; i < datos.length; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 7 + i);
			calendar.set(Calendar.MINUTE, 0);

			datos[i][0] = new SimpleDateFormat("hh:mm a").format(calendar.getTime());
		}

		datos[0][1] = "Complejidad Algoritmica";
		datos[1][1] = "Complejidad Algoritmica";

		modeloTabla = new DefaultTableModel(datos, diasSemana);
		tabla = new JTable(modeloTabla);
		tabla.setRowHeight(32);

		JScrollPane scrollPane = new JScrollPane(tabla);

		horario.add(scrollPane, BorderLayout.CENTER);

		add(horario);
	}

	public void ponerEnHorario(int x, int y, String materia) {
		datos[x][y] = materia;
		modeloTabla = new DefaultTableModel(datos, diasSemana);

	}

	private void crearMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("Menu");
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(JMenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}

	public JPanel getHorario() {
		return horario;
	}

	public void setHorario(JPanel horario) {
		this.horario = horario;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public String[][] getDatos() {
		return datos;
	}

	public void setDatos(String[][] datos) {
		this.datos = datos;
	}

	public String[] getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String[] diasSemana) {
		this.diasSemana = diasSemana;
	}

}
