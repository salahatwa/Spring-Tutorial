package com.z2data.crawler;


import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.z2data.browser.Browser;
import com.z2data.browser.HtmlUnit;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	 * 
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
    public static void main( String[] args ) throws InterruptedException
    {
    	try
    	{

    	File file = new File("urls.txt");
		List<String> urls = FileUtils.readLines(file);

		//"http://www.osram-group.com/en/investors/publications/2016"
		for (String url : urls) {
			Browser browser=new HtmlUnit();
	    	browser.checkUrl(url, "Z:\\SW\\salah atwa\\Download PDF\\Crawler4j Result\\status.txt", "Z:\\SW\\salah atwa\\Download PDF\\Crawler4j Result");
			
		}
    	
   

    	}catch(Exception ex){ex.printStackTrace();}
    }
    
    public static void checkMissingURL()
    {
    	try
    	{
    		File file = new File("urls.txt");
    		List<String> urls = FileUtils.readLines(file);
    		
    		File file2 = new File("statusURL.txt");
    		List<String> status = FileUtils.readLines(file2);
    		
    		for (String url : urls) {
				if(!status.contains(url))
				{
					System.out.println(url);
				}
			}
    		
    	}
    	catch(Exception ex){ex.printStackTrace();}
    }
}
