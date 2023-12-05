package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
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

	private JMenuItem exitMenuItem, reiniciar, mostrar;
	private JPanel horario;
	private JButton btnAgregar, btnprueba;
	private String[][] datos;
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private String[] diasSemana = { "Hora", "1) Lunes", "2) Martes", "3) Miércoles", "4) Jueves", "5) Viernes",
			"6) Sábado", "7) Domingo" };

	public Ventana() {
		setTitle("Horario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/logo.png"));
		setLayout(null);
		setResizable(false);

		ImageIcon icono = new ImageIcon("./img/logo2.png");
		setIconImage(icono.getImage());

		crearMenuBar();

		btnAgregar = new JButton("Agregar Materia");
		btnAgregar.setBounds(100, 90, 150, 40);
		btnAgregar.setFocusable(false);
		btnAgregar.setActionCommand("Agregar");
		add(btnAgregar);

		btnprueba = new JButton("Agregar mas de una");
		btnprueba.setBounds(100, 190, 150, 40);
		btnprueba.setFocusable(false);
		btnprueba.setActionCommand("AgregarMas");
		add(btnprueba);

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
		exitMenuItem = new JMenuItem("Salir");
		exitMenuItem.setActionCommand("Exit");

		reiniciar = new JMenuItem("Reiniciar Horario");
		reiniciar.setActionCommand("ReiniciarHorario");

		mostrar = new JMenuItem("Mostrar");
		mostrar.setActionCommand("mostrar");
		fileMenu.add(mostrar);
		fileMenu.add(reiniciar);
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

	public void reiniciar() {

		for (int i = 0; i < datos.length; i++) {
			for (int j = 1; j < datos[0].length; j++) {
				datos[i][j] = "";
			}
		}
		modeloTabla = new DefaultTableModel(datos, diasSemana);

	}

	public JButton getBtnprueba() {
		return btnprueba;
	}

	public void setBtnprueba(JButton btnprueba) {
		this.btnprueba = btnprueba;
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

	public JMenuItem getReiniciar() {
		return reiniciar;
	}

	public void setReiniciar(JMenuItem reiniciar) {
		this.reiniciar = reiniciar;
	}

	public JMenuItem getMostrar() {
		return mostrar;
	}

	public void setMostrar(JMenuItem mostrar) {
		this.mostrar = mostrar;
	}

}
