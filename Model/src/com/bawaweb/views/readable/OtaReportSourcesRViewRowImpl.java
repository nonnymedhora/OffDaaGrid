package com.bawaweb.views.readable;

import com.bawaweb.model.OtlReportSourcesImpl;

import com.bawaweb.views.readable.common.OtlReportSourcesRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportSourcesRViewRowImpl extends ViewRowImpl implements OtlReportSourcesRViewRow {
    public static final int RPSID = 0;
    public static final int RPSSRCID = 1;
    public static final int RPSRPRTID = 2;
    public static final int RPSRPTRID = 3;
    public static final int RPSCOMPEDYN = 4;
    public static final int RPSREPEATSOURCEYN = 5;
    public static final int RPSDELETEYN = 6;
    public static final int BaWaWEBSOURCEANSWERSRVIEW = 7;
    public static final int BaWaWEBSOURCESORTINGCRITERIARVIEW = 8;

    /**This is the default constructor (do not remove)
     */
    public OtlReportSourcesRViewRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute RpsId
     */
    public Number getRpsId() {
        return (Number) getAttributeInternal(RPSID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsId
     */
    public void setRpsId(Number value) {
        setAttributeInternal(RPSID, value);
    }

    /**Gets the attribute value for the calculated attribute RpsSrcId
     */
    public Number getRpsSrcId() {
        return (Number) getAttributeInternal(RPSSRCID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsSrcId
     */
    public void setRpsSrcId(Number value) {
        setAttributeInternal(RPSSRCID, value);
    }

    /**Gets the attribute value for the calculated attribute RpsRprtId
     */
    public Number getRpsRprtId() {
        return (Number) getAttributeInternal(RPSRPRTID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsRprtId
     */
    public void setRpsRprtId(Number value) {
        setAttributeInternal(RPSRPRTID, value);
    }

    /**Gets the attribute value for the calculated attribute RpsRptrId
     */
    public Number getRpsRptrId() {
        return (Number) getAttributeInternal(RPSRPTRID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsRptrId
     */
    public void setRpsRptrId(Number value) {
        setAttributeInternal(RPSRPTRID, value);
    }

    /**Gets the attribute value for the calculated attribute RpsCompedYn
     */
    public String getRpsCompedYn() {
        return (String) getAttributeInternal(RPSCOMPEDYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsCompedYn
     */
    public void setRpsCompedYn(String value) {
        setAttributeInternal(RPSCOMPEDYN, value);
    }

    /**Gets the attribute value for the calculated attribute RpsRepeatSourceYn
     */
    public String getRpsRepeatSourceYn() {
        return (String) getAttributeInternal(RPSREPEATSOURCEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsRepeatSourceYn
     */
    public void setRpsRepeatSourceYn(String value) {
        setAttributeInternal(RPSREPEATSOURCEYN, value);
    }

    /**Gets the attribute value for the calculated attribute RpsDeleteYn
     */
    public String getRpsDeleteYn() {
        return (String) getAttributeInternal(RPSDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RpsDeleteYn
     */
    public void setRpsDeleteYn(String value) {
        setAttributeInternal(RPSDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RPSID:
            return getRpsId();
        case RPSSRCID:
            return getRpsSrcId();
        case RPSRPRTID:
            return getRpsRprtId();
        case RPSRPTRID:
            return getRpsRptrId();
        case RPSCOMPEDYN:
            return getRpsCompedYn();
        case RPSREPEATSOURCEYN:
            return getRpsRepeatSourceYn();
        case RPSDELETEYN:
            return getRpsDeleteYn();
        case BaWaWEBSOURCEANSWERSRVIEW:
            return getOtlSourceAnswersRView();
        case BaWaWEBSOURCESORTINGCRITERIARVIEW:
            return getOtlSourceSortingCriteriaRView();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSourceAnswersRView
     */
    public RowIterator getOtlSourceAnswersRView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCEANSWERSRVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSourceSortingCriteriaRView
     */
    public RowIterator getOtlSourceSortingCriteriaRView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCESORTINGCRITERIARVIEW);
    }

    /**Gets OtlReportSources entity object.
     */
    public OtlReportSourcesImpl getOtlReportSources() {
        return (OtlReportSourcesImpl)getEntity(0);
    }
}
