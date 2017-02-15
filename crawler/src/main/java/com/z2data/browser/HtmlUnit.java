package com.z2data.browser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.z2data.beans.URLData;
import com.z2data.downloader.Downloader;
import com.z2data.files.WriteOperations;

public class HtmlUnit implements Browser {
	Logger LOGGER = LoggerFactory.getLogger(HtmlUnit.class);
	private WebClient webClient;

	public HtmlUnit() {
		setHtmlUnitConfigs();
	}

	private void setHtmlUnitConfigs() {
		webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(true);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());

		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setPrintContentOnFailingStatusCode(false);

		webClient.getOptions().setDoNotTrackEnabled(true);
		webClient.getOptions().setTimeout((int) TimeUnit.MINUTES.toMillis(5));

		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);

		webClient.getOptions().setDoNotTrackEnabled(true);
	}

	@Override
	public void followRedirect(boolean follow) {
		webClient.getOptions().setRedirectEnabled(follow);
	}


	/**
	 * Validate URL to Ex: if url not start with http:// this metgod inject missing value to url
	 * @param urlData
	 * @param title
	 * @param url
	 * @param urlHost
	 * @param downloadPath
	 * @return
	 */
	public URLData getValidURL(URLData urlData, String title , String url, String urlHost, String downloadPath) {

	
			if (url.startsWith("http")) {
				urlData.setAnchorTitle(
						title.replace("\n", "").replace("\r", "").replaceAll(System.lineSeparator(), "")
								.replaceAll("\\s+", " ").replaceAll("(?i)<br[^>]*>", " ").trim());
				urlData.setAnchor(url);

				if (urlData.getAnchor().contains(".pdf") || urlData.getAnchor().contains(".PDF")) {

					urlData=Downloader.downlaodPDF(urlData,downloadPath, urlData.getAnchor());
				}

			} else if (url.startsWith("www.")) {
				urlData.setAnchorTitle(
						title.replace("\n", "").replace("\r", "").replaceAll(System.lineSeparator(), "")
								.replaceAll("\\s+", " ").replaceAll("(?i)<br[^>]*>", " ").trim());
				urlData.setAnchor("http://" + url);

				if (urlData.getAnchor().contains(".pdf") || urlData.getAnchor().contains(".PDF")) {

					urlData=Downloader.downlaodPDF(urlData,downloadPath, urlData.getAnchor());
				}

			} else {
				urlData.setAnchorTitle(
						title.replace("\n", "").replace("\r", "").replaceAll(System.lineSeparator(), "")
								.replaceAll("\\s+", " ").replaceAll("(?i)<br[^>]*>", " ").trim());

				if (url.startsWith("/")) {
					urlData.setAnchor("http://" +urlHost + url);
				} else {
					urlData.setAnchor("http://" +urlHost + "/" + url);
				}

				if (urlData.getAnchor().contains(".pdf") || urlData.getAnchor().contains(".PDF")) {
                    
                    
                    urlData=Downloader.downlaodPDF(urlData,downloadPath, urlData.getAnchor());
				}

			}
		
		return urlData;
	}

	@Override
	public void checkUrl(String url,String statusFilePath,String downloadPath) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		URLData urlData = new URLData();

		try {

			if (url.startsWith("www.")) {
				String urlSt = "http://" + url;
				url = urlSt;
			}

			UrlUtils urlValidation = new UrlUtils(url);

			if (!urlValidation.isValid()) {

			} else {
				urlData.setParentURL(url);
				HtmlPage page = null;

				if ((page = webClient.getPage(url)) instanceof HtmlPage) {
					DomNodeList<DomElement> elements = page.getElementsByTagName("a");
					
					for (DomElement domElement : elements) {
						
						System.out.println(domElement.asText() + "\t" + domElement.getAttribute("href"));
			
						URLData data = getValidURL(urlData, domElement.asText() , domElement.getAttribute("href"), urlValidation.getHost(),downloadPath);

						WriteOperations.writeURLData(statusFilePath, data);

					}
				}

			}
		} catch (Exception ex) {
			LOGGER.error("", ex);
		}
	}

	@Override
	public void closeConnection() {
		webClient.close();
	}



}
