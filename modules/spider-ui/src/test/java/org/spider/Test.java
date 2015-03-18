/**
 * 
 */
package org.spider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.jsresources.apps.am.audio.AMAudioFormat;
import org.jsresources.apps.am.audio.AudioCapture;

/**
 * @author yangguangftlp
 * 
 *         2015年3月18日
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File gsmFile = new File("recordd.wav");
			AudioFormat amaudioFormat = AMAudioFormat
					.getNetAudioFormat(AMAudioFormat.FORMAT_CODE_GSM);
			AudioCapture audioCapture = new AudioCapture(0);
			audioCapture.open();
			int frameSizeInBytes = amaudioFormat.getFrameSize();
			// The number of frames = the size of the buffer
			int bufferLengthInFrames = audioCapture.getBufferSizeInBytes();
			// Number of frames * frame size = total bytes
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			// Make a new byte[] the size of the AudioBuffer
			byte[] data = new byte[bufferLengthInBytes];
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int numBytesRead; // Cache the number of bytes we have read
			AudioInputStream audioInputStream = audioCapture.getAudioInputStream();
			// Read in some data from the line
			// Read will return -1 if it encounters errors
			while ((numBytesRead = audioInputStream.read(data, 0, bufferLengthInBytes)) == -1) {
				out.write(data, 0, numBytesRead);
			}
			// Once we read in the data, we'll write it to an
			// audio output stream
			// Convert the output stream back to a byte[]
			byte[] audioBytes = out.toByteArray();
			// Make a ByteArrayInputStream from the byte[]
			ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE,gsmFile);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
