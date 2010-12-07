package org.codelabor.system.mime.services;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public interface MimeDetectService {
	public String getMimeType(InputStream inputStream);

	public String getMimeType(File file);

	public String getMimeType(URL url);

	public String getMimeType(byte[] byteArray);

	public String getMimeType(String string);
}
