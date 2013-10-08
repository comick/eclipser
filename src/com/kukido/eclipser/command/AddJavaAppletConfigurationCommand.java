package com.kukido.eclipser.command;

import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.applet.AppletConfiguration;
import com.intellij.execution.application.ApplicationConfiguration;
import com.intellij.execution.impl.RunManagerImpl;
import com.intellij.execution.impl.RunnerAndConfigurationSettingsImpl;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.kukido.eclipser.EclipserConfigurationType;
import com.kukido.eclipser.EclipserException;
import com.kukido.eclipser.configuration.JavaAppletConfiguration;

public class AddJavaAppletConfigurationCommand implements Command {

    private JavaAppletConfiguration javaAppletConfiguration;

    public AddJavaAppletConfigurationCommand(final JavaAppletConfiguration conf) {
        this.javaAppletConfiguration = conf;
    }

    @Override
    public void execute(Project project) throws EclipserException {
        createRunConfiguration(project);
    }

    private void createRunConfiguration(final Project project) throws EclipserException {

        String moduleNameOfRunner = javaAppletConfiguration.getModuleName();

        Module module = ModuleManager.getInstance(project).findModuleByName(moduleNameOfRunner);

        if (module == null) {
            String message = "Could not find the module with name '" + moduleNameOfRunner + "'. You can either update Eclipse launch file with the correct name or create a new module.";
            throw new EclipserException(message);
        }

        Application application = ApplicationManager.getApplication();

        AppletConfiguration appletConfiguration;



        RunManagerImpl runManager = (RunManagerImpl) RunManager.getInstance(project);

        RunnerAndConfigurationSettingsImpl runnerAndConfigurationSettings = findConfigurationByName(javaAppletConfiguration.getConfigurationName(), runManager);

        if (runnerAndConfigurationSettings != null) {
            String message = "Runtime configuration with name '" + javaAppletConfiguration.getConfigurationName() + "' already exists. You can either rename it or delete to be replaced.";
			throw new EclipserException(message);
        } else {
            EclipserConfigurationType type = application.getComponent(EclipserConfigurationType.class);
            runnerAndConfigurationSettings = (RunnerAndConfigurationSettingsImpl) runManager.createRunConfiguration(javaAppletConfiguration.getConfigurationName(), type.getConfigurationFactories()[0]);
            appletConfiguration = (AppletConfiguration) runnerAndConfigurationSettings.getConfiguration();
            runManager.addConfiguration(runnerAndConfigurationSettings, true);
        }

        appletConfiguration.setModule(module);
        appletConfiguration.setMainClassName(javaAppletConfiguration.getMainClassName());
        //appletConfiguration.setAppletParameters(javaAppletConfiguration.getProgramParameters());

        runManager.setSelectedConfiguration(runnerAndConfigurationSettings);
    }

    private RunnerAndConfigurationSettingsImpl findConfigurationByName(String name, RunManagerImpl runManager){
        for (RunnerAndConfigurationSettings settings : runManager.getSortedConfigurations()){
            if (settings.getName().equals(name))
                return (RunnerAndConfigurationSettingsImpl) settings;
        }
        return null;
    }
}
