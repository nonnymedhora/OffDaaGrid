package com.bawaweb.views.identify.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class GetErrXLFileInfoRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public GetErrXLFileInfoRowClient() {
    }


    public BlobDomain getAgefFile() {
        return (BlobDomain)getAttribute("AgefFile");
    }

    public String getAgefFileFormatType() {
        return (String)getAttribute("AgefFileFormatType");
    }

    public String getAgefFileName() {
        return (String)getAttribute("AgefFileName");
    }

    public Number getAgefId() {
        return (Number)getAttribute("AgefId");
    }

    public Number getAgefRprtId() {
        return (Number)getAttribute("AgefRprtId");
    }

    public String getCreatedBy() {
        return (String)getAttribute("CreatedBy");
    }

    public Date getCreationDate() {
        return (Date)getAttribute("CreationDate");
    }

    public void setAgefFile(BlobDomain value) {
        setAttribute("AgefFile", value);
    }

    public void setAgefFileFormatType(String value) {
        setAttribute("AgefFileFormatType", value);
    }

    public void setAgefFileName(String value) {
        setAttribute("AgefFileName", value);
    }

    public void setAgefId(Number value) {
        setAttribute("AgefId", value);
    }

    public void setAgefRprtId(Number value) {
        setAttribute("AgefRprtId", value);
    }

    public void setCreatedBy(String value) {
        setAttribute("CreatedBy", value);
    }

    public void setCreationDate(Date value) {
        setAttribute("CreationDate", value);
    }
}
