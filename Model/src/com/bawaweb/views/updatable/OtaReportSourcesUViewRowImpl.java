package com.bawaweb.views.updatable;

import com.bawaweb.model.OtlReportSourcesImpl;

import com.bawaweb.views.updatable.common.OtlReportSourcesUViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportSourcesUViewRowImpl extends ViewRowImpl implements OtlReportSourcesUViewRow {
    public static final int RPSID = 0;
    public static final int RPSSRCID = 1;
    public static final int RPSRPRTID = 2;
    public static final int RPSRPTRID = 3;
    public static final int RPSCOMPEDYN = 4;
    public static final int RPSREPEATSOURCEYN = 5;
    public static final int RPSDELETEYN = 6;
    public static final int BaWaWEBSOURCEANSWERSUVIEW = 7;
    public static final int BaWaWEBSOURCESORTINGCRITERIAUVIEW = 8;

    /**This is the default constructor (do not remove)
     */
    public OtlReportSourcesUViewRowImpl() {
    }

    /**Gets OtlReportSources entity object.
     */
    public OtlReportSourcesImpl getOtlReportSources() {
        return (OtlReportSourcesImpl)getEntity(0);
    }

    /**Gets the attribute value for RPS_ID using the alias name RpsId
     */
    public Number getRpsId() {
        return (Number) getAttributeInternal(RPSID);
    }

    /**Sets <code>value</code> as attribute value for RPS_ID using the alias name RpsId
     */
    public void setRpsId(Number value) {
        setAttributeInternal(RPSID, value);
    }

    /**Gets the attribute value for RPS_SRC_ID using the alias name RpsSrcId
     */
    public Number getRpsSrcId() {
        return (Number) getAttributeInternal(RPSSRCID);
    }

    /**Sets <code>value</code> as attribute value for RPS_SRC_ID using the alias name RpsSrcId
     */
    public void setRpsSrcId(Number value) {
        setAttributeInternal(RPSSRCID, value);
    }

    /**Gets the attribute value for RPS_RPRT_ID using the alias name RpsRprtId
     */
    public Number getRpsRprtId() {
        return (Number) getAttributeInternal(RPSRPRTID);
    }

    /**Sets <code>value</code> as attribute value for RPS_RPRT_ID using the alias name RpsRprtId
     */
    public void setRpsRprtId(Number value) {
        setAttributeInternal(RPSRPRTID, value);
    }

    /**Gets the attribute value for RPS_RPTR_ID using the alias name RpsRptrId
     */
    public Number getRpsRptrId() {
        return (Number) getAttributeInternal(RPSRPTRID);
    }

    /**Sets <code>value</code> as attribute value for RPS_RPTR_ID using the alias name RpsRptrId
     */
    public void setRpsRptrId(Number value) {
        setAttributeInternal(RPSRPTRID, value);
    }

    /**Gets the attribute value for RPS_COMPED_YN using the alias name RpsCompedYn
     */
    public String getRpsCompedYn() {
        return (String) getAttributeInternal(RPSCOMPEDYN);
    }

    /**Sets <code>value</code> as attribute value for RPS_COMPED_YN using the alias name RpsCompedYn
     */
    public void setRpsCompedYn(String value) {
        setAttributeInternal(RPSCOMPEDYN, value);
    }

    /**Gets the attribute value for RPS_REPEAT_SOURCE_YN using the alias name RpsRepeatSourceYn
     */
    public String getRpsRepeatSourceYn() {
        return (String) getAttributeInternal(RPSREPEATSOURCEYN);
    }

    /**Sets <code>value</code> as attribute value for RPS_REPEAT_SOURCE_YN using the alias name RpsRepeatSourceYn
     */
    public void setRpsRepeatSourceYn(String value) {
        setAttributeInternal(RPSREPEATSOURCEYN, value);
    }

    /**Gets the attribute value for RPS_DELETE_YN using the alias name RpsDeleteYn
     */
    public String getRpsDeleteYn() {
        return (String) getAttributeInternal(RPSDELETEYN);
    }

    /**Sets <code>value</code> as attribute value for RPS_DELETE_YN using the alias name RpsDeleteYn
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
        case BaWaWEBSOURCESORTINGCRITERIAUVIEW:
            return getOtlSourceSortingCriteriaUView();
        case BaWaWEBSOURCEANSWERSUVIEW:
            return getOtlSourceAnswersUView();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RPSID:
            setRpsId((Number)value);
            return;
        case RPSSRCID:
            setRpsSrcId((Number)value);
            return;
        case RPSRPRTID:
            setRpsRprtId((Number)value);
            return;
        case RPSRPTRID:
            setRpsRptrId((Number)value);
            return;
        case RPSCOMPEDYN:
            setRpsCompedYn((String)value);
            return;
        case RPSREPEATSOURCEYN:
            setRpsRepeatSourceYn((String)value);
            return;
        case RPSDELETEYN:
            setRpsDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSourceAnswersUView
     */
    public RowIterator getOtlSourceAnswersUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCEANSWERSUVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSourceSortingCriteriaUView
     */
    public RowIterator getOtlSourceSortingCriteriaUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCESORTINGCRITERIAUVIEW);
    }
}
