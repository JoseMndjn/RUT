import java.util.Scanner;
class RUT
{
    
    public static void main(String[] args) 
    {
        /* RUT independiente a todo, tiene cantidad de digitos, se verifica el modulo 11 */
        String RUT = "";
        String DV = "";
        int acum = 0;
        int cont = 2;
        int modl = 0;
        Scanner in = new Scanner(System.in);

        //Evitar vacios y caracteres distintos a numeros

        do {
            System.out.println("INGRESE RUT:");
            RUT = Integer.toString(in.nextInt());
        } while (RUT.isBlank() || RUT.isEmpty());

        //Calculo operacional en base a modulo 11
        for(int i = RUT.length()-1; i>=0; i--)
        {
            /* Acumulador permite almacernar mientras en una secuencia
            multiplique los numeros del rut asignados hasta completar
            el rut en general, la secuencia es de 2 a 7 siendo 7 el 
            ultimo numero a usar, luego se resetea la sucesion
            ej: rut: 12345678 sera multiplicado de derecha a izquierda
            [1*3 = 3][2*2 = 4][3*7 = 21][4*6 = 24][5*5 = 25][6*4 =24][7*3 = 21][8*2 = 16]
                                ^ al llegar a 7 se resetea la sucesion
            luego se suman las multiplicaciones y se almacenan
            3+4+21+24+25+24+21+16 = 138 */

            int j =  Character.getNumericValue(RUT.charAt(i));
            acum = acum + (j * cont);

            cont = (cont == 7)? 2 : cont+1 ;
        }

        /*luego el modulo tomara en consideracion el resto de la division y por ende sera restado por 11 */
        modl = 11 - (acum % 11);
        DV = (modl == 10)? "K" : (modl == 11)? "0" : Integer.toString(modl);

        //en la situacion se verifica que si el modulo es 10 equivalente a K mientras si es 11 es 0
        //en caso fortuito, la resta total se considera el digito verificador
        
        System.out.println(RUT +"-"+ DV);
    }
}
