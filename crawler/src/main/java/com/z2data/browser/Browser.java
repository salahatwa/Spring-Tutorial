package com.z2data.browser;

import java.io.IOException;
import java.net.MalformedURLException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.z2data.beans.URLData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Browser {
	
	
	static final Logger logger = LoggerFactory.getLogger(HtmlUnit.class);
	Status status = new Status();

	void followRedirect(boolean follow);

	void checkUrl(String url,String statusFilePath,String downloadPath) throws FailingHttpStatusCodeException, MalformedURLException, IOException;

	void closeConnection();
	
	

	default long getStatus(int code) {
		return status.getStatus(code);
	}

	
}