package java3.lesson_3;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.X509DigestResolver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;


public class WorkWithFiles {
    private byte[] arr = new byte[8192];
    public void readInArr(String fileName) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            e.printStackTrace();
        }
        int x;
        while ((x = in.read(arr)) != -1) {
            System.out.println(new String(arr, 0, x));
        }
    }

    public ArrayList<InputStream> addFiles(String... fileNames) throws FileNotFoundException {
        ArrayList<InputStream> result = new ArrayList<InputStream>();
        for (int i = 0; i < fileNames.length; i++) {
            result.add(new FileInputStream(fileNames[i]));
        }
        return result;
    }

    public void mergeFiles(ArrayList<InputStream> files) throws IOException {
        SequenceInputStream all = new SequenceInputStream(Collections.enumeration(files));
        File merge = new File("merge.txt");
        FileWriter fw = new FileWriter(merge);
        int x;
        while ((x = all.read()) != -1) {
            fw.write((char) x);
        }
        fw.close();
        all.close();
    }

    public void readPage(String fileName) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(fileName));
        int x;
        while ((x = in.read(arr)) != -1) {
            System.out.print(new String(arr, 0, x));
        }
    }
}
