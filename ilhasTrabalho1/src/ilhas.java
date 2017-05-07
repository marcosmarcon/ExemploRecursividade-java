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
               br = new BufferedReader(new FileReader("example_3.txt"));

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
                
            
                System.out.println((contaIlhas(matriz)));    // chama o primeiro metodo
            
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
                    if(matriz[i][j]== 1){                   // se for igual a 1 
                        count++;                            // incrementa o count e chama o metodo
                        lozalizaIlha(matriz, i, j, count ); // passa a matriz e sua posicao atual (i,j)                       
                    }
                }
            }
            return count; 
        }
         
        public static void lozalizaIlha(int[][] matriz, int i, int j, int count){  
            int matrizI = matriz.length;    // tamanho da matriz  
            int matrizJ = matriz[0].length; 
            
            /*verifica se o i e o j sao maiores ou menores que o tamamho da matriz 
		    ou se a posicao atual eh diferente de 1 */             
            if(i<0 || i>=matrizI || j<0 || j>=matrizJ || matriz[i][j]!= 1) 
               	return;  // se for tudo true continua e chama o proprio metodo novamente 
          
            representacao representacao = new representacao (i,j,count); 
            representacao.coordenadas(i,j,count);
           
            matriz[i][j]=2;  // caso a posicao atual seja 1 no teste acima, a posicao atual recebe 2                           
                             // evitando que uma posicao seja contada novamente
            
            lozalizaIlha(matriz, i-1, j, count); // passa por parametro outras posicoes para serem testadas
            lozalizaIlha(matriz, i+1, j, count);
            lozalizaIlha(matriz, i, j-1, count);
            lozalizaIlha(matriz, i, j+1, count);
               
        }        
  
        
       



}

 


