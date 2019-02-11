package com.bawaweb.views.updatable;

import com.bawaweb.model.FridFirmIndustriesImpl;

import com.bawaweb.views.updatable.common.FridFirmIndustriesUViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FridFirmIndustriesUViewRowImpl extends ViewRowImpl implements FridFirmIndustriesUViewRow {
    public static final int FRIDID = 0;
    public static final int FRIDDESCRIPTION = 1;
    public static final int FRIDPROPCAPACITY = 2;
    public static final int BaWaWEBANSWERSETSUVIEW = 3;
    public static final int BaWaWEBREPORTANSWERSETSUVIEW = 4;
    public static final int BaWaWEBSORTINGCRITERIAUVIEW = 5;
    public static final int PANPANELUVIEW = 6;
    public static final int RPRTREPORTSUVIEW = 7;

    /**This is the default constructor (do not remove)
     */
    public FridFirmIndustriesUViewRowImpl() {
    }

    /**Gets FridFirmIndustries entity object.
     */
    public FridFirmIndustriesImpl getFridFirmIndustries() {
        return (FridFirmIndustriesImpl)getEntity(0);
    }

    /**Gets the attribute value for FRID_ID using the alias name FridId
     */
    public Number getFridId() {
        return (Number) getAttributeInternal(FRIDID);
    }

    /**Sets <code>value</code> as attribute value for FRID_ID using the alias name FridId
     */
    public void setFridId(Number value) {
        setAttributeInternal(FRIDID, value);
    }

    /**Gets the attribute value for FRID_DESCRIPTION using the alias name FridDescription
     */
    public String getFridDescription() {
        return (String) getAttributeInternal(FRIDDESCRIPTION);
    }

    /**Sets <code>value</code> as attribute value for FRID_DESCRIPTION using the alias name FridDescription
     */
    public void setFridDescription(String value) {
        setAttributeInternal(FRIDDESCRIPTION, value);
    }

    /**Gets the attribute value for FRID_PROP_CAPACITY using the alias name FridPropCapacity
     */
    public String getFridPropCapacity() {
        return (String) getAttributeInternal(FRIDPROPCAPACITY);
    }

    /**Sets <code>value</code> as attribute value for FRID_PROP_CAPACITY using the alias name FridPropCapacity
     */
    public void setFridPropCapacity(String value) {
        setAttributeInternal(FRIDPROPCAPACITY, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case FRIDID:
            return getFridId();
        case FRIDDESCRIPTION:
            return getFridDescription();
        case FRIDPROPCAPACITY:
            return getFridPropCapacity();
        case BaWaWEBANSWERSETSUVIEW:
            return getOtlAnswerSetsUView();
        case BaWaWEBREPORTANSWERSETSUVIEW:
            return getOtlReportAnswerSetsUView();
        case BaWaWEBSORTINGCRITERIAUVIEW:
            return getOtlSortingCriteriaUView();
        case PANPANELUVIEW:
            return getPanPanelUView();
        case RPRTREPORTSUVIEW:
            return getRprtReportsUView();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case FRIDID:
            setFridId((Number)value);
            return;
        case FRIDDESCRIPTION:
            setFridDescription((String)value);
            return;
        case FRIDPROPCAPACITY:
            setFridPropCapacity((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlAnswerSetsUView
     */
    public RowIterator getOtlAnswerSetsUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBANSWERSETSUVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlReportAnswerSetsUView
     */
    public RowIterator getOtlReportAnswerSetsUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBREPORTANSWERSETSUVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSortingCriteriaUView
     */
    public RowIterator getOtlSortingCriteriaUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSORTINGCRITERIAUVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link PanPanelUView
     */
    public RowIterator getPanPanelUView() {
        return (RowIterator)getAttributeInternal(PANPANELUVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link RprtReportsUView
     */
    public RowIterator getRprtReportsUView() {
        return (RowIterator)getAttributeInternal(RPRTREPORTSUVIEW);
    }
}