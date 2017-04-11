
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 

public class ilhas {
	  public static void main(String[] args) {
		  
		  BufferedReader br = null;
	       try {
	           Scanner ler = new Scanner(System.in);
	           System.out.println("Infome somente o nome do arquivo");
	           String nomeArquivo = ler.next();
	           br = new BufferedReader(new FileReader(nomeArquivo + ".txt"));

	            String primeiraLinha = br.readLine();
	            String[] basesDaMatriz = primeiraLinha.split(" ");  // pega o tamanho da matriz
	            int y = Integer.parseInt(basesDaMatriz[0]);         // coluna
	            int x = Integer.parseInt(basesDaMatriz[1]);         // linha
	            int[][] matriz = new int[x][y]; 

	                       
	            int eixoY = 0;
	            while ((primeiraLinha = br.readLine()) != null) {//enquanto tiver linhas le o arquivo
	                String[] array = primeiraLinha.split("");
	                for (int eixoX = 0; eixoX < array.length; eixoX++) {
	                    matriz[eixoY][eixoX] = Integer.parseInt(array[eixoX]);
	                }
	                eixoY++;
	            }
	            
	        
	            System.out.println((contaIlhas(matriz)));
	            
	        
	       } catch (FileNotFoundException ex) {
	           Logger.getLogger(ilhas.class.getName()).log(Level.SEVERE, null, ex);
	       } catch (IOException ex) {
	           Logger.getLogger(ilhas.class.getName()).log(Level.SEVERE, null, ex);
	       } finally {
	           try {
	               br.close();
	           } catch (IOException ex) {
	               Logger.getLogger(ilhas.class.getName()).log(Level.SEVERE, null, ex);
	           }
	       }
}
	 
	  public static int contaIlhas(int[][] matriz) {

		    int matrizI = matriz.length;
		    int matrizJ = matriz[0].length;
		    int count=0;
		    
		    for(int i=0; i<matrizI; i++){
		        for(int j=0; j<matrizJ; j++){          
		            if(matriz[i][j]== 1){           // se for igual a 1 
		                count++;					// incrementa o count e chama o metodo
		                arquipelogo(matriz, i, j);  // passando a matriz e sua posicao atual (i,j)                 
		            }
		        }
		    }
		    return count; 
		}
		 
		public static void arquipelogo(int[][] matriz, int i, int j){  
		    int matrizI = matriz.length;    // tamanho da matriz  
		    int matrizJ = matriz[0].length; 

          /*verifica se o i e o j sao maiores ou menores que o tamamho da matriz 
		    ou se a posicao atual eh diferente de 1 */ 
		    
		    if(i<0 || i>=matrizI || j<0 || j>=matrizJ || matriz[i][j]!= 1) 
		       return;      // se for tudo true continua e chama o proprio metodo novamente 
		    
		    matriz[i][j]=0; // caso a posicao atual seja 1 no teste acima, a posicao atual recebe 0 
		    				// evitando que uma posicao seja contada indevidamente
		    
		    arquipelogo(matriz, i-1, j); // passa por parametro outras posicoes para serem testadas
            arquipelogo(matriz, i+1, j);
            arquipelogo(matriz, i, j-1);
            arquipelogo(matriz, i, j+1);
           





		}	    
  
}