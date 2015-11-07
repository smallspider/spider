package org.spider;
import java.io.IOException;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
public class GSMEncoder {
	public static void main(String[] args) {
		/*if (args.length != 2) {
			printUsageAndExit();
		}*/
		File pcmFile = new File("record.wav");
		
		
		
		System.out.println(pcmFile.getPath());
		File gsmFile = new File("recording_.wav");
		AudioInputStream ais = null;
		try {
			ais = AudioSystem.getAudioInputStream(pcmFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ais == null) {
			out("cannot open audio file");
			System.exit(1);
		}

		/**
		 * We check if the input file has a format that can be converted to GSM.
		 */
		AudioFormat sourceFormat = ais.getFormat();
		System.out.println(sourceFormat);
		if (!sourceFormat.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED)
				|| sourceFormat.getSampleRate() != 8000.0F
				|| sourceFormat.getSampleSizeInBits() != 16
				|| sourceFormat.getChannels() != 1) {
			out("The format of the input data has to be PCM 8 kHz 16 bit mono");
			System.exit(1);
		}
		AudioFormat.Encoding targetEncoding = new AudioFormat.Encoding(
				"GSM0610");
		AudioInputStream gsmAIS = AudioSystem.getAudioInputStream(
				targetEncoding, ais);
		AudioFileFormat.Type fileType = new AudioFileFormat.Type("GSM", ".gsm");
		int nWrittenFrames = 0;
		try {
			nWrittenFrames = AudioSystem.write(gsmAIS, fileType, gsmFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printUsageAndExit() {
		out("GSMEncoder: usage:");
		out("\tjava GSMEncoder <pcmfile> <gsmfile>");
		System.exit(1);
	}

	private static void out(String strMessage) {
		System.out.println(strMessage);
	}
}
