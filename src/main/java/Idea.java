import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Idea {
	static ArrayList<Materia> list = new ArrayList<Materia>();

	static Scanner lec = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Quemar 1) si  2) no");
		int aux = lec.nextInt();
		lec.nextLine();
		String[][] datos = new String[16][8];

		switch (aux) {
		case 2:
			System.out.println("Materia a registrar");
			lec.nextLine(); // Consumir la nueva línea pendiente
			String materia = lec.nextLine();
			System.out.println("Cuantas veces a la semana se ve");
			int cantidad = lec.nextInt();
			System.out.println("Cuantos profesores están para matricular la materia");
			int profesores = lec.nextInt();

			for (int i = 0; i < profesores; i++) {
				lec.nextLine(); // Consumir la nueva línea pendiente
				System.out.println("Nombre profesor");
				String profesor = lec.nextLine();
				for (int j = 0; j < cantidad; j++) {
					// ... rest of your input code
				}
				System.out.println("Siguiente\n\n");
			}
			break;
		case 1:
		
			break;
		default:
			break;
		}
		while (true) {
			quemar();
		agregar(datos);
		mostrar(datos);
	

			// Pedir al usuario que ingrese materia y profesor para filtrar la matriz
			System.out.println("\nIngrese materia y profesor para filtrar la matriz (separados por espacio):");
	
			String filtro = lec.nextLine();
			String[] criterios = filtro.split(" ");
			String materiaFiltrar = criterios[0];
			String profesorFiltrar = criterios[1];

			// Mostrar la matriz filtrada
			mostrarMatrizFiltrada(datos, materiaFiltrar, profesorFiltrar);
		}
	}

	public static void mostrarMatrizFiltrada(String[][] datos, String materia, String profesor) {
		System.out.println("\nMatriz filtrada para " + materia + " - " + profesor);
		for (int i = 0; i < datos.length; i++) {
			for (int j = 1; j < datos[0].length; j++) {
				if (datos[i][j] != null && datos[i][j].contains(materia) && datos[i][j].contains(profesor)) {
					System.out.println(datos[i][j]);
				} else {

					datos[i][j] = null;
				}
			}
		}

		JFrame ventaFrame = new JFrame();
		ventaFrame.setTitle("Horario Personalizado");
		ventaFrame.setSize(800, 400);
		ventaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventaFrame.setLocationRelativeTo(null);

		String[] diasSemana = { "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, diasSemana);
		JTable tabla = new JTable(modeloTabla);
		tabla.setRowHeight(30);

		JScrollPane scrollPane = new JScrollPane(tabla);

		ventaFrame.add(scrollPane);
		ventaFrame.setVisible(true);
	}

	public static void mostrar(String[][] datos) {

		for (int i = 0; i < datos.length; i++) {
			for (int j = 1; j < datos[0].length; j++) {
				if (datos[i][j] != null) {

					System.out.println(datos[i][j]);
				}
			}

		}
	}

	public String[] profesores(String[][] datos) {

		for (int i = 0; i < datos.length; i++) {
			for (int j = 1; j < datos[0].length; j++) {
				if (datos[i][j] != null) {

					System.out.println(datos[i][j]);
				}
			}

		}
		return null;
	}

	public static void agregar(String[][] datos) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, list.get(i).getHoraInicial());
			calendar.set(Calendar.MINUTE, 0);

			for (int j1 = 0; j1 < 16; j1++) {
				datos[j1][0] = new SimpleDateFormat("hh:mm a").format(calendar.getTime());
				if (j1 >= list.get(i).getHoraInicial() - 7 && j1 < list.get(i).getHoraFinal() - 7
						&& list.get(i).getDia() >= 1 && list.get(i).getDia() <= 7) {

					if (datos[j1][list.get(i).getDia()] == null) {
						datos[j1][list.get(i).getDia()] = j1 + " " + list.get(i).getDia() + " "
								+ list.get(i).getNombreMateria() + " " + list.get(i).getProfesor();
					} else {
						System.out.println("ya existe algo ahi");
						return;
					}
				}
				calendar.add(Calendar.HOUR_OF_DAY, 1);
			}
		}
	}

	public static void quemar() {
		list.add(new Materia("BD", "Ricardo", 7, 9, 6));
		list.add(new Materia("BD", "Ricardo", 7, 9, 2));
		list.add(new Materia("BD", "Jorge", 7, 9, 4));
		list.add(new Materia("BD", "Jorge", 7, 9, 5));
		list.add(new Materia("Ing Software", "Helio", 7, 9, 1));
		list.add(new Materia("Ing Software", "Helio", 11, 13, 5));

	}
}

class matriz {

	public static void main(String[] args) {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(" 0 ");
			}
			System.out.println();
		}
	}
}
