/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z2data.downloader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.z2data.beans.URLData;
import com.z2data.browser.HtmlUnit;

/**
 * @author salah.atwa
 */
public class Downloader {
	private static Logger LOGGER = LoggerFactory.getLogger(Downloader.class);

	/**
	 * @param urlPath
	 * @param dirPath
	 * @return
	 */
	public synchronized static URLData downlaodPDF(URLData urlData, String dirPath, String urlPath) {
		String filePath = "";
		try {
			LOGGER.info("Begin Download File..." + urlPath);
			URL url = new URL(urlPath);
			InputStream in = url.openStream();
			String fileName = urlPath.substring(urlPath.lastIndexOf("/") + 1);
			File file = new File(dirPath + "/" + url.getHost());

			if (!file.exists()) {
				file.mkdir();
			}

			filePath = Paths.get(file.getAbsolutePath() + "/" + fileName).toString();

			Files.copy(in, Paths.get(file.getAbsolutePath() + "/" + fileName), StandardCopyOption.REPLACE_EXISTING);

			in.close();
			
			urlData.setDownloadPath(filePath);
			urlData.setDownloadStatus("Done");
			
			LOGGER.info("Download Finished successfuly");
		} catch (Exception ex) {
			LOGGER.error("", ex);
			urlData.setDownloadPath(ex.getMessage());
			urlData.setDownloadStatus("Failed");
		}
		return urlData;
	}

}
