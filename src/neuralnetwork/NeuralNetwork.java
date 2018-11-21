/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork;

/**
 *
 * @author X441U
 */
public class NeuralNetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,j;
        int[] target = new int[]{0,1,1,1};
        int epoch = 0;
        double miu = 0.1;
        double[] w = new double[3];
        int[][]sequence = new int[][]{{1,0,0},{1,0,1},{1,1,0},{1,1,1}};
        double err =0;
        double[] sum = new double[4];
        int t = 0;
        int[] output = new int[4];
        
        //tabel data
        System.out.println("   X1 \t   X2 \t   X3 \t   Target \t");
        System.out.println("===============================================");
        for(i=0; i<4; i++){
            for(j=0; j<3; j++){
                System.out.print("   "+sequence[i][j]+"\t");
            }
            System.out.print("   "+ target[i]);
            System.out.println("");
        }
        System.out.println("\n");
        
        //mengambil nilai random
        for(i=0;i<3;i++){
            w[i] = -1 + Math.random()*(1-(-1));
            System.out.println("nilai w"+i+" = " +w[i]);
        }
       //looping selama epoch tidak sama dengan 100
        do{
            for(i=0;i<sequence.length;i++){
                    sum[i] = ((sequence[i][0]*(w[0]))+(sequence[i][1]*(w[1]))+(sequence[i][2]*(w[2])));
                    if(sum[i]>=t){
                        output[i]=1;
                    } else {
                        output[i]=0;
                    }
                    err = target[i] - output[i];
                   //pengecekan
                    if(output[i]!=target[i]){
                        if(err!=0){
                            for(int x=0;x<w.length;x++){
                                w[x]=w[x]+(miu*sequence[i][x]*err);
                            }
                        }
                    }
            }
            epoch++;
        } while(epoch!=100);
        
        //mencetak nilai wbaru
         System.out.println("===============================================");
        System.out.println("Nilai w baru : ");
        for(i=0;i<w.length;i++){
            System.out.println("w"+i+" = "+w[i]);
        }
        
        //pengecekan untuk testing
        System.out.println("===============================================");
        for(i=0;i<output.length;i++){
            System.out.println("output= "+output[i]);
        }
    }
    
}
