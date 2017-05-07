
public class representacao {
   
	private   String posicaoIlha = "" ;
	private int i;
	private int j;
	private int count;
	
	 public representacao(int i, int j, int count) {
		 this.i = i;
		 this.j = j;
		 this.count = count;
	}

	public   String coordenadas(int i, int j, int numeroilha){
		posicaoIlha = "ilha "+ numeroilha+ " [X"+ i + ",Y"+ j +"]"+"\r\n";
     //	System.out.print(posicaoIlha);
     	return "ilha "+ numeroilha+ " [X"+ i + ",Y"+ j +"]"+"\r\n"; // guarda a posicao atual ou a coordenada
	
	}
}
