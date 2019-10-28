package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SGBD {

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	private static void altaSocio(Statement st) throws SQLException {
		// TODO Auto-generated method stub

		int cod;
		String nombre = reader.nextLine();
		String apellidos = reader.nextLine();
		int edad = reader.nextInt();
		String pais = reader.nextLine();
		String provincia = reader.nextLine();
		String poblacion = reader.nextLine();
		String cp = reader.nextLine();
		String direccion = reader.nextLine();
		String telefono = reader.nextLine();
		String fechaAlta = reader.nextLine();
		int cuota;

		st.executeUpdate(
				"INSERT INTO socio (cod_soc, nombre, apellidos, edad, pais, provincia, poblacion, cp, direccion, telefono, fechaalta, cuota) VALUES ("
						+ cod + ",'" + nombre + "','" + apellidos + "'," + edad + ",'" + pais + "','" + provincia
						+ "','" + poblacion + "','" + cp + "','" + direccion + "','" + telefono + "','" + fechaAlta
						+ "'," + cuota + ");");
	}

	private static void cuotaSocio(Statement st) {
		// TODO Auto-generated method stub

	}

	private static void eliminarSocio(Statement st) {
		// TODO Auto-generated method stub

	}
}
