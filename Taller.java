package taller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

/**
 * Brayan Pizarro
 * Cecilia Gonzalez
 */
public class Taller {

    /**
     * @param matrizAlien the one where we're going to save the file
     * @param lCant save the amount of Aliens that are in the file
     * @throws IOException 
     */
    public static void leerX(String[][]matrizAlien,int[]lCant)throws IOException{
        File fileAlien =new File("x.txt");
        Scanner arch =new Scanner(fileAlien);
        int cantAlien=0;
        
        while(arch.hasNextLine()){
            String []  partes=arch.nextLine().split(",");
            String especie=partes[0];
            String nombreAlien=partes[1];            
            String idenUniversal=partes[2];
            String planeta=partes[3];
            String edad=partes[4];
            String altura=partes[5];            
            String peso=partes[6];
            String tipoAlien=partes[7];
            
            matrizAlien[cantAlien][0]=especie;
            matrizAlien[cantAlien][1]=nombreAlien;
            matrizAlien[cantAlien][2]=idenUniversal;
            matrizAlien[cantAlien][3]=planeta;          
            matrizAlien[cantAlien][4]=edad;
            matrizAlien[cantAlien][5]=altura;
            matrizAlien[cantAlien][6]=peso;
            matrizAlien[cantAlien][7]=tipoAlien;
                    
            cantAlien++;            
        }
        arch.close();
        lCant[0]=cantAlien;
    }
    /**    
     * @param matrizHumano the array where we're going to save the file
     * @param lCant save the amount of Humans that are in the file
     * @throws IOException 
     */    
    public static void leerH(String [][]matrizHumano,int[]lCant)throws IOException{
        File fileHumano =new File("h.txt");
        Scanner arch1 =new Scanner(fileHumano);
        int cantHumano=0;
        
        while(arch1.hasNextLine()){
            String []  partes=arch1.nextLine().split(",");
            String nacionalidad=partes[0];
            String nombre=partes[1];            
            String ident=partes[2];
            String region=partes[3];
            String ciudad=partes[4];
            String edad=partes[5];  
            String altura=partes[6];
            String peso=partes[7];                       
            
            String planetasTrabajo=partes[8];
            int pos=8;
            String []part=planetasTrabajo.split("");  
            int sep=0;
            for(int i=0;i<planetasTrabajo.length();i++){                                
                if(part[i].equals("/")){
                    sep++;
                }                                                                                                                                                                             
            }    
            String []parte=planetasTrabajo.split("/");
            for(int f=0;f<sep+1;f++){
                String planetas=parte[f];
                matrizHumano[cantHumano][pos]=planetas;
                pos++; 
            }                                           
             
            matrizHumano[cantHumano][0]=nacionalidad;
            matrizHumano[cantHumano][1]=nombre;
            matrizHumano[cantHumano][2]=ident;
            matrizHumano[cantHumano][3]=region;          
            matrizHumano[cantHumano][4]=ciudad;
            matrizHumano[cantHumano][5]=edad;
            matrizHumano[cantHumano][6]=altura;
            matrizHumano[cantHumano][7]=peso;
            
            cantHumano++;
        }
        arch1.close();
        lCant[1]=cantHumano;
    }
    /**     
     * @param matrizAlien from where we're going to search
     * @param lCant to have the amount of aliens
     */
    public static void buscarIdentficacion(String [][]matrizAlien,int []lCant){        
        //opcion 8
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese Identificacion universal: ");        
        String idUniversal=scanner.nextLine();
        for(int i=0; i<lCant[0];i++){           
            if(matrizAlien[i][2].equals(idUniversal)){
                System.out.println("Nombre Extraterrestre: "+matrizAlien[i][1]);        
                System.out.println("Nombre Especie: "+matrizAlien[i][0]);
                System.out.println("Planeta Origen: "+matrizAlien[i][3]);
                System.out.println("Tipo: "+matrizAlien[i][7]); 
            }
        }
    }
    /**     
     * @param matrizAlien from where we're going to search
     * @param lCant to have the amount of aliens
     */
    public static void tablaAlien(String matrizAlien[][],int lCant[]){
        //opcion 11
        int cantInv=0;
        int cantVer=0;
        int cantFlex=0;
        double porcInv;
        double porcVer;
        double porcFlex;
         
        for(int i=0;i<lCant[0];i++){
            switch (matrizAlien[i][7]) {
                case "I":
                    cantInv++;
                    break;
                case "V":
                    cantVer++;
                    break;            
                case "F":
                    cantFlex++;
                    break;
                default:
                    break;
            }
        }
        //*
        porcInv=(cantInv/lCant[0]);
        porcVer=(cantVer/lCant[0]);
        porcFlex=(cantFlex/lCant[0]);
        
        System.out.println("-TABLAS TIPOS EXTRATERRESTRES-");
        System.out.println("[ TIPO , CANTIDAD , PORCENTAJE ]");
        System.out.println("[ Invertebrado, "+cantInv+", "+porcInv*100+"% ]");
        System.out.println("[ Vertebrado  , "+cantVer+", "+porcVer*100+"% ]");
        System.out.println("[ Flexible    , "+cantFlex+", "+porcFlex*100+"% ]");
    }
    /**     
     * @param matrizAlien from where we're going to search
     * @param lCant to have the amount of aliens
     */
    public static void eliminarAlien(String matrizAlien[][],int[]lCant){
        //opcion 6
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese Identificacion universal: ");        
        String idUni=scanner.nextLine();        
        for(int i=0;i<lCant[0];i++){
            if(matrizAlien[i][2].equals(idUni)){
                for(int j=i+1;j<lCant[0];j++,i++){
                    for(int k=0;k<8;k++){
                        matrizAlien[i][k]=matrizAlien[j][k];
                    }                    
                }
                lCant[0]=lCant[0]-1;
                System.out.println("---EXTRATERRESTRE ELIMINADO---");
                break;
            }else{
                System.out.println("-----Identificacion incorrecta-----");
            }
        }
    }
    /**     
     * @param matrizHumano from where we're going to search
     * @param lCant to have the amount of humans
     */   
    public static void eliminarHumano(String matrizHumano[][],int[]lCant){
        //opcion 7        
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese Identificacion: ");        
        String id=scanner.nextLine();        
        for(int i=0;i<lCant[1];i++){
            if(matrizHumano[i][2].equals(id)){
                for(int j=i+1;j<lCant[0];j++,i++){
                    for(int k=0;k<15;k++){
                        matrizHumano[i][k]=matrizHumano[j][k];
                    }                    
                }
                lCant[1]=lCant[1]-1;
                System.out.println("---HUMANO ELIMINADO---");
                break;
            }else{
                System.out.println("-----Identificacion incorrecta-----");
            }
        }
    }
    /**
     * @param matrizHumano from where we're going to search
     * @param lCant to have the amount of humans     
     */
    public static void mostrarNacionalidad(String matrizHumano[][],int[]lCant){
        //opcion 5
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese Nacionalidad: ");        
        String nacionalidad=scanner.nextLine();  
        System.out.println("------------------");
        System.out.println("--Nacionalidad: "+nacionalidad);
        for(int i=0;i<lCant[1];i++){            
            if(matrizHumano[i][0].equals(nacionalidad)){
                System.out.println("--- ");
                System.out.println("- Nombre: "+matrizHumano[i][1]);
                System.out.println("- Identidicacion: "+matrizHumano[i][2]);
                System.out.println("- Region: "+matrizHumano[i][3]);
                System.out.println("- Ciudad: "+matrizHumano[i][4]);
                System.out.println("- Edad: "+matrizHumano[i][5]);
                int altura=Integer.parseInt(matrizHumano[i][6]);
                double estatura=altura/100;
                System.out.println("- Altura: "+estatura);
                int gramos=Integer.parseInt(matrizHumano[i][7]);
                double peso=gramos/1000;
                System.out.println("- Peso: "+peso);
                
                break;
            }else{
                System.out.println("-- Nacionalidad no encontrada --");
            }           
        }                
    }
    /** 
     * @param palabra the word to do the change
     */
    public static void traducir(String palabra){
        //traduccion de archivo
        String[] espacio=palabra.split("");
        OUTER:
        for (int i = 0; i<palabra.length(); i++) {
            switch (espacio[i]) {
                case "a":
                    espacio[i]="e";
                    break OUTER;
                case "o":
                    espacio[i]="i";
                    break OUTER;
                case "e":
                    espacio[i]="a";
                    break OUTER;
                case "i":
                    espacio[i]="o";
                    break OUTER;
                default:
                    break;
            }
        }
    }
    /**    
     * @param matrizAlien from where we're going to search
     * @param lCant to have the amount of aliens
     */
    public static void ingresarAlien(String [][]matrizAlien,int[]lCant){    
        //opcion 1
        Scanner scan=new Scanner(System.in);
        System.out.println("--- ");
        System.out.println("Ingrese especie: ");
        String especie=scan.nextLine();
        System.out.println("Ingrese nombre Extraterrestre: ");
        String nombreAlien=scan.nextLine();
        System.out.println("Ingrese identidad Universal: ");
        String idenUniversal=scan.nextLine();
        System.out.println("Ingrese planeta origen: ");
        String planeta=scan.nextLine();
        System.out.println("Ingrese edad: ");
        String edad=scan.nextLine();
        System.out.println("Ingrese altura(cm): ");
        String altura=scan.nextLine();
        System.out.println("Ingrese peso(gr): ");
        String peso=scan.nextLine();
        System.out.println("Ingrese tipo Alien(I,V,F): ");
        String tipoAlien=scan.nextLine();
        
        matrizAlien[lCant[0]][0]=especie;
        matrizAlien[lCant[0]][1]=nombreAlien;
        matrizAlien[lCant[0]][2]=idenUniversal;
        matrizAlien[lCant[0]][3]=planeta;          
        matrizAlien[lCant[0]][4]=edad;
        matrizAlien[lCant[0]][5]=altura;
        matrizAlien[lCant[0]][6]=peso;
        matrizAlien[lCant[0]][7]=tipoAlien;
        
        lCant[0]=lCant[0]+1;
        System.out.println("--EXTRATERRESTRE INGRESADO--");
    }
    /**     
     * @param matrizHumano from where we're going to search
     * @param lCant to have the amount of humans    
     */
    public static void ingresarHumano(String[][]matrizHumano,int[]lCant){
        //opcion 3
        Scanner scan=new Scanner(System.in);
        System.out.println("--- ");
        System.out.println("Ingrese nacionalidad: ");
        String nacionalidad=scan.nextLine();
        System.out.println("Ingrese nombre: ");
        String nombre=scan.nextLine();
        System.out.println("Ingrese identificacion: ");
        String ident=scan.nextLine();
        System.out.println("Ingrese region: ");
        String region=scan.nextLine();
        System.out.println("Ingrese ciudad: ");
        String ciudad=scan.nextLine();
        System.out.println("Ingrese edad: ");
        String edad=scan.nextLine();
        System.out.println("Ingrese altura(cm): ");
        String altura=scan.nextLine();
        System.out.println("Ingrese peso(gr): ");
        String peso=scan.nextLine();
        
        System.out.println("Ingrese cantidad de trabajos: ");
        int cant=scan.nextInt();
        int planetas=8;
        for(int i=0;i<cant;i++){
            System.out.println("Ingrese planeta de trabajo: ");
            String planeta=scan.nextLine();
            matrizHumano[lCant[1]+1][planetas]=planeta;
            planetas++;
        }
        
        matrizHumano[lCant[1]][0]=nacionalidad;
        matrizHumano[lCant[1]][1]=nombre;
        matrizHumano[lCant[1]][2]=ident;
        matrizHumano[lCant[1]][3]=region;          
        matrizHumano[lCant[1]][4]=ciudad;
        matrizHumano[lCant[1]][5]=edad;
        matrizHumano[lCant[1]][6]=altura;
        matrizHumano[lCant[1]][7]=peso;
        
        lCant[0]=lCant[1]+1;
        System.out.println("--HUMANO INGRESADO--");                
    }
    /**  
     * @param matrizAlien from where we're going to search
     * @param lCant to have the amount of aliens   
     */
    public static void modificarX(String[][]extraterrestres, int cant){
    	Scanner scan=new Scanner(System.in);
    	
    	System.out.println("Ingrese el id del alien que desea modificar");
    	String identificacion=scan.nextLine();
		int index=buscar(extraterrestres,identificacion,2,cant);
		if(index!=-1) {
			System.out.println("Extraterrestre encontrado:");
			for(int i=0;i<8;i++) {
				System.out.println(extraterrestres[index][i]);
			}
			
			System.out.println("ingrese lo que desea cambiar especie(e),nombre(n),identificacion(i),planeta(p),edad(ed),altura(a),peso(pe),tipo(t)");
			String opcion=scan.nextLine();
			while(!opcion.equals("-1")) {
				switch (opcion){
				case "e":{
					System.out.println("ingrese nueva especie: ");
					String especie=scan.nextLine();
					extraterrestres[index][0]=especie;
					opcion="-1";
					break;
				}
				case "n":{
					System.out.println("ingrese nuevo nombre: ");
					String nombre=scan.nextLine();
					extraterrestres[index][1]=nombre;
					opcion="-1";
					break;
				}
				case "i":{
					System.out.println("ingrese nueva identificacion: ");
					String ident=scan.nextLine();
					extraterrestres[index][2]=ident;
					opcion="-1";
					break;
				}
				case "p":{
					System.out.println("ingrese nuevo paneta: ");
					String planeta=scan.nextLine();
					extraterrestres[index][3]=planeta;
					opcion="-1";
					break;
				}
				case "ed":{
					System.out.println("ingrese nueva edad: ");
					String edad=scan.nextLine();
					extraterrestres[index][4]=edad;
					opcion="-1";
					break;
				}
				case "a":{
					System.out.println("ingrese nueva altura: ");
					String altura=scan.nextLine();
					extraterrestres[index][5]=altura;
					opcion="-1";
					break;
				}
				case "pe":{
					System.out.println("ingrese nuevo peso: ");
					String peso=scan.nextLine();
					extraterrestres[index][6]=peso;
					opcion="-1";
					break;
				}
				case "t":{
					System.out.println("ingrese nuevo tipo: ");
					String tipo=scan.nextLine();
					extraterrestres[index][7]=tipo;
					opcion="-1";
					break;
				}
				default :{
					System.out.println("la pcion ingresada no es valida ingresala nuevamente,si no desea cambiar nada ingrese -1:");
					opcion=scan.nextLine();
				}
				}
			}
		}else if(index==-1) {
			System.out.println("el identificador ingresado no fue encontrado ingrese nuevamente : ");
			identificacion=scan.nextLine();
		}
	}
	//this function search for id.
	public static int buscar(String[][]matriz,String identificaion,int columna,int cant) {
		int index=0;
		for(int i =0;i<cant;i++) {
			if(matriz[i][columna].equals(identificaion)) {
				break;
			}else if(!matriz[i][2].equals(identificaion)){
				index++;
			}
		}
		if(index==cant) {
			return -1;
		}
		else {
			return index;
		}

        
        
    }
    public static void modificarH(String[][]humano, int cant){
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Ingrese el id del alien que desea modificar");
    	String identificacion=scan.nextLine();
		int index=buscar(humano,identificacion,2,cant);
		if(index!=-1) {
			System.out.println("Extraterrestre encontrado:");
			for(int i=0;i<8;i++) {
				System.out.println(humano[index][i]);
			}
			
			System.out.println("ingrese lo que desea nacionalidad(n),nombre(nom),identificacion(i),region(r),ciudad(c),edad(e),altura(a),peso(p),trabajo(t)");
			String opcion=scan.nextLine();
			while(!opcion.equals("-1")) {
				switch (opcion){
				case "n":{
					System.out.println("ingrese nueva nacionalidad: ");
					String nacionalidad=scan.nextLine();
					humano[index][0]=nacionalidad;
					opcion="-1";
					break;
				}
				case "nom":{
					System.out.println("ingrese nuevo nombre: ");
					String nombre=scan.nextLine();
					humano[index][1]=nombre;
					opcion="-1";
					break;
				}
				case "i":{
					System.out.println("ingrese nueva identificacion: ");
					String ident=scan.nextLine();
					humano[index][2]=ident;
					opcion="-1";
					break;
				}
				case "r":{
					System.out.println("ingrese nuevo region: ");
					String region=scan.nextLine();
					humano[index][3]=region;
					opcion="-1";
					break;
				}
				case "c":{
					System.out.println("ingrese nueva ciudad: ");
					String ciudad=scan.nextLine();
					humano[index][4]=ciudad;
					opcion="-1";
					break;
				}
				case "e":{
					System.out.println("ingrese nueva edad: ");
					String edad=scan.nextLine();
					humano[index][5]=edad;
					opcion="-1";
					break;
				}
				case "a":{
					System.out.println("ingrese nuevo altura: ");
					String altura=scan.nextLine();
					humano[index][6]=altura;
					opcion="-1";
					break;
				}
				case "p":{
					System.out.println("ingrese nuevo peso: ");
					String peso=scan.nextLine();
					humano[index][7]=peso;
					opcion="-1";
					break;
				}
				case "t":{
					System.out.println("ingrese el trabajo que desea cambiar: ");
					String trabajo=scan.nextLine();
					int pocicion=0;
					for(int i=0;i<3;i++) {
						for(int j=8;j<15;j++) {
							if(trabajo.equals(humano[i][j])){
								break;
							}else {
								pocicion++;
							}
						}
					}
					if(pocicion==3) {
						System.out.println("El trabajo no a sido encontrado:");
						
					}else {
						System.out.println("ingrese el trabajo por el que sedea ser cambiado: ");
						trabajo="";
						trabajo=scan.nextLine();
						
						
						humano[index][8]=trabajo;
					}
					
					break;
				}
				default :{
					System.out.println("la pcion ingresada no es valida ingresala nuevamente,si no desea cambiar nada ingrese -1:");
					opcion=scan.nextLine();
				}
				}
			}
		}else if(index==-1) {
			System.out.println("el identificador ingresado no fue encontrado ingrese nuevamente : ");
			identificacion=scan.nextLine();
		}
      
    }
    /**
     * @param matrizAlien use this data for the file
     * @param lCant
     * @throws IOException 
     */
    public static void cerrarX(String [][]matrizAlien,int[]lCant) throws IOException{
        //sobreescribir archivo extraterrestre
        File file=new File("x.txt");
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0;i<lCant[0];i++){
            for(int f=0;f<8;f++){
                bw.write(matrizAlien[i][f]);
                if(f<7){
                    bw.write(",");
                }                
            }
            bw.newLine();
        }                
        
        bw.close();
        
    }
    /**    
     * @param matrizHumano the data use for the file
     * @param lCant
     * @throws IOException 
     */
    public static void cerrarH(String [][]matrizHumano,int[]lCant) throws IOException{
        //sobreescribir archivo humano
        File file=new File("h.txt");
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0;i<lCant[1];i++){
            for(int f=0;f<15;f++){
                if(matrizHumano[i][f]!=(null)){
                    if(f<8){
                        bw.write(matrizHumano[i][f]);
                        if(f<8){
                            bw.write(",");
                            } 
                    }else{
                        bw.write(matrizHumano[i][f]);
                        if(matrizHumano[i][f+1]!=(null)){
                            bw.write("/");
                        }                        
                    }                                         
                }                                              
            }
            bw.newLine();
        }                        
        bw.close();        
    }
    public static void mostrarPlaneta(String [][]extraterrestres,int cantAlien,String[][]humanos,int cantHuman) {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Ingresa el planeta que deseas buscar : ");
    	String planeta=scan.nextLine();
    	System.out.println("-EXTRATERRESTRES EN EL PLANETA-");
    	String linea="";
    	int cantPla=0;
    	for(int i=0;i<cantAlien;i++) {
    		if(planeta.equals(extraterrestres[i][3])) {
    			cantPla++;
    			for(int j=0;j<8;j++) {
    		     linea=linea+extraterrestres[i][j]+",";  
    		      
    			}
    			System.out.println(linea);
    			linea="";
    		}
    	}
    	System.out.println("El porcentaje de extraterrestres que viven en el planeta: "+(cantPla/cantAlien)*100+"%");
    	int cantH=0;
    	for(int i=0;i<cantHuman;i++) {
    		for(int j=8;j<15;j++) {
    			if(planeta.equals(humanos[i][j])) {
        			cantH++;
        			break;
        		}
    		}
    	}
    	System.out.println("La cantidad de humanos que trabajan en el planeta son "+cantH);
    	
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void mostrarNacionalidad(String[][]humano,int cant) {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Ingresa la nacionalidad que deseas buscar : ");
    	String nacionalidad=scan.nextLine();
    	System.out.println("-HUMANOS DE LA NACIONALIDAD-");
    	String linea="";
    	int cantH=0;
    	for(int i=0;i<cant;i++) {
    		if(nacionalidad.equals(humano[i][3])) {
    			cantH++;
    			for(int j=0;j<8;j++) {
    		     linea=linea+humano[i][j]+",";  
    		      
    			}
    			System.out.println(linea);
    			linea="";
    		}
    	}
    	
    }
    public static void main(String[] args) throws IOException {
        String [][] matrizHumano=new String[30][15];
        String [][] matrizAlien =new String[30][8];
        int []lCant=new int[2];
        
        leerX(matrizAlien,lCant);
        leerH(matrizHumano,lCant);
                
        Scanner scanner=new Scanner(System.in);
        
        int opc=0;
        while(opc!=12){
            System.out.println(" ");
            System.out.println("----Bienvenido a MENU----");
            System.out.println("-1) Ingresar Extraterrestre: ");
            System.out.println("-2) Modificar Extraterrestre: ");
            System.out.println("-3) Ingresar Humano: ");
            System.out.println("-4) Modificar Humano: ");
            System.out.println("-5) Mostrar por Nacionalidad: ");
            System.out.println("-6) Elimacion Extraterrestre: ");
            System.out.println("-7) Elimacion Humano: ");
            System.out.println("-8) Buscar por Identificacion Universal: ");
            System.out.println("-9) Mostrar por Planeta: ");
            System.out.println("-10) Mostrar por nacionalidad(%): ");
            System.out.println("-11) Mostrar tabla: ");
            System.out.println("-12) Cerrar Sesion: ");
           
            System.out.println(" ");
            System.out.println("--Ingrese opcion: ");
            opc=scanner.nextInt();
            
            switch (opc) {
                case 1:
                    ingresarAlien(matrizAlien,lCant);
                    break;
                case 2:
                	modificarX(matrizAlien,lCant[0]);
                    break;
                case 3:
                    ingresarHumano(matrizHumano,lCant);
                    break;
                case 4:
                	modificarH(matrizHumano,lCant[1]);
                    break;
                case 5:
                    mostrarNacionalidad(matrizHumano,lCant);
                    break;
                case 6:                                        
                    eliminarAlien(matrizAlien,lCant);
                    break;
                case 7:
                    eliminarHumano(matrizAlien,lCant);
                    break;
                case 8:                    
                    buscarIdentficacion(matrizAlien,lCant);
                    break;
                case 9:
                	mostrarPlaneta(matrizAlien,lCant[0],matrizHumano,lCant[1]);
                    break;
                case 10:
                	mostrarNacionalidad(matrizHumano,lCant[1]);
                    break;    
                case 11:
                    tablaAlien(matrizAlien,lCant);
                    break;
                default:
                    opc=12;
                    cerrarX(matrizAlien,lCant);
                    cerrarH(matrizHumano,lCant);
                    break;
            }            
        }       
        
    }  
    
}
