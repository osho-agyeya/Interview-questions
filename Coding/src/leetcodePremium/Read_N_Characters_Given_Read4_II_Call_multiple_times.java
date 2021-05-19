/*completed
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
 */

package leetcodePremium;

public class Read_N_Characters_Given_Read4_II_Call_multiple_times {

	private char[] buffer = new char[4];
	  private int offset = 0;
	  private int charactersInBuffer = 0; 

	  /**
	   * @param buf Destination buffer
	   * @param n   Maximum number of characters to read
	   * @return    The number of characters read
	   */
	  public int read(char[] buf, int n) {
	    int totalCharactersRead = 0;
	    boolean eof = false;
	    while (!eof && totalCharactersRead < n) {
	      if (charactersInBuffer == 0) {
	        charactersInBuffer = read4(buffer);
	        eof = charactersInBuffer < 4;
	      }
	      int numCharactersUsed = Math.min(charactersInBuffer, n - totalCharactersRead);
	      for (int i = 0; i < numCharactersUsed; i++) {
	        buf[totalCharactersRead + i] = buffer[offset + i];
	      }
	      totalCharactersRead += numCharactersUsed;
	      charactersInBuffer -= numCharactersUsed;
	      offset = (offset + numCharactersUsed) % 4;
	    }
	    return totalCharactersRead;
	  }
	
}
