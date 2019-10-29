package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class SGBD {

	static Scanner reader = new Scanner(System.in);

	static int cod;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion;
		int opcion = 0;

		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/videoclub?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			Statement st = conexion.createStatement();

			//Obtener max cod_soc
			ResultSet rs = st.executeQuery("SELECT max(cod_soc) FROM socio");
			if (rs.next()) {
				cod = rs.getInt("max(cod_soc)");
			}

			while (opcion != 5) {

				System.out.println("1. Alta socio\n2. Cuota socio\n3. Eliminar socio\n4. Salir\nOpcion:");
				opcion = reader.nextInt();
				reader.nextLine();
				switch (opcion) {
				case 1:
					altaSocio(st);
					break;
				case 2:
					cuotaSocio(st);
					break;
				case 3:
					eliminarSocio(st);
					break;
				case 4:
					System.out.println("\nBye!");
					break;
				default:
					System.out.println("Opcion invalida");
					break;
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void altaSocio(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("\n- Datos Nuevo Socio -");
		System.out.println("------------------------");
		cod++;
		System.out.println("Nombre:");
		String nombre = reader.nextLine();
		System.out.println("Apellidos:");
		String apellidos = reader.nextLine();
		System.out.println("Edad:");
		int edad = reader.nextInt();
		reader.nextLine();
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
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechaAlta = formato.format(Calendar.getInstance().getTime());
		int cuota = 5000;
		System.out.println();

		st.executeUpdate(
				"INSERT INTO socio (cod_soc, nombre, apellidos, edad, pais, provincia, poblacion, cp, direccion, telefono, fechaalta, cuota) VALUES ("
						+ cod + ",'" + nombre + "','" + apellidos + "'," + edad + ",'" + pais + "','" + provincia
						+ "','" + poblacion + "','" + cp + "','" + direccion + "','" + telefono + "','" + fechaAlta
						+ "'," + cuota + ");");

		System.out.println("Socio " + cod + " dado de alta");
	}

	private static void cuotaSocio(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println();
		ResultSet rs = st.executeQuery("SELECT * FROM socio");
		while (rs.next()) {
			System.out.println(rs.getObject("cod_soc") + ", " + rs.getObject("nombre") + ", "
					+ rs.getObject("apellidos") + ", " + rs.getObject("cuota"));
		}
	}

	private static void eliminarSocio(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Codigo del socio a eliminar:");
		int codDel = reader.nextInt();
		reader.nextLine();
		ResultSet rs = st.executeQuery("SELECT * FROM socio where cod_soc =" + codDel);
		System.out.println();
		while (rs.next()) {
			System.out.println(rs.getObject("cod_soc") + ", " + rs.getObject("nombre") + ", "
					+ rs.getObject("apellidos") + ", " + rs.getObject("cuota"));
		}
		System.out.println("\nEstá seguro de que quiere eliminar a este socio? S/N");
		String sn = "";
		do {
			sn = reader.nextLine();
			if (sn.equalsIgnoreCase("S")) {
				st.executeUpdate("DELETE FROM socio where cod_soc =" + codDel);
				System.out.println("\nSocio " + codDel + " eliminado");
			} else if (sn.equalsIgnoreCase("N")) {
				System.out.println("\nEliminacion cancelada");
			} else {
				System.out.println("Opcion invalida");
			}
		} while (!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N"));
	}

}
