package model;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class HorarioColegio extends JFrame {

	private ArrayList<Materia> listaMaterias = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public String[][] materia() {
		// Solicitar el número de materias

		System.out.print("Ingrese el nombre de la materia: ");
		String nombreMateria = scanner.nextLine();

		System.out.print("Cuantas veces se ven a la semana la materia: ");
		int vecesSemana = scanner.nextInt();
		System.out.println(vecesSemana);
		System.out.print("Cuantos profesores dan la materia ");
		int profesores = scanner.nextInt();

		String[][] datos = new String[16][8];
		scanner.nextLine();
		for (int i = 0; i < profesores; i++) {

			System.out.print("Ingrese el nombre del profesor: ");
			String profesor = scanner.nextLine();

			for (int j = 0; j < vecesSemana; j++) {
				System.out.print("Ingrese la hora de inicio (formato 24 horas, por ejemplo, 14 para las 2 PM): ");
				int horaInicio = scanner.nextInt();

				System.out.print("Ingrese la hora final (formato 24 horas): ");
				int horaFin = scanner.nextInt();

				System.out.print("Ingrese el día de la semana (1 para Lunes, 2 para Martes, ..., 7 para Domingo): ");
				int diaSemana = scanner.nextInt();

				// Crear objeto Materia y agregarlo a la lista
				Materia materia = new Materia(nombreMateria, profesor, horaInicio, horaFin, diaSemana);

				// Actualizar la tabla directamente sin usar la ArrayList
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.HOUR_OF_DAY, horaInicio);
				calendar.set(Calendar.MINUTE, 0);

				for (int j1 = 0; j1 < 16; j1++) {
					datos[j1][0] = new SimpleDateFormat("hh:mm a").format(calendar.getTime());
					if (j1 >= horaInicio - 7 && j1 < horaFin - 7 && diaSemana >= 1 && diaSemana <= 7) {
						datos[j1][diaSemana] = nombreMateria + "\n" + profesor;
					}
					calendar.add(Calendar.HOUR_OF_DAY, 1);
				}

			}
		}
		return datos;

	};

	public HorarioColegio() {
		setTitle("Horario Personalizado");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		String[] diasSemana = { "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
		String[][] datos = materia();
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, diasSemana);
		JTable tabla = new JTable(modeloTabla);
		tabla.setRowHeight(30);

		// Agregar la tabla a un JScrollPane
		JScrollPane scrollPane = new JScrollPane(tabla);

		// Añadir el JScrollPane al JFrame
		add(scrollPane);

		// Cerrar el scanner
		scanner.close();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			HorarioColegio horarioTabla = new HorarioColegio();
			horarioTabla.setVisible(true);
		});
	}
}
