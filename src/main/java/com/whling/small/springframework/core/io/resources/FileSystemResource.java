package com.whling.small.springframework.core.io.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author whling
 */
public class FileSystemResource implements Resource {

    private final File file;

    private final String filePath;

    public FileSystemResource(File file) {
        this.file = file;
        this.filePath = file.getPath();
    }

    public FileSystemResource(String filePath) {
        this.file = new File(filePath);
        this.filePath = filePath;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    public String getFilePath() {
        return filePath;
    }
}
