

package crudreto;

import crudreto.Connexion;
import java.util.Scanner;

public class Reto5 {
    public static void main(String[] args) {
        Connexion conect = new Connexion("ecodosruedas_ltda","root","123456");
        
        conect.ConnectionMyDB();
        
        
        conect.UPDATE("UPDATE bicicleta set Año='2017' where id ='1'");
        conect.UPDATE("UPDATE cliente SET celular= '3115678432' WHERE id ='5'");;
        conect.DELETE("DELETE FROM intencion_de_Compra where id= '16' and fabricante = 'Trek'");
        
    int opc;
    do {
        Scanner scn = new Scanner(System.in);
            
            System.out.println("*.-MENU CRUD");
            System.out.println("1.-Consulta 1");
            System.out.println("2.-Consulta 2");
            System.out.println("3.-Consulta 3");
            System.out.println("4.-Consulta 4");
            System.out.println("5.-Consulta 5");
            System.out.println("6.-Consulta 6");
            System.out.println("7.-SALIR ");
            System.out.println("INGRESE OPCION");
            opc = scn.nextInt();

            
            switch(opc){
                case 1:
                    System.out.println("\nConsulta 1:\n");
                    conect.READ("Select Nombre from fabricante order by Nombre asc;");
                    break;
                    
                case 2: 
                    System.out.println("\nConsulta 2:\n");
                    conect.READ1("Select  Nombre ,Precio_Unitario,Año FROM bicicleta inner join fabricante  on bicicleta.id = fabricante.id \n" +
                    "where Año >= '2019' order by Nombre asc  ;");
                    break;
                    
                case 3:
                    System.out.println("\nConsulta 3:\n");
                    conect.READ2("Select  Nombre  from fabricante left join motocicletaelectrica on fabricante.id = motocicletaelectrica.id_fabrica where id_proveedor=' 101' ;");
                    break;
                   
                case 4:
                    System.out.println("\nConsulta 4:\n");
                    conect.READ3("Select fabricante from  intencion_de_compra where Nombre ='lucky' order by fabricante asc ");
                    break;
                    
                case 5:
                    System.out.println("\nConsulta 5:\n");
                    conect.READ4("select alias ,nombre_c ,apellido \n" +
                     "from cliente left join intencion_de_Compra \n" +
                     "on cliente.id=intencion_de_Compra.id_cliente\n" +
                     "where intencion_de_compra.fabricante = 'Yeti' ; ");
                    break;
                    
                case 6:
                    System.out.println("\nConsulta 6:\n");
                     conect.READ5("Select COUNT(id_fabrica) as fabricadas FROM bicicleta WHERE Año >= 2019 ");
                     break;
                    
                case 7:
                    System.exit(0);
                   
            }
            
    }while (opc <=7);

    }    
 
}
