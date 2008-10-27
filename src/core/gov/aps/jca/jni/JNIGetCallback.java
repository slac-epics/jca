/**********************************************************************
 *
 *      Original Author: Eric Boucher
 *      Date:            05/05/2003
 *
 *      Experimental Physics and Industrial Control System (EPICS)
 *
 *      Copyright 1991, the University of Chicago Board of Governors.
 *
 *      This software was produced under  U.S. Government contract
 *      W-31-109-ENG-38 at Argonne National Laboratory.
 *
 *      Beamline Controls & Data Acquisition Group
 *      Experimental Facilities Division
 *      Advanced Photon Source
 *      Argonne National Laboratory
 *
 *
 * $Id: JNIGetCallback.java,v 1.3 2006-11-03 11:01:47 msekoranja Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */


package gov.aps.jca.jni;

import gov.aps.jca.event.*;
import gov.aps.jca.*;
import gov.aps.jca.dbr.*;


class JNIGetCallback extends JNICallback {
  protected JNIChannel _source;

  JNIGetCallback(JNIChannel source, EventDispatcher dispatcher, GetListener listener) {
    super(dispatcher, listener);
    _source= source;
  }
  public void fire(int type, int count, long dbrid, int status) {
    DBR dbr= DBRFactory.create(type,count);
    JNI.dbr_update(dbr,dbrid);
    dispatch(new GetEvent(_source, dbr, CAStatus.forValue(status)));
  }
}

