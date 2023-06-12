package com.example.rnsitcollegeapp;

public class ProjectData {
    private String demo,features,future,lang,pdes,pdeveloper,pdfUrl,plink,ps,ptitle;

    public ProjectData(){}

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public ProjectData(String demo, String features, String future, String lang, String pdes, String pdeveloper, String pdfUrl, String plink, String ptitle) {
        this.demo = demo;
        this.features = features;
        this.future = future;
        this.lang = lang;
        this.pdes = pdes;
        this.pdeveloper = pdeveloper;
        this.pdfUrl = pdfUrl;
        this.plink = plink;
        this.ptitle = ptitle;
        this.ps = ps;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
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
