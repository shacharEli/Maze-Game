package IO;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by elias_000 on 16/05/2017.
 */
public class MyDecompressorInputStream extends InputStream  {

    InputStream in;
    int sum;
    boolean  zogi;
    int first;



    public MyDecompressorInputStream(InputStream in) {
        this.sum=0;
        this.in = in;
        this.zogi=true;

    }

    @Override
    public int read() throws IOException{


            while (sum == 0) {
                if (zogi)
                    zogi = false;
                else
                    zogi = true;
                sum = in.read();
            }
            if (zogi) {

                    sum--;
                   return (byte) first;

                }
            else
            {
                if(first==1)
                {
                    sum--;
                       return 0;

                }
                else
                {
                        sum--;
                        return 1;
                }
            }


    }


    public int read(byte []byteMaze) throws IOException
    {
        for(int i=0 ; i<12 ; i++)
        {
            byte temp=(byte)this.in.read();
            byteMaze[i]=temp;
        }


        this.first=in.read();
        sum = in.read();
        for(int i=12; i<byteMaze.length;i++)
        {
            byteMaze[i]=(byte)read();

        }
        return 1;

    }




}
