package com.bawaweb.views.identify.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MaxAsvIdRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public MaxAsvIdRowClient() {
    }


    public Number getMaxAsvId() {
        return (Number)getAttribute("MaxAsvId");
    }

    public void setMaxAsvId(Number value) {
        setAttribute("MaxAsvId", value);
    }
}
