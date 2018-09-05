#!/bin/bash
#source /afs/slac/g/lcls/epics/setup/go_epics_3.15.5-1.0.bash
export JAVA_HOME=$PACKAGE_TOP/java/jdk1.8.0_181
export ANT_HOME=$PACKAGE_TOP/ant/apache-ant-1.7.0
export PATH=$JAVA_HOME/bin:$ANT_HOME/bin:$PATH
export LD_LIBRARY_PATH=$JAVA_HOME/jre/lib/amd64:$ANT_HOME/lib:$LD_LIBRARY_PATH

# Build with ant
#% ant
#....

# Install with ant
#% ant install
#...
