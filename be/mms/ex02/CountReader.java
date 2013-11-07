package be.mms.ex02;

import java.io.IOException;
import java.io.Reader;

public class CountReader extends Reader {

	private Reader reader;
	
	private int nbrWord = 0, nbrChar = 0, nbrLine=0;

	private boolean inWord = false;
	
	public CountReader(Reader fileReader) {
		this.reader = fileReader;
	}

	public int getLines() {
		return nbrLine;
	}

	public int getWords() {
		return nbrWord;
	}

	public int getChars() {
		return nbrChar;
	}

	@Override
	public void close() throws IOException {
		if (reader != null) reader.close();
	}

	@Override
	public int read() throws IOException {
		int data = reader.read();
		if (data != -1) counter(data);
		return data;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int n = reader.read(cbuf, off, len);
		for (int i = 0; i < n; i++) counter(cbuf[off+i]);
		return n;
	}
	
	private void counter(int data) {
		nbrChar++;
		if (data == '\n') nbrLine++;
		
		if (Character.isWhitespace(data)) {
			inWord = false;
		} else if (!inWord) {
			nbrWord++;
			inWord = true;
		}
	}
}