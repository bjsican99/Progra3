package laboratorio3;
import java.util.*;
import java.text.*;
/**
 *Software tipo planilla, para calculo de sueldo liquido, con uso de vectores y matrices.
 * @author BillyS
 * 0901-17-16250
 */
public class Laboratorio3 {  
    public static void main(String[] args) {        
        //Vectores y Matrices
        double [][] dblPlanilla = new double[10][7];
        int [] intDepartamento = new int[5];
        String [] snombres = new String[10];
        int [] [] intISR = new int[3][3];
        System.out.println("Bienvenido");
        LlenadoDePlanilla(dblPlanilla, snombres);
        SumaSueldo(dblPlanilla, intDepartamento);
        MostrarPlanillaYVector(dblPlanilla, intDepartamento, snombres);
    }
    
    public static void LlenadoDePlanilla(double[][] dblPlani, String[] sNombresVec){
        Scanner scngua = new Scanner(System.in);
        int iConteo=1;
        String sNombre;
        Random rSueldoBase = new Random();
        Random rDeducciones = new Random();
        Random rPersepciones = new Random();
        Random rDepartamento = new Random();
        for(int ifila = 0; ifila <10; ifila++){
            System.out.println("Ingrese el Nombre del Empleado #"+iConteo);
            sNombre = scngua.next();//Guardar el nombre en una variable            
            sNombresVec[ifila] = sNombre;//nombre
            dblPlani[ifila][0] = ifila;
            dblPlani[ifila][1] = rSueldoBase.nextInt(2000)+1500;
            dblPlani[ifila][2] = rDeducciones.nextInt(500)+100;
            dblPlani[ifila][3] = rPersepciones.nextInt(500)+250;
            dblPlani[ifila][4] = dblPlani[ifila][1] * 0.1067;//IGSS
            dblPlani[ifila][5] = dblPlani[ifila][1]-dblPlani[ifila][2]+dblPlani[ifila][3]-dblPlani[ifila][4];//Sueldo Liquido
            dblPlani[ifila][6] = rDepartamento.nextInt(5)+1;            
            iConteo++;
        }   
    }
    
    public static void SumaSueldo(double[][] dblPlani, int[] intDepar){
        int iAuxConteo=1;
        for(int iPosicion = 0; iPosicion < 5; iPosicion++){
            for(int iFila=0; iFila < 10; iFila++){
                if(iAuxConteo == dblPlani[iFila][5]){
                    intDepar[iPosicion] += dblPlani[iFila][4];                   
                }
            }
            iAuxConteo++;
        }
    }
    
    public static void MostrarPlanillaYVector(double[][] dblPlani, int[] intDepar, String[] sNombresVec){
        int iconteoaux=1;
        DecimalFormat dfDosDeci = new DecimalFormat("#.00");
        DecimalFormat dfUnDeci = new DecimalFormat("#");
        System.out.println("-------------------------------------------------");
        
        for(int iFila=0; iFila <10; iFila++){                
                System.out.println("Nombre: "+sNombresVec[iFila]+"--Sueldo Base: "+dblPlani[iFila][1]+"--Deducciones: "+dblPlani[iFila][2]+
                        "--Prestaciones: "+dblPlani[iFila][3]+"--IGSS: "+dfDosDeci.format(dblPlani[iFila][4])+
                        "--Sueldo Liquido: "+dfDosDeci.format(dblPlani[iFila][5])+"--Departamento: "+dfUnDeci.format(dblPlani[iFila][6]));            
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Total Por Departamento");
        for(int iPosicion = 0; iPosicion <5;iPosicion++){
            System.out.println("Numero De Departamento "+iconteoaux+": "+intDepar[iPosicion]);
            iconteoaux++;
        }
        
    }
}