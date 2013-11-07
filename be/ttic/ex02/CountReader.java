package be.ttic.ex02;

import java.io.IOException;
import java.io.Reader;


public class CountReader extends Reader {

	private Reader reader;
	private int nLines, nWords, nChars;
	private boolean inWord;
		
	public CountReader(Reader reader) {
		this.reader = reader;
	}
		
	@Override
	public int read() throws IOException {
		int c = reader.read();		
		if (c != -1) handleChar(c);	
		return c;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int n = reader.read(cbuf, off, len);
		
		for (int i = 0 ; i < n ; i++) {
			handleChar(cbuf[off + i]);
		}
		
		return n;
	}

	private void handleChar(int c) {
		nChars++;
		if (c == '\n') nLines++;
		
		if (Character.isWhitespace(c)) {
			inWord = false;
		} else if (!inWord) {
			nWords++;
			inWord = true;
		}
	}

	@Override
	public void close() throws IOException {
		if (reader != null) reader.close();
	}
	
	public int getChars() {
		return nChars;
	}
	
	public int getLines() {
		return nLines;
	}
	
	public int getWords() {
		return nWords;
	}
	
}
