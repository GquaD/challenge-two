import java.io.*;

public class MyReader {

    private File file;
    private long lastModifiedTime;

    private BufferedReader reader;

    public MyReader(File file) {
        this.file = file;
        lastModifiedTime = file.lastModified();
        readFile();
    }


    public void readFile() {
        try {
            reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        } catch (FileNotFoundException e) {
            System.out.println("There was an error during file read. " + e.getLocalizedMessage());
            System.exit(1);
        }
        updateLastModifiedTime();
    }

    public BufferedReader getReader() {
        if (!isReady()) readFile();
        return reader;
    }

    private void updateLastModifiedTime() {
        lastModifiedTime = file.lastModified();
    }

    public boolean isModified() {
        return lastModifiedTime != file.lastModified();
    }


    public boolean isReady() {
        try {
            return isModified() && reader.ready();
        } catch (IOException e) {
            return false;
        }
    }
}
