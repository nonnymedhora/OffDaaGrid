package com.bawaweb.model;

import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlMultiQuestionsImpl extends EntityImpl {
    public static final int QMQID = 0;
    public static final int QMQQSTID = 1;
    public static final int QMQNUMBER = 2;
    public static final int QMQTYPE = 3;
    public static final int QMQHINT = 4;
    public static final int QMQANSID = 5;
    public static final int QMQTLYID = 6;
    public static final int QMQPOINTSPREAD = 7;
    public static final int QMQRASID = 8;
    public static final int ROWID = 9;
    private static OtlMultiQuestionsDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlMultiQuestionsImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlMultiQuestionsDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlMultiQuestions");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for QmqId, using the alias name QmqId
     */
    public Number getQmqId() {
        return (Number)getAttributeInternal(QMQID);
    }

    /**Sets <code>value</code> as the attribute value for QmqId
     */
    public void setQmqId(Number value) {
        setAttributeInternal(QMQID, value);
    }

    /**Gets the attribute value for QmqQstId, using the alias name QmqQstId
     */
    public Number getQmqQstId() {
        return (Number)getAttributeInternal(QMQQSTID);
    }

    /**Sets <code>value</code> as the attribute value for QmqQstId
     */
    public void setQmqQstId(Number value) {
        setAttributeInternal(QMQQSTID, value);
    }

    /**Gets the attribute value for QmqNumber, using the alias name QmqNumber
     */
    public String getQmqNumber() {
        return (String)getAttributeInternal(QMQNUMBER);
    }

    /**Sets <code>value</code> as the attribute value for QmqNumber
     */
    public void setQmqNumber(String value) {
        setAttributeInternal(QMQNUMBER, value);
    }

    /**Gets the attribute value for QmqType, using the alias name QmqType
     */
    public String getQmqType() {
        return (String)getAttributeInternal(QMQTYPE);
    }

    /**Sets <code>value</code> as the attribute value for QmqType
     */
    public void setQmqType(String value) {
        setAttributeInternal(QMQTYPE, value);
    }

    /**Gets the attribute value for QmqHint, using the alias name QmqHint
     */
    public String getQmqHint() {
        return (String)getAttributeInternal(QMQHINT);
    }

    /**Sets <code>value</code> as the attribute value for QmqHint
     */
    public void setQmqHint(String value) {
        setAttributeInternal(QMQHINT, value);
    }

    /**Gets the attribute value for QmqAnsId, using the alias name QmqAnsId
     */
    public Number getQmqAnsId() {
        return (Number)getAttributeInternal(QMQANSID);
    }

    /**Sets <code>value</code> as the attribute value for QmqAnsId
     */
    public void setQmqAnsId(Number value) {
        setAttributeInternal(QMQANSID, value);
    }

    /**Gets the attribute value for QmqTlyId, using the alias name QmqTlyId
     */
    public Number getQmqTlyId() {
        return (Number)getAttributeInternal(QMQTLYID);
    }

    /**Sets <code>value</code> as the attribute value for QmqTlyId
     */
    public void setQmqTlyId(Number value) {
        setAttributeInternal(QMQTLYID, value);
    }

    /**Gets the attribute value for QmqPointSpread, using the alias name QmqPointSpread
     */
    public Number getQmqPointSpread() {
        return (Number)getAttributeInternal(QMQPOINTSPREAD);
    }

    /**Sets <code>value</code> as the attribute value for QmqPointSpread
     */
    public void setQmqPointSpread(Number value) {
        setAttributeInternal(QMQPOINTSPREAD, value);
    }

    /**Gets the attribute value for QmqRasId, using the alias name QmqRasId
     */
    public Number getQmqRasId() {
        return (Number)getAttributeInternal(QMQRASID);
    }

    /**Sets <code>value</code> as the attribute value for QmqRasId
     */
    public void setQmqRasId(Number value) {
        setAttributeInternal(QMQRASID, value);
    }

    /**Gets the attribute value for RowID, using the alias name RowID
     */
    public RowID getRowID() {
        return (RowID)getAttributeInternal(ROWID);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case QMQID:
            return getQmqId();
        case QMQQSTID:
            return getQmqQstId();
        case QMQNUMBER:
            return getQmqNumber();
        case QMQTYPE:
            return getQmqType();
        case QMQHINT:
            return getQmqHint();
        case QMQANSID:
            return getQmqAnsId();
        case QMQTLYID:
            return getQmqTlyId();
        case QMQPOINTSPREAD:
            return getQmqPointSpread();
        case QMQRASID:
            return getQmqRasId();
        case ROWID:
            return getRowID();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case QMQID:
            setQmqId((Number)value);
            return;
        case QMQQSTID:
            setQmqQstId((Number)value);
            return;
        case QMQNUMBER:
            setQmqNumber((String)value);
            return;
        case QMQTYPE:
            setQmqType((String)value);
            return;
        case QMQHINT:
            setQmqHint((String)value);
            return;
        case QMQANSID:
            setQmqAnsId((Number)value);
            return;
        case QMQTLYID:
            setQmqTlyId((Number)value);
            return;
        case QMQPOINTSPREAD:
            setQmqPointSpread((Number)value);
            return;
        case QMQRASID:
            setQmqRasId((Number)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
