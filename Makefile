#
# Simple front end so we can build jca via "make install"
#

ANT_HOME=$(PACKAGE_SITE_TOP)/ant/apache-ant-1.7.0

install:
	$(ANT_HOME)/bin/ant install

build:
	$(ANT_HOME)/bin/ant

clean:
	$(ANT_HOME)/bin/ant clean

