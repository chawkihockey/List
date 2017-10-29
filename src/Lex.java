/*
Chandler Hawkins
chmhawki
pa1
*/
import java.io.*;
import java.util.Scanner;

class Lex
{
    public static void main(String[] args) throws IOException
    {
        if(args.length < 2)
        {
            System.err.println("Usage: FileIO infile outfile");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new FileReader(args[0]));

        String content = in.readLine();
        int numLines = 0;

        while (content != null) {
            numLines++;
            content = in.readLine();
        }
        in.close();

        String lines[] = new String[numLines];

        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        for (int i = 0; i < numLines; i++)
        {
            lines[i] = br.readLine();
        }

        List myList = new List();

        System.out.println();

        insertionSort(myList, lines);

        System.out.println(myList);

        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        myList.moveFront();

        for (int i = 0; i < numLines; i++)
        {
            writer.write(lines[myList.get()]);
            writer.newLine();
            myList.moveNext();
        }
        writer.close();

        System.out.println();
        myList.moveFront();
        for (int i = 0; i < numLines; i++)
        {
            System.out.println(lines[myList.get()]);
            myList.moveNext();
        }
    }

       static void insertionSort(List L, String[] arr)
        {
            int length = arr.length;
            L.append(0);

            for (int i = 1; i < length; i++)
            {
                String key = arr[i];
                L.moveFront();

                while (L.index() != -1 && arr[L.get()].compareTo(key) < 0)
                {
                   L.moveNext();
                }
                if (L.index() == -1)
                {
                    L.append(i);
                }
                else
                {
                        L.insertBefore(i);
                }
            }
        }
}

