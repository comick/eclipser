package com.kukido.eclipser;

import org.jetbrains.annotations.NonNls;

public interface EclipserXml {

    @NonNls String LAUNCH_EXT = "launch";
    @NonNls String TYPE = "type";
    @NonNls String KEY = "key";
    @NonNls String VALUE = "value";
    @NonNls String MAIN_TYPE_KEY = "org.eclipse.jdt.launching.MAIN_TYPE";
    @NonNls String PROJECT_ATTR_KEY = "org.eclipse.jdt.launching.PROJECT_ATTR";
    @NonNls String VM_ARGUMENTS_KEY = "org.eclipse.jdt.launching.VM_ARGUMENTS";
    @NonNls String PROGRAM_ARGUMENTS_KEY = "org.eclipse.jdt.launching.PROGRAM_ARGUMENTS";
    @NonNls String ATTR_LOCATION_KEY = "org.eclipse.ui.externaltools.ATTR_LOCATION";
    @NonNls String ATTR_TOOL_ARGUMENTS_KEY = "org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS";
    @NonNls String ATTR_WORKING_DIRECTORY_KEY = "org.eclipse.ui.externaltools.ATTR_WORKING_DIRECTORY";
    @NonNls String ATTR_CLASSPATH_KEY = "org.eclipse.jdt.launching.CLASSPATH";
    @NonNls String ATTR_DEFAULT_CLASSPATH_KEY = "org.eclipse.jdt.launching.DEFAULT_CLASSPATH";
    @NonNls String ATTR_MAPPED_RESOURCE_TYPES_KEY = "org.eclipse.debug.core.MAPPED_RESOURCE_TYPES";
    @NonNls String ATTR_MAPPED_RESOURCE_PATHS_KEY = "org.eclipse.debug.core.MAPPED_RESOURCE_PATHS";
    @NonNls String ATTR_APPLET_HEIGHT_KEY = "org.eclipse.jdt.launching.APPLET_HEIGHT";
    @NonNls String ATTR_APPLET_WIDTH_KEY = "org.eclipse.jdt.launching.APPLET_WIDTH";
    @NonNls String ATTR_APPLET_NAME_KEY = "org.eclipse.jdt.launching.APPLET_NAME";
    @NonNls String ATTR_APPLET_PARAMETERS_KEY = "org.eclipse.jdt.launching.APPLET_PARAMETERS";

    // attribute type
    @NonNls String LIST_ATTRIBUTE = "listAttribute";
    @NonNls String MAP_ATTRIBUTE = "mapAttribute";
    @NonNls String STRING_ATTRIBUTE = "stringAttribute";
    @NonNls String INT_ATTRIBUTE = "intAttribute";
    @NonNls String BOOLEAN_ATTRIBUTE = "booleanAttribute";

    // configuration type
    @NonNls String CONFIGURATION_TYPE_ANT                       = "org.eclipse.ant.AntLaunchConfigurationType";
    @NonNls String CONFIGURATION_TYPE_JUNIT                     = "org.eclipse.jdt.junit.launchconfig";
    @NonNls String CONFIGURATION_TYPE_LOCAL_JAVA_APPLICATION    = "org.eclipse.jdt.launching.localJavaApplication";
    @NonNls String CONFIGURATION_TYPE_PROGRAM_LAUNCH            = "org.eclipse.ui.externaltools.ProgramLaunchConfigurationType";
    @NonNls String CONFIGURATION_TYPE_JAVA_APPLET               = "org.eclipse.jdt.launching.javaApplet";

}
