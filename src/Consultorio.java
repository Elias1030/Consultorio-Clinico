//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Consultorio {
    /*primero se busca la autenticacion del usuario que desee ingresar
    al sistema por medio un usuario una contraseñas las cuales se van a cargar de una
    archivo de texto.
     */
public static Map<String, String> cargarUsuarios(String archivo) throws IOException {
    Map<String, String> usuarios = new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(", ");
            usuarios.put(partes[0], partes[1]);
        }
    }
    return usuarios;
}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String archivoUsuarios = "C:\\Users\\La mas linda\\Documents\\proyectos intellij\\Consultorio\\Consultorio\\Usuarios.txt";
    Map<String, String> usuarios;
    try {
        usuarios = cargarUsuarios(archivoUsuarios);
    }catch (IOException e) {
        System.err.println("Error al cargar el archivo" + e.getMessage());
        return;
    }
    int choice;
    //aqui se solicita la entrada de los datps de usuario y contraseñ
    System.out.println("Escribe tu usuario: ");
    String username = scanner.nextLine();
    System.out.println("Escribe tu contraseña: ");
    String password = scanner.nextLine();
    //verificacion del usuario y contraseña correctos
    if (usuarios.containsKey(username) && usuarios.get(username).equals(password)) {
      String nombre = username.substring(0,1).toUpperCase() + username.substring(1);
      System.out.println("Hola, " + nombre);
        System.out.println("\nMenú:");
        System.out.println("1. Registrar un DOCTOR");
        System.out.println("2. Registrar un PACIENTE");
        System.out.println("3. Crear una CITA");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        choice = scanner.nextInt();
        scanner.nextLine();

    } else {
        System.out.println("Usuario incorrecto");
    }
}
}