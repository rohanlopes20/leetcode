package com.leetcode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChanneTest {
	public static void main(String[] args) throws IOException {
//		final FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\rplopes\\Documents\\work\\OBDXHelperProjects\\OBDXHelper\\src\\main\\resources\\fileChannel.text"), StandardOpenOption.READ);
		final FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\rplopes\\Downloads\\customers-100000.csv"), StandardOpenOption.READ);

		long noOfThreads = Runtime.getRuntime().availableProcessors();
		long startAddress = 0;
		long chunkSize    =  fileChannel.size()/noOfThreads;
		long startTime = System.currentTimeMillis();
		MappedByteBuffer buff = null;
		try {
			buff = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
			byte[] data = new byte[buff.remaining()];
			buff.get(data);
			buff.clear();
			System.out.println(Thread.currentThread().getName()  + " == > " + new String(data, StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TimeTaken :: " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		for(int i = 0; i < noOfThreads - 1; i++) {
			startAddress = startAddress;

			long finalStartAddress = startAddress;
			Thread t = new Thread(() -> {
				MappedByteBuffer buff2 = null;
				try {
					buff2 = fileChannel.map(FileChannel.MapMode.READ_ONLY, finalStartAddress, chunkSize);
					byte[] data = new byte[buff2.remaining()];
					buff2.get(data);
					buff2.clear();
					System.out.println(Thread.currentThread().getName()  + " == > " + new String(data, StandardCharsets.UTF_8));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			t.start();
			startAddress += chunkSize  + 1;
		}
		System.out.println("TimeTaken 2 :: " + (System.currentTimeMillis() - startTime));

	}
}
