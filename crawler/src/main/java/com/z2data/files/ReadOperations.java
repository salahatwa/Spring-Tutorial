/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z2data.files;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author salah.atwa
 */
public class ReadOperations {

    /**
     * read file line by line
     * @param filePath
     * @return list of lines
     */
    public static List<String> readList(String filePath) 
    {

        List<String> lines=null;
        try
        {
          File file = new File(filePath);
          lines = FileUtils.readLines(file);

          return lines;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
      return lines;
    }

}
