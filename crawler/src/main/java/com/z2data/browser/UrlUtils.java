package com.z2data.browser;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {
	private String urlStr;
	private URL url;
	private boolean valid;

	public UrlUtils(String urlStr) {
		super();
		this.urlStr=urlStr;
		validate();
	}

	private void validate() {
		try {
			if (null == urlStr || urlStr.trim().isEmpty()) {
				throw new MalformedURLException();
			}
			/**
			 * checks if it is a valid URL
			 */
			url = new URL(urlStr);
			valid = true;
		} catch (MalformedURLException e) {
			valid = false;
		}
	}

	public boolean isValid() {
		return valid;
	}

	public String getHost() {
		if (valid) {
			return url.getHost();
		}
		return null;
	}

	public String getFileName() {
		if (valid) {
			return url.getPath().substring(url.getPath().lastIndexOf("/") + 1);
		}
		return null;
	}
}
