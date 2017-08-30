#!/bin/bash
source /afs/slac/g/lcls/epics/setup/go_epics_3.15.5-1.0.bash
export JAVA_HOME=/afs/slac/g/lcls/package/java/jdk1.8.0_144
export PATH=$JAVA_HOME/bin:$PATH
export LD_LIBRARY_PATH=$JAVA_HOME/jre/lib/amd64:$LD_LIBRARY_PATH

# Build with ant
% ant
....

# Install with ant
% ant install
...
