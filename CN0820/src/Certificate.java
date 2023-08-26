public abstract class Certificate {
    String certificatedID;
    String certificateName;
    String certificateRank;
    int certificatedDate;
    public Certificate(String certificatedID, String certificateName, String certificateRank, int certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }
    public Certificate() {

    }

    public String getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public int getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(int certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    public String toString() {
        return "Certificate{" + "Mã chứng chỉ : '" + certificatedID + '\'' + "- Tên chứng chỉ'" + certificateName + '\'' + "- Xếp loại :'" + certificateRank + '\'' + "- Ngày cấp chứng chỉ : " + certificatedDate + '}';
    }
}
