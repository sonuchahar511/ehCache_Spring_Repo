package com.chahar.common;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileCreatorApp {
    public static void main(String[] args) {
        List<String> fileContents = new ArrayList<>();
        fileContents.add("this is sample content for 1");
        fileContents.add("this is sample content for 22");
        fileContents.add("this is sample content for 333");

        String baseDir = System.getProperty("java.io.tmpdir");
        String zipFileName = baseDir
                + "/" + "zip_" + UUID.randomUUID().toString() + ".zip";

        final File zipFile = new File(zipFileName);

        System.out.println("Zip file: " + zipFile.getAbsolutePath());

        try {
            zipFile.createNewFile();

            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));

            for (int i = 0; i < fileContents.size(); i++) {
                if (i == 0) {
                    writeFileInZip(zos, "com/xyz" + "/" + (i + 1) + ".txt", fileContents.get(i));
                } else {
                    writeFileInZip(zos, (i + 1) + ".txt", fileContents.get(i));
                }
            }

            IOUtils.closeQuietly(zos);
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFileInZip(ZipOutputStream zos, String filename, String fileContents) {
        ZipEntry entry = new ZipEntry(filename);

        StringWriter writer = new StringWriter();
        BufferedWriter bufferWriter = new BufferedWriter(writer);

        try {
            bufferWriter.append(fileContents);
            bufferWriter.flush();

            zos.putNextEntry(entry);
            zos.write(writer.toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferWriter);
        }

    }
}
