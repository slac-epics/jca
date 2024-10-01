package gov.aps.jca.jni;

/**
 * <p>Title: JCA2</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Erix Boucher
 * @version 1.0
 */

import java.text.*;

public class JNITargetArch {
  static public String getTargetArch() {

    String osname=System.getProperty( "os.name", "" );
    String osversionstring=System.getProperty( "os.version", "" );
    float osversion=0;

    try {
      osversion=NumberFormat.getInstance().parse( osversionstring ).floatValue();
    } catch( ParseException pe ) {
    }
    String osarch=System.getProperty( "os.arch", "" );

    if( osarch.equals( "i386" )||osarch.equals( "i486" )||osarch.equals( "i586" ) ) {
      osarch="x86";
    }

    if( osname.equals( "SunOS" ) ) {
      if( osversion>=5 ) {
        if( osarch.equals( "sparc" ) ) {
          return "solaris-sparc";
        } else if( osarch.equals( "x86" ) ) {
          return "solaris-x86";
        }
      }
    } else if ( osname.equals("Mac OS X") ) {
      if ( osarch.equals("ppc") ) {
        return "darwin-ppc";
      } else if (osarch.equals("x86") ) {
        return "darwin-x86";
      }
    } else if( osname.equals( "Linux" ) ) {
      String archName = "linux";
      if ( osversionstring.contains(".el9") ) {
        archName = "rhel9";
      }
      if ( osversionstring.contains(".el8") ) {
        archName = "rhel8";
      }
      if ( osversionstring.contains(".el7.") ) {
        archName = "rhel7";
      }
      if ( osversionstring.contains(".el6.") ) {
        archName = "rhel6";
      }
      if( osarch.equals( "x86" ) ) {
        return archName + "-x86";
      }
      else if ( osarch.equals("x86_64") || osarch.equals("amd64")) {
        return archName + "-x86_64";
      }
    } else if( osname.startsWith( "Win" ) ) {
      return "win32-x86";
    }
    return "unknown";
  }
}
