package com.learning.selenium.model;

import java.util.Objects;

public class ComputeEngine {

    private String numberOfInstances;
    private String whatAreInstances;
    private String provisioningModel;
    private String machineType;
    private String operatingSystem;
    private String series;
    private String gpuType;
    private String numberOfGpus;
    private String localSsd;
    private String dataCenterLocation;
    private String commitedUsage;

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public ComputeEngine withNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
        return this;
    }

    public String getWhatAreInstances() {
        return whatAreInstances;
    }

    public ComputeEngine withWhatAreInstances(String whatAreInstances) {
        this.whatAreInstances = whatAreInstances;
        return this;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public ComputeEngine withProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
        return this;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public ComputeEngine withOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    public String getSeries() {
        return series;
    }

    public ComputeEngine withSeries(String series) {
        this.series = series;
        return this;
    }

    public String getMachineType() {
        return machineType;
    }

    public ComputeEngine withMachineType(String machineType) {
        this.machineType = machineType;
        return this;
    }

    public String getGpuType() {
        return gpuType;
    }

    public ComputeEngine withGpuType(String gpuType) {
        this.gpuType = gpuType;
        return this;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public ComputeEngine withNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
        return this;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public ComputeEngine withLocalSsd(String localSsd) {
        this.localSsd = localSsd;
        return this;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public ComputeEngine withDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
        return this;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public ComputeEngine withCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) && Objects.equals(whatAreInstances, that.whatAreInstances) && Objects.equals(operatingSystem, that.operatingSystem) && Objects.equals(machineType, that.machineType) && Objects.equals(series, that.series) && Objects.equals(machineType, that.machineType) && Objects.equals(gpuType, that.gpuType) && Objects.equals(numberOfGpus, that.numberOfGpus) && Objects.equals(localSsd, that.localSsd) && Objects.equals(dataCenterLocation, that.dataCenterLocation) && Objects.equals(commitedUsage, that.commitedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, whatAreInstances, operatingSystem, machineType, series, machineType, gpuType, numberOfGpus, localSsd, dataCenterLocation, commitedUsage);
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", whatAreInstances='" + whatAreInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineType + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGpus='" + numberOfGpus + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }
}
