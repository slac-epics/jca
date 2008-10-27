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
 * $Id: DBR_TIME_Byte.java,v 1.3 2006-08-30 17:25:08 msekoranja Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import gov.aps.jca.CAStatusException;

import java.io.*;

public class DBR_TIME_Byte extends DBR_STS_Byte implements TIME {
  public static final DBRType TYPE= new DBRType("DBR_TIME_BYTE",  18, DBR_TIME_Byte.class);
  
  protected TimeStamp _stamp;

  public DBR_TIME_Byte() {

    this( 1 );

  }

  public DBR_TIME_Byte( int count ) {

    this( new byte[count] );

  }

  public DBR_TIME_Byte( byte[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public TimeStamp getTimeStamp() {
    return _stamp;
  }

  public void setTimeStamp( TimeStamp stamp ) {
    _stamp=stamp;
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    if (!isGR())
    	out.println( "TIME     : "+getTimeStamp().toMMDDYY() );

  }

	/**
	 * @see gov.aps.jca.dbr.DBR_Byte#convert(gov.aps.jca.dbr.DBRType)
	 */
	public DBR convert(DBRType convertType) throws CAStatusException {
		DBR dbr = super.convert(convertType);

		if (dbr.isTIME())
			((TIME)dbr).setTimeStamp(_stamp);
			
		return dbr;
	}

}
