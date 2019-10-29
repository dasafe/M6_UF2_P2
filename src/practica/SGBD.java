package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SGBD {

	static Scanner reader = new Scanner(System.in);

	static int cod = 2000;

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

		System.out.println("- Datos Nuevo Socio -");
		System.out.println("------------------------");
		cod += 100;
		System.out.println("Nombre:");
		String nombre = reader.nextLine();
		System.out.println("Apellidos:");
		String apellidos = reader.nextLine();
		System.out.println("Edad:");
		int edad = reader.nextInt();
		System.out.println("Pais:");
		String pais = reader.nextLine();
		System.out.println("Provincia:");
		String provincia = reader.nextLine();
		System.out.println("Poblacion:");
		String poblacion = reader.nextLine();
		System.out.println("Codigo Postal:");
		String cp = reader.nextLine();
		System.out.println("Direccion:");
		String direccion = reader.nextLine();
		System.out.println("Telefono:");
		String telefono = reader.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("yyy-MM-dd");
		String fechaAlta = formato.format(Calendar.getInstance().getTime());
		int cuota = 50;

		st.executeUpdate(
				"INSERT INTO socio (cod_soc, nombre, apellidos, edad, pais, provincia, poblacion, cp, direccion, telefono, fechaalta, cuota) VALUES ("
						+ cod + ",'" + nombre + "','" + apellidos + "'," + edad + ",'" + pais + "','" + provincia
						+ "','" + poblacion + "','" + cp + "','" + direccion + "','" + telefono + "','" + fechaAlta
						+ "'," + cuota + ");");
	}

	private static void cuotaSocio(Statement st) throws SQLException {
		// TODO Auto-generated method stub

		ResultSet rs = st.executeQuery("SELECT * FROM socio");
		while (rs.next()) {
			System.out.println("nombre=" + rs.getObject("nombre") + ", apellidos=" + rs.getObject("apellidos")
					+ ", edad=" + rs.getObject("edad"));
		}

	}

	private static void eliminarSocio(Statement st) {
		// TODO Auto-generated method stub

	}

}
