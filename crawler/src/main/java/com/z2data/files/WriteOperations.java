/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z2data.files;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.z2data.beans.URLData;

/**
 *
 * @author salah.atwa
 */
public class WriteOperations {

	/**
	 * Write status Data for URL To file
	 * 
	 * @param outputPath
	 * @param urlData
	 */
	@SuppressWarnings("deprecation")
	public static void writeURLData(String outputPath, URLData urlData) {

		try {
			File file = new File(outputPath);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileUtils.writeStringToFile(file, urlData.getParentURL()+"\t"+urlData.getAnchorTitle()+"\t"+urlData.getAnchor()+"\t"+urlData.getDownloadStatus()+"\t"+urlData.getDownloadPath(), true);
			FileUtils.writeStringToFile(file, System.lineSeparator(), true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Write error URL in file
	 * 
	 * @param outputPath
	 * @param URL
	 * @param errorMessage
	 */
	public static void writeErrorData(String outputPath, String URL, String errorMessage) {
		File file = null;
		try {
			file = new File(outputPath);

			if (!file.exists()) {
				file.createNewFile();
			}

			String errorFileName = "ERRORS_URLS_" + file.getName();
			File errorFile = null;
			if (file.getParent() == null || file.getParent().isEmpty()) {
				errorFile = new File(errorFileName);
			} else {
				errorFile = new File(file.getParent() + errorFileName);
			}

			if (!errorFile.exists()) {
				errorFile.createNewFile();
			}
			FileUtils.writeStringToFile(errorFile, URL + "\t" + errorMessage, true);
			FileUtils.writeStringToFile(errorFile, System.lineSeparator(), true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
