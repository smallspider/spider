/**
 * 
 */
package org.spider;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.jsresources.apps.am.audio.AMAudioFormat;
import org.jsresources.apps.am.audio.AudioCapture;
import org.jsresources.apps.am.audio.AudioPlayStream;
import org.tritonus.share.sampled.convert.TAudioInputStream;

import javax.sound.sampled.SourceDataLine;

import sun.audio.AudioPlayer;

/**
 * @author yangguangftlp
 * 
 *         2015年3月18日
 */
public class Test {

	public static void main(String[] args) {
		 //test1();
		 test2();
		//
		 play1();
	}
	public static void play1() {
		AudioFormat format;
		try {
			InputStream source = new FileInputStream("a2.wav");
			format = AMAudioFormat.getNetAudioFormat(AMAudioFormat.FORMAT_CODE_GSM);
			int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
			byte[] buffer = new byte[bufferSize];
			// create a line to play to
			SourceDataLine line;
			try {
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(format, bufferSize);
			} catch (LineUnavailableException ex) {
				ex.printStackTrace();
				return;
			}
			// start the line
			line.start();
			try {
				int numBytesRead = 0;
				while (numBytesRead != -1) {
					numBytesRead = source.read(buffer, 0, buffer.length);
					if (numBytesRead != -1) {
						line.write(buffer, 0, numBytesRead);
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			line.drain();
			line.close();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void play(InputStream source) {
		AudioFormat format;
		try {
			format = AMAudioFormat.getNetAudioFormat(AMAudioFormat.FORMAT_CODE_GSM);
			int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
			byte[] buffer = new byte[bufferSize];
			// create a line to play to
			SourceDataLine line;
			try {
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(format, bufferSize);
			} catch (LineUnavailableException ex) {
				ex.printStackTrace();
				return;
			}
			// start the line
			line.start();
			try {
				int numBytesRead = 0;
				while (numBytesRead != -1) {
					numBytesRead = source.read(buffer, 0, buffer.length);
					if (numBytesRead != -1) {
						line.write(buffer, 0, numBytesRead);
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			line.drain();
			line.close();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test3() {
		AudioFormat amaudioFormat;
		try {
			amaudioFormat = AMAudioFormat.getNetAudioFormat(AMAudioFormat.FORMAT_CODE_FM);
			AudioPlayStream audioPlayStream = new AudioPlayStream(amaudioFormat);
			FileInputStream in = new FileInputStream("a1.wav");
			int numBytesRead;
			int length = 1024;
			byte[] data = new byte[1024];
			audioPlayStream.open();
			System.out.println("---start-------");
			audioPlayStream.start();
			while ((numBytesRead = in.read(data, 0, length)) != -1) {
				audioPlayStream.write(data, 0, numBytesRead);
			}
			System.out.println("---end-------");
			// audioPlayStream.
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test4() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void test1() {
		// TODO Auto-generated method stub
		try {
			File gsmFile = new File("a1.wav");
			AudioFormat amaudioFormat = AMAudioFormat.getNetAudioFormat(AMAudioFormat.FORMAT_CODE_GSM);
			// audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
			// 44100F, 8, 1, 1, 44100F, false);
			// AudioFormat amaudioFormat =new
			// AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100.0f,16,1,2,
			// 44100.0f, true);
			AudioCapture audioCapture = new AudioCapture(AMAudioFormat.FORMAT_CODE_GSM);
			audioCapture.open();
			int frameSizeInBytes = amaudioFormat.getFrameSize();
			int bufferLengthInFrames = audioCapture.getBufferSizeInBytes();
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			byte[] data = new byte[bufferLengthInBytes];
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int numBytesRead;
			TAudioInputStream a;
			AudioInputStream audioInputStream = audioCapture.getAudioInputStream();
			while ((numBytesRead = audioInputStream.read(data, 0, bufferLengthInBytes)) == -1) {
				out.write(data, 0, numBytesRead);
			}
			Thread.sleep(1000 * 5);
			audioCapture.close();
			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, gsmFile);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test2() {
		String filename = "a2.wav ";
		File outputFile = new File(filename);
		AudioFormat audioFormat = null;
		audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 8, 1, 1, 44100F, false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
		TargetDataLine targetDataLine = null;
		try {
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			targetDataLine.open(audioFormat);// try{ }可能發生例外的敘述

		} catch (LineUnavailableException e)// catch{ }處理方法

		{
			System.out.println("無法錄音,錄音失敗 ");
			e.printStackTrace();
			System.exit(-1);
		}
		try {
			int frameSizeInBytes = audioFormat.getFrameSize();
			int bufferLengthInFrames = targetDataLine.getBufferSize();
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			byte[] data = new byte[bufferLengthInBytes];
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int numBytesRead;
			AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);
			while ((numBytesRead = audioInputStream.read(data, 0, bufferLengthInBytes)) == -1) {
				out.write(data, 0, numBytesRead);
			}
			Thread.sleep(1000*5);
			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile);
		} catch (Exception e) {

		}
	}

}
