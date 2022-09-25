package com.learning.selenium.testdata;

import com.learning.selenium.model.ComputeEngine;
import com.learning.selenium.utils.TestDataReader;

public class ComputeEngineCreator {

  private static ComputeEngine computeEngine;
  private static String numberOfInstances = "testdata.computeengine.numberOfInstances";
  private static String provisioningModel = "testdata.computeengine.provisioningModel";
  private static String machineType = "testdata.computeengine.machineType";
  private static String operatingSystem = "testdata.computeengine.operatingSystem";
  private static String series = "testdata.computeengine.series";
  private static String gpuType = "testdata.computeengine.gpuType";
  private static String numberOfGpus = "testdata.computeengine.numberOfGpus";
  private static String localSsd = "testdata.computeengine.localSsd";
  private static String dataCenterLocation = "testdata.computeengine.dataCenterLocation";
  private static String commitedUsage = "testdata.computeengine.commitedUsage";
  private static String price = "testdata.computeengine.price";

  public static ComputeEngine getComputeEngineInstanceFromProperty(String propertyName) {
    TestDataReader.readProperty(propertyName);
    computeEngine = new ComputeEngine()
        .withNumberOfInstances(TestDataReader.getFromProperty(numberOfInstances))
        .withProvisioningModel(TestDataReader.getFromProperty(provisioningModel))
        .withMachineType(TestDataReader.getFromProperty(machineType))
        .withOperatingSystem(TestDataReader.getFromProperty(operatingSystem))
        .withSeries(TestDataReader.getFromProperty(series))
        .withGpuType(TestDataReader.getFromProperty(gpuType))
        .withNumberOfGpus(TestDataReader.getFromProperty(numberOfGpus))
        .withLocalSsd(TestDataReader.getFromProperty(localSsd))
        .withDataCenterLocation(TestDataReader.getFromProperty(dataCenterLocation))
        .withCommitedUsage(TestDataReader.getFromProperty(commitedUsage))
        .withPrice(TestDataReader.getFromProperty(price));
    return computeEngine;
  }

  public static ComputeEngine getComputeEngineInstance() {
    computeEngine = new ComputeEngine()
        .withNumberOfInstances("4")
        .withOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL")
        .withProvisioningModel("Regular")
        .withSeries("N1")
        .withMachineType("n1-standard-8")
        .withGpuType("NVIDIA Tesla V100")
        .withNumberOfGpus("1")
        .withLocalSsd("2x375")
        .withDataCenterLocation("Frankfurt")
        .withCommitedUsage("1 Year");
    return computeEngine;
  }

}
