package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SGBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		Connection conexion;
		int opcion = 0;

		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/videoclub?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			Statement st = conexion.createStatement();

			while (opcion != 5) {

				System.out.println("1. Alta socio\n2. Cuota socio\n3. Eliminar socio\n4. Salir\nOpcion:");
				opcion = reader.nextInt();
				switch (opcion) {
				case 1:

					break;
				case 2:
					altaSocio(st);
					break;
				case 3:
					cuotaSocio(st);
					break;
				case 4:
					eliminarSocio(st);
					break;
				case 5:
					System.out.println("Bye!");
					break;

				default:
					System.out.println("Opcion invalida");
					break;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void altaSocio(Statement st) {
		// TODO Auto-generated method stub

	}

	private static void cuotaSocio(Statement st) {
		// TODO Auto-generated method stub

	}

	private static void eliminarSocio(Statement st) {
		// TODO Auto-generated method stub

	}
}
