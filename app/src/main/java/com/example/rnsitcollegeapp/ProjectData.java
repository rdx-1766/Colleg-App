package com.example.rnsitcollegeapp;

public class ProjectData {
    private String pdes,pdeveloper,pdfUrl,plink,ptitle;

    public ProjectData(){}

    public ProjectData(String pdes, String pdeveloper, String pdfUrl, String plink, String ptitle) {
        this.pdes = pdes;
        this.pdeveloper = pdeveloper;
        this.pdfUrl = pdfUrl;
        this.plink = plink;
        this.ptitle = ptitle;
    }

    public String getPdes() {
        return pdes;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

    public String getPdeveloper() {
        return pdeveloper;
    }

    public void setPdeveloper(String pdeveloper) {
        this.pdeveloper = pdeveloper;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPlink() {
        return plink;
    }

    public void setPlink(String plink) {
        this.plink = plink;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }
}
