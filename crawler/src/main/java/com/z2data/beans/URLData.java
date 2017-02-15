/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z2data.beans;


/**
 *
 * @author salah.atwa
 */
public class URLData {
    
    private String parentURL;
    private String anchor;
    private String anchorTitle;
    private String downloadStatus="";
    private String downloadPath="";

    /**
     * @return the parentURL
     */
    public String getParentURL() {
        return parentURL;
    }

    /**
     * @param parentURL the parentURL to set
     */
    public void setParentURL(String parentURL) {
        this.parentURL = parentURL;
    }

    /**
     * @return the anchor
     */
    public String getAnchor() {
        return anchor;
    }

    /**
     * @param anchor the anchor to set
     */
    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    /**
     * @return the anchorTitle
     */
    public String getAnchorTitle() {
        return anchorTitle;
    }

    /**
     * @param anchorTitle the anchorTitle to set
     */
    public void setAnchorTitle(String anchorTitle) {
        this.anchorTitle = anchorTitle;
    }

    /**
     * @return the downloadStatus
     */
    public String getDownloadStatus() {
        return downloadStatus;
    }

    /**
     * @param downloadStatus the downloadStatus to set
     */
    public void setDownloadStatus(String downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    /**
     * @return the downloadPath
     */
    public String getDownloadPath() {
        return downloadPath;
    }

    /**
     * @param downloadPath the downloadPath to set
     */
    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
    

  

}
