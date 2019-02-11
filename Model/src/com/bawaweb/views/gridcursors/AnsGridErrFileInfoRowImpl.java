package com.bawaweb.views.gridcursors;

import com.bawaweb.model.AnsGridErrorFileImpl;

import com.bawaweb.views.gridcursors.common.AnsGridErrFileInfoRow;

import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AnsGridErrFileInfoRowImpl extends ViewRowImpl implements AnsGridErrFileInfoRow {
    public static final int AGEFID = 0;
    public static final int AGEFFILENAME = 1;
    public static final int AGEFFILEFORMATTYPE = 2;
    public static final int AGEFRPRTID = 3;
    public static final int CREATIONDATE = 4;
    public static final int CREATEDBY = 5;
    public static final int AGEFFILE = 6;

    /**This is the default constructor (do not remove)
     */
    public AnsGridErrFileInfoRowImpl() {
    }

    /**Gets AnsGridErrorFile entity object.
     */
    public AnsGridErrorFileImpl getAnsGridErrorFile() {
        return (AnsGridErrorFileImpl)getEntity(0);
    }

    /**Gets the attribute value for AGEF_ID using the alias name AgefId
     */
    public Number getAgefId() {
        return (Number) getAttributeInternal(AGEFID);
    }

    /**Sets <code>value</code> as attribute value for AGEF_ID using the alias name AgefId
     */
    public void setAgefId(Number value) {
        setAttributeInternal(AGEFID, value);
    }

    /**Gets the attribute value for AGEF_FILE_NAME using the alias name AgefFileName
     */
    public String getAgefFileName() {
        return (String) getAttributeInternal(AGEFFILENAME);
    }

    /**Sets <code>value</code> as attribute value for AGEF_FILE_NAME using the alias name AgefFileName
     */
    public void setAgefFileName(String value) {
        setAttributeInternal(AGEFFILENAME, value);
    }

    /**Gets the attribute value for AGEF_FILE_FORMAT_TYPE using the alias name AgefFileFormatType
     */
    public String getAgefFileFormatType() {
        return (String) getAttributeInternal(AGEFFILEFORMATTYPE);
    }

    /**Sets <code>value</code> as attribute value for AGEF_FILE_FORMAT_TYPE using the alias name AgefFileFormatType
     */
    public void setAgefFileFormatType(String value) {
        setAttributeInternal(AGEFFILEFORMATTYPE, value);
    }

    /**Gets the attribute value for AGEF_RPRT_ID using the alias name AgefRprtId
     */
    public Number getAgefRprtId() {
        return (Number) getAttributeInternal(AGEFRPRTID);
    }

    /**Sets <code>value</code> as attribute value for AGEF_RPRT_ID using the alias name AgefRprtId
     */
    public void setAgefRprtId(Number value) {
        setAttributeInternal(AGEFRPRTID, value);
    }

    /**Gets the attribute value for CREATION_DATE using the alias name CreationDate
     */
    public Date getCreationDate() {
        return (Date) getAttributeInternal(CREATIONDATE);
    }

    /**Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**Gets the attribute value for CREATED_BY using the alias name CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**Gets the attribute value for AGEF_FILE using the alias name AgefFile
     */
    public BlobDomain getAgefFile() {
        return (BlobDomain) getAttributeInternal(AGEFFILE);
    }

    /**Sets <code>value</code> as attribute value for AGEF_FILE using the alias name AgefFile
     */
    public void setAgefFile(BlobDomain value) {
        setAttributeInternal(AGEFFILE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case AGEFID:
            return getAgefId();
        case AGEFFILENAME:
            return getAgefFileName();
        case AGEFFILEFORMATTYPE:
            return getAgefFileFormatType();
        case AGEFRPRTID:
            return getAgefRprtId();
        case CREATIONDATE:
            return getCreationDate();
        case CREATEDBY:
            return getCreatedBy();
        case AGEFFILE:
            return getAgefFile();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case AGEFID:
            setAgefId((Number)value);
            return;
        case AGEFFILENAME:
            setAgefFileName((String)value);
            return;
        case AGEFFILEFORMATTYPE:
            setAgefFileFormatType((String)value);
            return;
        case AGEFRPRTID:
            setAgefRprtId((Number)value);
            return;
        case CREATIONDATE:
            setCreationDate((Date)value);
            return;
        case CREATEDBY:
            setCreatedBy((String)value);
            return;
        case AGEFFILE:
            setAgefFile((BlobDomain)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
