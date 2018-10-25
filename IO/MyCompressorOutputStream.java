package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Math;

/**
 * Created by elias_000 on 16/05/2017.
 */
public class MyCompressorOutputStream  extends OutputStream   {

    //Data members
    /**
     * OutPutStream varible
     */
    public OutputStream out; // TODO: java doc


    private int length_sum;
    /**
     * the last number that have been wroten to the file
     */

    private int last_num;
    /**
     * the sum of the current series of bytes
     */
    private int sum;

    /**
     * consracts MyCompressorOutputStream object
     * @param out an OutPutStream object
     */
    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
        this.last_num=-1;
        length_sum=0;
        sum=0;
    }

    /**
     * writing a int number to the data member out
     * @param b- int number smaller that 255
     */
    public void write(int b) throws IOException {


        if (last_num != b) {
            out.write(sum);
            sum = 0;
            last_num = b;
            sum++;

        } else {


            if (sum == 255) {

                out.write(sum);
                out.write(0);
                sum = 1;
            } else {
                sum++;
                last_num=b;
            }


        }
    }

    /**
     * writing byte array value int a file
     * @param byteArray - array of bytes
     */
    public void write ( byte[] byteArray) throws IOException
    {
        // first it write to the file the : number of column, number of rows, starting position ( row*column), goal position ( row*column)
        for (int i=0;i<12;i++)
        {
            out.write((int)byteArray[i]);

        }
        out.write(byteArray[12]);
        last_num=byteArray[12];
        // the other bytes it sand to the write function
        for(int i=12;i< byteArray.length;i++)
        {
            write((int)byteArray[i]);
        }
    }
}
